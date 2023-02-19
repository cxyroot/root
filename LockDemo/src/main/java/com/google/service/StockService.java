package com.google.service;

import com.google.bean.Stock;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class StockService {

    private Stock stock = new Stock();

    private ReentrantLock lock = new ReentrantLock();

    @Autowired
    private StringRedisTemplate redisTemplate;

    //有性能损耗 ，使用redis的分布式锁
    //redis 的分布式锁
    public void deduct4() {

        //redis 乐观锁 算法
        redisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.watch("stock");
                String stock = redisOperations.opsForValue().get("stock").toString();
                if (null != stock && stock.length() > 0) {
                    Integer stockInt = Integer.valueOf(stock);
                    if (stockInt > 0) {
                        redisOperations.multi();
                        redisOperations.opsForValue().set("stock", String.valueOf(--stockInt));
                        List exec = redisOperations.exec();
                        //重试机制
                        if (exec == null || exec.size() == 0) {
                            deduct4();
                        }
                        return exec;
                    }
                }
                return null;
            }
        });
    }

    public void deduct5() {
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "111");
        if (!lock) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                deduct5();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                //redis 乐观锁 算法
                redisTemplate.watch("stock");
                String stock = redisTemplate.opsForValue().get("stock").toString();
                if (null != stock && stock.length() > 0) {
                    Integer stockInt = Integer.valueOf(stock);
                    if (stockInt > 0) {
                        redisTemplate.opsForValue().set("stock", String.valueOf(--stockInt));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                redisTemplate.delete("lock");
            }
        }
    }

    public void deduct6() {
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "111",3,TimeUnit.SECONDS);
        while (!lock) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {

            redisTemplate.expire("lock",3,TimeUnit.SECONDS);

            redisTemplate.watch("stock");
            String stock = redisTemplate.opsForValue().get("stock").toString();
            if (null != stock && stock.length() > 0) {
                Integer stockInt = Integer.valueOf(stock);
                if (stockInt > 0) {
                    redisTemplate.opsForValue().set("stock", String.valueOf(--stockInt));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisTemplate.delete("lock");
        }
    }

    public void deduct() {
        lock.lock();
        try {
            stock.setStock(stock.getStock() - 1);
            System.out.println("库存余量：" + stock.getStock());
        } finally {
            lock.unlock();
        }
    }

}

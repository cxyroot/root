package com.google.service;

import com.google.bean.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class StockService {

    private Stock stock = new Stock();

    private ReentrantLock lock = new ReentrantLock();

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void deduct4(){

        redisTemplate.execute(new SessionCallback<Object>(){
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.watch("stock");
                String stock = redisOperations.opsForValue().get("stock").toString();
                if (null != stock && stock.length() > 0){
                    Integer stockInt = Integer.valueOf(stock);
                    if (stockInt > 0){
                        redisOperations.multi();
                        redisOperations.opsForValue().set("stock",String.valueOf(--stockInt));
                        List exec = redisOperations.exec();
                        //重试机制
                        if(exec  == null || exec.size() == 0){
                            deduct4();
                        }
                        return exec;
                    }
                }
                return null;
            }
        });
    }

    public void deduct(){
        lock.lock();
        try {
            stock.setStock(stock.getStock() - 1);
            System.out.println("库存余量：" + stock.getStock());
        } finally {
            lock.unlock();
        }
    }

}

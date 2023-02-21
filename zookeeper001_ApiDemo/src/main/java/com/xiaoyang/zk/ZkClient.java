package com.xiaoyang.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ZkClient {

    private ZooKeeper zkCli;
    private static final String CONNECT_STRING = "192.168.10.120:2181,192.168.10.101:2181,192.168.10.130:2181";
    private static final int SESSION_TIMEOUT = 200000;

    @Before
    public void before() throws IOException {
        zkCli = new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("默认回调函数");
            }
        });
    }
    @Test
    public void lsFun(){
        try {
            List<String> children = zkCli.getChildren("/",true);
            for (String child:children) {
                System.out.println(child);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void create(){
        try {
           String s  = zkCli.create("/Idea","Idea2018".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);

           System.out.println(s);

           Thread.sleep(Integer.MIN_VALUE);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void set(){
        try {
            Stat stat = zkCli.setData("/zxx00000000007","defabc".getBytes(),10);
            System.out.println(stat.getDataLength());
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

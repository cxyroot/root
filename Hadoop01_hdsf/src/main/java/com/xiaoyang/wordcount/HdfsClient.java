package com.xiaoyang.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;

public class HdfsClient {
    @Test
    public void put(){
        try{
            Configuration configuration = new Configuration();
            FileSystem fs = FileSystem.get(new URI("hdfs://192.168.10.120:9000"), configuration, "root");
            fs.copyFromLocalFile(new Path("d:\\1.txt"),new Path("/"));
            fs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void input(){
        try{
            Configuration configuration = new Configuration();
            FileSystem fs = FileSystem.get(new URI("hdfs://192.168.10.120:9000"), configuration, "root");
            fs.copyToLocalFile(new Path("/1.txt"),new Path("d:\\"));//下载文件
            fs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void rename(){
        try{
            Configuration configuration = new Configuration();
            FileSystem fs = FileSystem.get(new URI("hdfs://192.168.10.120:9000"), configuration, "root");
            fs.rename(new Path("/1.txt"),new Path("/2.txt"));//修改文件名。可以修改目录名
            fs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    FileSystem fs =null;
    @Before
    public void before(){
        try {
            Configuration configuration = new Configuration();
            fs = FileSystem.get(new URI("hdfs://192.168.10.120:9000"), configuration, "root");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void del(){
        try {
            boolean del = fs.delete(new Path("/2.txt"),true);
            System.out.println(del);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void after(){
        try {
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void append(){
        try {
            FSDataOutputStream append = fs.append(new Path("/1.txt"),1024);
            FileInputStream open = new FileInputStream("d:\\1.txt");
            IOUtils.copyBytes(open,append,1024,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void ls(){
        try {
            FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
            for (FileStatus fileStatus : fileStatuses    ) {
                System.out.println(fileStatus.getPath());
                System.out.println(fileStatus.getLen());
                System.out.println(fileStatus.getGroup());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void listFiles(){
        try {
            RemoteIterator<LocatedFileStatus> fileStatusRemoteIterator = fs.listFiles(new Path("/"),true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

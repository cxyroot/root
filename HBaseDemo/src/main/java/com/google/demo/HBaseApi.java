package com.google.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.ByteStringer;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Map;

public class HBaseApi {
    public static void main(String[] args){
        try {
            //创建配置对象，获取hbase连接
            Configuration configuration = HBaseConfiguration.create();
            //1:获取hbase连接对象
            Connection connection = ConnectionFactory.createConnection(configuration);
            System.out.println(connection);
            //获取操作对象
            //HBaseAdmin hBaseAdmin = new HBaseAdmin(connection);
            //hBaseAdmin
            Admin admin = connection.getAdmin();
            try{
                NamespaceDescriptor namespaceDescriptor = admin.getNamespaceDescriptor("caoxiaoyang");
                System.out.println("namespaceDescriptor:"+namespaceDescriptor);
            }catch (Exception e){
                NamespaceDescriptor nd = NamespaceDescriptor.create("caoxiaoyang").build();
                admin.createNamespace(nd);
            }
            //操作数据库
            TableName student = TableName.valueOf("caoxiaoyang:student");
            boolean flag = admin.tableExists(student);
            System.out.println(flag);
            if (flag){
                Table table = connection.getTable(student);
                String rowkey = "10001";
                Get get =new Get(Bytes.toBytes(rowkey));
                Result result = table.get(get);
                boolean empty = result.isEmpty();
                System.out.println("10001 数据是否存在= "+ empty);
                if(empty){
                    //增加数据
                    Put put= new Put(Bytes.toBytes(rowkey));
                    String family = "info";
                    String column = "name";
                    String val = "zhangsan";
                    put.addColumn(Bytes.toBytes(family),Bytes.toBytes(column),Bytes.toBytes(val));
                    table.put(put);
                    System.out.println("增加数据。。。。");
                }else{
                    for (Cell cell : result.rawCells()) {
                        //UTF8_CHARSET
                        System.out.println("value="+ Bytes.toString(CellUtil.cloneValue(cell)));
                        System.out.println("rowKey="+ Bytes.toString(CellUtil.cloneRow(cell)));
                        System.out.println("family="+ Bytes.toString(CellUtil.cloneFamily(cell)));
                        System.out.println("column="+ Bytes.toString(CellUtil.cloneQualifier(cell)));
                    }
                }
            }else{
                HTableDescriptor tableDescriptor = new HTableDescriptor(student);
                HColumnDescriptor hColumnDescriptor=new  HColumnDescriptor("info");
                //增加列族
                tableDescriptor.addFamily(hColumnDescriptor);
                admin.createTable(tableDescriptor);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

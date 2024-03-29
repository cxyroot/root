package com.xiaoyang.input;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileAsBinaryOutputFormat;

public class WholeFileDriver  {
    public static void main(String[] args) {
        try {
            // 输入输出路径需要根据自己电脑上实际的输入输出路径设置
            args = new String[] { "d:/input/inputinputformat", "e:/output1" };
            // 1 获取job对象
            Configuration conf = new Configuration();
            Job job = Job.getInstance(conf);
            // 2 设置jar包存储位置、关联自定义的mapper和reducer
            job.setJarByClass(WholeFileDriver.class);
            // 3 设置map输出端的kv类型
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(BytesWritable.class);
            // 4 设置最终输出端的kv类型
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(BytesWritable.class);
            job.setInputFormatClass(WholeFileInputFormat.class);
            //job.setOutputFormatClass(SequenceFileAsBinaryOutputFormat.class);
            // 5 设置输入输出路径
            FileInputFormat.setInputPaths(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job, new Path(args[1]));
            // 6 提交job
            boolean result = job.waitForCompletion(true);
            System.exit(result ? 0 : 1);

            job.setNumReduceTasks(10);//设置分区

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

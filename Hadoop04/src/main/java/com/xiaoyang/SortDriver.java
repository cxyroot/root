package com.xiaoyang;

import javafx.scene.text.Text;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class SortDriver {
    public static void main(String[] args) {
        try {
            Job job= Job.getInstance();
            job.setJarByClass(SortDriver.class);

            job.setMapperClass(SortMapper.class);
            job.setReducerClass(SortReducer.class);

            job.setMapOutputKeyClass(FlowBean.class);
            job.setMapOutputValueClass(Text.class);

            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(FlowBean.class);
            Path path = new Path("d:\\input");
            FileInputFormat.setInputPaths(job,path);
            Path oPaht = new Path("d:\\output2");

            FileOutputFormat.setOutputPath(job,oPaht);
            boolean b = job.waitForCompletion(true);
            System.exit(b?0:1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

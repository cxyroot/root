package com.roocon.test;
// -XX:+HeapDumpOnOutOfMemoryError  生成快照。 可以用MemoryAnalyzer-1.8.0.20180604-win32.win32.x86_64\mat 查看

//- XX:+HeapDumpOnOutOfMemoryError 
// -Xms20m -Xmx20m  配置jvm的参数。
import java.util.ArrayList;
import java.util.List;

public class MainDemo {
	public static void main(String[] args) {
		List<Demo>  listDemo =new ArrayList<Demo>();
		while(true){
			int i=1;
			listDemo.add(new Demo());
			i = i+1;
			System.out.println(i);
		}
	}
}
/**
 *1:jconsole  java 命令。开启图形化监控工具。
 *2:jps  
 *
 *
 */

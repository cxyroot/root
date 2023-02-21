package com.google.test2;

import java.util.Scanner;

/**
 * jps
 * jps -l
 * 查看Java进程，显示主方法名称。
 * jps -m
 * @author CAOXIAOYANG
 * jps -v
 * 拿到jvm的虚拟机消息。
 * jps -mlv
 *
 * jstat  -gcutil 6692
 *
 */
public class JpsDemo {
	public JpsDemo(){
		System.out.println("JpsDemo");
	}

	public static void main(String[] args) {
		/*try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		Scanner sc=new Scanner(System.in);
		sc.next();
	}
}

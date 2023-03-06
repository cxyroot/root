package com.google.thread3;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadDemo {
	public static void main(String[] args) {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] dumpAllThreads = threadMXBean.dumpAllThreads(false, false);
		for (int i = 0; i < dumpAllThreads.length; i++) {
			ThreadInfo threadInfo = dumpAllThreads[i];
			System.out.println(threadInfo.getThreadId()+threadInfo.getThreadName());
		}
	}
}

package com.google.dao;

import org.apache.ibatis.annotations.Param;

import com.google.bean.TestTb;

public interface TestDao {
	//保存数据
	public void insertTestTb(TestTb testTb);
	public TestTb findById(@Param("id")String id);
}

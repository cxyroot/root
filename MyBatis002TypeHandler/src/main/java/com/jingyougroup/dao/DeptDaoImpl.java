package com.jingyougroup.dao;

import com.jingyougroup.bean.Dept;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DeptDaoImpl implements DeptDAO{
    private SqlSessionFactory sqlSessionFactory;
    public DeptDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public void insertDept(Dept dept) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行插入操作
        sqlSession.insert("insertDept", dept);
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }
}

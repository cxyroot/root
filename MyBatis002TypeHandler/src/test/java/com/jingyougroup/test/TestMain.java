package com.jingyougroup.test;

import com.jingyougroup.bean.Dept;
import com.jingyougroup.dao.DeptDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class TestMain {
    public static void main(String[] args) {
       /* try {
            Dept dept=new Dept();
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveDept",dept);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void insertUserTest() {
        DeptDaoImpl deptDao = new DeptDaoImpl(sqlSessionFactory);
        Dept dept = new Dept();
        //user.setUsername("张三丰");
        //user.setSex("1");
        //user.setBirthday(new Date());
        ///user.setAddress("武当山");
        deptDao.insertDept(dept);
    }
}

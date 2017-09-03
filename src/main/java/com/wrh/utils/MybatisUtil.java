package com.wrh.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by wuranghao on 2017/7/16.
 */
public class MybatisUtil {
    private final  static SqlSessionFactory sqlSessionFactory;

    static {
        String resource="mybatis-config.xml";
        Reader reader =null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    /**
     * 获取SqlSessionFactory
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    /**
     * 获取SqlSession
     * @return SqlSession
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 获取SqlSession，可以设置是否自动commit
     * @return SqlSession
     */
    public static SqlSession getSqlSession(boolean isAutoCommit){
        return sqlSessionFactory.openSession(isAutoCommit);
    }
    /**
     * 关闭SqlSession
     */
    public  static void closeSession(SqlSession sqlSession){
        if (sqlSession!=null)
            sqlSession.close();
    }
}

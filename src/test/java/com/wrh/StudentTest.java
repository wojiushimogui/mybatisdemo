package com.wrh;

import com.wrh.entity.Student;
import com.wrh.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by wuranghao on 2017/7/16.
 */
public class StudentTest {

    SqlSession sqlSession ;

    @Test
    public void queryById(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 1;
        try{

            Student student = sqlSession.selectOne("mapper.StudentMapper.queryById",id);
            System.out.println(student);//null
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById2(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 1;
        try{

            Student student = sqlSession.selectOne("mapper.StudentMapper.queryById2",id);
            System.out.println(student);//Student{id=1, name='wojiushimogui', age=18}
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById3(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 1;
        try{

            Student student = sqlSession.selectOne("mapper.StudentMapper.queryById3",id);
            System.out.println(student);//Student{id=1, name='wojiushimogui', age=18}
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }
}

package com.wrh;

import com.wrh.entity.Person;
import com.wrh.mapper.PersonMapper;
import com.wrh.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by wuranghao on 2017/7/16.
 */
public class PersonTest {

    SqlSession sqlSession ;
    @Test
    public void insertPerson(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 100;
        String userName = "wojiushimogui";
        int age = 19;
        String mobilePhone = "18000000001";
        Person person = new Person();
        person.setId(id);
        person.setAge(age);
        person.setUserName(userName);
        person.setMobilePhone(mobilePhone);
        try{
            sqlSession.insert("insertPerson",person);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 100;
        try{
            /**
             * 映射sql的标识字符串，
             * mapper是Person.xml文件中mapper标签的namespace属性的值，
             * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
             */
            Person person = sqlSession.selectOne("mapper.Person.queryById",id);

            sqlSession.commit();
            System.out.println(person.getUserName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void add(){
        sqlSession = MybatisUtil.getSqlSession(true);
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        int id = 1001;
        String userName = "wojiushimogui";
        int age = 19;
        String mobilePhone = "18000000001";
        Person person = new Person();
        person.setId(id);
        person.setAge(age);
        person.setUserName(userName);
        person.setMobilePhone(mobilePhone);
        try{
            int add = personMapper.add(person);
            System.out.println("add = " + add);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById2(){
        sqlSession = MybatisUtil.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

        int id = 100;
        try{

            Person person = personMapper.queryById(id);
            System.out.println(person.getUserName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }


}

package com.wrh.mapper;

import com.wrh.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 上午8:18 on 2017/9/3.
 */
public interface PersonMapper {

    @Insert("insert into person(ID,USERNAME,AGE,MOBILEPHONE) VALUES(#{id},#{userName},#{age},#{mobilePhone})")
    int add(Person person);


    @Select("select * from person where id = #{id}")
    Person queryById(int id);
}

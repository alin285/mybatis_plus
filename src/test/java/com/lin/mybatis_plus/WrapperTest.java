package com.lin.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.mybatis_plus.mapper.UserMapper;
import com.lin.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WrapperTest {



    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        final List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


    @Test
    void test1() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name").isNotNull("email").ge("age",12);
        userMapper.selectList(wrapper).forEach(System.out::print);
    }

    @Test
    void test2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.inSql("id","select id from user where id < 3");

        List<Object> objects =userMapper.selectObjs(wrapper);
        objects.forEach(System.out::print);
    }

    @Test
    void test3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.orderByDesc("id");

//        List<Object> objects =userMapper.selectObjs(wrapper);
        List<User> list  = userMapper.selectList(wrapper);
        list.forEach(System.out::print);
    }


}

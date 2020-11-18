package com.lin.mybatis_plus;

import com.lin.mybatis_plus.mapper.UserMapper;
import com.lin.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        final List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void testInsert(){
        User user = new User();
        user.setName("lhd");
        user.setAge(16);
        user.setEmail("11111111222");
//        user.setId( 111l);
        int result = userMapper.insert(user); //自动生成id
//        userMapper.insert(user);
        System.out.println(result);//受影响的行数
        System.out.println(user);//发现id自动回填

    }
    @Test
    void Update (){
        User user = new User();
        user.setId( 5l);
        user.setName("lhd冲11111111");
        userMapper.updateById(user);

    }


    //测试成功的案例
    @Test
    void OptimisticLocker(){
        //11111111
        // 1、查询用户信息
        User user = userMapper.selectById(1l);
        // 2、修改用户信息
        user.setName("jone11111111");
        // 3、执行更新操作
        userMapper.updateById(user);
    }


    //测试失败的案例
    @Test
    void OptimisticLocker1(){
        //11111111
        // 1、查询用户信息
        User user = userMapper.selectById(1l);
        // 2、修改用户信息
        user.setName("jone11111111");
        // 3、执行更新操作
        //222222222222
        // 1、查询用户信息
        User user2 = userMapper.selectById(1l);
        // 2、修改用户信息
        user.setName("jone2222222");
        // 3、执行更新操作
        userMapper.updateById(user2);
        userMapper.updateById(user);
    }

    //按照id查询
    @Test
    void testselectByid(){
        User user2 = userMapper.selectById(1l);
        System.out.println(user2);
    }

    //按照条件批量查询
    @Test
    void testselectBylisy(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        users.forEach(System.out::print);
    }
    //按条件查询
    @Test
    void testselectBymap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","Tom");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::print);
    }
}

package com.lin.mybatis_plus.config;


import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("com.lin.mybatis_plus.mapper")
@EnableTransactionManagement   //自动管理事物
@Configuration  //配置类
public class MyBatisPlusConfig {


    //注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor  optimisticlockerinterceptor(){
        return new OptimisticLockerInterceptor();
    }

}

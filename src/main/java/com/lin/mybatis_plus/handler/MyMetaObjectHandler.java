package com.lin.mybatis_plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import jdk.internal.instrumentation.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    //插入
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始 插入");
        this.setFieldValByName("createtime",new Date(),metaObject);
        this.setFieldValByName("updatetime",new Date(),metaObject);

    }

    //更新
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始 更新");
        this.setFieldValByName("updatetime",new Date(),metaObject);

    }
}

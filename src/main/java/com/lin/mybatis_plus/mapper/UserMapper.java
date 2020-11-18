package com.lin.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.mybatis_plus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;


//@MapperScan("com.lin.mybatis_plus.mapper")  //扫描我们的mapper文件夹   或者直接加 Mapper
@Mapper
@Repository   //代表dao 持久层
public interface UserMapper extends BaseMapper <User>{
    //所有的crud操作都好了 ，不需要配置一大堆的文件


}

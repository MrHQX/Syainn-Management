package com.example.demo.config;

import java.time.LocalDateTime;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

@Component
public class TimeHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
    	metaObject.setValue("tourokubi", LocalDateTime.now());
        metaObject.setValue("kousinnbi",LocalDateTime.now());
        //this.setFieldValByName("tourokubi", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //this.setFieldValByName("kousinnbi", new Date(), metaObject);
    	metaObject.setValue("kousinnbi",LocalDateTime.now());
    }
}
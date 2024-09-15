package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UserAccessLog;
import com.example.demo.mapper.UseraccesslogMapper;
import com.example.demo.service.UseraccesslogService;

@Service
public class UseraccesslogServiceImpl extends ServiceImpl<UseraccesslogMapper, UserAccessLog> implements UseraccesslogService{
	
}
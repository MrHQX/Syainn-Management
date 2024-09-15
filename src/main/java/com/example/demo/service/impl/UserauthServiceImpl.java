package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UserAuth;
import com.example.demo.mapper.UserauthMapper;
import com.example.demo.service.UserauthService;

@Service
public class UserauthServiceImpl extends ServiceImpl<UserauthMapper,UserAuth> implements UserauthService{
	
}
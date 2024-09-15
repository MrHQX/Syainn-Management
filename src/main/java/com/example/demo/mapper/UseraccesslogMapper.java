package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserAccessLog;

@Mapper
public interface UseraccesslogMapper extends BaseMapper<UserAccessLog>{
	
}
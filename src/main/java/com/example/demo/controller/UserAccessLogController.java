package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.R;
import com.example.demo.entity.UserAccessLog;
import com.example.demo.entity.UserAuth;
import com.example.demo.service.UseraccesslogService;
import com.example.demo.service.UserauthService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/userlog")
public class UserAccessLogController{
	@Autowired
	private UseraccesslogService useraccesslogService;
	@Autowired
	private UserauthService userservice;
	
	@Transactional
	@PostMapping
	public R<String> addKyuyo(@RequestBody UserAccessLog userAccessLog){
		Integer userid=userAccessLog.getUserId();
		LambdaQueryWrapper<UserAuth> queryWrapper=new LambdaQueryWrapper();
		queryWrapper.eq(UserAuth::getUserId, userid);
		UserAuth userAuth= userservice.getOne(queryWrapper);
		if (userAuth!=null) {
			
			useraccesslogService.save(userAccessLog);
			return R.success("新增成功");
		}
		return R.error("日志失败");
	}
}
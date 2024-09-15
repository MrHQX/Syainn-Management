package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.R;
import com.example.demo.entity.UserAuth;
import com.example.demo.service.UserauthService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserauthController{
	
	@Autowired
	private UserauthService userauthService;
	
	/**
	 * 登录
	 * @param request
	 * @param userauth
	 * @return
	 */
	@PostMapping("/login")
	public R<UserAuth> login(HttpServletRequest request, @RequestBody UserAuth userauth) {
		String password = userauth.getPassword();
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		password = password.toUpperCase();
		LambdaQueryWrapper<UserAuth> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(UserAuth::getUserCode,userauth.getUserCode());
		UserAuth user = userauthService.getOne(queryWrapper);
		if(user==null) {
			return R.error("ユーザーありません");
		}
		if (!user.getPassword().equals(password)) {
			return R.error("パスワード違います");
		}
		if (user.getIsYoukou()==0) {
			return R.error("ユーザー無効");
		}
		String name=user.getUserName();
		String role=user.getUserRole();
		//request.getSession().setAttribute("username", name);
		//request.getSession().setAttribute("userrole", role);
		return R.success(user);
	}
}
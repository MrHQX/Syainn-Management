package com.example.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class UserAuth implements Serializable{
	@TableId(value = "USER_ID")
	private Integer userId;
	private String userCode;
	
	private String userName;
	
	private String password;
	
	private String userRole;
	
	private Integer isYoukou;
	
}
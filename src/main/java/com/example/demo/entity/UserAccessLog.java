package com.example.demo.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class UserAccessLog{
	@TableId(type = IdType.AUTO)
	private Integer id;
	private Integer userId;
	private String gamenId;
	private LocalDateTime startTime;
}
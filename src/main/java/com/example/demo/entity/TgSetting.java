package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class TgSetting implements Serializable{
	//@TableId(value = "category1")
	private Integer category1;
	//@TableId(value = "category2")
	private Integer category2;
	//@TableId(value = "category3")
	private Integer category3;
	private String value1;
	private String value2;
	private String value3;
	private String value4;
	private String value5;
} 
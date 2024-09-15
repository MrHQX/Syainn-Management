package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SyainItkeireki implements Serializable{
	@TableId
	private Integer syainId;
	//@TableId(type = IdType.INPUT)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date nyuusyaData; 
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date taisyaDate; 
	private String keisyaName; 
	private String haibi; 
}
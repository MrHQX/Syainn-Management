package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class SyainKeireki implements Serializable{
	@TableId
	private Integer syainId; 
	//@TableId(type = IdType.INPUT)
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private Date kaisibi; 
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private Date syuryobi; 
	private String pjName;
	private Integer tainitiFlag; 
	private Integer basyo; 
	private Integer kibo; 
	private Integer gyosyu; 
	private Integer kaihatukankyo; 
	private Integer unyoukankyo; 
	private String gengo; 
	private String db; 
	private String tool;
	private Integer tantou; 
	private Integer sagyohani; 
	private String gaiyou; 
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime tourokubi; 
	@TableField(fill = FieldFill.UPDATE)
	private LocalDateTime kousinnbi; 
}
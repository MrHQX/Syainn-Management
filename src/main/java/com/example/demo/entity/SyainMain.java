package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SyainMain implements Serializable{
	@TableId(type = IdType.AUTO)
	private Integer syainId;
	private String employeecode;
	private String firstNameKanji;
	private String LastNameKanji;
	private String FirstNameKana;
	private String LastNameKana;
	private String FirstNameEigo;
	private String LastNameEigo;
	private Integer Seibetu;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date Tanjyobi;
	private Integer Kokuseki;
	private String Syussinn;
	private Integer Haigusya;
	private String PassportNum;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date PassportEndDate;
	private Integer VisaKikan;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date VisaEndDate;
	private Integer ZairyuSikaku;
	private String KojinNum;
	private String ZairyuNum;
	private Integer SyozokuKaisya;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date NyuusyaDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date TaisyaDate;
	private Integer SyokugyoKind;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date RainitiDate;
	private String Bikou;
	private String Yuubin;
	private String Jyusyo_1;
	private String Jyusyo_2;
	private String MoyoriEki;
	private String Tel;
	private String Email;
	private String Wechat;
	private String Line;
	private String BokokuJyusyo;
	private String BokokuKinnkyuuRennraku;
	private Integer SaisyuuGakureki;
	private String GakkouName;
	private String SennmomName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date SotugyoDate;
	private Float GyumuNensu;
	private String ItOs;
	private String ItGengo;
	private String ItDb;
	private String ItWebServer;
	private String ItFw;
	private String ItOther;
	private String ItBikou;
	//@TableLogic(value = "1",delval = "0")
	private Integer deleteFlag;
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime tourokubi;
	@TableField(fill = FieldFill.UPDATE)
	private LocalDateTime kousinnbi;
	
}
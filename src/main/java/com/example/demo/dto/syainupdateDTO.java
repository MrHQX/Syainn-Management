package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class syainupdateDTO {
	private Integer syainId;
	private String employeecode;
	private String firstNameKanji;
	private String LastNameKanji;
	private String FirstNameKana;
	private String LastNameKana;
	private String FirstNameEigo;
	private String LastNameEigo;
	private Integer Seibetu;
	private Date Tanjyobi;
	private Integer Kokuseki;
	private String Syussinn;
	private Integer Haigusya;
	private String PassportNum;
	private Date PassportEndDate;
	private Integer VisaKikan;
	private Date VisaEndDate;
	private Integer ZairyuSikaku;
	private String KojinNum;
	private String ZairyuNum;
	private Integer SyozokuKaisya;
	@JsonFormat(pattern = "yyyy年MM月dd日")
	private Date NyuusyaDate;
	@JsonFormat(pattern = "yyyy年MM月dd日")
	private Date TaisyaDate;
	private Integer SyokugyoKind;
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
	private Date SotugyoDate;
	private Float GyumuNensu;
	private String ItOs;
	private String ItGengo;
	private String ItDb;
	private String ItWebServer;
	private String ItFw;
	private String ItOther;
	private String ItBikou;
	private Integer deleteFlag;
	  private Date kaisibi; 
	  private Date shuryobi; 
	  private String pjName;
	  private Integer tainitiFlag; 
	  private Integer basho; 
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
}
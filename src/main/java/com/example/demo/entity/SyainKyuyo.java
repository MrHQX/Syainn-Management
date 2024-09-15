package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class SyainKyuyo implements Serializable{
	  @TableId()
	  private Integer syainId; 
	  //@TableId(value = "SYAINKAISHI_NENGETSU_ID", type = IdType.INPUT)
	  //@TableField(insertStrategy = FieldStrategy.IGNORED)
	  @JsonFormat(pattern = "yyyy-MM-dd")
	  private String kaishiNengetsu; 
	  @JsonFormat(pattern = "yyyy-MM-dd")
	  private String syuryoNengetsu; 
	  private Integer kihonkyu; 
	  private Integer syokunoukyu; 
	  private String koyouHokenNo; 
	  private String nankinNo; 
	  private Integer nankinKijyunGaku;
	  private String kenkouHokenNo; 
	  private String bikou; 
	  @TableField(fill = FieldFill.INSERT)
	  private LocalDateTime tourokubi; 
	  @TableField(fill = FieldFill.UPDATE)
	  private LocalDateTime kousinnbi; 
}
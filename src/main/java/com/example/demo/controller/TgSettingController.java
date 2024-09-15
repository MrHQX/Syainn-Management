package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.R;
import com.example.demo.entity.TgSetting;
import com.example.demo.service.TgSettingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/Tgsetting")
public class TgSettingController{
	
	@Autowired
	private TgSettingService tgSettingService;
	
	@GetMapping()
	public R<List<TgSetting>> getTgSetting(@RequestParam(required = false) String category1,
			@RequestParam(required = false) String category2,
			@RequestParam(required = false) String category3){
		LambdaQueryWrapper<TgSetting> queryWrapper=new LambdaQueryWrapper<>();
		if (category1 != null) {
			queryWrapper.eq(TgSetting::getCategory1, category1);
        }
        if (category2 != null) {
        	queryWrapper.eq(TgSetting::getCategory2, category2);
        }
        if (category3 != null) {
        	queryWrapper.eq(TgSetting::getCategory3, category3);
        }

		List<TgSetting> tglist;
	
		tglist=tgSettingService.list(queryWrapper);
		log.info(tglist.toString());
		return R.success(tglist);
	}
	
	@GetMapping("/IT")
	public R<List<String>> getTgSetting_it(@RequestParam(required = false) String category1,
			@RequestParam(required = false) String category2,
			@RequestParam(required = false) String category3){
		{
			LambdaQueryWrapper<TgSetting> queryWrapper=new LambdaQueryWrapper<>();
			if (category1 != null) {
				queryWrapper.eq(TgSetting::getCategory1, category1);
	        }
	        if (category2 != null) {
	        	queryWrapper.eq(TgSetting::getCategory2, category2);
	        }
	        if (category3 != null) {
	        	queryWrapper.eq(TgSetting::getCategory3, category3);
	        }
	        List<TgSetting> entities = tgSettingService.list(queryWrapper);
	        List<String> value=entities.stream().map(TgSetting::getValue1).collect(
	        		Collectors.toList());
	        
			return R.success(value);
		}
	}

	private Object getValue1() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
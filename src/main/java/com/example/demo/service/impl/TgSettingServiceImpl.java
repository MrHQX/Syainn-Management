package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.TgSetting;
import com.example.demo.mapper.TgSettingMapper;
import com.example.demo.service.TgSettingService;
@Service
public class TgSettingServiceImpl extends ServiceImpl<TgSettingMapper,TgSetting> implements TgSettingService{
	
}
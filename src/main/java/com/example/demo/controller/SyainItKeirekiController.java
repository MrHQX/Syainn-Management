package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.R;
import com.example.demo.entity.SyainItkeireki;
import com.example.demo.service.SyainItkeirekiService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ITKeireki")
public class SyainItKeirekiController{
	@Autowired
	private SyainItkeirekiService service;
	@Transactional
	@PostMapping
	public R<String> addItKeireki(@RequestBody List<SyainItkeireki> syainItKeirekis){
		
		for (SyainItkeireki item : syainItKeirekis) 
		{
            service.save(item);
        }
		return R.success("新增成功");
	}
	@GetMapping("/g")
	public R<List<SyainItkeireki>> getItKerrekiByid(@RequestParam Integer syainId){
		LambdaQueryWrapper<SyainItkeireki> queryWrapper=new LambdaQueryWrapper();
		queryWrapper.eq(SyainItkeireki::getSyainId, syainId);
		List<SyainItkeireki> ItkeirekiList=service.list(queryWrapper);
		return R.success(ItkeirekiList);
	}
	
	@Transactional
	@PutMapping
	public R<String> updateKyuyo(@RequestBody List<SyainItkeireki> syainItKeirekis)
	{
		
		LambdaQueryWrapper<SyainItkeireki> queryWrapper=new LambdaQueryWrapper();
		//queryWrapper.eq(SyainItkeireki::getSyainId, syainId);
		//service.remove(queryWrapper);
		Integer id=null;
		for (SyainItkeireki item : syainItKeirekis) {
            id=item.getSyainId();
            break;
        }
		if (id!=null) {
			queryWrapper.eq(SyainItkeireki::getSyainId, id);
			service.remove(queryWrapper);
		}else {
			return R.success("kyuyo更新成功");
		}
		for (SyainItkeireki item : syainItKeirekis) {
			service.save(item);
        }
		
		return R.success("itkeireki更新成功");
	}
}
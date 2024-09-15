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
import com.example.demo.entity.SyainKeireki;
import com.example.demo.service.SyainKeirekiService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/Keireki")
public class SyainKeirekiController{
	@Autowired
	private SyainKeirekiService service;
	@Transactional
	@PostMapping
	public R<String> addKeireki(@RequestBody List<SyainKeireki> syainKeirekiList) {
		
		for (SyainKeireki item : syainKeirekiList) {
            service.save(item);
        }
		return R.success("新增成功");

	}
	@GetMapping("/g")
	public R<List<SyainKeireki>> getKeirekiByid(@RequestParam Integer syainId){
		LambdaQueryWrapper<SyainKeireki> queryWrapper=new LambdaQueryWrapper();
		queryWrapper.eq(SyainKeireki::getSyainId, syainId);
		List<SyainKeireki> keirekisList=service.list(queryWrapper);
		return R.success(keirekisList);
	}
	@Transactional
	@PutMapping
	public R<String> updateKeireki(@RequestBody List<SyainKeireki> syainKeirekiList)
	{
		LambdaQueryWrapper<SyainKeireki> queryWrapper=new LambdaQueryWrapper();
		//queryWrapper.eq(SyainKeireki::getSyainId, syainId);
		//service.remove(queryWrapper);
		Integer id=null;
			for (SyainKeireki item : syainKeirekiList) {
	            id=item.getSyainId();
	            break;
	        }
			if (id!=null) {
				queryWrapper.eq(SyainKeireki::getSyainId, id);
				service.remove(queryWrapper);
			}else {
				return R.success("kyuyo更新成功");
			}
			for (SyainKeireki item : syainKeirekiList) {
				service.save(item);
	        }
		return R.success("keireki更新成功");
	}
}
	

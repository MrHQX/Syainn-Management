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
import com.example.demo.entity.SyainKyuyo;
import com.example.demo.service.SyainKyuyoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/Kyuyo")
public class SyainKyuyoController{
	@Autowired
	private SyainKyuyoService service;
	@Transactional
	@PostMapping
	public R<String> addKyuyo(@RequestBody List<SyainKyuyo> syainKyuyo){
		for (SyainKyuyo item : syainKyuyo) {
            service.save(item);
        }
		return R.success("新增成功");


	}
	@GetMapping("/g")
	public R<List<SyainKyuyo>> getKyuryoByid(@RequestParam Integer syainId){
		LambdaQueryWrapper<SyainKyuyo> queryWrapper=new LambdaQueryWrapper();
		queryWrapper.eq(SyainKyuyo::getSyainId, syainId);
		List<SyainKyuyo> KyuyoList=service.list(queryWrapper);
		return R.success(KyuyoList);
	}
	
	@Transactional
	@PutMapping
	public R<String> updateKyuyo(@RequestBody List<SyainKyuyo> syainKyuyo)
	{
		LambdaQueryWrapper<SyainKyuyo> queryWrapper=new LambdaQueryWrapper();
		//queryWrapper.eq(SyainKyuyo::getSyainId, syainId);
		//service.remove(queryWrapper);
		Integer id=null;
		for (SyainKyuyo item : syainKyuyo) {
            id=item.getSyainId();
            break;
        }
		if (id!=null) {
			queryWrapper.eq(SyainKyuyo::getSyainId, id);
			service.remove(queryWrapper);
		}else {
			return R.success("kyuyo更新成功");
		}
		for (SyainKyuyo item : syainKyuyo) {
			service.save(item);
        }
		return R.success("kyuyo更新成功");
	}
}
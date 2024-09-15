package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.example.demo.entity.SyainKeireki;
import com.example.demo.entity.SyainKyuyo;
import com.example.demo.entity.SyainMain;
import com.example.demo.service.SyainItkeirekiService;
import com.example.demo.service.SyainKeirekiService;
import com.example.demo.service.SyainKyuyoService;
import com.example.demo.service.SyainnMainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@Transactional
@RequestMapping("/Syain")
public class SyainController{
	@Autowired
	private SyainnMainService syainnMainService;
	@Autowired
	private SyainKyuyoService syainKyuyoService;
	@Autowired
	private SyainKeirekiService syainKeirekiService;
	@Autowired
	private SyainItkeirekiService syainItkeirekiService;
	
	@PostMapping
	public R<SyainMain> AddSyainA(@RequestBody SyainMain syainnMain){
		syainnMainService.save(syainnMain);
		LambdaQueryWrapper<SyainMain> queryWrapper=new LambdaQueryWrapper();
		queryWrapper.eq(SyainMain::getEmployeecode, syainnMain.getEmployeecode());
		Integer id= syainnMainService.getOne(queryWrapper).getSyainId();
		syainnMain.setSyainId(id);
		return R.success(syainnMain);
	}
	@GetMapping("/1") //条件查询
	public R<List<SyainMain>> getSyainList(@RequestParam(required = false) Integer syozokuKaisya,
			@RequestParam(required = false) Integer syokugyoKind,
			@RequestParam(required = false) String zaisyokuyes,
			@RequestParam(required = false) String zaisyokuno,
			@RequestParam(required = false) String name){
		LambdaQueryWrapper<SyainMain> queryWrapper =new LambdaQueryWrapper();
        
		if(syozokuKaisya!=0)
		{
			queryWrapper.eq(SyainMain::getSyozokuKaisya, syozokuKaisya);
		}
		if(name!="")
		{
			queryWrapper
			.or().like(SyainMain::getFirstNameKanji,name)
			.or().like(SyainMain::getFirstNameKana, name)
			.or().like(SyainMain::getFirstNameEigo, name)
			.or().like(SyainMain::getLastNameKanji, name)
			.or().like(SyainMain::getLastNameKana, name)
			.or().like(SyainMain::getLastNameEigo, name);
		}
//		if (zaisyokuno!="true"&&zaisyokuyes!="true") {
//			if(zaisyokuno=="true")
//			{
//				queryWrapper.isNotNull(SyainMain::getTaisyaDate);
//			}else {
//				queryWrapper.isNull(SyainMain::getTaisyaDate);
//			}
//		}
		List<SyainMain> syainlist;
		queryWrapper.eq(SyainMain::getDeleteFlag, 0);
		queryWrapper.eq(SyainMain::getSyokugyoKind, syokugyoKind);
		if(zaisyokuno!="true"&&zaisyokuyes!="true")
		{
			syainlist=syainnMainService.list(queryWrapper);
		}else if(zaisyokuno!="true"){
			queryWrapper.isNotNull(SyainMain::getTaisyaDate);
			syainlist=syainnMainService.list(queryWrapper);
		}else {
			queryWrapper.isNull(SyainMain::getTaisyaDate);
			syainlist=syainnMainService.list(queryWrapper);
		}
		return R.success(syainlist);
	}
	
	
	@GetMapping
	public R<List<SyainMain>> getall() { //查询所有
		LambdaQueryWrapper<SyainMain> queryWrapper =new LambdaQueryWrapper();
		queryWrapper.eq(SyainMain::getDeleteFlag, 0);
		List<SyainMain> syainlist=syainnMainService.list(queryWrapper);
		//log.info(syainlist.toString());
		return R.success(syainlist);
	}
	@Transactional
	@DeleteMapping
	public R<String> deleteById(@RequestParam Integer syainId) {//删除
		//log.info(Id.toString());
		LambdaQueryWrapper<SyainMain> queryWrapper =new LambdaQueryWrapper();
		LambdaQueryWrapper<SyainKyuyo> queryWrapperkyuro =new LambdaQueryWrapper();
		LambdaQueryWrapper<SyainKeireki> queryWrapperkeireki =new LambdaQueryWrapper();
		LambdaQueryWrapper<SyainItkeireki> queryWrapperitkeireki =new LambdaQueryWrapper();
		//String syainId=Id.toString();
		//queryWrapper.eq(SyainMain::getSyainId,Id );
		//if(Id==null)
		//{
		//	log.info(Id.toString());
		//}
		queryWrapper.eq(SyainMain::getSyainId, syainId);
		SyainMain syainMain=syainnMainService.getOne(queryWrapper);
		syainMain.setDeleteFlag(1);
		log.info(syainMain.toString());
		syainnMainService.updateById(syainMain);
		queryWrapperitkeireki.eq(SyainItkeireki::getSyainId, syainId);
		queryWrapperkeireki.eq(SyainKeireki::getSyainId, syainId);
		queryWrapperkyuro.eq(SyainKyuyo::getSyainId, syainId);
		log.info(syainItkeirekiService.list(queryWrapperitkeireki).toString());
		if (syainItkeirekiService.list(queryWrapperitkeireki).isEmpty()==false) {
			syainItkeirekiService.remove(queryWrapperitkeireki);
		}
		if (syainKeirekiService.list(queryWrapperkeireki).isEmpty()==false) {
			syainKeirekiService.remove(queryWrapperkeireki);
		}
		if (syainKyuyoService.list(queryWrapperkyuro).isEmpty()==false) {
			syainKyuyoService.remove(queryWrapperkyuro);
		}
		
		//syainnMainService.updateById(syainMain);
		//syainnMainService.removeById(Id);
		//log.info(Id.toString());
		return R.success("删除成功");
	}
	
	@GetMapping("/g") 
	public R<SyainMain> getSyainByid(@RequestParam Integer syainId){//ID查询
		LambdaQueryWrapper<SyainMain> queryWrapper=new LambdaQueryWrapper();
		queryWrapper.eq(SyainMain::getSyainId, syainId);
		SyainMain syainMain=syainnMainService.getOne(queryWrapper);
		return R.success(syainMain);
	}
	
	@PutMapping
	public R<String> updateSyain(@RequestBody SyainMain syainMain){
		syainnMainService.updateById(syainMain);
		return R.success("社员更新成功");
	}
	
}
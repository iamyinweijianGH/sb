package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.T;
import com.example.demo.service.TService;

@Controller
@RequestMapping("/t")
public class TController {

	@Autowired
	private TService tService;
	
	@RequestMapping("/findById")
	@ResponseBody
	public Object findById(Long id) {
		return tService.findById(id); 
	}
	
	@RequestMapping("/addT")
	@ResponseBody
	public Object addT() {
		T t = new T();
		t.setName("ttt");
		tService.addT(t);
		return 1;
	}
	
	@RequestMapping("/t")
	@ResponseBody
	public Object t() {
		return 1;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Object findAll() {
		return tService.findAll(1 , 3, "id desc");
	}
}

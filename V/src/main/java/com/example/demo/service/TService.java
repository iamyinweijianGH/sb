package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.T;
import com.example.demo.mapper.TMapper;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class TService {

	@Autowired
	private TMapper tMapper;
	
	public T findById(Long id) {
		
		return tMapper.findById(id);
	}
	
	public int addT(T t) {
		return tMapper.addT(t);
	}
	
	public List<T> findAll(Integer pageNum, Integer  pageSize, String order){
		PageHelper.startPage(pageNum, pageSize, " id desc");
		return tMapper.findAll(pageNum, pageSize, order);
	}
}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.T;
import com.example.demo.mapper.TMapper;

@Service
@Transactional
public class TService {

	@Autowired
	private TMapper tMapper;
	
	public T findById(Long id) {
		return tMapper.findById(id);
	}
	
	public int addT(T t) {
		
		T t2 = new T();
		t2.setName("t2222222222222222222222222222222222222222222222222222222222");
		
		tMapper.addT(t);
		return tMapper.addT(t2);
	}
	
}

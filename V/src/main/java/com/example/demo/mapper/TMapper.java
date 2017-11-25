package com.example.demo.mapper;


import java.util.List;

import com.example.demo.entity.T;

public interface TMapper {

	public T findById(Long id);
	
	public int addT(T t);
	
	public List<T> findAll(Integer pageNum, Integer  pageSize, String order);
}

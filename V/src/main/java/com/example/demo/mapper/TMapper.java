package com.example.demo.mapper;


import com.example.demo.entity.T;

public interface TMapper {

	public T findById(Long id);
	
	public int addT(T t);
}

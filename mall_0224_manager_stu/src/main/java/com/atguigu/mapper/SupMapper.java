package com.atguigu.mapper;

import java.util.HashMap;

import com.atguigu.bean.T_MALL_PRODUCT;
public interface SupMapper {

	int insertSpu(T_MALL_PRODUCT spu);

	void insertImages(HashMap<String, Object> map);
	
}

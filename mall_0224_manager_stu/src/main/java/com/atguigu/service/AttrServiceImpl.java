package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.mapper.AttrMapper;
@Service
public class AttrServiceImpl implements AttrServiceInf {
	@Autowired
	AttrMapper attrMapper;
		
	public List<OBJECT_T_MALL_ATTR> select_attr(Integer class_2_id) {
		
		List<OBJECT_T_MALL_ATTR> list_attr = attrMapper.select_attrs(class_2_id);
		
		return list_attr;
	}

}

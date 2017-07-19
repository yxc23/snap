package com.atguigu.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.bean.OBJECT_T_MALL_ATTR;

public interface AttrMapper {

	List<OBJECT_T_MALL_ATTR> select_attrs(@Param("class_2_id")Integer class_2_id);

	void insert_attr(HashMap<Object, Object> hashMap1);

	void insert_value(HashMap<Object, Object> hashMap2);

}

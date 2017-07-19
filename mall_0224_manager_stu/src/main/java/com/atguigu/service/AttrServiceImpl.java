package com.atguigu.service;

import java.util.HashMap;
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

	public void add_attr(List<OBJECT_T_MALL_ATTR> list_attr, int class_2_id) {
		for (int i = 0; i < list_attr.size(); i++) {
			//逐条存放t_mall_attr
			HashMap<Object,Object> hashMap1 = new HashMap<Object,Object>();
			hashMap1.put("class_2_id", class_2_id);
			hashMap1.put("attr_obj", list_attr.get(i));
			attrMapper.insert_attr(hashMap1);
			
			//批量存放t_mall_value
			HashMap<Object,Object> hashMap2 = new HashMap<Object,Object>();
			hashMap2.put("shxm_id", list_attr.get(i).getId());
			hashMap2.put("list_value", list_attr.get(i).getList_value());
			attrMapper.insert_value(hashMap2);
			
			
		}
	}

}

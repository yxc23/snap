package com.atguigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.service.AttrServiceImpl;

@Controller
public class AttrController {
	@Autowired
	AttrServiceImpl attrServiceImpl; 
	
	
	@RequestMapping("/goto_attr_publish/{success}")
	public String test(@PathVariable("success") String success){
		
		return "manager_atttr_publish";
	}
	
	@RequestMapping("/goto_attr_by_class2_id")
	public String goto_attr_by_class2_id(int class_2_id,String class_2_name,ModelMap map){
		//调用业务查询分类属性的数据
		List<OBJECT_T_MALL_ATTR> list_value =  attrServiceImpl.select_attr(class_2_id);
		
		map.addAttribute("list_value", list_value);
		map.addAttribute("class_2_id", class_2_id);
		map.addAttribute("class_2_name", class_2_name);
		
		return "manager_attr_list_inner";
	}
	
	
}

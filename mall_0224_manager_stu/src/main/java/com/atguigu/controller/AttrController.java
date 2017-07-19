package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.MODEL_T_MALL_ATTR;
import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.service.AttrServiceImpl;

@Controller
public class AttrController {
	@Autowired
	AttrServiceImpl attrServiceImpl; 
	
	//跳转查询属性的页面
	@RequestMapping("/goto_attr_publish/{success}")
	public String test(@PathVariable("success") String success){
		
		return "manager_atttr_publish";
	}
	
	//根据属性二级分类查找属性，并转发到内部页面
	@RequestMapping("/goto_attr_by_class2_id")
	public String goto_attr_by_class2_id(int class_2_id,String class_2_name,ModelMap map){
		//调用业务查询分类属性的数据
		List<OBJECT_T_MALL_ATTR> list_attr =  attrServiceImpl.select_attr(class_2_id);
		
		map.addAttribute("list_attr", list_attr);
		map.addAttribute("class_2_id", class_2_id);
		map.addAttribute("class_2_name", class_2_name);
		
		return "manager_attr_list_inner";
	}
	
	//跳转添加属性页面
	@RequestMapping("goto_add_attr/{class_2_id}/{class_2_name}")
	public String  goto_add_attr(@PathVariable("class_2_id") int class_2_id ,@PathVariable("class_2_name") String class_2_name){
		
		return "manager_add_attr_list";
	}
	
	//保存属性
	@RequestMapping("save_attr")
	public ModelAndView  save_attr(int class_2_id,String class_2_name,MODEL_T_MALL_ATTR list_attr){
		//调用业务层属性添加方法
		attrServiceImpl.add_attr(list_attr.getList_attr(),class_2_id);
		
		//attrServiceImpl.add_value();
		ModelAndView mv = new ModelAndView("redirect:/goto_add_attr/{class_2_id}/{class_2_name}.do");
		mv.addObject("class_2_id",class_2_id);
		mv.addObject("class_2_name",class_2_name);
		
		/*	//插入属性名
		attrServiceImpl.insert_attr();
		//插入属性值
		attrServiceImpl.insert_value();*/
		return mv;
	}
	
	
}

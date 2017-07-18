package com.atguigu.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.atguigu.bean.T_MALL_CLASS_1;
import com.atguigu.bean.T_MALL_CLASS_2;
import com.atguigu.bean.T_MALL_TRADE_MARK;
import com.atguigu.factory.MysqlSessionFactory;
import com.atguigu.mapper.ClassMapper;
import com.google.gson.Gson;

public class Test01 {

	public static void main(String[] args) throws Exception, IOException {
		SqlSessionFactory sqlSessionFactory = MysqlSessionFactory.getSqlSessionFactory();
		System.out.println(sqlSessionFactory);

		// 获取一级分类
		ClassMapper mapper = sqlSessionFactory.openSession().getMapper(ClassMapper.class);
		List<T_MALL_CLASS_1> select_class_1 = mapper.select_class_1();
		Gson gson1 = new Gson();
		String json1 = gson1.toJson(select_class_1);
		FileOutputStream fileOutputStream1 = new FileOutputStream(new File("E:/json/class_1.js"));
		fileOutputStream1.write(json1.getBytes("utf-8"));
		// 获取二级分类
		for (T_MALL_CLASS_1 t_MALL_CLASS_1 : select_class_1) {
			Integer id = t_MALL_CLASS_1.getId();
			List<T_MALL_CLASS_2> select_class_2 = mapper.select_class_2(id);
			Gson gson = new Gson();
			String json2 = gson.toJson(select_class_2);
			FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/json/class_2_" + id + ".js"));
			fileOutputStream.write(json2.getBytes("utf-8"));
		}
		// 获取商标
		for (T_MALL_CLASS_1 t_MALL_CLASS_1 : select_class_1) {
			Integer id = t_MALL_CLASS_1.getId();//一级分类的id
			List<T_MALL_TRADE_MARK> select_mark = mapper.select_mark(id);
			Gson gson = new Gson();//创建gson来解析
			String json3 = gson.toJson(select_mark);
			FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/json/tm_class_1_"+id+".js"));
			fileOutputStream.write(json3.getBytes("utf-8"));
		}

	}

}

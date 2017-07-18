package com.atguigu.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.T_MALL_PRODUCT;
import com.atguigu.mapper.SupMapper;
@Service
public class SpuServiceImpl implements SpuServiceInf {
	@Autowired
	SupMapper supMapper;
	
	public void saveSpu(T_MALL_PRODUCT spu, List<String> list_image) {
			
			int spu_id = supMapper.insertSpu(spu);//保存商品基本信息并返回主键
		
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("spu_id", spu_id);
			map.put("list_image", list_image);
			//批量保存图片
			supMapper.insertImages(map);
			
	}

}

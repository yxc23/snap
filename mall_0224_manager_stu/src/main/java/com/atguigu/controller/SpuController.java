package com.atguigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.T_MALL_PRODUCT;
import com.atguigu.service.SpuServiceImpl;
import com.atguigu.util.MyUploadUtil;

@Controller
public class SpuController {
	@Autowired
	SpuServiceImpl spuServiceImpl;

	@RequestMapping("/index")
	public String publishShp() {

		return "manager_index";
	}

	@RequestMapping("/goto_spu_publish/{success}")
	public String gotoSpuPublish(@PathVariable String success) {
		
		return "manager_spu_publish";
	}

	@RequestMapping("save_spu")
	public ModelAndView saveSpu(T_MALL_PRODUCT spu, @RequestParam("image_file") MultipartFile[] image_file) {
		// 上传图片
		List<String> list_image = MyUploadUtil.uploadImages(image_file);

		// 保存商品和图片信息
		spuServiceImpl.saveSpu(spu, list_image);

		ModelAndView mv = new ModelAndView("redirect:goto_spu_publish/{success}.do");

		mv.addObject("success", "恭喜发布成功");
		return mv;
	}
}

package com.atguigu.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;


public class MyUploadUtil {

	public static List<String> uploadImages(MultipartFile[] image_file) {
		//创建图片的集合
		List<String> list_image = new ArrayList<String>();
		
		//遍历数组
		for (int i = 0; i < image_file.length; i++) {
			//获取上传名称
			String originalFilename = image_file[i].getOriginalFilename();
			//创建当前图片名称
			String image_name = System.currentTimeMillis()+originalFilename;
			
			//创建上传路径
			String windowsPath = MyUploadUtil.getProperties("windowsPath");
			
			String upload_path = windowsPath+"\\upload\\"+image_name;
			
			try {
				image_file[i].transferTo(new File(upload_path));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			list_image.add(image_name);
		}
		return list_image;
	}

	private static String getProperties(String string) {
		Properties properties = new Properties();
		InputStream inputStream = MyUploadUtil.class.getClassLoader().getResourceAsStream("filePath.properties");
		
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String property = properties.getProperty(string);
		return property;
	}

}

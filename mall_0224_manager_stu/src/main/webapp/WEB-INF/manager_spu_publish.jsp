<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="image/iocn" href="images/jd.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仿京东商城</title>
<base href="<%=basePath %>" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	//获取一级菜单
		$(function(){
			//首先异步加载json,获取json数据
			$.getJSON("js/json/class_1.js",function(data){
				$(data).each(function(i,json){
					//将数据遍历到下拉框
					$("#spu_publish_class1_select").append("<option value="+json.id+">"+json.flmch1+"</option>")
				});
			});
		});
		
		//获取二级菜单
		 function spu_publish_get_class_2_select(class_1_id){
			$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
				$("#spu_publish_class2_select").empty();	
				$(data).each(function(i,json){
					
						//将数据遍历到下拉框
						$("#spu_publish_class2_select").append("<option value="+json.id+">"+json.flmch2+"</option>")
					});
				
			});
			spu_publish_get_tm_select(class_1_id);
		}
		 
		//获取商标
		 function spu_publish_get_tm_select(class_1_id){
			$.getJSON("js/json/tm_class_1_"+class_1_id+".js",function(data){
					$("#spu_publish_tm_select").empty();
					$(data).each(function(i, json){
					//将数据遍历到下拉框
					$("#spu_publish_tm_select").append("<option value="+json.id+">"+json.ppmch+"</option>")
				});
			});
		 }
		
		function index_image_click(index){
			$("#index_file_"+index).click();	
		}
		
			//获得缩略图，替换点击的图片按钮
		function index_image_change(index){
				var image = $("#index_file_"+index)[0].files[0];
				var image_url = window.URL.createObjectURL(image);
				$("#index_img_"+index).attr("src",image_url);
				
				var len =$("#spu_publish_image_area input").length;
					if((index+1)==len){
						spu_add_click_image(index+1);
				}	
		}
		
		function spu_add_click_image(index){//追加按钮图片
				var a = '<img  id ="index_img_'+index+'" width="100px" onclick="index_image_click('+index+')" src="images/upload_hover.png" style="cursor: pointer;">'
				var b = '<input style="display: none;" id ="index_file_'+index+'" type="file" name="image_file" onChange="index_image_change('+index+')">'
				$("#spu_publish_image_area").append(a+b);
					
		}
			
</script>
</head>
<body>
	<form action="save_spu.do" method="post" enctype="multipart/form-data">
		${success}============================
		<hr>
		<select name ="flbh1" id="spu_publish_class1_select" onChange="spu_publish_get_class_2_select(this.value)" ></select>
		<select name ="flbh2" id="spu_publish_class2_select" ></select>
		<select name ="pp_id"id="spu_publish_tm_select"></select><br>
		
		商品名称：<input id = "aaa"  type="text" name="shp_mch"><br>
		商品描述：<input type="text" name="shp_msh"><br>
		
		商品图片组：
		<div id="spu_publish_image_area">
			<img  id ="index_img_0" width="100px" onclick="index_image_click(0)" src="images/upload_hover.png" style="cursor: pointer;">
			<input style="display: none;" id ="index_file_0" type="file" name="image_file" onChange="index_image_change(0)">
		</div>
		
		<input type="submit" value="发布商品信息">
	</form>
</body>
</html>
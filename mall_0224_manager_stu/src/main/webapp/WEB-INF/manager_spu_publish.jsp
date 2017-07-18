<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>京东商城</title>
<base href="<%=basePath %>" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
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
		function index_image_click(){
			$("#index_file").click();	
		}
			//获得缩略图，替换点击的图片按钮
		function index_image_change(){
				var image = $("index_file")[0].image_file[0];
				alert(image);
				var image_url = window.URL.createObjectURL(image);
				$("#index_img").attr("src",image_url);
		}
</script>
</head>
<body>
	<form action="save_spu.do" method="post" enctype="multipart/form-data">
		${success}
		<hr>
		
		<select name ="flbh1" id="spu_publish_class1_select" onChange="spu_publish_get_class_2_select(this.value)" ></select>
		<select name ="flbh2" id="spu_publish_class2_select" ></select>
		<select name ="pp_id"id="spu_publish_tm_select"></select><br>
		
		商品名称：<input type="text" name="shp_mch"><br>
		商品描述：<input type="text" name="shp_msh"><br>
		
		商品图片组：
		<img  id ="index_img" width="100px" onclick="index_image_click()" src="image/upload_hover.png" style="cursor: pointer;">
		<input id ="index_file" type="file" name="image_file" onChange="index_image_change()">
		
		<input type="submit" value="发布商品信息">
	</form>
</body>
</html>
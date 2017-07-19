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
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
//获取一级菜单
	$(function(){
		//首先异步加载json,获取json数据
		$.getJSON("js/json/class_1.js",function(data){
			$(data).each(function(i,json){
				//将数据遍历到下拉框
				$("#attr_publish_class1_select").append("<option value="+json.id+">"+json.flmch1+"</option>")
			});
		});
	});

	//获取二级菜单
	 function attr_publish_get_class_2_select(class_1_id){
		$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
			$("#attr_publish_class2_select").empty();	
			$(data).each(function(i,json){
					//将数据遍历到下拉框
					$("#attr_publish_class2_select").append("<option value="+json.id+">"+json.flmch2+"</option>")
				});
			
		});
	}
	function attr_publish_list_inner(class_2_id){
		$.post("goto_attr_by_class2_id.do",{class_2_id:class_2_id},function(html){
			$("#manager_publish_attr_list_inner").append(html);
		})
		
	}

</script>
</head>
<body>
		<select name ="flbh1" id="attr_publish_class1_select" onChange="attr_publish_get_class_2_select(this.value)" ></select>
		<select name ="flbh2" id="attr_publish_class2_select" onChange="attr_publish_list_inner(this.value)"></select>
		<hr>
		<div id="manager_publish_attr_list_inner">
			
		</div>


</body>
</html>
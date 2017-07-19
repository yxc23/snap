<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仿京东商城</title>
<base href="<%=basePath %>" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function a (){
		
	}
	
</script>
</head>
<body>
		${class_2_id } ${class_2_name }的分类属性：
	<c:forEach items="${list_attr }" var="attr">
		${attr.shxm_mch } 
		<br>
		<c:forEach items="${attr.list_value }" var="val">
			${val.shxzh } ${val.shxzh_mch }
		</c:forEach>
	</c:forEach>
	<a href="goto_add_attr/${class_2_id}/${class_2_name}.do">分类属性添加</a>
</body>
</html>
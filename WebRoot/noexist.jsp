<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<title>该用户不存在</title>

		<link rel="stylesheet" href="<%=path%>/css/demo.css" type="text/css" />
		<link rel="stylesheet" href="<%=path%>/css/easyui.css" type="text/css" />
		<link rel="stylesheet" href="<%=path%>/css/icon.css" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<h1>
			错误页面
		</h1>
		<p>
			该用户不存在！
		</p>
		<script type="text/javascript">
	$.messager.alert('提示', "该用户不存在！");
</script>
	</body>
</html>

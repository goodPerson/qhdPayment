<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
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
			����ҳ��
		</h1>
		<p>
			û�и��û���Ϣ��
		</p>
		<script type="text/javascript">
	$.messager.alert('��ʾ', "�Բ��𣬲����ڸ��û���ְλ��Ϣ��");
</script>
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>����ҳ��</title>
    
	<link rel="stylesheet" href="<%=path%>/css/demo.css" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/easyui.css" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/icon.css" type="text/css" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/DatePicker.js"></script>

  </head>
  
  <body>
  <h1> ����ҳ��  </h1>
  <p>�Բ�����û��Ȩ�޷��ʣ�</p>
  <script type="text/javascript">  
  $.messager.alert('��ʾ', "�Բ�����û��Ȩ�޷��ʣ�");
   </script>
  </body>
</html>

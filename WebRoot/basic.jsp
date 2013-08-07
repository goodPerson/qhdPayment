<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>渠道经理首页</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/demo.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
	<script type="text/javascript" src="<%=path%>/css/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="<%=path%>/css/jquery.easyui.min.js"></script>
</head>
<body>
 <%@include file="/common/top.jsp" %>
	<table class="easyui-datagrid" title="渠道经理月统计" style="position:absolute;height:80px"
			data-options="singleSelect:true,collapsible:true">
		<thead>
			<tr>
				<th data-options="field:'month',width:200,align:'center'"">月份</th>
				<th data-options="field:'chnlcount',width:200,align:'center'">渠道数量</th>
				<th data-options="field:'monthscoretotal',width:200,align:'center'">月累计积分</th>
				<th data-options="field:'monthpaytotal',width:200,align:'center'">月累计薪酬</th>
			</tr>
		</thead>
	</table>
</body>
</html>
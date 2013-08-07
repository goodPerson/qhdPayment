<%@ page contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title></title>
</head>
<body style="padding:10px;background-color:#D6D3CE;">
<center><h2></h2></center>
<font color="#FF0000"><b></b></font><br/>
<textarea rows="22" cols="106">
	<!-- 输出异常信息内容 -->
	<s:property value="exception.message"/>
</textarea>
</body>
</html>
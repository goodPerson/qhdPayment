<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style type="text/css">
#topMenu a:link {color: #FFFFFF;text-decoration: none;}     /* 未访问的链接 */
#topMenu a:visited {color:#FFFFFF;text-decoration: none;}  /* 已访问的链接 */
#topMenu a:hover {color: #FFFFFF;text-decoration: none;}    /* 当有鼠标悬停在链接上 */
#topMenu a:active {color: #FFFFFF;text-decoration: none;}   /* 被选择的链接 */
.nav-Style{
width:122px;
height:31px;
line-height:30px; 
background-image:url(css/images/daohang.1.gif);
font-size:14px;
color:#FFFFFF;
font-family:"宋体";
text-align:center;
vertical-align : center; 
overflow:hidden; 
float:left;
margin-right:10px;
}
.nav-Out{
border-bottom:1px #027DCA solid;
height:31px;
border-bottom:1px solid #95B8E7;
padding-left:10px;
padding-top:10px;
text-align:left;
margin-bottom:10px;
}
.top{
font-size:20px;
font-family:"宋体";
font-weight:bold;
margin-top:20px;
pddding-top:10px;
text-align:center;
}
</style>
<div class="top">渠道经理计件薪酬系统</div>
<div id="topMenu" class="nav-Out" >

	<s:if test="#session.chanlMager.post=='渠道经理'">
	    <div></div>&nbsp;
		<div class="nav-Style"> <a href="magerIndexStati_Action.action?staticId=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">我的薪酬 </a></div>&nbsp;
		<div class="nav-Style"> <a href="pieceUrl.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">计件分项月统计 </a></div>&nbsp; 
		<div class="nav-Style"> <a href="pieceUrlday.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">计件分项日统计 </a></div>&nbsp;
	</s:if>
	<s:elseif test="#session.chanlMager.post=='区县负责人'">
	    <div></div>&nbsp; 
	    <div class="nav-Style"><a href="index_Action.action?userId=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">首页</a></div>&nbsp;
		<div class="nav-Style"><a href="entry.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">渠道经理管理</a></div>&nbsp;   
        <div class="nav-Style"><a href="execute1.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">渠道经理渠道管理</a></div>&nbsp;
        <div class="nav-Style"> <a href="pieceUrl.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">计件分项月统计 </a></div>&nbsp;
        <div class="nav-Style"> <a href="pieceUrlday.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">计件分项日统计 </a></div>&nbsp;
        <div class="nav-Style"> <a target="_blank" href="http://www.hebmcbass.com/GisWeb/PieceWorkSys/PieceWorkSysTestPage.aspx?roleName=${roleName }&userId=${staticId }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">营业员计件薪酬 </a></div>&nbsp;
	</s:elseif>
	<s:if test="#session.post=='市负责人'">
	    <div></div>&nbsp; 
	    <div class="nav-Style"><a href="index_Action.action?userId=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">首页</a></div>&nbsp;
		<div class="nav-Style"><a href="entry.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">渠道经理管理</a></div>&nbsp;   
        <div class="nav-Style"><a href="execute1.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">渠道经理渠道管理</a></div>&nbsp;
	    <div class="nav-Style"><a href="execute.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">调节系数管理</a></div>&nbsp;
        <div class="nav-Style"><a href="myPieceContent.action?str_isMana=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">计件目录管理</a></div>&nbsp;
	    <div class="nav-Style"> <a href="pieceUrl.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">计件分项月统计 </a></div>&nbsp;
	    <div class="nav-Style"> <a href="pieceUrlday.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">计件分项日统计 </a></div>&nbsp;
	    <div class="nav-Style"> <a target="_blank" href="http://www.hebmcbass.com/GisWeb/PieceWorkSys/PieceWorkSysTestPage.aspx?roleName=${roleName }&userId=${staticId }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">营业员计件薪酬 </a></div>&nbsp;
	</s:if>
	<s:if test="#session.post=='超级管理员'">
	    <div></div>&nbsp;
	    <div class="nav-Style"><a href="index_Action.action?userId=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">首页</a></div>&nbsp;
		<div class="nav-Style"><a href="entry.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">渠道经理管理</a></div>&nbsp;   
        <div class="nav-Style"><a href="execute1.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">渠道经理渠道管理</a></div>&nbsp;
	    <div class="nav-Style"><a href="execute.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">调节系数管理</a></div>&nbsp;
        <div class="nav-Style"><a href="myPieceContent.action?str_isMana=5&userId=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">计件目录管理</a></div>&nbsp;
	    <div class="nav-Style"> <a href="pieceUrl.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">计件分项月统计 </a></div>&nbsp;
	    <div class="nav-Style"> <a href="pieceUrlday.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">计件分项日统计 </a></div>&nbsp;
	    <div class="nav-Style"> <a target="_blank" href="http://www.hebmcbass.com/GisWeb/PieceWorkSys/PieceWorkSysTestPage.aspx?roleName=${roleName }&userId=${staticId }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">营业员计件薪酬 </a></div>&nbsp;
	</s:if>
</div>
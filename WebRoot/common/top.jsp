<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style type="text/css">
#topMenu a:link {color: #FFFFFF;text-decoration: none;}     /* δ���ʵ����� */
#topMenu a:visited {color:#FFFFFF;text-decoration: none;}  /* �ѷ��ʵ����� */
#topMenu a:hover {color: #FFFFFF;text-decoration: none;}    /* ���������ͣ�������� */
#topMenu a:active {color: #FFFFFF;text-decoration: none;}   /* ��ѡ������� */
.nav-Style{
width:122px;
height:31px;
line-height:30px; 
background-image:url(css/images/daohang.1.gif);
font-size:14px;
color:#FFFFFF;
font-family:"����";
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
font-family:"����";
font-weight:bold;
margin-top:20px;
pddding-top:10px;
text-align:center;
}
</style>
<div class="top">��������Ƽ�н��ϵͳ</div>
<div id="topMenu" class="nav-Out" >

	<s:if test="#session.chanlMager.post=='��������'">
	    <div></div>&nbsp;
		<div class="nav-Style"> <a href="magerIndexStati_Action.action?staticId=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�ҵ�н�� </a></div>&nbsp;
		<div class="nav-Style"> <a href="pieceUrl.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�Ƽ�������ͳ�� </a></div>&nbsp; 
		<div class="nav-Style"> <a href="pieceUrlday.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�Ƽ�������ͳ�� </a></div>&nbsp;
	</s:if>
	<s:elseif test="#session.chanlMager.post=='���ظ�����'">
	    <div></div>&nbsp; 
	    <div class="nav-Style"><a href="index_Action.action?userId=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">��ҳ</a></div>&nbsp;
		<div class="nav-Style"><a href="entry.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�����������</a></div>&nbsp;   
        <div class="nav-Style"><a href="execute1.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">����������������</a></div>&nbsp;
        <div class="nav-Style"> <a href="pieceUrl.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�Ƽ�������ͳ�� </a></div>&nbsp;
        <div class="nav-Style"> <a href="pieceUrlday.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�Ƽ�������ͳ�� </a></div>&nbsp;
        <div class="nav-Style"> <a target="_blank" href="http://www.hebmcbass.com/GisWeb/PieceWorkSys/PieceWorkSysTestPage.aspx?roleName=${roleName }&userId=${staticId }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">ӪҵԱ�Ƽ�н�� </a></div>&nbsp;
	</s:elseif>
	<s:if test="#session.post=='�и�����'">
	    <div></div>&nbsp; 
	    <div class="nav-Style"><a href="index_Action.action?userId=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">��ҳ</a></div>&nbsp;
		<div class="nav-Style"><a href="entry.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�����������</a></div>&nbsp;   
        <div class="nav-Style"><a href="execute1.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">����������������</a></div>&nbsp;
	    <div class="nav-Style"><a href="execute.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">����ϵ������</a></div>&nbsp;
        <div class="nav-Style"><a href="myPieceContent.action?str_isMana=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�Ƽ�Ŀ¼����</a></div>&nbsp;
	    <div class="nav-Style"> <a href="pieceUrl.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�Ƽ�������ͳ�� </a></div>&nbsp;
	    <div class="nav-Style"> <a href="pieceUrlday.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�Ƽ�������ͳ�� </a></div>&nbsp;
	    <div class="nav-Style"> <a target="_blank" href="http://www.hebmcbass.com/GisWeb/PieceWorkSys/PieceWorkSysTestPage.aspx?roleName=${roleName }&userId=${staticId }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">ӪҵԱ�Ƽ�н�� </a></div>&nbsp;
	</s:if>
	<s:if test="#session.post=='��������Ա'">
	    <div></div>&nbsp;
	    <div class="nav-Style"><a href="index_Action.action?userId=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">��ҳ</a></div>&nbsp;
		<div class="nav-Style"><a href="entry.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�����������</a></div>&nbsp;   
        <div class="nav-Style"><a href="execute1.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">����������������</a></div>&nbsp;
	    <div class="nav-Style"><a href="execute.action?Id=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">����ϵ������</a></div>&nbsp;
        <div class="nav-Style"><a href="myPieceContent.action?str_isMana=5&userId=${ staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�Ƽ�Ŀ¼����</a></div>&nbsp;
	    <div class="nav-Style"> <a href="pieceUrl.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�Ƽ�������ͳ�� </a></div>&nbsp;
	    <div class="nav-Style"> <a href="pieceUrlday.action?Id=${staticId }&roleName=${roleName }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">�Ƽ�������ͳ�� </a></div>&nbsp;
	    <div class="nav-Style"> <a target="_blank" href="http://www.hebmcbass.com/GisWeb/PieceWorkSys/PieceWorkSysTestPage.aspx?roleName=${roleName }&userId=${staticId }&userName=${userName }&regionId=${regionId }&regionName=${regionName }">ӪҵԱ�Ƽ�н�� </a></div>&nbsp;
	</s:if>
</div>
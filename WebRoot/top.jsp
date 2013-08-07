<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<s:property value="#session.chanlMager.post"/>
    <s:if test="{#session.chanlMager.id.trim=='6'}">
	 <a class='easyui-linkbutton' href="magerIndexStati_Action.action?staticId=${ staticId }">我的薪酬 </a>&nbsp;  
	</s:if>
	<s:elseif test="{#session.chanlMager.post=='区县负责人'}">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">渠道经理管理</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">渠道经理渠道管理</a>&nbsp;
	</s:elseif>
	<s:else>
	测试
	</s:else> 
	
	<s:if test="#session.chanlMager.post=='12121'">
	   撒旦撒旦撒旦 
	</s:if>
	<s:elseif test="#session.chanlMager.post=='121212'">
	 大幅度反弹
	</s:elseif>
	<s:else>
	测试
	</s:else> 
	<!-- 
	<s:if test="#session.post=='市负责人'">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">渠道经理管理</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">渠道经理渠道管理</a>&nbsp;
	 <a class='easyui-linkbutton' href="execute.action?Id=${ staticId }">调节系数管理</a>&nbsp;
     <a class='easyui-linkbutton' href="myPieceContent.action?str_isMana=${ staticId }">计件目录管理</a>&nbsp;
	</s:if>
	<s:if test="#session.post=='超级管理员'">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">渠道经理管理</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">渠道经理渠道管理</a>&nbsp;
	 <a class='easyui-linkbutton' href="execute.action?Id=${ staticId }">调节系数管理</a>&nbsp;
     <a class='easyui-linkbutton' href="myPieceContent.action?str_isMana=${ staticId }">计件目录管理</a>&nbsp;
	</s:if>
 -->
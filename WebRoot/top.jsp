<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<s:property value="#session.chanlMager.post"/>
    <s:if test="{#session.chanlMager.id.trim=='6'}">
	 <a class='easyui-linkbutton' href="magerIndexStati_Action.action?staticId=${ staticId }">�ҵ�н�� </a>&nbsp;  
	</s:if>
	<s:elseif test="{#session.chanlMager.post=='���ظ�����'}">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">�����������</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">����������������</a>&nbsp;
	</s:elseif>
	<s:else>
	����
	</s:else> 
	
	<s:if test="#session.chanlMager.post=='12121'">
	   ������������ 
	</s:if>
	<s:elseif test="#session.chanlMager.post=='121212'">
	 ����ȷ���
	</s:elseif>
	<s:else>
	����
	</s:else> 
	<!-- 
	<s:if test="#session.post=='�и�����'">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">�����������</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">����������������</a>&nbsp;
	 <a class='easyui-linkbutton' href="execute.action?Id=${ staticId }">����ϵ������</a>&nbsp;
     <a class='easyui-linkbutton' href="myPieceContent.action?str_isMana=${ staticId }">�Ƽ�Ŀ¼����</a>&nbsp;
	</s:if>
	<s:if test="#session.post=='��������Ա'">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">�����������</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">����������������</a>&nbsp;
	 <a class='easyui-linkbutton' href="execute.action?Id=${ staticId }">����ϵ������</a>&nbsp;
     <a class='easyui-linkbutton' href="myPieceContent.action?str_isMana=${ staticId }">�Ƽ�Ŀ¼����</a>&nbsp;
	</s:if>
 -->
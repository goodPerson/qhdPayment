<s:if test="#session.post=='��������'">
	 <a class='easyui-linkbutton' href="magerIndexStati_Action.action?staticId=${ staticId }">�ҵ�н�� </a>&nbsp;  
	</s:if>
	<s:elseif test="#session.post=='���ظ�����'">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">�����������</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">����������������</a>&nbsp;
	</s:elseif> 
	<s:elseif test="�и�����">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">�����������</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">����������������</a>&nbsp;
	 <a class='easyui-linkbutton' href="execute.action?Id=${ staticId }">����ϵ������</a>&nbsp;
     <a class='easyui-linkbutton' href="myPieceContent.action?str_isMana=${ staticId }">�Ƽ�Ŀ¼����</a>&nbsp;
	</s:elseif>
	<s:elseif test="��������Ա">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">�����������</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">����������������</a>&nbsp;
	 <a class='easyui-linkbutton' href="execute.action?Id=${ staticId }">����ϵ������</a>&nbsp;
     <a class='easyui-linkbutton' href="myPieceContent.action?str_isMana=${ staticId }">�Ƽ�Ŀ¼����</a>&nbsp;
	</s:elseif>
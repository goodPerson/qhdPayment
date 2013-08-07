<s:if test="#session.post=='渠道经理'">
	 <a class='easyui-linkbutton' href="magerIndexStati_Action.action?staticId=${ staticId }">我的薪酬 </a>&nbsp;  
	</s:if>
	<s:elseif test="#session.post=='区县负责人'">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">渠道经理管理</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">渠道经理渠道管理</a>&nbsp;
	</s:elseif> 
	<s:elseif test="市负责人">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">渠道经理管理</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">渠道经理渠道管理</a>&nbsp;
	 <a class='easyui-linkbutton' href="execute.action?Id=${ staticId }">调节系数管理</a>&nbsp;
     <a class='easyui-linkbutton' href="myPieceContent.action?str_isMana=${ staticId }">计件目录管理</a>&nbsp;
	</s:elseif>
	<s:elseif test="超级管理员">
	 <a class='easyui-linkbutton' href="entry.action?Id=${ staticId }">渠道经理管理</a>&nbsp;   
     <a class='easyui-linkbutton' href="execute1.action?Id=${ staticId }">渠道经理渠道管理</a>&nbsp;
	 <a class='easyui-linkbutton' href="execute.action?Id=${ staticId }">调节系数管理</a>&nbsp;
     <a class='easyui-linkbutton' href="myPieceContent.action?str_isMana=${ staticId }">计件目录管理</a>&nbsp;
	</s:elseif>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>员工基础信息列表</title>
<link rel="stylesheet" href="<%=path%>/css/easyui.css" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/icon.css" type="text/css" />
<script type="text/javascript" src="<%=path%>/css/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="<%=path%>/css/demo.css" type="text/css" />
<script type="text/javascript">
	var objWidth;
	var objHeight;
	$(function() {
	
		var a;	
		var upMsg='<s:property value="upMsg" />';
		var imsg='<s:property value="imsg"/>';
		var addMsg='<s:property value="addMsg" />';
		var actionMsg ='<s:property value="actionMsg" />';
		
		if (upMsg!="" || upMsg.length>0){
			a=upMsg;
		}else if (imsg!="" || imsg.length>0){
		  a=imsg;
		}else if (addMsg!="" || addMsg.length>0){
			a=addMsg;
		}else if (actionMsg!="" || actionMsg.length>0){
			a=actionMsg;
		}else{
			a="";
		}
		if (a!="" || a.length>0){
			$.messager.alert('提示',a);
		}
	//	objWidth = $(document.body).width();
	//	objHeight = $(document.body).height();
		var d = new Date();
		var vYear = d.getFullYear();
		var vMon = d.getMonth() + 1;
		var month = encodeURI(vYear + (vMon < 10 ? "0" + vMon : vMon));
		
		
	//	$('#dataDiv').height(objHeight * 0.3);		
		$('#fromDate').combobox({  
		valueField: 'label',
		textField: 'value', 
		data: [{
					label: vYear+'01',
					value: vYear+'01'
				},{
					label: vYear+'02',
					value: vYear+'02'
				},{
					label: vYear+'03',
					value: vYear+'03'
				},{
					label: vYear+'04',
					value: vYear+'04'
				},{
					label: vYear+'05',
					value: vYear+'05'
				},{
					label: vYear+'06',
					value: vYear+'06'
				},{
					label: vYear+'07',
					value: vYear+'07'
				},{
					label: vYear+'08',
					value: vYear+'08'
				},{
					label: vYear+'09',
					value: vYear+'09'
				},{
					label: vYear+'10',
					value: vYear+'10'
				},{
					label: vYear+'11',
					value: vYear+'11'
				},{
					label: vYear+'12',
					value: vYear+'12'
				}]
});		
		$('#toDate').combobox({  
		valueField: 'label',
		textField: 'value', 
		data: [{
					label: vYear+'01',
					value: vYear+'01'
				},{
					label: vYear+'02',
					value: vYear+'02'
				},{
					label: vYear+'03',
					value: vYear+'03'
				},{
					label: vYear+'04',
					value: vYear+'04'
				},{
					label: vYear+'05',
					value: vYear+'05'
				},{
					label: vYear+'06',
					value: vYear+'06'
				},{
					label: vYear+'07',
					value: vYear+'07'
				},{
					label: vYear+'08',
					value: vYear+'08'
				},{
					label: vYear+'09',
					value: vYear+'09'
				},{
					label: vYear+'10',
					value: vYear+'10'
				},{
					label: vYear+'11',
					value: vYear+'11'
				},{
					label: vYear+'12',
					value: vYear+'12'
				}]
});
$('#fromDate').combobox('setValue',month);
$('#toDate').combobox('setValue',month);
		var quanXianPost=$("#postsession").val();
	    var quanXianCountyName=$("#countysession").val();
         //combobox级联		 
		 $('#county').combobox({
		     url:'county.action',
		     valueField:'id',  
		     textField:'countyName', 
		     panelHeight:'auto',
		     onChange:function(newValue,oldValue){		  
		          $('#area').combobox({
			                    disabled:false,
			                    url:'area.action?countyName='+ encodeURI(encodeURI(newValue)),
			                    valueField:'id',
			                    textField:'areaName'
			      });			      
	     		$('#area').combobox('setValue', '--全部--');
		     }
	    });  
	    
	    $('#searchCounty').combobox({
		     url:'county.action',  
		     valueField:'id',  
		     textField:'countyName', 
		     panelHeight:'auto',
		     onChange:function(newValue,oldValue){		  
		          $('#searchArea').combobox({
			                    disabled:false,
			                    url:'area.action?countyName='+ encodeURI(encodeURI(newValue)),
			                    valueField:'id',
			                    textField:'areaName'			                    
			      });
	    		 $('#searchArea').combobox('setValue', '--全部--');
		     }
	    }); 
	    
	    var d = new Date();
		var vYear = d.getFullYear();
		var vMon = d.getMonth() + 1;
		var vDay = d.getDate();
		var date = vYear + (vMon < 10 ? "0" + vMon : vMon)
				+ (vDay < 10 ? "0" + vDay : vDay);
	     $('#stat').combobox({
		     onChange:function(newValue,oldValue){		  
		          if(newValue=='离职'){$('#leftdate').val(date);}else{$('#leftdate').val('');}
		     }
	    }); 

	   
	    if(quanXianPost!="区县负责人"){
	     document.getElementById("file").style.display = "none";
	     document.getElementById("adduser").style.display = "none"; 
	     document.getElementById("importuser").style.display = "none";
	     $('#searchCounty').combobox('setValue', '--全部--');
	     $('#searchArea').combobox('setValue', '--全部--');
	      $('#dg').datagrid({
			url : 'searchUser.action',
			pagination : true,
			title : '渠道经理基础信息',
			iconCls : 'icon-save',
			width : 'auto',
			height : 500,
			rownumbers : true,
			singleSelect : true,
			nowrap : false,
			striped : true,
			collapsible : false,
			remoteSort : true,
			idField : 'value4',
			fitColumns : true,
			loadMsg : '数据加载中请稍后……',
			toolbar : '#tb',
			columns : [ [ {
				field : 'value1',
				title : '月份',
				width : $(this).width() * 0.2,//fixWidth(0.2),//
				align : 'center'
			}, {
				field : 'value2',
				title : '县区',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value3',
				title : '姓名',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value4',
				title : '工号',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value5',
				title : '负责区域',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value6',
				title : '状态',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value7',
				title : '岗位',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value8',
				title : '入职时间',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value9',
				title : '离职时间',
				width : $(this).width() * 0.2,
				align : 'center'
			}] ]
		});
	     }else{
	     document.getElementById("adduser").style.display = ""; 
	     document.getElementById("importuser").style.display = ""; 
	     $('#searchCounty').combobox('setValue', quanXianCountyName);
	     $('#searchArea').combobox('setValue', '--全部--');
	      $('#dg').datagrid({
			url : 'searchUser.action',
			pagination : true,
			title : '渠道经理基础信息',
			iconCls : 'icon-save',
			width : 'auto',
			height : 500,
			rownumbers : true,
			fitColumns : true,
			singleSelect : true,
			nowrap : false,
			striped : true,
			collapsible : false,
			remoteSort : true,
			idField : 'value4',
			loadMsg : '数据加载中请稍后……',
			toolbar : '#tb',
			columns : [ [ {
				field : 'value1',
				title : '月份',
				width : $(this).width() * 0.2,//fixWidth(0.2),//
				align : 'center'
			}, {
				field : 'value2',
				title : '县区',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value3',
				title : '姓名',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value4',
				title : '工号',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value5',
				title : '负责区域',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value6',
				title : '状态',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value7',
				title : '岗位',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value8',
				title : '入职时间',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				field : 'value9',
				title : '离职时间',
				width : $(this).width() * 0.2,
				align : 'center'
			}, {
				title : '操作',
				field : 'value10',
				width : $(this).width() * 0.2,
				align : 'center',
				sortable : true
			}  ] ]
		});
	     }
	     var p = $('#dg').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10  
			pageList : [ 10, 15, 20 ],//可以设置每页记录条数的列表  
			beforePageText : '第',//页数文本框前显示的汉字  
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});	
		
		
	});
</script>
<script type="text/javascript">   
	var url;
	var flag;	
	function addUser() {
	    document.getElementById("dlg-buttons").style.display = ""; 
	    document.getElementById("dlg").style.display = "";	
		var d = new Date();
		var vYear = d.getFullYear();
		var vMon = d.getMonth() + 1;
		var vDay = d.getDate();
		var date = vYear + (vMon < 10 ? "0" + vMon : vMon)
				+ (vDay < 10 ? "0" + vDay : vDay);
		var quanXianCountyName='<%=request.getAttribute("quanXianCountyName")%>';
		$('#ff').form('clear');
		$('#dlg').dialog('open').dialog('setTitle', '创建工号');
		$('#name').val('');
		$('#id').val('');
		//$('#id').attr("disabled",false);
		document.getElementById("id").readOnly=false;
		$('#county').combobox('setValue', quanXianCountyName);
		$('#area').combobox('setValue', '--全部--');
		$('#stat').combobox('setValue', '试用期');
		$('#post').combobox('setValue', '渠道经理');
		$('#entrydate').val(date);
		$('#leftdate').val('');
		document.getElementById("leftdate").readOnly=true;
		flag = "addUser";
	}
	function editUser() {
	    document.getElementById("dlg-buttons").style.display = ""; 
	    document.getElementById("dlg").style.display = "";
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', '编辑信息');
			$('#id').focus().select();
			var selectRow = $('#dg').datagrid('getSelected');//获取选中行
			$('#county').combobox('setValue', selectRow.value2);
			$('#name').val(selectRow.value3);
			$('#id').val(selectRow.value4);
		//	$('#id').attr("disabled",true);
			document.getElementById("id").readOnly=true;
			$('#area').combobox('setValue', selectRow.value5);
			$('#stat').combobox('setValue', selectRow.value6);
			$('#post').combobox('setValue', selectRow.value7);
			$('#entrydate').val(selectRow.value8);
			if (selectRow.value9 == '--') {
				$('#leftdate').val('');
			} else {
				$('#leftdate').val(selectRow.value9);
			}

		}		
		flag = "editUser";
	}
	function saveUser() {
		var d = new Date();
		var vYear = d.getFullYear();
		var vMon = d.getMonth() + 1;
		var month = encodeURI(vYear + (vMon < 10 ? "0" + vMon : vMon));
		month = encodeURI(month);
		var county = encodeURI($('#county').combobox('getText'));
		county = encodeURI(county);
		var area = encodeURI($('#area').combobox('getText'));
		area = encodeURI(area);
		var post = encodeURI($('#post').combobox('getText'));
		post = encodeURI(post);
		var stat = encodeURI($('#stat').combobox('getText'));
		stat = encodeURI(stat);
		var id = encodeURI($('#id').val());
		id = encodeURI(id);
		var name = encodeURI($('#name').val());
		name = encodeURI(name);
		var entrydate = encodeURI($('#entrydate').val());
		entrydate = encodeURI(entrydate);
		var leftdate = encodeURI($('#leftdate').val());
		leftdate = encodeURI(leftdate);

		if (flag == "editUser") {
		
			var url='updateAndAddUser.action?StatisMonth=' + month
							+ '&CountyName=' + county + '&Name=' + name
							+ '&Id=' + id + '&PrncpArea=' + area + '&UserStat='
							+ stat + '&Post=' + post + '&EntryTime='
							+ entrydate + '&LeftTime=' + leftdate;
                $("#dlg").dialog('close');
                window.location.href=url;  
              //  $("#dg").datagrid('reload');
 //               var a = '<s:property value="upMsg"/>';
 //               $.messager.alert('提示', a);
                /*
			$.ajax({
				url : 'updateAndAddUser.action?StatisMonth=' + month
						+ '&CountyName=' + county + '&Name=' + name + '&Id='
						+ id + '&PrncpArea=' + area + '&UserStat=' + stat
						+ '&Post=' + post + '&EntryTime=' + entrydate
						+ '&LeftTime=' + leftdate,
				type : 'post',
				dataType : 'text',
				success : function(msg) {
					//关闭dialog
					$("#dlg").dialog('close');
					$.messager.alert('提示', msg);
					//重新加载数据
					//$("#dg").datagrid('reload');
				}
			});*/
		} else {
			if (id == "") {
				$.messager.alert('提示', '工号不能为空，请输入工号！');
			} else if (name == "") {
				$.messager.alert('提示', '姓名不能为空，请输入姓名！');
			}else if($('#area').combobox('getText')=='--全部--'){
				$.messager.alert('提示', '请选择区域！');
			}else {
			
				var url='addTbBasicInfoM.action?StatisMonth=' + month
							+ '&CountyName=' + county + '&Name=' + name
							+ '&Id=' + id + '&PrncpArea=' + area + '&UserStat='
							+ stat + '&Post=' + post + '&EntryTime='
							+ entrydate + '&LeftTime=' + leftdate;
                $("#dlg").dialog('close');
                window.location.href=url;  
              //  $("#dg").datagrid('reload');
              //  var a = '<s:property value="addMsg"/>';
              //  $.messager.alert('提示', a);
			
			/*
				$.ajax({
					url : 'addTbBasicInfoM.action?StatisMonth=' + month
							+ '&CountyName=' + county + '&Name=' + name
							+ '&Id=' + id + '&PrncpArea=' + area + '&UserStat='
							+ stat + '&Post=' + post + '&EntryTime='
							+ entrydate + '&LeftTime=' + leftdate,
					type : 'post',
					dataType : 'text',
					success : function(msg) {
						//关闭dialog
						$("#dlg").dialog('close');
						$.messager.alert('提示', msg);
						//重新加载数据
						//$("#dg").datagrid('reload');
					}
				});*/
			}
		}

	}
	function delUser() {
		$.messager.confirm('删除', '您确认删除这条记录么?', function(r) {
			if (r) {
				var selectRow = $("#dg").datagrid('getSelected');//获取选中行
				var Id = encodeURI(selectRow.value4);
				Id = encodeURI(Id);
				var url="delUser.action?Id=" + Id;
                $("#dlg").dialog('close');
                window.location.href=url;  
                //$("#dg").datagrid('reload');
               // var a = '<s:property value="actionMsg"/>';
              //  $.messager.alert('提示', a);
				/*$.ajax({
					url : "delUser.action?Id=" + Id,
					type : "post",
					dataType : 'text',
					success : function(msg) {
					$("#dlg").dialog('close');
						//重新加载数据
						$.messager.alert('提示', msg);
						//$("#dg").datagrid('reload');
						
					}
				});*/
			}
		});
	}

	function searchUser() {
		var str = $("#fromDate").combobox('getText');
		$("#fromDate").combobox('setValue',str);
		var fromDate = encodeURI($("#fromDate").combobox('getText'));
		var str1 = $("#toDate").combobox('getText');
		$("#toDate").combobox('setValue',str1);
		var toDate = encodeURI($("#toDate").combobox('getText'));
		var countyName;
		if ($('#searchCounty').combobox('getText') == '--全部--') {
			countyName = '';
		} else {
			countyName = encodeURI($('#searchCounty').combobox('getText'));
		}
		var areaName;
		if ($('#searchArea').combobox('getText') == '--全部--') {
			areaName = '';
		} else {
			areaName = encodeURI($('#searchArea').combobox('getText'));
		}
		//countyName = encodeURI(countyName);
		var id = encodeURI($('#searchId').searchbox('getValue'));
		//id = encodeURI(id);
		var name = encodeURI($('#searchName').searchbox('getValue'));
		//name = encodeURI(name);

		$('#dg').datagrid('load', {
			StatisMonth : fromDate,
			StatisMonth1 : toDate,
			Name : name,
			Id : id,
			CountyName : countyName,
			prncpArea:areaName
		});
	}
	 
     function filecheckmethod(){
				if($('#file').val()=="" || $('#file')==null){
					$.messager.alert('提示',"请输入要上传的文件!");
					return false;
				}
				
				var fileValue = $('#file').val();
				if(fileValue.substring(fileValue.length-4,fileValue.length)!=".xls"){
					fileValue = "";
					$.messager.alert('提示',"请选择以'.xls'结尾的文件");
					
					return false;
				}
				
				return true;	
			}
    
    function importDatas(){
				var fileName = $("#file").val();
				fileName = encodeURI(fileName);
				fileName = encodeURI(fileName);
				if(fileName==""||$("#file")==null){
					$.messager. alert('提示',"路径输入有误");
					return false;
				}
				$("#form1").attr("action","importUser.action");
				$("#form1")[0].submit();
//				var msg='<s:property value="imsg"/>';
//				$.messager.alert('提示', msg);
				return true;
			}
/*	function importUser() {
		document.all.fileBrowser.click();
		var filename = encodeURI(document.all.fileBrowser.value);
		var path = encodeURI(filename);
		//alert(filename);
		var impPath =document.all.fileBrowser.value;
        if ((impPath.lastIndexOf(".xls") == impPath.length - 4)) {     
			if (path != '' && path != null) {
				$.ajax({
					url : 'importUser.action?path=' + path,
					type : 'post',
					dataType : 'text',
					success : function(msg) {
						//关闭dialog
						$("#dlg").dialog('close');
						$.messager.alert('提示', msg);
						//重新加载数据
						$("#dg").datagrid('reload');
						
					}
				});
			}
		}else{
			if(impPath!=''&&impPath!=null){
           		$.messager.alert('提示', '请选择符合模板格式的Excel文件！');
			}
        }
	}  */

	function exportUser() {
		var exportUrl = "exportUser.action";
		window.location.href = exportUrl;
	}
</script>
<script type="text/javascript">
	function myformatter(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + (m < 10 ? ('0' + m) : m) + (d < 10 ? ('0' + d) : d);
	}
	function myparser(s) {
		if (!s){
			return new Date();}
		var ss = (s.split('-'));
		var y = parseInt(ss[0], 10);
		var m = parseInt(ss[1], 10);
		var d = parseInt(ss[2], 10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
			return new Date(y, m - 1, d);
		} else {
			return new Date();
		}
	}
</script>
</head>
<body>
   <jsp:include page="/common/top.jsp"></jsp:include>
	<div style="margin:10px"></div>
	<input id="countysession" type="hidden" value="<s:property value="#session.chanlMager.countyName"/>" style="border:0px;"/>
	<input id="postsession" type="hidden" value="<s:property value="#session.chanlMager.post"/>" style="border:0px;" />	
	<div id="dataDiv" align="center">
		<table id="dg" cellspacing="0" cellpadding="0" align="center">
		</table>
	</div>
	<div style="display:none">
		<div id="tb">
		<form   method="post" id="form1" enctype="multipart/form-data" name="form1" onsubmit="return excuteQuery();">
		 <div>
			 <input id="file" type="file" name="file" onchange="filecheckmethod(this)"  style="height:22px;width:10%;"/>
			 <a  class="easyui-linkbutton"
					id="importuser" iconCls="icon-edit" plain="true" 
					onClick="importDatas()">导入工号</a>
				  &nbsp;&nbsp;&nbsp; <a 
					class="easyui-linkbutton" id="adduser" iconCls="icon-add"
					plain="true" onClick="addUser();">创建工号</a>&nbsp;&nbsp;&nbsp;
				 <input type="file" name="fileBrowser"
					size="125" style="display:none" onChange="fileBrowserChange(this);" />&nbsp;&nbsp;<a
					 id="exportExl" class="easyui-linkbutton"
					iconCls="icon-print" plain="true" onClick="exportUser();">导出EXCEL</a>				
		 </div>
		</form>
			<div>
			<table>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月份:&nbsp;
				从</td>
			<td><select id="fromDate"
					name="fromDate" class="easyui-combobox" style="width:120px; height:22px;vertical-align:middle;" 
					panelHeight="auto">
				</select></td>
			<td> &nbsp;
				到&nbsp;<select id="toDate"
					name="toDate" class="easyui-combobox" style="width:120px; height:22px;vertical-align:middle;" 
					panelHeight="auto">
				</select></td>
			<td>&nbsp;
				县区:&nbsp; <select id="searchCounty"
					name="searchCounty" class="easyui-combobox" style="width:120px; height:22px;vertical-align:middle;"
					data-options="  
	                    url:'county.action',  
	                    valueField:'id',  
	                    textField:'countyName',  
	                    panelHeight:'auto'">
				</select></td>
			<td>&nbsp;
				区域:&nbsp;<select id="searchArea"
					name="searchArea" class="easyui-combobox" style="width:120px; height:22px;vertical-align:middle;"
					data-options="  
	                    url:'area.action',  
	                    valueField:'id',  
	                    textField:'areaName',  
	                    panelHeight:'auto'">
				</select></td>
			<td> &nbsp;姓名:&nbsp; <input
					name="searchName" type="text"  class="easyui-searchbox" id="searchName" data-options="prompt:'请输入姓名...'" style="height:22px; display:table-cell;width:120px;vertical-align:bottom;" /> </td>
			<td>&nbsp;工号:
				&nbsp; <input name="searchId" type="text" class="easyui-searchbox" id="searchId" 
				 style="height:22px; display:table-cell;width:120px;vertical-align:bottom;" data-options="prompt:'请输入工号...'"/> </td>	
				 <td>&nbsp; <a 
					class="easyui-linkbutton" iconCls="icon-search" style="height:15px" 
					onClick="searchUser();">查询</a></td>	
			</tr>
			</table>
				
			</div>
		</div>
		<div id="dlg" class="easyui-dialog"
			style="width:400px;height:480px;padding:10px 20px;" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle" align="center">
				<label style="text-align:center; font-weight:900">渠道经理基础信息</label>
			</div>
			<div>&nbsp;</div>
			<form id="fm" method="post" novalidate>
				<div align="center">
					<div class="fitem">
						<label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
						<input name="id" id="id" type="text">
					</div>
					<div>&nbsp;</div>
					<div style="height:1px"></div>
					<div class="fitem">
						<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
						<input name="name" id="name" type="text">
					</div>
					<div>&nbsp;</div>
					<div style="height:1px"></div>
					<div class="fitem">
						<label>县&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区:</label>
						<select name="county" id="county" class="easyui-combobox"
							 style="width:134px;"
							data-options="  
	                    url:'county.action',  
	                    valueField:'id',  
	                    textField:'countyName',  
	                    panelHeight:'auto' ">
							<option>--请选择县区--</option>
						</select>
					</div>
					<div>&nbsp;</div>
					<div style="height:1px"></div>
					<div class="fitem">
						<label>负责区域:</label> <select name="area" id="area"
							class="easyui-combobox" panelHeight="auto"
							 style="width:134px;">
							<option>--请选择区域--</option>
						</select>
					</div>
					<div>&nbsp;</div>
					<div style="height:1px"></div>
					<div class="fitem">
						<label>状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</label>
						<select name="stat" id="stat" class="easyui-combobox"
							panelHeight="auto"  style="width:134px;">
							<option value="试用期" selected="selected">试用期</option>
							<option value="在职">在职</option>
							<option value="离职">离职</option>
						</select>
					</div>
					<div>&nbsp;</div>
					<div style="height:1px"></div>
					<div class="fitem">
						<label>岗&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:</label>
						<select name="post" id="post" class="easyui-combobox"
							panelHeight="auto"  style="width:134px;">
							<option value="渠道经理" selected="selected">渠道经理</option>
							<option value="区县负责人">区县负责人</option>
							<option value="市负责人">市负责人</option>
							<option value="超级管理员">超级管理员</option>
						</select>
					</div>
					<div>&nbsp;</div>
					<div style="height:1px"></div>
					<div class="fitem">
						<label>入职时间:</label> <input name="entrydate" id="entrydate" type="text" value="yyyyMMdd" >
					</div>
					<div>&nbsp;</div>
					<div style="height:1px"></div>
					<div class="fitem">
						<label>离职时间:</label>  <input name="leftdate" id="leftdate" type="text" value="yyyyMMdd">
					</div>
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a  class="easyui-linkbutton"
				iconCls="icon-ok" onClick="saveUser()">保存</a>
				 <a	 class="easyui-linkbutton"	iconCls="icon-cancel" onClick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
	</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>调节系数信息管理</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/icon.css" />
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/demo.css" />
<style type="text/css">
#container {
	text-align: center;
}

#topDiv {
	border: 1px solid #ccc;
	display: none;
}

#dataDiv {
	
}

#editTable {
	margin: 5px 0px 5px 0px;
}
#editForm {
	display: none;
}

#combobox {
	display: none;
}

#dlg-buttons {
	display: none;
}

#editForm {
	display: none;
}
</style>
<script type="text/javascript">
            $(function(){
            var a;	
			var umsg='<s:property value="umsg" />';
			var dmsg='<s:property value="dmsg" />';
			
			if (umsg!="" || umsg.length>0){
				a=umsg;
			}else if (dmsg!="" || dmsg.length>0){
				a=dmsg;
			}else{
				a="";
			}
			if (a!="" || a.length>0){
				$.messager.alert('提示',a);
			}
            
           		var quanXianPost=$("#sessionpost").val();
	    		var quanXianCountyName=$("#sessioncounty").val();
                var objWidth = document.body.clientWidth;
                var objHeight = document.body.clientHeight;
                $("#container").width(objWidth - 20);
                $("#container").height(objHeight);
                $("#topDiv").height(objHeight * 0.3);
                $("#dataDiv").height(objHeight * 0.7);
                
                if(quanXianPost!="区县负责人"){
                	$('#combo').combobox('setValue', '--全部--');
                }else{
                	var quanXianCountyName=$("#sessioncounty").val();
                	$('#combo').combobox('setValue', quanXianCountyName);
                }   
                
                  //定义表格
              if(quanXianPost!="超级管理员"){
                $('#dataGrid').datagrid({
                    url :'setJson.action',
					pagination : true,
					title: '调节系数信息表',
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
					idField : 'value3',
					loadMsg : '数据加载中请稍后……',
					toolbar : '#combobox', 
                    columns: [[{
                        title: '月份',
                        field: 'value1',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '区县',
                        field: 'value2',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '区域',
                        field: 'value3',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '卡号调节系数',
                        field: 'value4',
                        width: fixWidth(0.125),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '终端调节系数',
                        field: 'value5',
                        width: fixWidth(0.125),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '数据业务调节系数',
                        field: 'value6',
                        width: fixWidth(0.2),
                        align: 'center',
                        sortable: true
                    },{
                    title: '营销活动调节系数',
                        field: 'value7',
                        width: fixWidth(0.2),
                        align: 'center',
                        sortable: true
                    },{title: '代收费调节系数',
                        field: 'value8',
                        width: fixWidth(0.2),
                        align: 'center',
                        sortable: true
                        }
                    ]],
                    frozenColumns: [{
                        field: 'ck',
                        checkbox: false
                    }]
                });
                }else{               
                $('#dataGrid').datagrid({
                    url :'setJson.action',
					pagination : true,
					title: '调节系数信息表',
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
					idField : 'value3',
					loadMsg : '数据加载中请稍后……',
					toolbar : '#combobox',                 
                    columns: [[{
                        title: '月份',
                        field: 'value1',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '区县',
                        field: 'value2',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '区域',
                        field: 'value3',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '卡号调节系数',
                        field: 'value4',
                        width: fixWidth(0.125),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '终端调节系数',
                        field: 'value5',
                        width: fixWidth(0.125),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '数据业务调节系数',
                        field: 'value6',
                        width: fixWidth(0.2),
                        align: 'center',
                        sortable: true
                    },{
                    title: '营销活动调节系数',
                        field: 'value7',
                        width: fixWidth(0.2),
                        align: 'center',
                        sortable: true
                    },{title: '代收费调节系数',
                        field: 'value8',
                        width: fixWidth(0.2),
                        align: 'center',
                        sortable: true
                        },{title: '操作',
                        field: 'value9',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                        }
                        
                    
                    ]],
                    frozenColumns: [{
                        field: 'ck',
                        checkbox: false
                    }]
                });
                }
                //设置分页控件   
                var p = $('#dataGrid').datagrid('getPager');
                $(p).pagination({
                    pageSize: 10,//每页显示的记录条数，默认为10   
                    pageList: [10, 15, 20],//可以设置每页记录条数的列表   
                    beforePageText: '第',//页数文本框前显示的汉字   
                    afterPageText: '页    共 {pages} 页',
                    displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
                });
                
                          //级联
           $('#combo').combobox({
		     url:'setJson1.action',  
		     valueField:'id',  
		     textField:'text', 
		     panelHeight:'auto',
		     onChange:function(newValue,oldValue){		  
		          $('#comboArea').combobox({
			                    disabled:false,
			                    url:'setJsonArea.action?countyName='+ encodeURI(encodeURI(newValue)),
			                    valueField:'id',
			                    textField:'text'			                    
			      });
	    		 $('#comboArea').combobox('setValue', '--全部--');
		     }
	     });
	      $('#combo').combobox('setValue', '--全部--'); 
	      $('#comboArea').combobox('setValue', '--全部--'); 
         });
            //定义表格各列宽度
            function fixWidth(percent){
                return ($("#dataDiv").width() - 20) * 0.8 * percent;
            };
           
            //编辑
            function EditCoffcnt(){
            $("#editForm").css("display", "inline");
                $("#dlg").dialog('open');
                $("#county").focus().select();
                $("#area").focus().select();
                $("#cardAccomdCoffcnt").focus().select();
                $("#tmnlAccmdCoffcnt").focus().select();
                $("#dataActAccomdCoffcnt").focus().select();
                $("#marktActAccomdCoffcnt").focus().select();
                $("#generChargeAccomdCofcnt").focus().select();
                var selectRow = $("#dataGrid").datagrid('getSelected');//获取选中行
                var area =selectRow.value3;
                
                $("#statisMonth").val(selectRow.value1);
                $("#county").val(selectRow.value2);
                $("#area").val(selectRow.value3);
                $("#cardAccomdCoffcnt").val(selectRow.value4);
                $("#tmnlAccmdCoffcnt").val(selectRow.value5);
                $("#dataActAccomdCoffcnt").val(selectRow.value6);
                $("#marktActAccomdCoffcnt").val(selectRow.value7);
                $("#generChargeAccomdCofcnt").val(selectRow.value8);
            };
            //保存修改信息
            function saveCoffcnt(){
                var selectRow = $("#dataGrid").datagrid('getSelected');//获取选中行
               // var upateId = selectRow.value3;
                 var area=encodeURI(selectRow.value3);
                    area=encodeURI(area);
                var statisMonth =$("#statisMonth").val();
                var cardAccomdCoffcnt = $("#cardAccomdCoffcnt").val();
                var tmnlAccmdCoffcnt = $("#tmnlAccmdCoffcnt").val();
                var dataActAccomdCoffcnt = $("#dataActAccomdCoffcnt").val();
                var marktActAccomdCoffcnt = $("#marktActAccomdCoffcnt").val();
                var generChargeAccomdCofcnt = $("#generChargeAccomdCofcnt").val();
                //$("#statisMonth").val(selectRow.value1);
                $("#county").val(selectRow.value2);
                $("#area").val(selectRow.value3);
                var updateUrl = "Updatercd.action?statisMonth=" + statisMonth + "&county=" + encodeURI(encodeURI(selectRow.value2)) + "&area=" + encodeURI(encodeURI(selectRow.value3)) + "&cardAccomdCoffcnt=" + cardAccomdCoffcnt + "&tmnlAccmdCoffcnt=" + tmnlAccmdCoffcnt + "&dataActAccomdCoffcnt=" +dataActAccomdCoffcnt+ "&marktActAccomdCoffcnt=" +marktActAccomdCoffcnt+ "&generChargeAccomdCofcnt=" +generChargeAccomdCofcnt ;
                
                if (cardAccomdCoffcnt == "" || tmnlAccmdCoffcnt == "" || dataActAccomdCoffcnt=="" || marktActAccomdCoffcnt=="" || generChargeAccomdCofcnt=="") {
                    $.messager.alert('警告', '调节系数均不能为空！');
                    return false;
                }
                else {
                           $("#dlg").dialog('close');
                         window.location.href=updateUrl;
                        // var mag='<s:property value="umsg"/>';
                       //   $("#dataGrid").datagrid('reload');
                       //    $.messager.alert('提示', mag);
     
              /*      $.ajax({
                        url: updateUrl,
                        type: "post",
                        dataType: 'text',
                        success: function(msg){
                       // alert(updateUrl);
                         
                            //关闭dialog
                            $("#dlg").dialog('close');
                            //重新加载数据
                            $("#dataGrid").datagrid('reload');
                            $.messager.alert('提示', msg);
                        }
                    });*/
                    
                
                }
            };
            //删除信息
            function DelCoffcnt(){
                $.messager.confirm('警告', '您确认删除这条记录么?', function(r){
                    if (r) {
                        var selectRow = $("#dataGrid").datagrid('getSelected');//获取选中行
                        //alert(selectRow.value3);
                        var area = encodeURI(selectRow.value3);
                        area = encodeURI(area);
                        var url="delrecd.action?area=" + area;
                         $("#dlg").dialog('close');
                         window.location.href=url;
                         // var msg='<s:property value="dmsg"/>';
                         // $("#dataGrid").datagrid('reload');
                        //   $.messager.alert('提示', msg);
             /*           $.ajax({
                            url: "delrecd.action?area=" + area,
                            type: "post",
                            dataType: 'text',
                            success: function(msg){
                                //重新加载数据
                                $("#dlg").dialog('close');
                                $("#dataGrid").datagrid('reload');
                                $.messager.alert('提示', msg);
                            }
                        });*/
                    }
                });
            };
            //查询县区的调节系数
            function findCoffcnt(){
              var county = $("#combo").combobox('getText');//获取选中行
              var area=$("#comboArea").combobox('getText');//获取选中行
               county=encodeURI(county);
               area=encodeURI(area);
				$('#dataGrid').datagrid('load',{
				 county:county,
				 area:area
				});
            };
            //导出ＥＸＣＥＬ方法
           function exportCoffcnt(){
            var county = $("#combo").combobox('getText');//获取选中行
               county=encodeURI(encodeURI(county));
              window.location.href="export.action?county=" +county ;
           };
        </script>
</head>
<body>
	<center>
	 <jsp:include page="/common/top.jsp"></jsp:include>
		<div id="container">
			<div id="topDiv">
				<div id="p" class="easyui-panel" title="Panel Tools"
					style="height:200px;padding:5px;"
					data-options="collapsible:true,minimizable:true,maximizable:true,closable:false">
				</div>
			</div>
			<div id="dataDiv">
				<table id="dataGrid" cellspacing="0" cellpadding="0">
				</table>
				 
			</div>
			<div id="dlg" title="修改调节系数" class="easyui-dialog" closed="true"
				buttons="#dlg-buttons" data-options="iconCls:'icon-save'"
				style="width:320px;height:340px;">
				<form id="editForm">
					<table id="editTable">
						<tr>
							<td><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 区县: </label></td>
							<td><input name="county" id="county" border="none"
								readonly="true" /></td>
						</tr>
						<tr>
							<td><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 区域: </label></td>
							<td><input type="text" name="area" id="area" readonly="true" />
							</td>
						</tr>
						<tr>
							<td><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 月份: </label></td>
							<td><input type="text" name="statisMonth" id="statisMonth" />
							</td>
						</tr>
						<tr>
							<td><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 卡号调节系数: </label></td>
							<td><input type="text" name="cardAccomdCoffcnt"
								id="cardAccomdCoffcnt" /></td>
						</tr>
						<tr>
							<td><label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;终端调节系数: </label></td>
							<td><input type="text" name="tmnlAccmdCoffcnt"
								id="tmnlAccmdCoffcnt" /></td>
						</tr>
						<tr>
							<td><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 数据业务调节系数: </label></td>
							<td><input type="text" name="dataActAccomdCoffcnt"
								id="dataActAccomdCoffcnt" /></td>
						</tr>
						<tr>
							<td><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 营销活动调节系数: </label></td>
							<td><input type="text" name="marktActAccomdCoffcnt"
								id="marktActAccomdCoffcnt" /></td>
						</tr>
						<tr>
							<td><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 代收费调节系数: </label></td>
							<td><input type="text" name="generChargeAccomdCofcnt"
								id="generChargeAccomdCofcnt" /></td>
						</tr>
					</table>
					<div id="dlg-buttons">
						<a  class="easyui-linkbutton"
							iconCls="icon-ok" onclick="saveCoffcnt();">保存</a> <a
							 class="easyui-linkbutton"
							iconCls="icon-cancel"
							onclick="javascript:$('#dlg').dialog('close')">取消</a>
					</div>
				</form>
			</div>
		</div>
	</center>
	<div id="combobox">
		&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="easyui-linkbutton" iconCls="icon-print"
					onclick="exportCoffcnt(); "  plain="true">导出Excel</a>
		<div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	区县：<select id="combo" class="easyui-combobox" name="state"
				style="width:150px;"
				data-options="url:'setJson1.action',panelHeight:'auto'">
			</select> 区域：<select id="comboArea" class="easyui-combobox" name="state"
				style="width:150px;" 
				data-options=" panelHeight:'auto'">
			</select> <a class="easyui-linkbutton" iconCls="icon-search"
				onclick="findCoffcnt();">查询</a>
		</div>
	</div>
	<!-- 获取session值 -->	
	<input id="sessioncounty" type="hidden" value="<s:property value="#session.chanlMager.countyName"/>" style="border:0px;"/>
	<input id="sessionpost" type="hidden" value="<s:property value="#session.chanlMager.post"/>" style="border:0px;"/>

</body>
</html>
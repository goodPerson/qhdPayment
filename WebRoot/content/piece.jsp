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
<title>计件目录</title>
<link rel="stylesheet" href="<%=path%>/css/easyui.css" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/icon.css" type="text/css" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="<%=path%>/css/demo.css" type="text/css" />
<script type="text/javascript" src="<%=path%>/js/DatePicker.js">
        </script>
<style type="text/css">
#selectDiv {
	display: table-cell;
	vertical-align: middle;
}

#form2 {
	display: none;
}

#tanchuClick {
	display: none;
}

#exportExl {
	display: none;
}

#editForm {
	display: none;
}
#file {
	display: none;
}
</style>
<script type="text/javascript">
         //   window.onload = init;
          	$(function() {
                var d = new Date();
                var vYear = d.getFullYear();
                $('#fromDate').combobox({
                
                    valueField: 'label',
                    
                    textField: 'value',
                    
                    data: [{
                    
                        label: vYear + '01',
                        
                        value: vYear + '01'
                    
                    }, {
                    
                        label: vYear + '02',
                        
                        value: vYear + '02'
                    
                    }, {
                    
                        label: vYear + '03',
                        
                        value: vYear + '03'
                    
                    }, {
                    
                        label: vYear + '04',
                        
                        value: vYear + '04'
                    
                    }, {
                    
                        label: vYear + '05',
                        
                        value: vYear + '05'
                    
                    }, {
                    
                        label: vYear + '06',
                        
                        value: vYear + '06'
                    
                    }, {
                    
                        label: vYear + '07',
                        
                        value: vYear + '07'
                    
                    }, {
                    
                        label: vYear + '08',
                        
                        value: vYear + '08'
                    
                    }, {
                    
                        label: vYear + '09',
                        
                        value: vYear + '09'
                    
                    }, {
                    
                        label: vYear + '10',
                        
                        value: vYear + '10'
                    
                    }, {
                    
                        label: vYear + '11',
                        
                        value: vYear + '11'
                    
                    }, {
                    
                        label: vYear + '12',
                        
                        value: vYear + '12'
                    
                    }]
                });
                $('#toDate').combobox({
                
                    valueField: 'label',
                    
                    textField: 'value',
                    
                    data: [{
                    
                        label: vYear + '01',
                        
                        value: vYear + '01'
                    
                    }, {
                    
                        label: vYear + '02',
                        
                        value: vYear + '02'
                    
                    }, {
                    
                        label: vYear + '03',
                        
                        value: vYear + '03'
                    
                    }, {
                    
                        label: vYear + '04',
                        
                        value: vYear + '04'
                    
                    }, {
                    
                        label: vYear + '05',
                        
                        value: vYear + '05'
                    
                    }, {
                    
                        label: vYear + '06',
                        
                        value: vYear + '06'
                    
                    }, {
                    
                        label: vYear + '07',
                        
                        value: vYear + '07'
                    
                    }, {
                    
                        label: vYear + '08',
                        
                        value: vYear + '08'
                    
                    }, {
                    
                        label: vYear + '09',
                        
                        value: vYear + '09'
                    
                    }, {
                    
                        label: vYear + '10',
                        
                        value: vYear + '10'
                    
                    }, {
                    
                        label: vYear + '11',
                        
                        value: vYear + '11'
                    
                    }, {
                    
                        label: vYear + '12',
                        
                        value: vYear + '12'
                    
                    }]
                });
                
                var objWidth = document.body.clientWidth;
                var objHeight = document.body.clientHeight;
                $("#container").width(objWidth - 20);
               $("#container").height(objHeight);
                $("#topDiv").height(objHeight * 0.3);
                $("#dataDiv").height(objHeight * 0.7);
                var mana = $("#str_isMana").val();
                var bigPiece1 = $("#bigPiece").val();
                var smallPiece1 = $("#smallPiece").val();
                var bigPiece = encodeURI(bigPiece1);
                var smallPiece = encodeURI(smallPiece1);
                if (mana == "5") {
                     $("#file").css("display", "inline");
                    $("#tanchuClick").css("display", "inline");
                    $('#dataGrid').datagrid({
                       
                        
                        
                        url : 'TbReckonPieceContentInfoMServiceGetData.action?str_isMana=' + mana + '&fromDate=${fromDate}&toDate=${toDate}&bigPiece=' + bigPiece + '&smallPiece=' + smallPiece,
						pagination : true,
						title : '计件目录列表',
						iconCls : 'icon-save',
						width : 'auto',
						height : '500',
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
			
                        columns: [[{
                            title: '月份',
                            field: 'value1',
                            width: fixWidth(0.15),//$(this).width() * 0.15,
                            align: 'center',
                            sortable: true
                        }, {
                            title: '计件大类',
                            field: 'value2',
                            width:  fixWidth(0.15),//$(this).width() * 0.15,
                            align: 'center',
                            sortable: true
                        }, {
                            title: '计件分项',
                            field: 'value3',
                            width:  fixWidth(0.15),//$(this).width() * 0.15,
                            align: 'center',
                            sortable: true
                        }, {
                            title: '积分值',
                            field: 'value4',
                            width:  fixWidth(0.15),//$(this).width() * 0.15,
                            align: 'center',
                            sortable: true
                        }, {
                            title: '积分单价',
                            field: 'value5',
                            width:  fixWidth(0.15),// fixWidth(0.15),//$(this).width() * 0.15,
                            align: 'center',
                            sortable: true
                        }, {
                            title: '操作',
                            field: 'value6',
                            width:  fixWidth(0.15),//$(this).width() * 0.15,
                            align: 'center',
                            sortable: true
                        }]]
                    });
                }
                else {
                    $('#dataGrid').datagrid({
                       
                        
                        
                        url : 'TbReckonPieceContentInfoMServiceGetData.action?str_isMana=' + mana + '&fromDate=${fromDate}&toDate=${toDate}&bigPiece=' + bigPiece + '&smallPiece=' + smallPiece,
						pagination : true,
						title : '应用系统列表',
						iconCls : 'icon-save',
						width : 'auto',
						height : '500',
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
                        columns: [[{
                            title: '月份',
                            field: 'value1',
                            width: fixWidth(0.18),//$(this).width() * 0.18,
                            align: 'center',
                            sortable: true
                        }, {
                            title: '计件大类',
                            field: 'value2',
                            width: fixWidth(0.18),//$(this).width() * 0.18,
                            align: 'center',
                            sortable: true
                        }, {
                            title: '计件分项',
                            field: 'value3',
                            width: fixWidth(0.18),//$(this).width() * 0.18,
                            align: 'center',
                            sortable: true
                        }, {
                            title: '积分值',
                            field: 'value4',
                            width:fixWidth(0.18),// $(this).width() * 0.18,
                            align: 'center',
                            sortable: true
                        }, {
                            title: '积分单价',
                            field: 'value5',
                            width: fixWidth(0.18),//$(this).width() * 0.18,
                            align: 'center',
                            sortable: true
                        }]]
                    });
                }
                //设置分页控件   
                var p = $('#dataGrid').datagrid('getPager');
                $(p).pagination({
                    pageSize: 10,//每页显示的记录条数，默认为10   
                    pageList: [10, 15,20],//可以设置每页记录条数的列表   
                    beforePageText: '第',//页数文本框前显示的汉字   
                    afterPageText: '页    共 {pages} 页',
                    displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
                });
                $("#form2").css("display", "inline");
                $("#exportExl").css("display", "inline");
            });
            
            
            //导出
            function exportPieceContent(){
                var bigPiece1 = $("#bigPiece").val();
                var smallPiece1 = $("#smallPiece").val();
                var bigPiece = encodeURI(encodeURI(bigPiece1));
                var smallPiece = encodeURI(encodeURI(smallPiece1));
                var exportUrl = "<%=request.getContextPath()%>/exJiJianExcel.action?bigPiece="
				+ bigPiece + '&smallPiece=' + smallPiece;
		window.location.href = exportUrl;
	};
	//定义表格各列宽度
	function fixWidth(percent) {
		return ($("#dataDiv").width() - 30) * 0.8 * percent;
	};
	//编辑计件目录信息
	function EditPieceContent() {
		$("#editForm").css("display", "inline");
		$("#dlg").dialog('open');
		$("#scoreVal").focus().select();
		var selectRow = $("#dataGrid").datagrid('getSelected');//获取选中行
		$("#scoreVal").val(selectRow.value4);
		$("#piecePrice").val(selectRow.value5);
	};
	//保存修改信息
	function savePiece() {
		var selectRow = $("#dataGrid").datagrid('getSelected');//获取选中行
		var score = $("#scoreVal").val();
		var price = $("#piecePrice").val();
		if (price == "" || score == "") {
			$.messager.alert('提示', '积分值和积分单价均不能为空！');
			return false;
		} else {
			//正则
			reg = /^(\-?)(\d+)$/;
			if (true) {
			//if (reg.test(score) && reg.test(price)) {
				//alert('a');return false;
				$("#staticMonth").val(selectRow.value1);
				var updateUrl = "UpdateTbReckonPieceContentInfoMActionAction.action?staticMonth="
						+ selectRow.value1
						+ "&bigPiece="
						+ encodeURI(encodeURI(selectRow.value2))
						+ "&smallPiece="
						+ encodeURI(encodeURI(selectRow.value3))
						+ "&scoreVal="
						+ score + "&piecePrice=" + price;
				$.ajax({
					url : updateUrl,
					type : "post",
					dataType : 'text',
					success : function(msg) {
						//关闭dialog
						$("#dlg").dialog('close');
						//重新加载数据                            
						$("#dataGrid").datagrid('reload');
						$.messager.alert('提示', '更新成功');
					}
				});
				//使用提交表单 $("#editForm").submit();$("#dlg").dialog('close');//重新加载数据$("#dataGrid").datagrid('reload');$.messager.alert('提示', '操作成功！');
			} else {
				$.messager.alert('提示', '积分值和积分单价只能为数字！');
				return false;
			}
		}

	};
	//删除计件目录信息
	function DelPieceContent() {
		$.messager
				.confirm(
						'删除',
						'您确认删除这条记录么?',
						function(r) {
							if (r) {
								var selectRow = $("#dataGrid").datagrid(
										'getSelected');//获取选中行
								var delteID = encodeURI(selectRow.value3);
								delteID = encodeURI(delteID);
								$
										.ajax({
											url : "DeleteTbReckonPieceContentInfoMActionAction.action?delteID="
													+ delteID,
											type : "post",
											dataType : 'text',
											success : function(msg) {
												//重新加载数据
												$("#dataGrid").datagrid('reload');
												$.messager.alert('提示', '删除成功！');
											}
										});
							}
						});
	};
	//依据时间查找计件目录
	function searchPiece() {
		var fromDate = $("#fromDate").combobox('getValue');
		var toDate = $("#toDate").combobox('getValue');
		if (fromDate == "" && toDate != "") {
			$.messager.alert('警告', '起始时间均不能为空！');
			return false;
		}
		if (fromDate != "" && toDate == "") {
			$.messager.alert('警告', '截至时间均不能为空！');
			return false;
		}
		if ((fromDate == "" && toDate == "")
				|| ((fromDate != "" && toDate != ""))) {
			var mana = $("#str_isMana").val();
			var bigPiece1 = $("#bigPiece").val();
			var smallPiece1 = $("#smallPiece").val();
			var bigPiece = encodeURI(bigPiece1);
			var smallPiece = encodeURI(smallPiece1);
			$('#dataGrid').datagrid('load', {
				fromDate : fromDate,
				toDate : toDate,
				bigPiece : bigPiece,
				smallPiece : smallPiece,
				mana : mana
			});
		}
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
					$.messager.alert('提示',"路径输入有误");
					return false;
				}
				$("#form1").attr("action","ImportTbReckonPieceContentInfoMActionAction.action");
				$("#form1")[0].submit();
				$.messager.alert('提示', '导入成功！');
				return true;
			}

	//弹出窗口
/*	function tanchu() {
		$("#impPieCon").click();
	};
	//获取导入文件名
	function huoqu() {
		var impPath = $("#impPieCon").val();
		if ((impPath.lastIndexOf(".xls") == impPath.length - 4)
				|| (impPath.lastIndexOf(".xlsx") == impPath.length - 5)) {
			$
					.ajax({
						url : "ImportTbReckonPieceContentInfoMActionAction.action?impPath="
								+ encodeURI(encodeURI(impPath)),
						type : "post",
						dataType : 'text',
						success : function(msg) {
						//alert(impPath);
							$("#impPieceDiv").empty();
							$('#impPieceDiv')
									.append(
											"<input type='file' class='impPiece' id='impPieCon' style='display:none;' onchange='huoqu();'/>");
							$.messager.alert('提示', '导入成功！');
							$("#dataGrid").datagrid('reload');
						}
					});
		} else {
			$.messager.alert('提示', '请选择EXCEL文件！');
		}
	};*/
</script>
</head>
<body>
	<center>

	 <jsp:include page="/common/top.jsp"></jsp:include>
		<div id="container">
			<div id="dataDiv">
				<table id="dataGrid" cellspacing="0" cellpadding="0">
				</table>
				 
			</div>
			<div id="dlg" title="修改计件信息" class="easyui-dialog" closed="true"
				buttons="#dlg-buttons" data-options="iconCls:'icon-save'"
				style="width:250px;height:180px;">
				<form id="editForm"
					action="UpdateTbReckonPieceContentInfoMActionAction.action">
					<table id="editTable" align="center"
						style="margin:30px 0px 10px 0px;">
						<tr>
							<td><label> 积分值: </label></td>
							<td><input type="text" name="scoreVal" id="scoreVal" /></td>
						</tr>
						<tr>
							<td><label> 积分单价: </label></td>
							<td><input type="text" name="piecePrice" id="piecePrice" /><input
								type="hidden" name="staticMonth" id="staticMonth"
								value="${staticMonth}"><input type="hidden"
								name="bigPiece" id="bigPiece" value="${bigPiece }"><input
								type="hidden" name="smallPiece" id="smallPiece"
								value="${smallPiece}"></td>
						</tr>
					</table>
					<div id="dlg-buttons">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-ok" onclick="savePiece();">保存</a> <a
							href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-cancel"
							onclick="javascript:$('#dlg').dialog('close')">取消</a>
					</div>
				</form>
			</div>
			<div id="tb" style="padding:5px;height:auto">
			<form   method="post" id="form1" enctype="multipart/form-data" name="form1" onsubmit="return excuteQuery();">
				<div id="importDiv" style="margin-bottom:5px">
				    <input id="file" type="file" name="file" onchange="filecheckmethod(this)"  style="height:22px;width:10%;"/>
					<a id="tanchuClick" class="easyui-linkbutton" iconCls="icon-edit" 
						plain="true" onclick="importDatas();">导入计件目录</a>
					<a id="exportExl" class="easyui-linkbutton" iconCls="icon-print"
						plain="true" onclick="exportPieceContent();">导出EXCEL</a>
				</div>
			</form>
				<div>
					<form id="form2">
					<table>
					<tr>
					<td>起始时间:</td><td><select id="fromDate" name="fromDate"
							class="easyui-combobox" style="width:80px;height:20px;"></select>&nbsp;&nbsp;&nbsp;</td>
							<td>截止时间: </td>
							<td><select id="toDate" name="toDate"
							class="easyui-combobox" style="width:80px;height:20px;">
						</select>&nbsp;&nbsp;&nbsp;</td>
						<td>计件大类:</td><td><input name="bigPiece" id="bigPiece"
							type="text" value="${bigPiece}" style="height:21px;" />&nbsp;&nbsp;&nbsp;</td>
							<td>计件分项:</td><td><input name="smallPiece" id="smallPiece" type="text"
							value="${smallPiece}" style="height:21px;" />&nbsp;&nbsp;&nbsp;</td><td><a
							class="easyui-linkbutton" iconCls="icon-search"
							onclick="searchPiece();">查询</a></td>
					</tr>
					</table>
						 
						
						
					</form>
				</div>
			</div>
		</div>
	</center>
	<input type="hidden" id="str_isMana" name="str_isMana"
		value="${str_isMana }">
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>渠道经理渠道信息管理</title>
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
#combobox {
	display: none;
}

#dlg {
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
            	
             	var quanXianPost=$("#post").val();
	    		var quanXianCountyName=$("#county").val();
	    		
                var objWidth = document.body.clientWidth;
                var objHeight = document.body.clientHeight;
               // $("#container").width(objWidth - 20);
               // $("#container").height(objHeight);
               // $("#topDiv").height(objHeight * 0.3);
               // $("#dataDiv").height(objHeight * 0.7);
               var a;
               var msg='<s:property value="msg"/>' ; 
               var msg_update='<s:property value="msg_update"/>' ; 
               var imsg='<s:property value="imsg"/>' ;
               if (msg!="" || msg.length>0){
                      a=msg;
               }else if(msg_update!="" || msg_update.length>0){
                  a=msg_update;
               }else if(imsg!="" || imsg.length>0){
                  a=imsg;
               }else {
                  a="";
               }
               if(a!="" || a.lenth>0){
                 $.messager.alert('提示', a);
               }
                //区县与区域级联
                $('#combo1').combobox({
                url: 'makeJson1.action',
                editable:false,
				valueField: 'id',
				textField: 'text',
				panelHeight: 'auto',
				  onChange:function(newValue,oldValue){		  
		          $('#combo4').combobox({
			                    disabled:false,
			                   url:'makeJson3.action?countyName='+ encodeURI(encodeURI(newValue)),
			                    valueField:'id',
			                    textField:'text'
			      });
		     }
				});
				$('#countyName').combobox({
                url: 'makeJson1.action',
                editable:false,
				valueField: 'id',
				textField: 'text',
				panelHeight: 'auto',
				  onChange:function(newValue,oldValue){		  
		          $('#area').combobox({
			                    disabled:false,
			                    url:'makeJson3.action?countyName='+ encodeURI(encodeURI(newValue)),
			                    valueField:'id',
			                    textField:'text',
			                    panelHeight: 'auto'
			      		});
			      		$('#area').combobox('setValue','--全部--');
		     		}
				});
				$('#combo2').combobox({
                url: 'makeJson4.action',
                editable:true,
				valueField: 'id',
				textField: 'text',
				panelWidth: 100,
				panelHeight: '100'
				}
				);				
				
                var d = new Date();
				var vYear = d.getFullYear();
				var vMon = d.getMonth() + 1;
				var month = encodeURI(vYear + (vMon < 10 ? "0" + vMon : vMon));
				
				$('#combo3').combobox({  
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
				$('#tocombo3').combobox({  
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
		$('#combo3').combobox('setValue',month);
		$('#tocombo3').combobox('setValue',month);
               
               
                
                //定义表格
              if(quanXianPost!="区县负责人"){
               document.getElementById("file").style.display = "none"; 
              document.getElementById("addchnl").style.display = "none"; 
	          document.getElementById("importchnl").style.display = "none"; 
	          $('#area').combobox('setValue','--全部--');
			  $('#countyName').combobox('setValue','--全部--');
              $('#dataGrid').datagrid({
                    url :'makeJson.action',
					pagination : true,
					 title: '渠道经理渠道信息表',
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
					idField : 'value6',
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
                        title: '姓名',
                        field: 'value3',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '编号',
                        field: 'value4',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '负责区域',
                        field: 'value5',
                        width: fixWidth(0.15),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '负责渠道编码',
                        field: 'value6',
                        width: fixWidth(0.2),
                        align: 'center',
                        sortable: true
                    },{
                    title: '负责渠道名称',
                        field: 'value7',
                        width: fixWidth(0.2),
                        align: 'center',
                        sortable: true
                    },{title: '负责渠道类型',
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
               document.getElementById("addchnl").style.display = ""; 
	           document.getElementById("importchnl").style.display = ""; 
	           $('#countyName').combobox('setValue', quanXianCountyName);
	           $('#area').combobox('setValue','--全部--');
               $('#dataGrid').datagrid({  
		            url :'makeJson.action',
					pagination : true,
					 title: '渠道经理渠道信息表',
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
					idField : 'value6',
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
                        title: '姓名',
                        field: 'value3',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '编号',
                        field: 'value4',
                        width: fixWidth(0.1),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '负责区域',
                        field: 'value5',
                        width: fixWidth(0.15),
                        align: 'center',
                        sortable: true
                    }, {
                        title: '负责渠道编码',
                        field: 'value6',
                        width: fixWidth(0.2),
                        align: 'center',
                        sortable: true
                    },{
                    title: '负责渠道名称',
                        field: 'value7',
                        width: fixWidth(0.2),
                        align: 'center',
                        sortable: true
                    },{title: '负责渠道类型',
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
                    ]]
                });
              }
                
                //设置分页控件
                var p = $('#dataGrid').datagrid('getPager');
				$(p).pagination({
					pageSize : 10,//每页显示的记录条数，默认为10  
					pageList : [ 10, 15, 20 ],//可以设置每页记录条数的列表  
					beforePageText : '第',//页数文本框前显示的汉字  
					afterPageText : '页    共 {pages} 页',
					displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
				});	
                
            });
            //定义表格各列宽度
            function fixWidth(percent){
                return ($("#dataDiv").width() - 20) * 0.8 * percent;
            };
             //查询
             function findCoffcnt(){

              var countyName = $("#countyName").combobox('getText');//获取选中行
               countyName=encodeURI(countyName);
                var prncpArea = $("#area").combobox('getText');//获取选中行
               prncpArea=encodeURI(prncpArea);
                var name = $("#combo2").combobox('getText');//获取选中行
               name=encodeURI(name);
                var statisMonth =$("#combo3").combobox('getText');
                var statisMonth1=$("#tocombo3").combobox('getText');
				$('#dataGrid').datagrid('load',{
				 countyName:countyName,
				 name:name,
				 statisMonth:statisMonth,
				 statisMonth1:statisMonth1,
				 prncpArea:prncpArea
				});
            };
             //删除信息
            function DelChnl(){
                $.messager.confirm('提示', '您确认删除这条记录么?', function(r){
                    if (r) {
                        var selectRow = $("#dataGrid").datagrid('getSelected');//获取选中行
                        //alert(selectRow.value3);
                        var prncpChnlId = encodeURI(selectRow.value6);
                        var url= "delchnl.action?prncpChnlId=" + prncpChnlId;
                        window.location.href=url;
                     //    var mag='<s:property value="msg"/>';
                       //   $("#dataGrid").datagrid('reload');
                       //    $.messager.alert('提示', mag);
                       /* $.ajax({
                            url: "delchnl.action?prncpChnlId=" + prncpChnlId,
                            type: "post",
                            dataType: 'text',
                            success: function(msg){
                                //重新加载数据
                                $("#dataGrid").datagrid('reload');
                             //   $.messager.alert('提示', msg);
                            }
                        });*/
                    }
                });
            };
            //编辑
            function Editchnl(){
            $("#editForm").css("display", "inline");
              $("#dlg").css("display", "inline");
                $("#dlg").dialog('open');
                var d = new Date();
				var vYear = d.getFullYear();
				var vMon = d.getMonth() + 1;
				var date = vYear + (vMon < 10 ? "0" + vMon : vMon);
                var quanXianCountyName1=$("#county").val();
              //  alert(quanXianCountyName1);
                $('#combo1').combobox('setValue', quanXianCountyName1 );
                $('#combo4').combobox('setValue', '--请选择区域--');
                $('#statisMonth').val(date);
                
            };
            //保存修改信息
            function savechnl(){
                var selectRow = $("#dataGrid").datagrid('getSelected');//获取选中行
                var statisMonth =$("#statisMonth").val();
                var countyName = $("#combo1").combobox('getText');//获取选中行
                  //  countyName=encodeURI(encodeURI(countyName));
                var name = $("#name").val();
                var ID = $("#ID").val();
                   var prncpArea = $("#combo4").combobox('getText');//获取选中行
               //prncpArea=encodeURI(prncpArea);
                var prncpChnlId = $("#prncpChnlId").val();
                var prncpChnlName = $("#prncpChnlName").val();
                var pnncpChnlType = $("#pnncpChnlType").val();
                var updateUrl = "Updatechnl.action?statisMonth=" + statisMonth + "&countyName=" + encodeURI(encodeURI(countyName)) + "&name=" + encodeURI(encodeURI(name)) + "&id=" + ID + "&prncpArea=" + encodeURI(encodeURI(prncpArea)) + "&prncpChnlId=" +prncpChnlId+ "&prncpChnlName=" +encodeURI(encodeURI(prncpChnlName))+ "&pnncpChnlType=" +encodeURI(encodeURI(pnncpChnlType)) ;
                
                if (statisMonth == "" || countyName == "" || name=="" || ID=="" || prncpArea=="" || prncpChnlName=="" || prncpChnlId=="" || pnncpChnlType=="") {
                    $.messager.alert('警告', '记录均不能为空！');
                    return false;
                }else {
                       $("#dlg").dialog('close');
                     window.location.href=updateUrl;  
                       $("#dataGrid").datagrid('reload');
                     //  var a = '<s:property value="msg_update"/>';
                    //   $.messager.alert('提示', a);
               /*     $.ajax({
                        url: updateUrl,
                        type: "post",
                        dataType: 'text',
                        success: function(msg){
                       // alert(updateUrl);
                         
                            //关闭dialog
                            $("#dlg").dialog('close');
                            //重新加载数据
                            $("#dataGrid").datagrid('reload');
                      //      $.messager.alert('提示', msg);
                          // $.messager.show({
                          //      msg:msg,
                          //      title:'提示',
                          //     timeout:'2000',
                          //      showType:'fade',
                         //       style:{
                         //             right:'',
                         //             bottom:''  
                         //               }
                         //  })
                        }
                    });*/
                    
                
                }
            };
            //自动填充
            function auto(){
              var prncpChnlId=$("#prncpChnlId").val();
                    $.ajax({
                          
                              url: "findnt.action?prncpChnlId=" + prncpChnlId,
                              type: "get",
                              dataType: 'text',
                            success: function(datas){
                            
                             var a = eval(datas);
                            // alert(a);
                            
                            var prncpChnlName=a[0].prncpChnlName;
                            var pnncpChnlType=a[0].pnncpChnlType;
                             
                            // alert(prncpChnlName);
                            //alert(pnncpChnlType);
                             $("#prncpChnlName").val(prncpChnlName);
                              $("#pnncpChnlType").val(pnncpChnlType);
                            }
                        });
                                   
            };
            
            
            function exportCoffcnt(){
            var exportUrl = "exportChanel.action";
		    window.location.href = exportUrl;
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
				$("#form1").attr("action","importChanel.action");
				$("#form1")[0].submit();
			//	var msg='<s:property value="imsg"/>';
			//	$.messager.alert('提示', msg);
				return true;
			}
			
    /*        function importChanel(){
	            document.all.fileBrowser.click();
				var filename = encodeURI(document.all.fileBrowser.value);
				var path = encodeURI(filename);
				//alert(filename);
				if (path != '' && path != null) {
					$.ajax({
						url : 'importChanel.action?path=' + path,
						type : 'post',
						dataType : 'text',
						success : function(msg) {
							//关闭dialog
							$("#dlg").dialog('close');
							//重新加载数据
						//	$("#dataGrid").datagrid('reload');
		
							$.messager.alert('提示', msg);
						}
					});
				}
			}*/
           
        </script>
</head>
<body>
  <jsp:include page="/common/top.jsp"></jsp:include>
<!-- 获取session值 -->	
	<input id="county" type="hidden" value="<s:property value="#session.chanlMager.countyName"/>" style="border:0px;"/>
	<input id="post" type="hidden" value="<s:property value="#session.chanlMager.post"/>" style="border:0px;" />	
		<div id="combobox">
		<form   method="post" id="form1" enctype="multipart/form-data" name="form1" onsubmit="return excuteQuery();">	 
			     <div>
			      <input id="file" type="file" name="file" onchange="filecheckmethod(this)"  style="height:22px;width:10%;"/>
				 <a class="easyui-linkbutton"
					id="importchnl" iconCls="icon-edit" plain="true"
					onClick="importDatas();">导入渠道信息</a>
					&nbsp; 
				&nbsp;&nbsp;&nbsp; <a  class="easyui-linkbutton"
					id="addchnl" iconCls="icon-add" plain="true"
					onClick="Editchnl();">增加记录</a>&nbsp;   <input
					type="file" name="fileBrowser" size="125" id="exportchnl"
					style="display:none" onchange="fileBrowserChange();" /> <a
					class="easyui-linkbutton" iconCls="icon-print"
					onclick="exportCoffcnt(); "  plain="true">导出Excel</a>					
			</div>
		</form>
			<div align="left">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>月份:</label>&nbsp;从&nbsp;<select id="combo3" panelHeight="auto"
					class="easyui-combobox" name="month" style="width: 100px;">
				</select>&nbsp;到&nbsp;<select id="tocombo3" panelHeight="auto"
					class="easyui-combobox" name="tomonth" style="width: 100px;">
				</select> <label>区县:</label>&nbsp; <select id="countyName"
					class="easyui-combobox" name="state" style="width: 100px;"
					>
				</select> <label>区域:</label>&nbsp; <select id="area"
					class="easyui-combobox" name="state" style="width: 100px;"
					>
				</select> <label>员工姓名：</label>&nbsp; <select id="combo2" panelHeight="auto"
					class="easyui-combobox" name="name" style="width: 100px;">
				</select> <a class="easyui-linkbutton" iconCls="icon-search"
					onclick="findCoffcnt();">查询</a>

			</div>
		</div>
		
		<div id="dataDiv">
			<table id="dataGrid" cellspacing="0" cellpadding="0">
			</table>
			&nbsp;
		</div>
		
		<div id="dlg" title="渠道经理渠道信息" class="easyui-dialog" closed="true"
			buttons="#dlg-buttons" data-options="iconCls:'icon-save'"
			style="width: 400px; height: 480px; padding:10px 20px">
			<div class="ftitle" align="center">
				<label style="align:center;font-weight:900;">渠道经理渠道信息</label>
			</div>
			<form id="editForm">
				<div align="center">
					<div>
						<label>
							月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份：
						</label> <input type="text" name="statisMonth" id="statisMonth" />
					</div>
					<div>&nbsp;</div>
					<div>

						区&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;县：
						<select id="combo1" class="easyui-combobox" name="state"
							style="width: 134px">
						</select>


					</div>
                    <div>&nbsp;</div>
					<div>
						<label>
							姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：
						</label> <input type="text" name="name" id="name" />
					</div>
					<div>&nbsp;</div>
					<div>
						<label>
							编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：
						</label> <input type="text" name="ID" id="ID" />
					</div>
                    <div>&nbsp;</div>
					<div>
						<label>
							负&nbsp;&nbsp;&nbsp;责&nbsp;&nbsp;区&nbsp;&nbsp;&nbsp;域： </label> <select
							id="combo4" panelHeight="auto" class="easyui-combobox"
							name="state" style="width: 134px;">
						</select>
					</div>
                    <div>&nbsp;</div>
					<div>
						<label> 负责渠道编码： </label> <input type="text" name="prncpChnlId"
							id="prncpChnlId" onblur="auto();" />
					</div>
					<div>&nbsp;</div>
					<div>
						<label> 负责渠道名称： </label> <input type="text" name="prncpChnlName"
							id="prncpChnlName" />
					</div>
					<div>&nbsp;</div>
					<div>
						<label> 负责渠道类型： </label> <input type="text" name="pnncpChnlType"
							id="pnncpChnlType" />
					</div>

				</div>				
			</form>
		</div>
		
		<div id="dlg-buttons">
					<a  class="easyui-linkbutton"
						iconCls="icon-ok" onclick="savechnl();">保存</a> <a
						 class="easyui-linkbutton"
						iconCls="icon-cancel"
						onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
</body>
</html>
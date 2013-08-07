<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>渠道经理计件分项日统计</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/icon.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/demo.css" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript">
            function exportMonthPiece(){
            var exportUrl = "exportDayPiece.action";
		    window.location.href = exportUrl;
            }
             $(function(){
                
                var quanXianPost="<%=request.getAttribute("quanXianPost")%>";
	    var quanXianCountyName="<%=request.getAttribute("quanXianCountyName")%>";
	        if(quanXianPost!="市管理员"){
	    document.getElementById("countyNames").style.display = "none";
	    }else {
	    document.getElementById("countyNames").style.display = "";
	    }
	    
	      $('#countyNames').combobox({
                url: 'makecountysday.action',
                editable:true,
				valueField: 'id',
				textField: 'text',
				panelWidth: 100,
				panelHeight: 'auto',
				editable: true
				}
				);	
			$('#combo2').combobox({
                url: 'makenamesday.action',
                editable:true,
				valueField: 'id',
				textField: 'text',
				panelWidth: 100,
				panelHeight: '100',
				editable: true
				}
				);				
	        //combobox级联		 
		 $('#bigpiecename').combobox({
		     url:'makebigpieceD.action',
		     valueField:'id',  
		     textField:'text', 
		     panelHeight:'auto',
		     onChange:function(newValue,oldValue){		  
		          $('#smallpiecename').combobox({
			                    disabled:false,
			                    url:'makesmallpieceD.action?bigPieceName='+ encodeURI(encodeURI(newValue)),
			                    valueField:'id',
			                    panelHeight:'100',
			                    textField:'text'
			      });			     
		     }
	    });     
                
             $('#peieceDetail').datagrid({
                    url :'browDayPiect.action',
					pagination : true,
					 title: '渠道经理计件分项日统计表',
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
					toolbar : '#toolbar',  
                    columns: [[{
                        title: '日期',
                        field: 'value1',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '区县',
                        field: 'value2',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '姓名',
                        field: 'value3',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '渠道编码',
                        field: 'value4',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '渠道名称',
                        field: 'value5',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '计件项目大类',
                        field: 'value6',
                        width: 250,
                        align: 'center',
                        sortable: true
                    }, {
                        title: '计件项目小类',
                        field: 'value7',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '日发展量',
                        field: 'value8',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '日发展积分',
                        field: 'value9',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '日发展薪酬',
                        field: 'value10',
                        width: 250,
                        align: 'center',
                        sortable: true
                    }, {
                        title: '月发展量',
                        field: 'value11',
                        width: 250,
                        align: 'center',
                        sortable: true
                    }, {
                        title: '月发展积分',
                        field: 'value12',
                        width: 250,
                        align: 'center',
                        sortable: true
                    }, {
                        title: '月发展薪酬',
                        field: 'value13',
                        width: 250,
                        align: 'center',
                        sortable: true
                    }]],
                    frozenColumns: [{
                        field: 'ck',
                        checkbox: false
                    }]
                });
                 //设置分页控件
                  var p = $('#peieceDetail').datagrid('getPager');
				$(p).pagination({
					pageSize : 10,//每页显示的记录条数，默认为10  
					pageList : [ 10, 15, 20 ],//可以设置每页记录条数的列表  
					beforePageText : '第',//页数文本框前显示的汉字  
					afterPageText : '页    共 {pages} 页',
					displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
				});	
                });
                
                var d = new Date();
				var vYear = d.getFullYear();
				var vMon = d.getMonth() + 1;
				var month = encodeURI(vYear + (vMon < 10 ? "0" + vMon : vMon));	
				var a="yyyyMMdd";
		$('#combo3').combobox('setValue',a);
		
		var quanXianPost="<%=request.getAttribute("quanXianPost")%>";
	    var quanXianCountyName="<%=request.getAttribute("quanXianCountyName")%>";
	        if(quanXianPost=="区县负责人"){
	    document.getElementById("countyName").style.display = "none";
	    }
	    
		 //查询
</script>
     <script type="text/javascript">
             function findsmallpiece(){

              var statisDate =$("#combo3").datebox('getValue');

              var countyName = $("#countyNames").combobox('getText');//获取选中行
               countyName=encodeURI(countyName);
                
              var name = $("#combo2").combobox('getText');//获取选中行
                name=encodeURI(name);
              
              var prncpChnlId=$("#prncpChnlId").val();
               
              var prncpChnlName=$("#prncpChnlName").val();
				prncpChnlName=encodeURI(prncpChnlName);
			   var bigPieceName=$("#bigpiecename").combobox('getText');
				bigPieceName=encodeURI(bigPieceName);
			  var smallPieceName=$("#smallpiecename").combobox('getText');
				smallPieceName=encodeURI(smallPieceName);
				  $('#peieceDetail').datagrid('load',{
				    statisDate:statisDate,
				    countyName:countyName,
				    name:name, 
				    prncpChnlId:prncpChnlId,
				    prncpChnlName:prncpChnlName,
				    bigPieceName:bigPieceName,
				    smallPieceName:smallPieceName
				});
            };	
            function myformatter(date){
             var y = date.getFullYear();
             var m = date.getMonth()+1;
             var d = date.getDate();
             return y+(m<10?('0'+m):m)+(d<10?('0'+d):d);
             };
              //自动填充
            function auto(){
              var prncpChnlId=$("#prncpChnlId").val();
                    $.ajax({
                              url: "findchinlname.action?prncpChnlId=" + prncpChnlId,
                              type: "get",
                              dataType: 'text',
                            success: function(datas){
                            
                             var a = eval(datas);
                            // alert(a);
                            
                            var prncpChnlName=a[0].prncpChnlName;
                          //  var pnncpChnlType=a[0].pnncpChnlType;
                             
                            // alert(prncpChnlName);
                            //alert(pnncpChnlType);
                             $("#prncpChnlName").val(prncpChnlName);
                           //   $("#pnncpChnlType").val(pnncpChnlType);
                            }
                        });
                                   
            };
            
            function autoid(){
               var prncpChnlName=$("#prncpChnlName").val();
				prncpChnlName=encodeURI(prncpChnlName);
				prncpChnlName=encodeURI(prncpChnlName);
				    $.ajax({
                              url: "findchinlid.action?prncpChnlName="+prncpChnlName,
                              type: "get",
                              dataType: 'text',
                            success: function(datas){
                            
                             var a = eval(datas);
                            // alert(a);
                            
                            var prncpChnlId=a[0].prncpChnlId;
                             $("#prncpChnlId").val(prncpChnlId);
                          
                            }
                        });
                                   
            };
</script>
  </head>
  
  <body>
  <jsp:include page="/common/top.jsp"></jsp:include>
    <div style="width:98%; height:250px; float:left; margin-left:2px"> &nbsp;
    	<table id="peieceDetail" cellspacing="0" cellpadding="0"></table>
	</div>
	<div id="toolbar">
				<div>
				<a class="easyui-linkbutton" iconCls="icon-print"
					onclick="exportMonthPiece(); "  plain="true">导出Excel</a>	
				</div>
			<div align="left">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>日期:</label>&nbsp;&nbsp;
				<input id="combo3" panelHeight="auto"class="easyui-datebox" name="month" style="width: 100px;" data-options="formatter:myformatter">
				&nbsp;&nbsp;<label>区县:</label>&nbsp; 
				<select id="countyNames"class="easyui-combobox" name="state" style="width: 100px;"></select>
				<label>员工姓名：</label>&nbsp; <select id="combo2" panelHeight="auto" class="easyui-combobox" name="name" style="width: 100px;"></select> 
				<label>渠道编码：</label>&nbsp;  <input type="text" name="prncpChnlId"	id="prncpChnlId" onblur="auto();"/>
				<label>渠道名称：</label>&nbsp;  <input type="text" name="prncpChnlName"	id="prncpChnlName"  onblur="autoid();"/>			
				<label>计件大类：</label>&nbsp; <select id="bigpiecename" panelHeight="auto" class="easyui-combobox" name="name" style="width: 100px;"></select>	
				<label>计件小类：</label>&nbsp; <select id="smallpiecename" panelHeight="auto" class="easyui-combobox" name="name" style="width: 100px;"></select>	
				<a class="easyui-linkbutton" iconCls="icon-search"
				    onclick="findsmallpiece();">查询</a>
			</div>
	</div>
		
  </body>
</html>

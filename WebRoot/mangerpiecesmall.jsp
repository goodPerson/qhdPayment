<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��������Ƽ�������ͳ��</title>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript">
            function exportMonthPiece(){
            var exportUrl = "exportMonthPiece.action";
		    window.location.href = exportUrl;
            }
             $(function(){
                
         var quanXianPost="<%=request.getAttribute("quanXianPost")%>";
         
	    var quanXianCountyName="<%=request.getAttribute("quanXianCountyName")%>";
	        
             $('#countyNames').combobox({
                url: 'makecountys.action',
                editable:true,
				valueField: 'id',
				textField: 'text',
				panelWidth: 100,
				panelHeight: 'auto',
				editable: true
				}
				);	
			$('#combo2').combobox({
                url: 'makenames.action',
                editable:true,
				valueField: 'id',
				textField: 'text',
				panelWidth: 100,
				panelHeight: '100',
				editable: true
				}
				);				    
           //combobox����		 
		 $('#bigpiecename').combobox({
		     url:'makebigpiece.action',
		     valueField:'id',  
		     textField:'text', 
		     panelHeight:'auto',
		     onChange:function(newValue,oldValue){		  
		          $('#smallpiecename').combobox({
			                    disabled:false,
			                    url:'makesmallpiece.action?bigPieceName='+ encodeURI(encodeURI(newValue)),
			                    valueField:'id',
			                    panelHeight:'100',
			                    textField:'text'
			      });			     
		     }
	    });     
             $('#peieceDetail').datagrid({
                    url :'browMonthPiect.action',
					pagination : true,
					 title: '��������Ƽ�������ͳ�Ʊ�',
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
					loadMsg : '���ݼ��������Ժ󡭡�',
					toolbar : '#toolbar',  
                    columns: [[{
                        title: '����',
                        field: 'value1',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '����',
                        field: 'value2',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '����',
                        field: 'value3',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '��������',
                        field: 'value4',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '��������',
                        field: 'value5',
                        width: 250,
                        align: 'center',
                        sortable: true
                    },{
                        title: '�Ƽ���Ŀ����',
                        field: 'value6',
                        width: 250,
                        align: 'center',
                        sortable: true
                    }, {
                        title: '�Ƽ���ĿС��',
                        field: 'value7',
                        width: 250,
                        align: 'center',
                        sortable: true
                    }, {
                        title: '�·�չ��',
                        field: 'value8',
                        width: 250,
                        align: 'center',
                        sortable: true
                    }, {
                        title: '�·�չ����',
                        field: 'value9',
                        width: 250,
                        align: 'center',
                        sortable: true
                    }, {
                        title: '�·�չн��',
                        field: 'value10',
                        width: 250,
                        align: 'center',
                        sortable: true
                    }]],
                    frozenColumns: [{
                        field: 'ck',
                        checkbox: false
                    }]
                });
                 //���÷�ҳ�ؼ�
                  var p = $('#peieceDetail').datagrid('getPager');
				$(p).pagination({
					pageSize : 10,//ÿҳ��ʾ�ļ�¼������Ĭ��Ϊ10  
					pageList : [ 10, 15, 20 ],//��������ÿҳ��¼�������б�  
					beforePageText : '��',//ҳ���ı���ǰ��ʾ�ĺ���  
					afterPageText : 'ҳ    �� {pages} ҳ',
					displayMsg : '��ǰ��ʾ {from} - {to} ����¼   �� {total} ����¼'
				});	
                });
                
                var d = new Date();
				var vYear = d.getFullYear();
				var vMon = d.getMonth() + 1;
				var month = encodeURI(vYear + (vMon < 10 ? "0" + vMon : vMon));	
				 $(function(){
				$('#combo3').combobox({  
				valueField: 'label',
				textField: 'value', 
				data: [{
							label: vYear+'00',
							value: '--ȫ��--',
						},{
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
		});
		$('#combo3').combobox('setValue',month);
		
		var quanXianPost="<%=request.getAttribute("quanXianPost")%>";
	    var quanXianCountyName="<%=request.getAttribute("quanXianCountyName")%>";
	        if(quanXianPost=="���ظ�����"){
	    document.getElementById("countyName").style.display = "none";
	    }
	    
		 //��ѯ
</script>
     <script type="text/javascript">
             function findsmallpiece(){

              var statisDate =$("#combo3").combobox('getText');

              var countyName = $("#countyNames").combobox('getText');//��ȡѡ����
               countyName=encodeURI(countyName);
                
              var name = $("#combo2").combobox('getText');//��ȡѡ����
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
             //�Զ����
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
					onclick="exportMonthPiece(); "  plain="true">����Excel</a>	
				</div>
			<div align="left">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>�·�:</label>&nbsp;&nbsp;
				<select id="combo3" panelHeight="auto"class="easyui-combobox" name="month" style="width: 100px;"></select>
				&nbsp;&nbsp;<label>����:</label>&nbsp; 
				<select id="countyNames"class="easyui-combobox" name="state" style="width: 100px;" ></select>
				<label>Ա��������</label>&nbsp; <select id="combo2" panelHeight="auto" class="easyui-combobox" name="name" style="width: 100px;"></select> 
				<label>�������룺</label>&nbsp; <input type="text" name="prncpChnlId"	id="prncpChnlId" onblur="auto();"/>
				<label>�������ƣ�</label>&nbsp; <input type="text" name="prncpChnlName"	id="prncpChnlName"  onblur="autoid();"/>		
				<label>�Ƽ����ࣺ</label>&nbsp; <select id="bigpiecename" panelHeight="auto" class="easyui-combobox" name="name" style="width: 100px;"></select>	
				<label>�Ƽ�С�ࣺ</label>&nbsp; <select id="smallpiecename" panelHeight="auto" class="easyui-combobox" name="name" style="width: 100px;"></select>	
				<a class="easyui-linkbutton" iconCls="icon-search"
				    onclick="findsmallpiece();">��ѯ</a>
			</div>
	</div>
		
  </body>
</html>

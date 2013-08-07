<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>�и������ջ���</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/demo.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/css/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/highcharts.js"></script>
<!--��ͼ-->
<script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
		// Build the chart
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'pieChartDiv1',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },credits:{
           		enabled: false
            },
            title: {
                text: '�Ƽ������շ�չ������'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b> <br> ��������<b>{point.y} ��</b>',
            	percentageDecimals: 1
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        formatter: function() {
                            return '<b>'+ this.point.name ;
                        }
                    }
                }
            },
            series: [{
                type: 'pie',
                name: '�ٷֱ�',
                data: [
                    {
                        name: '����ҵ����',
                        y: <s:property value="data"/>,
                        sliced: true,
                        selected: true
                    },
                    ['Ӫ�����',  <s:property value="market"/>],
                    ['�ն˷�չ��',    <s:property value="tmnl"/>]
                ]
            }]
        });
    });
    
});
</script>
<script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'pieChartDiv2',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },credits:{
           		enabled: false
            },
            title: {
                text: '�����ص����ܷ�չ������'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b> <br>��������<b>{point.y} ��</b>',
            	percentageDecimals: 1
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        formatter: function() {
                            return '<b>'+ this.point.name;
                        }
                    }
                }
            },
            series: [{
                type: 'pie',
                name: '�ٷֱ�',
                data: [
                     ['¬��',    <s:property value="lulong"/>],
                    ['������',    <s:property value="qinglong"/>],
                    {
                        name: '����',
                        y:  <s:property value="changli"/>,
                        sliced: true,
                        selected: true
                    },
                    ['������',    <s:property value="bdh"/>],
                    ['ɽ����',    <s:property value="shg"/>],
                    ['����',  <s:property value="funing"/>]
                ]
            }]
        });
    });
    
});

</script>
<!--����ͼ-->
<script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
           chart = new Highcharts.Chart({
						chart : {
							renderTo : 'lineChartDiv',
							type : 'line',
							marginRight : 100,
							marginBottom : 33
						},credits:{
           	            	enabled: false
                        },
						title : {
							text : '����ҵ�������'
						},
						subtitle : {
				            text : ''
			            },
						xAxis : {
							categories : [ 'һ��', '����', '����', '����', '����',
									'����', '����', '����', '����', 'ʮ��', 'ʮһ��',
									'ʮ����' ]
						   
						},
						yAxis : {
							title : {
								text : '����Ӫ�����',
								tickWidth: 0.5,
								gridLineWidth :0.6
							},
							plotLines : [ {
								value : 0,
								width : 0.9,
								color : '#808080'
							} ]
						},
						tooltip : {
							formatter : function() {
								return '<b>' + this.series.name + '</b><br/>'
										+ this.x + ': ' + this.y + '��';
							}
						},
						plotOptions : {
				           line : {
					            dataLabels : {
						          enabled : true
					    },
					enableMouseTracking : false
				        }
			            },
						legend : {
							layout : 'vertical',
							align : 'right',
							verticalAlign : 'top',
							x : -10,
							y : 100,
							borderWidth : 0
						},
						
						series : [
								{
									name : '����ҵ�������',
									data:[<s:iterator value="list1" id="obj" status="a"><s:property value="#obj"/>,</s:iterator><s:property value="d"/>]} ]
					});
				});

	});
</script>
</head>
<body>
<jsp:include page="/common/top.jsp"></jsp:include>
<table width="100%" border="0">
  <tr>
    <td colspan="2">
      <div  style="width:98%; height:250px; float:left; margin-left:2px"> &nbsp;
         <table class="easyui-datagrid" title="�ջ�������" 
					data-options="singleSelect:true,collapsible:false,fitColumns:true,url:'browserStatisInfoD.action',loadMsg : '���ݼ��������Ժ󡭡�'">
				<thead>
					<tr>
						<th data-options="field:'value1',width:100,align:'center'">����</th>
						<th data-options="field:'value2',width:100,align:'center'">����</th>
						<th data-options="field:'value3',width:100,align:'center'">������������������</th>
						<th data-options="field:'value4',width:100,align:'center'">������������������</th>
						<th data-options="field:'value5',width:100,align:'center'">���ջ��֣��֣�</th>
						<th data-options="field:'value6',width:100,align:'center'">���ۼƻ��֣��֣�</th>
						<th data-options="field:'value7',width:150,align:'center'">���ۼ�н�꣨Ԫ��</th>
					</tr>
				</thead>					
			</table> 
      </div></td>
  </tr>
  <tr>
    <td width="49%"  colspan="1">
      <s:if test="msg==''">
      <div style="width:99%; float:left; margin-left:5px">
        <div id="pieChartDiv1" style="min-width: 400px; height: 300px; margin: 0 auto"></div>
      </div>
      </s:if>
      <s:else>
      <div style="width:99%; float:left; margin-left:5px">
        <div style="min-width: 400px; height: 300px; margin: 0 auto ">${msg}</div>
      </div>
	   		
	   </s:else>
      </td>
    <td width="49%"  colspan="1">
     <s:if test="msg1==''">
      <div style="width:98%; float:right; margin-right:5px">
        <div id="pieChartDiv2" style="min-width: 400px; height: 300px; margin: 0 auto"></div>
      </div>
      </s:if>
       <s:else>
       <div style="width:98%; float:right; margin-right:5px">
        <div  style="min-width: 400px; height: 300px; margin: 0 auto">${msg1}</div>
      </div>
	   		
	   </s:else>
      </td>
  </tr>
  <tr>
    <td colspan="2"> <div style="width:99%; float:left; margin-left:5px">
        <div id="lineChartDiv" style="min-width: 250px; height: 255px; margin: 0 auto"></div>
      </div></div></td>
  </tr>
  <tr>
    <td width="48%"  colspan="1">&nbsp;
     <div style="width:99%; float:left; margin-left:5px">
        
     
      <table class="easyui-datagrid" title="��������ǰ10��" style=" height:150px"
					data-options="singleSelect:true,collapsible:false,fitColumns:true,loadMsg : '���ݼ��������Ժ󡭡�'"><!-- ,url:'browserCityTop10.action' -->
				<thead>
					<tr>
						<th data-options="field:'value1',width:100,align:'center'"">ͳ���·�</th>
						<th data-options="field:'value2',width:100,align:'center'">������������</th>
						<th data-options="field:'value3',width:100,align:'center'">������������</th>
						<th data-options="field:'value4',width:100,align:'center'">���������»����ܺ�</th>
					</tr>
				</thead>					
				<s:iterator id="iteratorTop10" value="tbChnlMagrScoreTop10MList"  var="tbChnlMagrScoreTop10M">
					<tr>				
						<td><s:property value="#tbChnlMagrScoreTop10M.STATIS_MONTH"/></td>
					    <td><s:property value="#tbChnlMagrScoreTop10M.CHNL_MAGR_ORDER"/></td>
					    <td><s:property value="#tbChnlMagrScoreTop10M.CHNL_MAGR_NAME"/></td>
					    <td><s:property value="#tbChnlMagrScoreTop10M.CHNL_MAGR_MON_TOTAL_SCORE"/></td>
					</tr>
				</s:iterator>					
			</table> </div>
			</td>
			 
    <td width="45%" colspan="1">&nbsp;
     <div style="width:96%; float:right; margin-right:5px;float:left;margin-left:5px">
       
     <table class="easyui-datagrid" title="���������10��"  style=" height:150px"
					data-options="singleSelect:true,collapsible:false,fitColumns:true,loadMsg : '���ݼ��������Ժ󡭡�'">
				<thead>
					<tr>
						<th data-options="field:'value1',width:100,align:'center'"">ͳ���·�</th>
						<th data-options="field:'value2',width:100,align:'center'">��������������</th>
						<th data-options="field:'value3',width:100,align:'center'">������������</th>
						<th data-options="field:'value4',width:100,align:'center'">���������»����ܺ�</th>
					</tr>
				</thead>
				<s:iterator id="iteratorDesc10" value="tbChnlMagrScoreDesc10MList"  var="tbChnlMagrScoreDesc10M">
					<tr>				
						<td><s:property value="#tbChnlMagrScoreDesc10M.STATIS_MONTH"/></td>
					    <td><s:property value="#tbChnlMagrScoreDesc10M.DESC_ORDER"/></td>
					    <td><s:property value="#tbChnlMagrScoreDesc10M.CHNL_MAGR_NAME"/></td>
					    <td><s:property value="#tbChnlMagrScoreDesc10M.CHNL_MAGR_MON_TOTAL_SCORE"/></td>
					</tr>
				</s:iterator>
			</table></div> </td>
  </tr>
  <tr>
    <td colspan="2" >&nbsp;
      <div>&nbsp;
      <div style="width:98%; float:left; margin-left:5px">
        
      
       <table class="easyui-datagrid" title="�»�������"  style=" height:auto"
					data-options="singleSelect:true,collapsible:false,fitColumns:true,loadMsg : '���ݼ��������Ժ󡭡�'">
				<thead>
					<tr>
						<th data-options="field:'value1',width:100,align:'center'"">ͳ���·�</th>
						<th data-options="field:'value2',width:100,align:'center'">������������</th>
						<th data-options="field:'value3',width:100,align:'center'">������������</th>
						<th data-options="field:'value4',width:100,align:'center'">����ҵ��չ���ܻ���</th>
						<th data-options="field:'value5',width:100,align:'center'"">�ն�ҵ��չ���ܻ���</th>
						<th data-options="field:'value6',width:100,align:'center'">����ҵ��չ���ܻ���</th>
						<th data-options="field:'value7',width:100,align:'center'">�ҵ��չ�»���</th>
						<th data-options="field:'value8',width:100,align:'center'">����ҵ��չ���ܻ���</th>
						<th data-options="field:'value9',width:100,align:'center'"">�ܼƼ�н��</th>
						<th data-options="field:'value10',width:100,align:'center'">�ܽ���</th>
					</tr>
				</thead>
				<s:iterator id="iteratorDevScore" value="tbCityMonDevScoreInfoMList"  var="tbCityMonDevScoreInfoM">
					<tr>				
						<td><s:property value="#tbCityMonDevScoreInfoM.STATIS_MONTH"/></td>
					    <td><s:property value="#tbCityMonDevScoreInfoM.CHNL_MAGR_TOTAL_CNT"/></td>
					    <td><s:property value="#tbCityMonDevScoreInfoM.AGT_CHNL_TOTAL_CNT"/></td>
					    <td><s:property value="#tbCityMonDevScoreInfoM.CARD_NUM_SERV_MON_TOTAL_SCORE"/></td>
					    <td><s:property value="#tbCityMonDevScoreInfoM.TMNL_SERV_MON_TOTAL_SCORE"/></td>
					    <td><s:property value="#tbCityMonDevScoreInfoM.DATA_SERV_MON_TOTAL_SCORE"/></td>
					    <td><s:property value="#tbCityMonDevScoreInfoM.ACT_SERV_MON_SCORE"/></td>
					    <td><s:property value="#tbCityMonDevScoreInfoM.AGENC_SERV_MON_TOTAL_SCORE"/></td>
					    <td><s:property value="#tbCityMonDevScoreInfoM.TOTAL_PIECE_PAY"/></td>
					    <td><s:property value="#tbCityMonDevScoreInfoM.TOTAL_MONEY"/></td>
					</tr>
				</s:iterator>
			</table> 
      </div></div></td>
  </tr>
</table>

</body>
</html>

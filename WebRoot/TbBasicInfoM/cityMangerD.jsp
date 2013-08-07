<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>市负责人日汇总</title>
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
<!--饼图-->
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
                text: '计件大项日发展量构成'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b> <br> 办理量：<b>{point.y} 件</b>',
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
                name: '百分比',
                data: [
                    {
                        name: '数据业务类',
                        y: <s:property value="data"/>,
                        sliced: true,
                        selected: true
                    },
                    ['营销活动类',  <s:property value="market"/>],
                    ['终端发展类',    <s:property value="tmnl"/>]
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
                text: '各区县当日总发展量构成'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b> <br>办理量：<b>{point.y} 件</b>',
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
                name: '百分比',
                data: [
                     ['卢龙',    <s:property value="lulong"/>],
                    ['海港区',    <s:property value="qinglong"/>],
                    {
                        name: '昌黎',
                        y:  <s:property value="changli"/>,
                        sliced: true,
                        selected: true
                    },
                    ['北戴河',    <s:property value="bdh"/>],
                    ['山海关',    <s:property value="shg"/>],
                    ['抚宁',  <s:property value="funing"/>]
                ]
            }]
        });
    });
    
});

</script>
<!--折线图-->
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
							text : '各县业务办理量'
						},
						subtitle : {
				            text : ''
			            },
						xAxis : {
							categories : [ '一月', '二月', '三月', '四月', '五月',
									'六月', '七月', '八月', '九月', '十月', '十一月',
									'十二月' ]
						   
						},
						yAxis : {
							title : {
								text : '各县营销情况',
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
										+ this.x + ': ' + this.y + '件';
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
									name : '当月业务办理量',
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
         <table class="easyui-datagrid" title="日汇总数据" 
					data-options="singleSelect:true,collapsible:false,fitColumns:true,url:'browserStatisInfoD.action',loadMsg : '数据加载中请稍后……'">
				<thead>
					<tr>
						<th data-options="field:'value1',width:100,align:'center'">日期</th>
						<th data-options="field:'value2',width:100,align:'center'">县区</th>
						<th data-options="field:'value3',width:100,align:'center'">渠道经理总数（个）</th>
						<th data-options="field:'value4',width:100,align:'center'">代理渠道总数（个）</th>
						<th data-options="field:'value5',width:100,align:'center'">当日积分（分）</th>
						<th data-options="field:'value6',width:100,align:'center'">月累计积分（分）</th>
						<th data-options="field:'value7',width:150,align:'center'">月累计薪酬（元）</th>
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
        
     
      <table class="easyui-datagrid" title="渠道经理前10名" style=" height:150px"
					data-options="singleSelect:true,collapsible:false,fitColumns:true,loadMsg : '数据加载中请稍后……'"><!-- ,url:'browserCityTop10.action' -->
				<thead>
					<tr>
						<th data-options="field:'value1',width:100,align:'center'"">统计月份</th>
						<th data-options="field:'value2',width:100,align:'center'">渠道经理排名</th>
						<th data-options="field:'value3',width:100,align:'center'">渠道经理姓名</th>
						<th data-options="field:'value4',width:100,align:'center'">渠道经理月积分总和</th>
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
       
     <table class="easyui-datagrid" title="渠道经理后10名"  style=" height:150px"
					data-options="singleSelect:true,collapsible:false,fitColumns:true,loadMsg : '数据加载中请稍后……'">
				<thead>
					<tr>
						<th data-options="field:'value1',width:100,align:'center'"">统计月份</th>
						<th data-options="field:'value2',width:100,align:'center'">渠道经理倒数排名</th>
						<th data-options="field:'value3',width:100,align:'center'">渠道经理姓名</th>
						<th data-options="field:'value4',width:100,align:'center'">渠道经理月积分总和</th>
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
        
      
       <table class="easyui-datagrid" title="月汇总数据"  style=" height:auto"
					data-options="singleSelect:true,collapsible:false,fitColumns:true,loadMsg : '数据加载中请稍后……'">
				<thead>
					<tr>
						<th data-options="field:'value1',width:100,align:'center'"">统计月份</th>
						<th data-options="field:'value2',width:100,align:'center'">渠道经理总数</th>
						<th data-options="field:'value3',width:100,align:'center'">代理渠道总数</th>
						<th data-options="field:'value4',width:100,align:'center'">卡号业务发展月总积分</th>
						<th data-options="field:'value5',width:100,align:'center'"">终端业务发展月总积分</th>
						<th data-options="field:'value6',width:100,align:'center'">数据业务发展月总积分</th>
						<th data-options="field:'value7',width:100,align:'center'">活动业务发展月积分</th>
						<th data-options="field:'value8',width:100,align:'center'">代办业务发展月总积分</th>
						<th data-options="field:'value9',width:100,align:'center'"">总计件薪酬</th>
						<th data-options="field:'value10',width:100,align:'center'">总奖金</th>
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

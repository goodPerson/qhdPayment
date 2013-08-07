<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>渠道经理月统计</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/demo.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/css/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/highcharts.js"></script>
		<script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
		// Build the chart
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'contains',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },credits:{
           		enabled: false
            },
            title: {
                text: '当月渠道经理大类业务薪酬比例'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b> <br>薪酬:<b>{point.y}元</b>',
              
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
                    ['卡号类业务',   <s:property value="tbMangerMonthBigClassCounts.cardNumServTotalPay"/>],
                    ['数据类业务',  <s:property value="tbMangerMonthBigClassCounts.dataServTotalPay"/>],
                    {
                        name: '代收费类业务',
                        y: <s:property value="tbMangerMonthBigClassCounts.agencyServTotalPay"/>,
                        sliced: true,
                        selected: true
                    },
                    ['终端类业务',  <s:property value="tbMangerMonthBigClassCounts.tmnlServTotalPay"/>],
                    ['营销类业务',     <s:property value="tbMangerMonthBigClassCounts.marktActServTotalPay"/>]
                ]
            }]
        });
    });
    
});
</script>
		<script type="text/javascript">
$(function() {
		var chart;
     $(document).ready(function() {
		chart = new Highcharts.Chart({
			chart : {
				renderTo : 'linechart',
				type : 'line'
			},
			credits:{
           		enabled: false
            },
			title : {
				text : '渠道经理月积分和薪酬曲线图'
			},
			subtitle : {
				text : ''
			},
			xAxis : {
				categories : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月',
						'9月', '10月', '11月', '12月' ]
			},
			yAxis : {
				title : {
					text : ''
				}
			},
			tooltip : {
				enabled : false,
				formatter : function() {
					return '<b>' + this.series.name + '</b><br/>' + this.x
							+ ': ' + this.y + '°C';
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
			series : [{
						name : '月积分',
						data : [ <s:property value="modelScore.one"/>,
								<s:property value="modelScore.tow"/>,
								<s:property value="modelScore.three"/>,
								<s:property value="modelScore.four"/>,
								<s:property value="modelScore.five"/>,
								<s:property value="modelScore.six"/>,
								<s:property value="modelScore.seven"/>,
								<s:property value="modelScore.eight"/>,
								<s:property value="modelScore.nine"/>,
								<s:property value="modelScore.ten"/>,
								<s:property value="modelScore.eleven"/>,
								<s:property value="modelScore.twelve"/> ]
					},{
						name : '月薪酬',
						data : [ <s:property value="modelPay.one"/>,
								<s:property value="modelPay.tow"/>,
								<s:property value="modelPay.three"/>,
								<s:property value="modelPay.four"/>,
								<s:property value="modelPay.five"/>,
								<s:property value="modelPay.six"/>,
								<s:property value="modelPay.seven"/>,
								<s:property value="modelPay.eight"/>,
								<s:property value="modelPay.nine"/>,
								<s:property value="modelPay.ten"/>,
								<s:property value="modelPay.eleven"/>,
								<s:property value="modelPay.twelve"/> ]
					}]
			});
		});
	});
</script>
<!--导出 当月渠道经理明细 -->
<script type="text/javascript">
	function exportChnlDetail(staticId) {
		var exportUrl = "exportChnlDetail.action?staticId=" + staticId;
		window.location.href = exportUrl;
	}
</script>
	</head>
	<body>
	<jsp:include page="/common/top.jsp"></jsp:include>
	<table width="100%" border="0">
	<tr>
    <td colspan="2" height="20%">
      <div  style="width:98%; height:120px; float:left; margin-left:2px"> &nbsp;
		<table class="easyui-datagrid" title="渠道经理员工数据"
			style="width:auto;height:80px"
			data-options="singleSelect:true,collapsible:true,fitColumns : true,
			loadMsg : '数据加载中请稍后……',url:''">
			<thead>
				<tr>
					<th data-options="field:'date',width:150,align:'center'"">日期</th>
					<th data-options="field:'county',width:150,align:'center'">县区</th>
					<th data-options="field:'name',width:150,align:'center'">姓名</th>
					<th data-options="field:'nameid',width:150,align:'center'">员工编号</th>
					<th data-options="field:'chnlcounts',width:150,align:'center'">代理渠道总数（个）</th>
					<th data-options="field:'dayscore',width:150,align:'center'">当日积分（分）</th>
					<th data-options="field:'monthscore',width:150,align:'center'">月累计积分（分）</th>
					<th data-options="field:'monthpay',width:150,align:'center'">月累计薪酬（元）</th>
				</tr>
			</thead>
			<tr>
			         <td><s:property value="tbMagerDayCounts.statisDate" /></td>
			         <td><s:property value="tbMagerDayCounts.country" /></td>
			         <td><s:property value="tbMagerDayCounts.name" /></td>
			         <td><s:property value="tbMagerDayCounts.staffId" /></td>
		           	 <td><s:property value="tbMagerDayCounts.prncpChnlCnt" /></td>
			         <td><s:property value="tbMagerDayCounts.curDaytotalScore" /></td>
			         <td><s:property value="tbMagerDayCounts.curMonTotalScore" /></td>
			         <td><fmt:formatNumber value="${tbMagerDayCounts.curMonTotalPay}" pattern="#.00" type="number"/></td>
			</tr>			
		</table>
		</div>
		</td>
		</tr>
		<tr>
		 <td colspan="2">
	       <div style="width:98%;hight:330px;float:left">
								<table class="easyui-datagrid" title="渠道经理当月大类业务薪酬  "
									style="width:auto;height:80px">
									<thead>
										<tr>
											<th data-options="field:'card',width:300,align:'center'"">卡号业务薪酬 （元）</th>
											<th data-options="field:'data',width:300,align:'center'">数据业务薪酬（元）</th>
											<th data-options="field:'agency',width:300,align:'center'">代办业务薪酬（元）</th>
											<th data-options="field:'term',width:300,align:'center'">终端业务薪酬（元）</th>
											<th data-options="field:'active',width:320,align:'center'">营销活动业务薪酬（元）</th>
										</tr>
									</thead>
									<tr>
									     <td> <s:property value="tbMangerMonthBigClassCounts.cardNumServTotalPay" /></td>
										<td><fmt:formatNumber value="${tbMangerMonthBigClassCounts.dataServTotalPay}" pattern="#.00" type="number"/></td>
										<td> <s:property value="tbMangerMonthBigClassCounts.agencyServTotalPay" /></td>
										<td><fmt:formatNumber value="${tbMangerMonthBigClassCounts.tmnlServTotalPay}" pattern="#.00" type="number"/></td>
									    <td><fmt:formatNumber value="${tbMangerMonthBigClassCounts.marktActServTotalPay}" pattern="#.00" type="number"/></td>
									</tr>
								</table>
							</div>
							</td>
		</tr>
		 <tr>
    <td width="49%"  colspan="1">
		<s:if test="msgpie==''">
			<div style="width: 550px; hight: 300px; float: left">
				<div id="contains"
					style="min-width: 400px; height: 300px; margin: 0 auto"></div>
			</div>
		</s:if>
		<s:else>
			<s:property value="msgpie" />
		</s:else>
		</td>
		 <td width="49%"  colspan="1">
			<s:if test="msgscore==''">
				<div
					style="width: 500px; hight: 350px; float: left; margin-left: 60px">
					<div id="linechart"
						style="min-width: 500px; height: 330px; margin: 0 auto"></div>
				</div>
			</s:if>
			<s:else>
	   		${msgscore}
	   </s:else>
		</td>
		</tr>
		<tr>
    <td colspan="2">
      <div  style="width:98%; height:250px; float:left; margin-left:2px"> &nbsp;
		<table id="chnldetail" class="easyui-datagrid"
			title="渠道经理当月明细统计  &nbsp; &nbsp; &nbsp; &nbsp;    <a
				href='javascript:void(0)' id='exportExl' class='easyui-linkbutton'
				iconCls='icon-print' plain='true' onclick='exportChnlDetail(${staticId });'>导出EXCEL</a>" 
			style="width:auto;height:320px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,pageSize:10,fitColumns : true,
			loadMsg : '数据加载中请稍后……',url:'browerMangerdetail.action?staticId='+<s:property value="staticId"/>">
			<thead>
				<tr>
					<th data-options="field:'date',width:90,align:'center'"">日期</th>
					<th data-options="field:'county',width:90,align:'center'">县区</th>
					<th data-options="field:'name',width:90,align:'center'">姓名</th>
					<th data-options="field:'nameid',width:90,align:'center'">员工编号</th>
					<th data-options="field:'chnlcounts',width:90,align:'center'">代理渠道总数（个）</th>
					<th data-options="field:'cardcore',width:90,align:'center'"">卡号发展积分（分）</th>
					<th data-options="field:'termscore',width:90,align:'center'">终端发展积分（分）</th>
					<th data-options="field:'datascore',width:90,align:'center'">数据业务发展积分（分）</th>
					<th data-options="field:'agenscore',width:90,align:'center'">代办业务积分（分）</th>
					<th data-options="field:'actiscore',width:90,align:'center'">营销活动积分（分）</th>
					<th data-options="field:'sumpay',width:110,align:'center'">总薪酬（元）</th>
					<th data-options="field:'moneypay',width:110,align:'center'">总奖金（元）</th>
				</tr>
			</thead>
		</table>
	</div></td></tr>
		</table>
	</body>
</html>
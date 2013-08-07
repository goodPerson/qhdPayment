<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>区县负责人月统计</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/demo.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/css/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/highcharts.js"></script>
<!-- 饼图ｊｓ脚本 -->
<script type="text/javascript">
	$(function() {
		var chart;

		chart = new Highcharts.Chart(
				{
					chart : {
						renderTo : 'pietu',
						plotBackgroundColor : null,
						plotBorderWidth : null,
						plotShadow : false
					},
					credits:{
           		enabled: false
                    },
					title : {
						text : '区县负责人大类业务积分比例'
					},
					tooltip : {
						pointFormat : '{series.name}: <b>{point.percentage}%</b> <br>积分：<b>{point.y} 分</b>',
						percentageDecimals : 1
					},
					plotOptions : {
						pie : {
							allowPointSelect : true,
							cursor : 'pointer',
							dataLabels : {
								enabled : true,
								color : '#000000',
								connectorColor : '#000000',
								formatter : function() {
									//var percentFormat=this.percentage.substring(0,this.percentage.indexOf(".") + 3);
									return '<b>'
											+ this.point.name
											+ '</b> '
											;
								}
							}
						}
					},
					series : [ {
						type : 'pie',
						name : '百分比',
						data : [
								[ '卡号类业务',
										<s:property value="countyCountMonth.cardNumServScoreTotalCnt"/> ],
								[ '数据类业务',
										<s:property value="countyCountMonth.dataServScoreTotalCnt"/> ],
								['代收费类业务',<s:property value="countyCountMonth.tmnlServScoreTotalCnt"/>],
								[ '终端类业务',
										<s:property value="countyCountMonth.tmnlServScoreTotalCnt"/> ],
								[ '营销类业务',
										<s:property value="countyCountMonth.actServScoreTotalCnt"/> ]
						]
					} ]
				});
	});

	$(function() {
		var chart;
		chart = new Highcharts.Chart(
				{
					chart : {
						renderTo : 'linechart',
						type : 'line'
					},
					credits:{
           		enabled: false
                    },
					title : {
						text : '本县积分和成交量折线图'
					},
					subtitle : {
						text : ''
					},
					xAxis : {
						categories : [ '1月', '2月', '3月', '4月', '5月', '6月',
								'7月', '8月', '9月', '10月', '11月', '12月' ]
					},
					yAxis : {
						title : {
							text : ''
						}
					},
					tooltip : {
						enabled : false,
						formatter : function() {
							return '<b>' + this.series.name + '</b><br/>'
									+ this.x + ': ' + this.y + '°C';
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
					series : [
							{
								name : '月积分',
								data : [
										<s:property value="countyStaticMonthScore.one"/>,
										<s:property value="countyStaticMonthScore.two"/>,
										<s:property value="countyStaticMonthScore.three"/>,
										<s:property value="countyStaticMonthScore.four"/>,
										<s:property value="countyStaticMonthScore.five"/>,
										<s:property value="countyStaticMonthScore.six"/>,
										<s:property value="countyStaticMonthScore.seven"/>,
										<s:property value="countyStaticMonthScore.eight"/>,
										<s:property value="countyStaticMonthScore.nine"/>,
										<s:property value="countyStaticMonthScore.ten"/>,
										<s:property value="countyStaticMonthScore.eleven"/>,
										<s:property value="countyStaticMonthScore.twelve"/> ]
							},
							{
								name : '月成交量',
								data : [
										<s:property value="countyStaticMonthCnt.one"/>,
										<s:property value="countyStaticMonthCnt.two"/>,
										<s:property value="countyStaticMonthCnt.three"/>,
										<s:property value="countyStaticMonthCnt.four"/>,
										<s:property value="countyStaticMonthCnt.five"/>,
										<s:property value="countyStaticMonthCnt.six"/>,
										<s:property value="countyStaticMonthCnt.seven"/>,
										<s:property value="countyStaticMonthCnt.eight"/>,
										<s:property value="countyStaticMonthCnt.nine"/>,
										<s:property value="countyStaticMonthCnt.ten"/>,
										<s:property value="countyStaticMonthCnt.eleven"/>,
										<s:property value="countyStaticMonthCnt.twelve"/> ]
							} ]
				});

	});
</script>
</head>

<body>
   <jsp:include page="/common/top.jsp"></jsp:include>
	<!-- 区县日汇总数据  	开始 -->
	<div style="margin-left:10px">
		<table class="easyui-datagrid" title="区县日汇总数据"
			style="position:absolute;height:80px"
			data-options="singleSelect:true,collapsible:true,fitColumns : true,
			loadMsg : '数据加载中请稍后……',url:''">
			<thead>
				<tr>
					<th data-options="field:'date',width:100,align:'center'"">日期</th>
					<th data-options="field:'county',width:100,align:'center'">县区</th>
					<th data-options="field:'name',width:100,align:'center'">渠道经理总数（个）</th>
					<th data-options="field:'nameid',width:100,align:'center'">代理渠道总数（个）</th>
					<th data-options="field:'chnlcounts',width:100,align:'center'">当日总积分（分）</th>
					<th data-options="field:'dayscore',width:100,align:'center'">当月累计积分（分）</th>
					<th data-options="field:'monthscore',width:100,align:'center'">当月累计薪酬（元）</th>
				</tr>
			</thead>
			<tr>
				<td data-options="field:'date',width:100,align:'center'""><s:property
						value="model.statisDate" />
				</td>
				<td data-options="field:'county',width:100,align:'center'"><s:property
						value="model.county" />
				</td>
				<td data-options="field:'name',width:100,align:'center'"><s:property
						value="model.chnlMagrTotalCnt" />
				</td>
				<td data-options="field:'nameid',width:100,align:'center'"><s:property
						value="model.chnlTotalCnt" />
				</td>
				<td data-options="field:'chnlcounts',width:100,align:'center'"><s:property
						value="model.dayTotalScoreCnt" />
				</td>
				<td data-options="field:'dayscore',width:100,align:'center'"><s:property
						value="model.curMonTotalScoreCnt" />
				</td>
				<td data-options="field:'monthscore',width:100,align:'center'"><s:property
						value="model.curMonTotalPay" />
				</td>
			</tr>
		</table>
	</div>
	<!-- 区县日汇总数据  	结束 -->
	<br />
	<br />
	<!-- 图形展示 	开始 -->
	<div style="margin-left:10px">
		<table width="100%">
			<tr>
				<td width="50%">
					<!-- 大类业务薪酬所占比例 --> <s:if test="msg==''">
						<div style="width:660px;hight:500px;float:left">
							<div style="width:650px;">
								<table class="easyui-datagrid" title="区县日大类业务积分"  
									style="width:650px;height:80px">
									<thead>
										<tr>
											<th data-options="field:'card',width:120,align:'center'"">卡号业务积分（分）</th>
											<th data-options="field:'data',width:120,align:'center'">数据业务积分（分）</th>
											<th data-options="field:'agency',width:120,align:'center'">代办业务积分（分）</th>
											<th data-options="field:'term',width:120,align:'center'">终端业务积分（分）</th>
											<th data-options="field:'active',width:140,align:'center'">营销活动业务积分（分）</th>
										</tr>
									</thead>
									<tr>
										<td><s:property
												value="countyCountMonth.cardNumServScoreTotalCnt" />
										</td>
										<td><s:property
												value="countyCountMonth.dataServScoreTotalCnt" />
										</td>
										<td><s:property
												value="countyCountMonth.tmnlServScoreTotalCnt" />
										</td>
										<td><s:property
												value="countyCountMonth.tmnlServScoreTotalCnt" />
										</td>
										<td><s:property
												value="countyCountMonth.actServScoreTotalCnt" />
										</td>
									</tr>
								</table>
							</div>
							<br /> <br />
							<div id="pietu"
								style="min-width: 650px; height: 300px; margin: 0 auto;float:left;"></div>
						</div>
					</s:if> <s:else>
						<s:property value="msg" />
					</s:else></td>
				<td width="50%">
					<!-- 每月积分和成交量折线图  -->
					<div style="width:660px;hight:400px;float:left;margin-left:20px">
						<div id="linechart"
							style="min-width: 650px; height: 400px; margin: 0 auto"></div>
					</div></td>
			</tr>
		</table>
	</div>
	<!-- 图形展示 	结束 -->
	<br />
	<br />
	<div style="margin-left:10px;margin-right:10px;">
		<!-- 区县排名 	开始 -->
		<table width="100%">
			<tr>
				<td width="50%">
					<!-- 区县正向排名 	开始 -->
					<table class="easyui-datagrid" title="本县销售前十名"
						style="width:650px;height:300px">
						<thead>
							<tr>
								<th data-options="field:'statisDate',width:90,align:'center'"">日期</th>
								<th data-options="field:'county',width:90,align:'center'">区县</th>
								<th data-options="field:'countyOrder',width:90,align:'center'">区县排名</th>
								<th data-options="field:'chnlMagrName',width:90,align:'center'">姓名</th>
								<th data-options="field:'cityOrder',width:90,align:'center'">市排名</th>
								<th data-options="field:'chnlMagrCurMonTotalScore',width:90,align:'center'">当月总积分（分）</th>
								<th data-options="field:'chnlMagrCurMonTotalPay',width:90,align:'center'">当月总薪酬（元）</th>
							</tr>
						</thead>
						<s:iterator value="countyTopDayList" id="ctdl" status="i">
							<tr>
								<td><s:property value="#ctdl.statisDate" />
								</td>
								<td><s:property value="#ctdl.county" />
								</td>
								<td><s:property value="#ctdl.countyOrder" />
								</td>
								<td><s:property value="#ctdl.chnlMagrName" />
								</td>
								<td><s:property value="#ctdl.cityOrder" />
								</td>
								<td><s:property value="#ctdl.chnlMagrCurMonTotalScore" />
								</td>
								<td><s:property value="#ctdl.chnlMagrCurMonTotalPay" />
								</td>
							</tr>
						</s:iterator>
					</table> <!-- 区县正向排名 	结束 --></td>
				<td style="padding-left:30px;">
					<!-- 区县反向排名 	开始 -->
					<table class="easyui-datagrid" title="本县销售后十名"
						style="width:650px;height:300px;margin-left:30px;">
						<thead>
							<tr>
								<th data-options="field:'card',width:120,align:'center'"">日期</th>
								<th data-options="field:'data',width:120,align:'center'">区县</th>
								<th data-options="field:'agency',width:120,align:'center'">区县倒数排名</th>
								<th data-options="field:'term',width:120,align:'center'">姓名</th>
								<th data-options="field:'active',width:120,align:'center'">当月总积分（分）</th>
							</tr>
						</thead>
						<s:iterator value="countryChnlDescDayList" id="ctddl" status="a">
							<tr>
								<td><s:property value="#ctddl.statisDate" />
								</td>
								<td><s:property value="#ctddl.county" />
								</td>
								<td><s:property value="#ctddl.descOrder" />
								</td>
								<td><s:property value="#ctddl.chnlMagrName" />
								</td>
								<td><s:property value="#ctddl.chnlMagrNcore" />
								</td>
							</tr>
						</s:iterator>
					</table> <!-- 区县反向排名 	结束 --></td>
			</tr>
		</table>
	</div>
	<!-- 区县排名 	结束 -->
</body>
</html>

<%@ page contentType="text/html; charset=gbk"%>
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
<title>��������_��ҳ</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/demo.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/css/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/css/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		var chart;

		chart = new Highcharts.Chart(
				{
					chart : {
						renderTo : 'container',
						plotBackgroundColor : null,
						plotBorderWidth : null,
						plotShadow : false
					},
					title : {
						text : '���������������ҵ�񽱽����'
					},
					tooltip : {
						pointFormat : '{series.name}: <b>{point.percentage}%</b>',
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
											+ '</b>: '
											+ Number(this.percentage)
													.toFixed(2) + ' %';
								}
							}
						}
					},
					series : [ {
						type : 'pie',
						name : '�ٷֱ�',
						data : [
								[ '������ҵ��',<s:property value="tbMangerMonthBigClassCounts.cardNumServTotalPay"/> ],
								[ '������ҵ��',<s:property value="tbMangerMonthBigClassCounts.dataServTotalPay"/> ],
								['���շ���ҵ��',<s:property value="tbMangerMonthBigClassCounts.agencyServTotalPay"/>]
								[ '�ն���ҵ��',<s:property value="tbMangerMonthBigClassCounts.tmnlServTotalPay"/> ],
								[ 'Ӫ����ҵ��',<s:property value="tbMangerMonthBigClassCounts.marktActServTotalPay"/> ]
						]
					} ]
				});
	});
	
	$(function() {
		var chart;
		chart = new Highcharts.Chart({
			chart : {
				renderTo : 'linechart',
				type : 'line'
			},
			title : {
				text : '���������»��ֺ�н������ͼ'
			},
			subtitle : {
				text : ''
			},
			xAxis : {
				categories : [ '1��', '2��', '3��', '4��', '5��', '6��', '7��', '8��',
						'9��', '10��', '11��', '12��' ]
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
							+ ': ' + this.y + '��C';
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
						name : '�»���',
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
					},
					{
						name : '��н��',
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
					} ]
		});
	});
</script>
</head>

<body>
	<script type="text/javascript" src="<%=path%>/css/highcharts.js"></script>
	<script type="text/javascript" src="<%=path%>/css/exporting.js"></script>
	<jsp:include page="/common/top.jsp"></jsp:include>
	<div>
		<table class="easyui-datagrid" title="������������Ա������"
			style="position:absolute;height:80px"
			data-options="singleSelect:true,collapsible:true,fitColumns : true,
			loadMsg : '���ݼ��������Ժ󡭡�',url:'chnlMagerDayCounts.action?workerID=1'">
			<thead>
				<tr>
					<th data-options="field:'date',width:100,align:'center'"">����</th>
					<th data-options="field:'county',width:100,align:'center'">����</th>
					<th data-options="field:'name',width:100,align:'center'">����</th>
					<th data-options="field:'nameid',width:100,align:'center'">Ա�����</th>
					<th data-options="field:'chnlcounts',width:100,align:'center'">������������</th>
					<th data-options="field:'dayscore',width:100,align:'center'">���ջ���</th>
					<th data-options="field:'monthscore',width:100,align:'center'">���ۼƻ���</th>
					<th data-options="field:'monthpay',width:150,align:'center'">���ۼ�н��</th>
				</tr>
			</thead>
		</table>
	</div>
	<br />
	<br />
	<table width="100%">
		<tr>
			<td width="50%">
				<!-- ����ҵ��н����ռ���� -->
				<div
					style="border:1px solid #ED9F9F;width:660px;hight:500px;float:left">
					<div style="width:650px;">
						<table class="easyui-datagrid" title="���������´���ҵ�񽱽�(����)"
							style="width:650px;height:80px"
							data-options="singleSelect:true,fitColumns : true,
			loadMsg : '���ݼ��������Ժ󡭡�',collapsible:true,url:''">
							<!-- magerBigClassCounts.action?workerID=1 -->
							<thead>
								<tr>
									<th data-options="field:'card',width:100,align:'center'"">����ҵ�񽱽�</th>
									<th data-options="field:'data',width:100,align:'center'">����ҵ�񽱽�</th>
									<th data-options="field:'agency',width:100,align:'center'">����ҵ�񽱽�</th>
									<th data-options="field:'term',width:100,align:'center'">�ն�ҵ�񽱽�</th>
									<th data-options="field:'active',width:120,align:'center'">Ӫ���ҵ�񽱽�</th>
								</tr>
							</thead>
							<tr>
								<td><s:property
										value="tbMangerMonthBigClassCounts.cardNumServTotalPay" />
								</td>
								<td><s:property
										value="tbMangerMonthBigClassCounts.dataServTotalPay" />
								</td>
								<td><s:property
										value="tbMangerMonthBigClassCounts.agencyServTotalPay" />
								</td>
								<td><s:property
										value="tbMangerMonthBigClassCounts.tmnlServTotalPay" />
								</td>
								<td><s:property
										value="tbMangerMonthBigClassCounts.marktActServTotalPay" />
								</td>
							</tr>
						</table>
					</div>
					<br /> <br />
					<div id="container"
						style="min-width: 650px; height: 400px; margin: 0 auto;float:left;"></div>

				</div></td>
			<td width="50%">
				<!-- ÿ��н����ռ����  -->
				<div
					style="background-color:#CC0033; border:1px solid #ED9F9F;width:660px;hight:600px;float:left;margin-left:60px">
					<div id="linechart"
						style="min-width: 400px; height: 400px; margin: 0 auto"></div>
				</div></td>
		</tr>
	</table>

	<div
		style="background-color:#CC0033; border:1px solid #ED9F9F;width��auto;hight:600px;">
		<table class="easyui-datagrid" title="��������������"
			style="width:auto;height:300px"
			data-options="singleSelect:true,collapsible:true,fitColumns : true,
			loadMsg : '���ݼ��������Ժ󡭡�',url:'magerBigClassCounts.action?workerID=1'">
			<thead>
				<tr>
					<th data-options="field:'card',width:100,align:'center'"">�·�</th>
					<th data-options="field:'data',width:100,align:'center'">����</th>
					<th data-options="field:'agency',width:100,align:'center'">����</th>
					<th data-options="field:'term',width:100,align:'center'">Ա�����</th>
					<th data-options="field:'active',width:120,align:'center'">������������</th>
					<th data-options="field:'card',width:100,align:'center'"">���ŷ�չ����</th>
					<th data-options="field:'data',width:100,align:'center'">�ն˷�չ����</th>
					<th data-options="field:'agency',width:100,align:'center'">����ҵ��չ����</th>
					<th data-options="field:'term',width:100,align:'center'">Ӫ�������</th>
					<th data-options="field:'active',width:120,align:'center'">��н��</th>
					<th data-options="field:'active',width:120,align:'center'">�ܽ���</th>
				</tr>
			</thead>
			<tr>
				<td><s:property
						value="tbMangerMonthBigClassCounts.cardNumServTotalPay" />
				</td>
				<td><s:property
						value="tbMangerMonthBigClassCounts.dataServTotalPay" />
				</td>
				<td><s:property
						value="tbMangerMonthBigClassCounts.agencyServTotalPay" />
				</td>
				<td><s:property
						value="tbMangerMonthBigClassCounts.tmnlServTotalPay" />
				</td>
				<td><s:property
						value="tbMangerMonthBigClassCounts.marktActServTotalPay" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>

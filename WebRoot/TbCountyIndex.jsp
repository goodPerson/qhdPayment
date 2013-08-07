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
<title>���ظ�������ͳ��</title>
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
<!-- ��ͼ���ű� -->
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
						text : '���ظ����˴���ҵ����ֱ���'
					},
					tooltip : {
						pointFormat : '{series.name}: <b>{point.percentage}%</b> <br>���֣�<b>{point.y} ��</b>',
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
						name : '�ٷֱ�',
						data : [
								[ '������ҵ��',
										<s:property value="countyCountMonth.cardNumServScoreTotalCnt"/> ],
								[ '������ҵ��',
										<s:property value="countyCountMonth.dataServScoreTotalCnt"/> ],
								['���շ���ҵ��',<s:property value="countyCountMonth.tmnlServScoreTotalCnt"/>],
								[ '�ն���ҵ��',
										<s:property value="countyCountMonth.tmnlServScoreTotalCnt"/> ],
								[ 'Ӫ����ҵ��',
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
						text : '���ػ��ֺͳɽ�������ͼ'
					},
					subtitle : {
						text : ''
					},
					xAxis : {
						categories : [ '1��', '2��', '3��', '4��', '5��', '6��',
								'7��', '8��', '9��', '10��', '11��', '12��' ]
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
									+ this.x + ': ' + this.y + '��C';
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
								name : '�³ɽ���',
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
	<!-- �����ջ�������  	��ʼ -->
	<div style="margin-left:10px">
		<table class="easyui-datagrid" title="�����ջ�������"
			style="position:absolute;height:80px"
			data-options="singleSelect:true,collapsible:true,fitColumns : true,
			loadMsg : '���ݼ��������Ժ󡭡�',url:''">
			<thead>
				<tr>
					<th data-options="field:'date',width:100,align:'center'"">����</th>
					<th data-options="field:'county',width:100,align:'center'">����</th>
					<th data-options="field:'name',width:100,align:'center'">������������������</th>
					<th data-options="field:'nameid',width:100,align:'center'">������������������</th>
					<th data-options="field:'chnlcounts',width:100,align:'center'">�����ܻ��֣��֣�</th>
					<th data-options="field:'dayscore',width:100,align:'center'">�����ۼƻ��֣��֣�</th>
					<th data-options="field:'monthscore',width:100,align:'center'">�����ۼ�н�꣨Ԫ��</th>
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
	<!-- �����ջ�������  	���� -->
	<br />
	<br />
	<!-- ͼ��չʾ 	��ʼ -->
	<div style="margin-left:10px">
		<table width="100%">
			<tr>
				<td width="50%">
					<!-- ����ҵ��н����ռ���� --> <s:if test="msg==''">
						<div style="width:660px;hight:500px;float:left">
							<div style="width:650px;">
								<table class="easyui-datagrid" title="�����մ���ҵ�����"  
									style="width:650px;height:80px">
									<thead>
										<tr>
											<th data-options="field:'card',width:120,align:'center'"">����ҵ����֣��֣�</th>
											<th data-options="field:'data',width:120,align:'center'">����ҵ����֣��֣�</th>
											<th data-options="field:'agency',width:120,align:'center'">����ҵ����֣��֣�</th>
											<th data-options="field:'term',width:120,align:'center'">�ն�ҵ����֣��֣�</th>
											<th data-options="field:'active',width:140,align:'center'">Ӫ���ҵ����֣��֣�</th>
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
					<!-- ÿ�»��ֺͳɽ�������ͼ  -->
					<div style="width:660px;hight:400px;float:left;margin-left:20px">
						<div id="linechart"
							style="min-width: 650px; height: 400px; margin: 0 auto"></div>
					</div></td>
			</tr>
		</table>
	</div>
	<!-- ͼ��չʾ 	���� -->
	<br />
	<br />
	<div style="margin-left:10px;margin-right:10px;">
		<!-- �������� 	��ʼ -->
		<table width="100%">
			<tr>
				<td width="50%">
					<!-- ������������ 	��ʼ -->
					<table class="easyui-datagrid" title="��������ǰʮ��"
						style="width:650px;height:300px">
						<thead>
							<tr>
								<th data-options="field:'statisDate',width:90,align:'center'"">����</th>
								<th data-options="field:'county',width:90,align:'center'">����</th>
								<th data-options="field:'countyOrder',width:90,align:'center'">��������</th>
								<th data-options="field:'chnlMagrName',width:90,align:'center'">����</th>
								<th data-options="field:'cityOrder',width:90,align:'center'">������</th>
								<th data-options="field:'chnlMagrCurMonTotalScore',width:90,align:'center'">�����ܻ��֣��֣�</th>
								<th data-options="field:'chnlMagrCurMonTotalPay',width:90,align:'center'">������н�꣨Ԫ��</th>
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
					</table> <!-- ������������ 	���� --></td>
				<td style="padding-left:30px;">
					<!-- ���ط������� 	��ʼ -->
					<table class="easyui-datagrid" title="�������ۺ�ʮ��"
						style="width:650px;height:300px;margin-left:30px;">
						<thead>
							<tr>
								<th data-options="field:'card',width:120,align:'center'"">����</th>
								<th data-options="field:'data',width:120,align:'center'">����</th>
								<th data-options="field:'agency',width:120,align:'center'">���ص�������</th>
								<th data-options="field:'term',width:120,align:'center'">����</th>
								<th data-options="field:'active',width:120,align:'center'">�����ܻ��֣��֣�</th>
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
					</table> <!-- ���ط������� 	���� --></td>
			</tr>
		</table>
	</div>
	<!-- �������� 	���� -->
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>����������ͳ��</title>
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
                text: '���������������ҵ��н�����'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b> <br>н��:<b>{point.y}Ԫ</b>',
              
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
                    ['������ҵ��',   <s:property value="tbMangerMonthBigClassCounts.cardNumServTotalPay"/>],
                    ['������ҵ��',  <s:property value="tbMangerMonthBigClassCounts.dataServTotalPay"/>],
                    {
                        name: '���շ���ҵ��',
                        y: <s:property value="tbMangerMonthBigClassCounts.agencyServTotalPay"/>,
                        sliced: true,
                        selected: true
                    },
                    ['�ն���ҵ��',  <s:property value="tbMangerMonthBigClassCounts.tmnlServTotalPay"/>],
                    ['Ӫ����ҵ��',     <s:property value="tbMangerMonthBigClassCounts.marktActServTotalPay"/>]
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
			series : [{
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
					},{
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
					}]
			});
		});
	});
</script>
<!--���� ��������������ϸ -->
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
		<table class="easyui-datagrid" title="��������Ա������"
			style="width:auto;height:80px"
			data-options="singleSelect:true,collapsible:true,fitColumns : true,
			loadMsg : '���ݼ��������Ժ󡭡�',url:''">
			<thead>
				<tr>
					<th data-options="field:'date',width:150,align:'center'"">����</th>
					<th data-options="field:'county',width:150,align:'center'">����</th>
					<th data-options="field:'name',width:150,align:'center'">����</th>
					<th data-options="field:'nameid',width:150,align:'center'">Ա�����</th>
					<th data-options="field:'chnlcounts',width:150,align:'center'">������������������</th>
					<th data-options="field:'dayscore',width:150,align:'center'">���ջ��֣��֣�</th>
					<th data-options="field:'monthscore',width:150,align:'center'">���ۼƻ��֣��֣�</th>
					<th data-options="field:'monthpay',width:150,align:'center'">���ۼ�н�꣨Ԫ��</th>
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
								<table class="easyui-datagrid" title="���������´���ҵ��н��  "
									style="width:auto;height:80px">
									<thead>
										<tr>
											<th data-options="field:'card',width:300,align:'center'"">����ҵ��н�� ��Ԫ��</th>
											<th data-options="field:'data',width:300,align:'center'">����ҵ��н�꣨Ԫ��</th>
											<th data-options="field:'agency',width:300,align:'center'">����ҵ��н�꣨Ԫ��</th>
											<th data-options="field:'term',width:300,align:'center'">�ն�ҵ��н�꣨Ԫ��</th>
											<th data-options="field:'active',width:320,align:'center'">Ӫ���ҵ��н�꣨Ԫ��</th>
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
			title="������������ϸͳ��  &nbsp; &nbsp; &nbsp; &nbsp;    <a
				href='javascript:void(0)' id='exportExl' class='easyui-linkbutton'
				iconCls='icon-print' plain='true' onclick='exportChnlDetail(${staticId });'>����EXCEL</a>" 
			style="width:auto;height:320px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,pageSize:10,fitColumns : true,
			loadMsg : '���ݼ��������Ժ󡭡�',url:'browerMangerdetail.action?staticId='+<s:property value="staticId"/>">
			<thead>
				<tr>
					<th data-options="field:'date',width:90,align:'center'"">����</th>
					<th data-options="field:'county',width:90,align:'center'">����</th>
					<th data-options="field:'name',width:90,align:'center'">����</th>
					<th data-options="field:'nameid',width:90,align:'center'">Ա�����</th>
					<th data-options="field:'chnlcounts',width:90,align:'center'">������������������</th>
					<th data-options="field:'cardcore',width:90,align:'center'"">���ŷ�չ���֣��֣�</th>
					<th data-options="field:'termscore',width:90,align:'center'">�ն˷�չ���֣��֣�</th>
					<th data-options="field:'datascore',width:90,align:'center'">����ҵ��չ���֣��֣�</th>
					<th data-options="field:'agenscore',width:90,align:'center'">����ҵ����֣��֣�</th>
					<th data-options="field:'actiscore',width:90,align:'center'">Ӫ������֣��֣�</th>
					<th data-options="field:'sumpay',width:110,align:'center'">��н�꣨Ԫ��</th>
					<th data-options="field:'moneypay',width:110,align:'center'">�ܽ���Ԫ��</th>
				</tr>
			</thead>
		</table>
	</div></td></tr>
		</table>
	</body>
</html>
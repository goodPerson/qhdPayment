package com.jyyr.strtus.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import com.jyyr.utitly.DateUtil;


import com.jyyr.common.PrintExcelUtil;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.orm.TbMagerDayCounts;
import com.jyyr.orm.TbMangerMonthBigClassCounts;
import com.jyyr.orm.TbMonthLineChart;
import com.jyyr.service.TbDayCountsDetailService;
import com.jyyr.service.TbMagerDayCountsService;
import com.jyyr.service.TbMangerMonthBigClassCountsService;
import com.jyyr.service.TbMonthLineChartService;
import com.jyyr.service.TbReckonPiecePayDealInfoDService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TbMangerMonthBigClassCountsAction extends ActionSupport implements ModelDriven<TbMangerMonthBigClassCounts> {
	TbMagerDayCountsService magerDayCountsService;// 渠道经理日统计接口
	TbMangerMonthBigClassCountsService service;//渠道经理大类接口
	TbReckonPiecePayDealInfoDService reckonPayService;//渠道计件项目日明细
	TbMonthLineChartService tbMonthLineChart; //渠道经理月薪酬和积分统计
	TbDayCountsDetailService dayCountsDetailService; //渠道经理日明细统计接口	
	
	/**所需要的参数*/
	private  String staticId; //经分工号
	private  String staticDay; //日期
	private  Integer monthMaxDays; //每月最大天数
	private  Integer pageSize; //每页记录数
	private  Integer page; //当前页数
	private	String pageNum; //总页数
	private Integer totalCounts;   //总记录数
	private  String msgpie;
	private  String msgscore;

	private String roleName;
    private String userName;
	private String regionId;
    private String regionName;
	
	/**所需要的类*/
	private TbMagerDayCounts tbMagerDayCounts;  //渠道经理日统计
	private TbMangerMonthBigClassCounts tbMangerMonthBigClassCounts; //渠道经理大类业务统计
	private TbMonthLineChart modelPay; //渠道经理月薪酬
	private TbMonthLineChart modelScore; //渠道经理月积分
	List<TbMangerMonthBigClassCounts> tbMangerMonthBigClassCountsList;
	    
	/**下载渠道经理详细信息所需要的参数*/
	String contentType;//内容类型
	FileInputStream downloadFile;//
	String fileName;//文件名
	
	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	TbMangerMonthBigClassCounts model=new TbMangerMonthBigClassCounts();
	public TbMangerMonthBigClassCounts getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	

	public String magerIndexStati(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		if (request.getParameter("page")!=null&&!"".equals(request.getParameter("page"))) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		else {
			page=1;
		}

		if (request.getParameter("rows")!=null&&!"".equals(request.getParameter("rows"))) {
			pageSize=Integer.parseInt(request.getParameter("rows"));
		}else {
			pageSize=10;
		}
//**********************渠道经理大类业务奖金统计  开始  ********************************************	
		String curday=DateUtil.getYearMonthDay();
		String beforeDay=DateUtil.getSpecifiedDayBefore(curday);
		tbMagerDayCounts=reckonPayService.ChnlMagerDayCount(staticId);
//		System.out.println(staticId);
//		tbMangerMonthBigClassCounts=reckonPayService.magerBigClassPayCount(staticId);
		tbMangerMonthBigClassCounts=reckonPayService.magerBigClassPayCount(staticId);
		if (null==tbMangerMonthBigClassCounts){
			msgpie="没有您最新的数据";
		}else{
			msgpie="";
		}
//**********************渠道经理大类业务奖金统计  结束  ********************************************	
		
		modelScore=tbMonthLineChart.loadtbMonthLineChart(staticId,"score");
		if (null==modelScore){
			msgscore="没有您最新的数据";
		}else{
			msgscore="";
		}
		modelPay=tbMonthLineChart.loadtbMonthLineChart(staticId,"pay");
		if (null==modelScore){
			msgscore="没有您最新的数据";
		}else{
			msgscore="";
		}
		return SUCCESS;
	}
	
	public String browerMagerDetail() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		
//**********************渠道经理日统计明细  开始  ********************************************	
		if (request.getParameter("page")!=null&&!"".equals(request.getParameter("page"))) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		else {
			page=1;
		}

		if (request.getParameter("rows")!=null&&!"".equals(request.getParameter("rows"))) {
			pageSize=Integer.parseInt(request.getParameter("rows"));
		}else {
			pageSize=10;
		}
		
		staticDay=DateUtil.getSpecifiedDayBefore(DateUtil.getYearMonthDay());
		tbMangerMonthBigClassCountsList=service.browerTbMangerMonthBigClassCounts(staticId,staticDay, pageSize, page);	
		totalCounts=service.bigClassCounts(staticId, staticDay);
		
		JSONArray jsonArray = new JSONArray();
		
		if (tbMangerMonthBigClassCountsList!=null){
			for(int i=0;i<tbMangerMonthBigClassCountsList.size();i++){
				TbMangerMonthBigClassCounts mmbcc= tbMangerMonthBigClassCountsList.get(i);
				JSONObject jsonObjectmonthBigClassdetail = new JSONObject();
				jsonObjectmonthBigClassdetail.put("date", mmbcc.getStatisMonth()); //日期
				jsonObjectmonthBigClassdetail.put("county", mmbcc.getCounty()); //县区
				jsonObjectmonthBigClassdetail.put("name",mmbcc.getName());									//姓名
				jsonObjectmonthBigClassdetail.put("nameid",mmbcc.getStaffId());		//工号
				jsonObjectmonthBigClassdetail.put("chnlcounts", mmbcc.getChnlCounts()); //渠道经理渠道数量
				jsonObjectmonthBigClassdetail.put("cardcore",mmbcc.getCardNumServTotalScore());//卡号业务总积分							//日积分
				jsonObjectmonthBigClassdetail.put("termscore", mmbcc.getTmnlServTotalScore()); //终端业务总积分
				jsonObjectmonthBigClassdetail.put("datascore",mmbcc.getDataServTotalScore()); //数据业务总积分
				jsonObjectmonthBigClassdetail.put("agenscore",mmbcc.getAgencyServTotalScore()); //代办业务总积分
				jsonObjectmonthBigClassdetail.put("actiscore",mmbcc.getMarktActServTotalScore()); //活动业务总积分
				jsonObjectmonthBigClassdetail.put("sumpay",mmbcc.getSunPay()); //总薪酬
				jsonObjectmonthBigClassdetail.put("moneypay",mmbcc.getMoneyPay()); //总奖金
				jsonArray.add(jsonObjectmonthBigClassdetail);	
			}
//			for (TbMangerMonthBigClassCounts mmbcc : tbMangerMonthBigClassCountsList){
//				JSONObject jsonObjectmonthBigClassdetail = new JSONObject();
//				jsonObjectmonthBigClassdetail.put("date", mmbcc.getStatisMonth()); //日期
//				jsonObjectmonthBigClassdetail.put("county", mmbcc.getCounty()); //县区
//				jsonObjectmonthBigClassdetail.put("name",mmbcc.getName());									//姓名
//				jsonObjectmonthBigClassdetail.put("nameid",mmbcc.getStaffId() );		//工号
//				jsonObjectmonthBigClassdetail.put("chnlcounts", mmbcc.getChnlCounts()); //渠道经理渠道数量
//				jsonObjectmonthBigClassdetail.put("cardcore",mmbcc.getCardNumServTotalScore());//卡号业务总积分							//日积分
//				jsonObjectmonthBigClassdetail.put("termscore", mmbcc.getTmnlServTotalScore()); //终端业务总积分
//				jsonObjectmonthBigClassdetail.put("datascore",mmbcc.getDataServTotalScore()); //数据业务总积分
//				jsonObjectmonthBigClassdetail.put("agenscore",mmbcc.getAgencyServTotalScore() ); //代办业务总积分
//				jsonObjectmonthBigClassdetail.put("actiscore",mmbcc.getMarktActServTotalScore() ); //活动业务总积分
//				jsonObjectmonthBigClassdetail.put("sumpay",mmbcc.getSunPay() ); //总薪酬
//				jsonObjectmonthBigClassdetail.put("moneypay",mmbcc.getMoneyPay() ); //总奖金
//				jsonArray.add(jsonObjectmonthBigClassdetail);				
//			}
		}
		JSONObject jsonObjectFinal = new JSONObject();
		jsonObjectFinal.put("rows", jsonArray);
		jsonObjectFinal.put("total", totalCounts);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonObjectFinal.toString());
		printWriter.flush();
		printWriter.close();	
//**********************渠道经理日统计明细  结束  ********************************************
		
		return SUCCESS;
	}
	
	/**导出工号
	 * @throws Exception */
	public String exportChnlDetail() throws Exception {
//		HttpServletResponse response = ServletActionContext.getResponse();
		String  exportType = "xls";
		// 定义表头
		String header = "月份 县区 姓名 员工编号 代理渠道总数 卡号发展积分 终端发展积分 数据业务发展积分 代办业务积分 营销活动积分 总薪酬 总奖金 ";
		// 获取数据
//		List l = exportBasicInfoMList;
		staticDay=DateUtil.getSpecifiedDayBefore(DateUtil.getYearMonthDay());
		List<TbMangerMonthBigClassCounts> l=service.loadTbMangerMonthBigClassCounts(staticId, staticDay);
		
		List<Object[]> datalist = new ArrayList<Object[]>();
		for (int i = 0; i < l.size(); i++) {
			TbMangerMonthBigClassCounts magerMonthbigClassCount = (TbMangerMonthBigClassCounts) l.get(i);
			Object[] obj = { magerMonthbigClassCount.getStatisMonth(),magerMonthbigClassCount.getCounty(),magerMonthbigClassCount.getName(),
					         magerMonthbigClassCount.getStaffId(),magerMonthbigClassCount.getChnlCounts(),magerMonthbigClassCount.getCardNumServTotalScore(),
					         magerMonthbigClassCount.getTmnlServTotalScore(),magerMonthbigClassCount.getDataServTotalScore(),magerMonthbigClassCount.getAgencyServTotalScore(),
					         magerMonthbigClassCount.getMarktActServTotalScore(),magerMonthbigClassCount.getSunPay(),magerMonthbigClassCount.getMoneyPay()};
			datalist.add(obj);
		}
		FileInputStream result = PrintExcelUtil.getDownloadFile(exportType,
				"渠道经理当月明细统计", "渠道经理当月明细统计", header, datalist);
		contentType = "application/vnd.ms-excel;charset=utf-8";
		downloadFile = result;
		fileName = "渠道经理当月明细统计.xls";
		fileName = new String(fileName.getBytes(), "ISO8859-1");
		return "downLoad" ;		
	}

	public TbMangerMonthBigClassCountsService getService() {
		return service;
	}

	public void setService(TbMangerMonthBigClassCountsService service) {
		this.service = service;
	}

	public TbMagerDayCountsService getMagerDayCountsService() {
		return magerDayCountsService;
	}

	public void setMagerDayCountsService(
			TbMagerDayCountsService magerDayCountsService) {
		this.magerDayCountsService = magerDayCountsService;
	}

	public TbReckonPiecePayDealInfoDService getReckonPayService() {
		return reckonPayService;
	}

	public void setReckonPayService(
			TbReckonPiecePayDealInfoDService reckonPayService) {
		this.reckonPayService = reckonPayService;
	}

	public TbMonthLineChartService getTbMonthLineChart() {
		return tbMonthLineChart;
	}

	public void setTbMonthLineChart(TbMonthLineChartService tbMonthLineChart) {
		this.tbMonthLineChart = tbMonthLineChart;
	}



	public TbDayCountsDetailService getDayCountsDetailService() {
		return dayCountsDetailService;
	}

	public void setDayCountsDetailService(
			TbDayCountsDetailService dayCountsDetailService) {
		this.dayCountsDetailService = dayCountsDetailService;
	}

	public String getStaticId() {
		return staticId;
	}

	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}

	public String getStaticDay() {
		return staticDay;
	}

	public void setStaticDay(String staticDay) {
		this.staticDay = staticDay;
	}

	public Integer getMonthMaxDays() {
		return monthMaxDays;
	}

	public void setMonthMaxDays(Integer monthMaxDays) {
		this.monthMaxDays = monthMaxDays;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public TbMagerDayCounts getTbMagerDayCounts() {
		return tbMagerDayCounts;
	}

	public void setTbMagerDayCounts(TbMagerDayCounts tbMagerDayCounts) {
		this.tbMagerDayCounts = tbMagerDayCounts;
	}

	public TbMangerMonthBigClassCounts getTbMangerMonthBigClassCounts() {
		return tbMangerMonthBigClassCounts;
	}

	public void setTbMangerMonthBigClassCounts(
			TbMangerMonthBigClassCounts tbMangerMonthBigClassCounts) {
		this.tbMangerMonthBigClassCounts = tbMangerMonthBigClassCounts;
	}

	public TbMonthLineChart getModelPay() {
		return modelPay;
	}

	public void setModelPay(TbMonthLineChart modelPay) {
		this.modelPay = modelPay;
	}

	public TbMonthLineChart getModelScore() {
		return modelScore;
	}

	public void setModelScore(TbMonthLineChart modelScore) {
		this.modelScore = modelScore;
	}


	


	public String getMsgpie() {
		return msgpie;
	}


	public void setMsgpie(String msgpie) {
		this.msgpie = msgpie;
	}


	public String getMsgscore() {
		return msgscore;
	}


	public void setMsgscore(String msgscore) {
		this.msgscore = msgscore;
	}


	public String getPageNum() {
		return pageNum;
	}


	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}


	public Integer getTotalCounts() {
		return totalCounts;
	}


	public void setTotalCounts(Integer totalCounts) {
		this.totalCounts = totalCounts;
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public FileInputStream getDownloadFile() {
		return downloadFile;
	}


	public void setDownloadFile(FileInputStream downloadFile) {
		this.downloadFile = downloadFile;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public List<TbMangerMonthBigClassCounts> getTbMangerMonthBigClassCountsList() {
		return tbMangerMonthBigClassCountsList;
	}


	public void setTbMangerMonthBigClassCountsList(
			List<TbMangerMonthBigClassCounts> tbMangerMonthBigClassCountsList) {
		this.tbMangerMonthBigClassCountsList = tbMangerMonthBigClassCountsList;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getRegionId() {
		return regionId;
	}


	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}


	public String getRegionName() {
		return regionName;
	}


	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
    


}

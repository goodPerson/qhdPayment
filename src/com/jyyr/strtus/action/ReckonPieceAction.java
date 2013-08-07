package com.jyyr.strtus.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyyr.orm.*;
import com.jyyr.service.*;
import com.jyyr.utitly.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * 渠道计件项目日明细信息查询Action
 * @author ywz
 *
 */

public class ReckonPieceAction extends ActionSupport implements ModelDriven<TbReckonPiecePayDealInfoD>{

	/** 通过依赖注入TbReckonPiecePayDealInfoDService组件实例 */
	TbReckonPiecePayDealInfoDService reckonPayService;
	/** 我的薪酬管理所有请求中常用的参数值 */
	private String workerID; //经分编号
	public TbReckonPiecePayDealInfoD  tbReckonInfo; //渠道经理明细信息
	private int monthDayCounts;//当月最大天数
	private StringBuffer  temptdsbTitle; //临时<td>组装
	private StringBuffer  temptdsbData; //临时数据组装
	private int pageSize; //每页显示数量
	private int pager; //当前页数	
	private TbMagerDayCounts tbMagerDayCounts;  //渠道经理日统计
	private TbMangerMonthBigClassCounts tbMangerMonthBigClassCounts; //渠道经理大类业务统计
	DateUtil du;  //日期工具类
	private String staticId;//经分工号
	private String roleName;
    private String userName;
	private String regionId;
    private String regionName;
	//	private List<TbReckonPiecePayDealInfoD> tdList;
	private List<TbReckonPiecePayDealInfoD> tempTd;
	

	//采用模型驱动
	private TbReckonPiecePayDealInfoD model=new TbReckonPiecePayDealInfoD();//用于封装会员属性模型
	public TbReckonPiecePayDealInfoD getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	/**
	 * 主方法
	 * @return
	 */
 	public String pieceDetailInfo(){
		return SUCCESS;
	}
 	
 	/**
 	 * 渠道经理大类业务奖金统计（比例）
 	 */
 	public String magerBigClassCounts(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
//**********************渠道经理大类业务奖金统计  开始  ********************************************	
		String curDay=DateUtil.getYearMonthDay();
		String beforeDay=DateUtil.getSpecifiedDayBefore(curDay);
		tbMangerMonthBigClassCounts=reckonPayService.magerBigClassPayCount(workerID);		
//**********************渠道经理大类业务奖金统计  结束  ********************************************	
 		return SUCCESS;
 	}
 	
 	/** 渠道经理日统计 首页第一个表格
	 * @throws IOException */
	public String chnlMagerDayCounts() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		
//**********************渠道经理日统计  开始  ********************************************		
		String curDay=DateUtil.getYearMonthDay();
		String beforeDay=DateUtil.getSpecifiedDayBefore(curDay);
		tbMagerDayCounts=reckonPayService.ChnlMagerDayCount(workerID);
		JSONObject jsonObjectMagerDayCounts = new JSONObject();
		jsonObjectMagerDayCounts.put("date", tbMagerDayCounts.getStatisDate()); //日期
		jsonObjectMagerDayCounts.put("county", tbMagerDayCounts.getCountry()); //县区
		jsonObjectMagerDayCounts.put("name", tbMagerDayCounts.getName());									//姓名
		jsonObjectMagerDayCounts.put("nameid", tbMagerDayCounts.getStaffId());		//工号
		jsonObjectMagerDayCounts.put("chnlcounts", tbMagerDayCounts.getPrncpChnlCnt()); //渠道经理渠道数量
		jsonObjectMagerDayCounts.put("dayscore", tbMagerDayCounts.getCurDaytotalScore());								//日积分
		jsonObjectMagerDayCounts.put("monthscore", tbMagerDayCounts.getCurMonTotalScore()); //当月总积分
		jsonObjectMagerDayCounts.put("monthpay", tbMagerDayCounts.getCurMonTotalPay()); //当月总薪酬
	
		JSONObject jsonObjectFinal = new JSONObject();
		jsonObjectFinal.put("rows", jsonObjectMagerDayCounts);
		PrintWriter printWriter = response.getWriter();
		printWriter.print("["+jsonObjectMagerDayCounts.toString()+"]");
		printWriter.flush();
		printWriter.close();		
//**********************渠道经理日统计  结束  ********************************************
		

		
		return SUCCESS;
}
	/** 渠道经理昨日员工数据 
	 * @throws IOException */
	public String browTd() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
	
		//渠道经理个人信息
		tbReckonInfo=reckonPayService.loadTbrppdinif(workerID);

        temptdsbTitle=new StringBuffer("");
        temptdsbData=new StringBuffer("");
//		当月最大天数
        monthDayCounts=du.getCurrentMonthLastDay();
        for (int i=1;i<=monthDayCounts;i++){
        	String j="1";
        	if(i<10){
        		j="0"+i;
        	}else{
        		j=""+i;
        	}
        	temptdsbTitle.append(j+",");
        	temptdsbData.append("");
        }   
        
//        int queryCounts=reckonPayService.queryCountsDetail(workerID, reckonPayService.getYearMonthDay(), pageSize, pager);
        int queryCounts=reckonPayService.queryCountsDetail(workerID, DateUtil.getSpecifiedDayBefore(DateUtil.getYearMonthDay()).substring(0, 6), pageSize, pager);
        tempTd=reckonPayService.browserBusDetail(workerID, DateUtil.getSpecifiedDayBefore(DateUtil.getYearMonthDay()).substring(0, 6), pageSize, pager);
        JSONArray jsonArray = new JSONArray();   //json数组
  		if (tempTd != null) {
  			for (TbReckonPiecePayDealInfoD tdDeal : tempTd) {
  				JSONObject jsonObject = new JSONObject();
  				jsonObject.put("month", tdDeal.getStatisDate());
  				jsonObject.put("county", tdDeal.getCountyName());
  				jsonObject.put("name", tdDeal.getName());
  				jsonObject.put("workerNo", tdDeal.getMonSumPay());
  				jsonObject.put("agency", tdDeal.getMonSumPay());
  				jsonObject.put("card", tdDeal.getMonSumPay());
  				jsonObject.put("term", tdDeal.getMonSumPay());
  				jsonObject.put("data", tdDeal.getMonSumPay());
  				jsonObject.put("active", tdDeal.getMonSumPay());
  				jsonObject.put("sumpay", tdDeal.getMonSumPay());
  				jsonObject.put("sumpay", tdDeal.getMonSumPay());
  				jsonArray.add(jsonObject);
  			}
  			JSONObject jsonObjectFinal = new JSONObject();
  			jsonObjectFinal.put("rows", jsonArray);
  			jsonObjectFinal.put("total", queryCounts);
  			PrintWriter printWriter = response.getWriter();
  			printWriter.print(jsonObjectFinal.toString());
  			printWriter.flush();
  			printWriter.close();
  		}
        return INPUT;
	}

	public TbReckonPiecePayDealInfoDService getReckonPayService() {
		return reckonPayService;
	}

	public void setReckonPayService(
			TbReckonPiecePayDealInfoDService reckonPayService) {
		this.reckonPayService = reckonPayService;
	}

	public String getWorkerID() {
		return workerID;
	}

	public void setWorkerID(String workerID) {
		this.workerID = workerID;
	}
	
	public TbReckonPiecePayDealInfoD getTbReckonInfo() {
		return tbReckonInfo;
	}

	public void setTbReckonInfo(TbReckonPiecePayDealInfoD tbReckonInfo) {
		this.tbReckonInfo = tbReckonInfo;
	}
	
	public StringBuffer getTemptdsbTitle() {
		return temptdsbTitle;
	}

	public void setTemptdsbTitle(StringBuffer temptdsbTitle) {
		this.temptdsbTitle = temptdsbTitle;
	}

	public StringBuffer getTemptdsbData() {
		return temptdsbData;
	}

	public void setTemptdsbData(StringBuffer temptdsbData) {
		this.temptdsbData = temptdsbData;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPager() {
		return pager;
	}

	public void setPager(int pager) {
		this.pager = pager;
	}

	public int getMonthDayCounts() {
		return monthDayCounts;
	}

	public void setMonthDayCounts(int monthDayCounts) {
		this.monthDayCounts = monthDayCounts;
	}
	
	public TbMagerDayCounts getTbMagerDayCounts() {
		return tbMagerDayCounts;
	}
	public void setTbMagerDayCounts(TbMagerDayCounts tbMagerDayCounts) {
		this.tbMagerDayCounts = tbMagerDayCounts;
	}
	
	public List<TbReckonPiecePayDealInfoD> getTempTd() {
		return tempTd;
	}
	public void setTempTd(List<TbReckonPiecePayDealInfoD> tempTd) {
		this.tempTd = tempTd;
	}
	
	public TbMangerMonthBigClassCounts getTbMangerMonthBigClassCounts() {
		return tbMangerMonthBigClassCounts;
	}

	public void setTbMangerMonthBigClassCounts(
			TbMangerMonthBigClassCounts tbMangerMonthBigClassCounts) {
		this.tbMangerMonthBigClassCounts = tbMangerMonthBigClassCounts;
	}

	public String getStaticId() {
		return staticId;
	}

	public void setStaticId(String staticId) {
		this.staticId = staticId;
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

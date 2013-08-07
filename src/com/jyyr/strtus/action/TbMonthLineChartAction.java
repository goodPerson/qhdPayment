package com.jyyr.strtus.action;

import com.jyyr.orm.TbMonthLineChart;
import com.jyyr.service.TbMonthLineChartService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TbMonthLineChartAction extends ActionSupport implements ModelDriven<TbMonthLineChart> {
	TbMonthLineChartService service;
	

	TbMonthLineChart modelPay=new TbMonthLineChart();
	TbMonthLineChart modelScore=new TbMonthLineChart();

	TbMonthLineChart model=new TbMonthLineChart();
	
	private String workerID; //经分工号
	private String sType;//类型  积分
	private String sTypePay;//类型 薪酬
	private String staticId;//经分工号
	private String roleName;
    private String userName;
	private String regionId;
    private String regionName;
	public String loadTbMonthLineChart(){
		modelScore=service.loadtbMonthLineChart(workerID,"score");
		modelPay=service.loadtbMonthLineChart(workerID,"pay");
		return SUCCESS;
	}
	
	public TbMonthLineChart getModelScore() {
		return modelScore;
	}

	public void setModelScore(TbMonthLineChart modelScore) {
		this.modelScore = modelScore;
	}




	public TbMonthLineChartService getService() {
		return service;
	}

	public void setService(TbMonthLineChartService service) {
		this.service = service;
	}

	public String getWorkerID() {
		return workerID;
	}

	public void setWorkerID(String workerID) {
		this.workerID = workerID;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public TbMonthLineChart getModelPay() {
		return modelPay;
	}

	public void setModelPay(TbMonthLineChart modelPay) {
		this.modelPay = modelPay;
	}


	public String getsTypePay() {
		return sTypePay;
	}


	public void setsTypePay(String sTypePay) {
		this.sTypePay = sTypePay;
	}


	public String getsType() {
		return sType;
	}

	public TbMonthLineChart getModel() {
		// TODO Auto-generated method stub
		return model;
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

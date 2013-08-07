package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TbMangerMontTotalCounts {
//	TB_CHNL_MAGR_STATIS_INFO_M
//	渠道经理月总量统计
	private String staffId;//   经分工号           varchar(32)  ,
	private String statisMonth;//   统计月份        varchar(10)  ,
	private String county;//      区县          varchar(100)  ,
	private String area;//     区域             varchar(100)  ,
	private float monTotalScore;// 月累计总积分      decimal(18,4)  ,
	private float monTotalPay;//  月总薪酬       decimal(18,4)  
	
	public TbMangerMontTotalCounts(){}

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STAFF_ID",length=32)
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	@Column(name = "STATIS_MONTH",length=10)
	public String getStatisMonth() {
		return statisMonth;
	}

	public void setStatisMonth(String statisMonth) {
		this.statisMonth = statisMonth;
	}

	@Column(name = "COUNTY",length=100)
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name = "AREA",length=100)
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "MON_TOTAL_SCORE",length=18)
	public float getMonTotalScore() {
		return monTotalScore;
	}

	public void setMonTotalScore(float monTotalScore) {
		this.monTotalScore = monTotalScore;
	}

	@Column(name = "MON_TOTAL_PAY",length=18)
	public float getMonTotalPay() {
		return monTotalPay;
	}

	public void setMonTotalPay(float monTotalPay) {
		this.monTotalPay = monTotalPay;
	};
	

}

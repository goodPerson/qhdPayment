package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="TB_COUNTY_SERV_CNT_INFO_D",schema="qinhuangdao")
public class TbCountyServCntInfoD {
	//       区县业务发展量统计表
	//tableName TB_COUNTY_SERV_CNT_INFO_D

	private String statisDate;//    统计日期      varchar(10)  ,
	private String county;//    区县      varchar(100)  ,
	private Float countyServTotalPay;//   计件大类业务当月总薪酬      decimal(18,2)  ,
	private Float countyServTotalCnt;// 计件大类业务当月总发展量 decimal(18,2)  

	public TbCountyServCntInfoD(){}

	@Column(name = "STATIS_DATE",length=10)
	public String getStatisDate() {
		return statisDate;
	}

	public void setStatisDate(String statisDate) {
		this.statisDate = statisDate;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "COUNTY",length=100)
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name = "COUNTY_SERV_TOTAL_PAY",length=18)
	public Float getCountyServTotalPay() {
		return countyServTotalPay;
	}

	public void setCountyServTotalPay(Float countyServTotalPay) {
		this.countyServTotalPay = countyServTotalPay;
	}

	@Column(name = "COUNTY_SERV_TOTAL_CNT",length=18)
	public Float getCountyServTotalCnt() {
		return countyServTotalCnt;
	}

	public void setCountyServTotalCnt(Float countyServTotalCnt) {
		this.countyServTotalCnt = countyServTotalCnt;
	}






}

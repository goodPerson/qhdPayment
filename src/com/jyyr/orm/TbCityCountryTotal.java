package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TbCityCountryTotal {
//	'区县业务发展量统计表
//	.TB_COUNTY_SERV_CNT_INFO_D
	private String statisDate;//   统计日期        varchar(10)  ,
	private String county;//    区县            varchar(100)  ,
	private Float countyServTotalPay;// 区县业务总薪酬  decimal(18,2)  ,
	private Float countyServTotalCnt;// 区县业务总发展量  decimal(18,2)  
	
	public TbCityCountryTotal(){}

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_MONTH",length=10)
	public String getStatisDate() {
		return statisDate;
	}

	public void setStatisDate(String statisDate) {
		this.statisDate = statisDate;
	}
	@Column(name = "COUNTY",length=10)
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	@Column(name = "COUNTY_SERV_TOTAL_PAY",length=10)
	public Float getCountyServTotalPay() {
		return countyServTotalPay;
	}

	public void setCountyServTotalPay(Float countyServTotalPay) {
		this.countyServTotalPay = countyServTotalPay;
	}
	@Column(name = "COUNTY_SERV_TOTAL_CNT",length=10)
	public Float getCountyServTotalCnt() {
		return countyServTotalCnt;
	}
	public void setCountyServTotalCnt(Float countyServTotalCnt) {
		this.countyServTotalCnt = countyServTotalCnt;
	};	

}

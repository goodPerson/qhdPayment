package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TbCityDayCnt {
//	市日发展量统计表
//	tableName TB_CITY_DAY_DEV_CNT_D
	private String statisDate;//  统计日期         varchar(10)  ,
	private Float cityDayServCnt;//  市统计日业务发展量   decimal(18,2)  ,
	private Float cityDayServScore;// 市统计日业务发展积分   decimal(18,2)  ,
	private Float cityDayServPay;//  市统计日业务发展薪酬   decimal(18,2)  
	
	public TbCityDayCnt(){};
	
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_MONTH",length=10)
	public String getStatisDate() {
		return statisDate;
	}

	public void setStatisDate(String statisDate) {
		this.statisDate = statisDate;
	}

	@Column(name = "CITY_DAY_SERV_CNT",length=18)
	public Float getCityDayServCnt() {
		return cityDayServCnt;
	}

	public void setCityDayServCnt(Float cityDayServCnt) {
		this.cityDayServCnt = cityDayServCnt;
	}

	@Column(name = "CITY_DAY_SERV_SCORE",length=18)
	public Float getCityDayServScore() {
		return cityDayServScore;
	}

	public void setCityDayServScore(Float cityDayServScore) {
		this.cityDayServScore = cityDayServScore;
	}

	@Column(name = "CITY_DAY_SERV_PAY",length=18)
	public Float getCityDayServPay() {
		return cityDayServPay;
	}

	public void setCityDayServPay(Float cityDayServPay) {
		this.cityDayServPay = cityDayServPay;
	}

}

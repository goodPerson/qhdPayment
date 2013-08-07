package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class TbCountryTotalMonth {
//	TB_COUNTY_MONEY_STATIS_INFO_M
//	本县当月奖金统计表
	private String statisMonth;//  统计月份        varchar(10)  ,
	private String county;//   区县             varchar(100)  ,
	private Integer cardNumServDevTotalCnt;// 卡号业务发展总量  integer  ,
	private Float cardNumServDevTotalScore;// 卡号业务发展总积分  decimal(18,4)  ,
	private Float cardNumServDevTotalPay;// 号业务发展总薪酬 decimal(18,4)  ,
	private Integer dataServDevTotalCnt;// 数据业务发展总量 Integer  ,
	private Float dataServDevTotalScore;// 数据业务发展总积分 decimal(18,4)  ,
	private Float dataServDevTotalPay;//  数据业务发展总薪酬 decimal(18,4)  ,
	private Integer actServDevTotalCn;//t 活动业务发展总量  integer  ,
	private Float actServDevTotalScore;//  活动业务发展总积分 decimal(8,4)  ,
	private Float actServDevTotalPay;// 活动业务发展总薪酬 decimal(18,4)  ,
	private Integer tmnlServDevTotalCnt;// 终端业务发展总量 integer  ,
	private Float tmnlServDevTotalScore;// 终端业务发展总积分   decimal(18,4)  ,
	private Float tmnlServDevTotalPay;// 终端业务发展总薪酬 decimal(18,4)  ,
	private Integer agencyServDevTotalCnt;// 代办业务发展总量  integer  ,
	private Float agencyServDevTotalScore;// 办业务发展总积分  decimal(18,4)  ,
	private Float agencyServDevTotalPay;// 业务发展总薪酬 decimal(18,4)  
	
	public TbCountryTotalMonth(){}

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_MONTH",length=10)
	public String getStatisMonth() {
		return statisMonth;
	}

	public void setStatisMonth(String statisMonth) {
		this.statisMonth = statisMonth;
	}

	@Column(name = "COUNTY ",length=10)
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	@Column(name = "CARD_NUM_SERV_DEVTOTAL_CNT",length=10)
	public Integer getCardNumServDevTotalCnt() {
		return cardNumServDevTotalCnt;
	}

	public void setCardNumServDevTotalCnt(Integer cardNumServDevTotalCnt) {
		this.cardNumServDevTotalCnt = cardNumServDevTotalCnt;
	}
	@Column(name = "CARD_NUM_SERV_DEV_TOTAL_SCORE",length=10)
	public Float getCardNumServDevTotalScore() {
		return cardNumServDevTotalScore;
	}

	public void setCardNumServDevTotalScore(Float cardNumServDevTotalScore) {
		this.cardNumServDevTotalScore = cardNumServDevTotalScore;
	}
	@Column(name = "CARD_NUM_SERV_DEV_TOTAL_PAY",length=10)
	public Float getCardNumServDevTotalPay() {
		return cardNumServDevTotalPay;
	}

	public void setCardNumServDevTotalPay(Float cardNumServDevTotalPay) {
		this.cardNumServDevTotalPay = cardNumServDevTotalPay;
	}
	@Column(name = "DATA_SERV_DEV_TOTAL_CNT",length=10)
	public Integer getDataServDevTotalCnt() {
		return dataServDevTotalCnt;
	}

	public void setDataServDevTotalCnt(Integer dataServDevTotalCnt) {
		this.dataServDevTotalCnt = dataServDevTotalCnt;
	}
	@Column(name = "DATA_SERV_DEV_TOTAL_SCORE",length=10)
	public Float getDataServDevTotalScore() {
		return dataServDevTotalScore;
	}

	public void setDataServDevTotalScore(Float dataServDevTotalScore) {
		this.dataServDevTotalScore = dataServDevTotalScore;
	}
	@Column(name = "DATA_SERV_DEV_TOTAL_PAY",length=10)
	public Float getDataServDevTotalPay() {
		return dataServDevTotalPay;
	}

	public void setDataServDevTotalPay(Float dataServDevTotalPay) {
		this.dataServDevTotalPay = dataServDevTotalPay;
	}
	@Column(name = "ACT_SERV_DEV_TOTAL_CNT",length=10)
	public Integer getActServDevTotalCn() {
		return actServDevTotalCn;
	}

	public void setActServDevTotalCn(Integer actServDevTotalCn) {
		this.actServDevTotalCn = actServDevTotalCn;
	}
	@Column(name = "ACT_SERV_DEV_TOTAL_SCORE",length=10)
	public Float getActServDevTotalScore() {
		return actServDevTotalScore;
	}

	public void setActServDevTotalScore(Float actServDevTotalScore) {
		this.actServDevTotalScore = actServDevTotalScore;
	}
	@Column(name = "ACT_SERV_DEV_TOTAL_PAY",length=10)
	public Float getActServDevTotalPay() {
		return actServDevTotalPay;
	}

	public void setActServDevTotalPay(Float actServDevTotalPay) {
		this.actServDevTotalPay = actServDevTotalPay;
	}
	@Column(name = "TMNL_SERV_DEV_TOTAL_CNT ",length=10)
	public Integer getTmnlServDevTotalCnt() {
		return tmnlServDevTotalCnt;
	}

	public void setTmnlServDevTotalCnt(Integer tmnlServDevTotalCnt) {
		this.tmnlServDevTotalCnt = tmnlServDevTotalCnt;
	}
	@Column(name = "TMNL_SERV_DEV_TOTAL_SCORE",length=10)
	public Float getTmnlServDevTotalScore() {
		return tmnlServDevTotalScore;
	}

	public void setTmnlServDevTotalScore(Float tmnlServDevTotalScore) {
		this.tmnlServDevTotalScore = tmnlServDevTotalScore;
	}
	@Column(name = "TMNL_SERV_DEV_TOTAL_PAY",length=10)
	public Float getTmnlServDevTotalPay() {
		return tmnlServDevTotalPay;
	}

	public void setTmnlServDevTotalPay(Float tmnlServDevTotalPay) {
		this.tmnlServDevTotalPay = tmnlServDevTotalPay;
	}
	@Column(name = "AGENCY_SERV_DEV_TOTAL_CNT",length=10)
	public Integer getAgencyServDevTotalCnt() {
		return agencyServDevTotalCnt;
	}

	public void setAgencyServDevTotalCnt(Integer agencyServDevTotalCnt) {
		this.agencyServDevTotalCnt = agencyServDevTotalCnt;
	}
	@Column(name = "AGENCY_SERV_DEV_TOTAL_SCORE",length=10)
	public Float getAgencyServDevTotalScore() {
		return agencyServDevTotalScore;
	}

	public void setAgencyServDevTotalScore(Float agencyServDevTotalScore) {
		this.agencyServDevTotalScore = agencyServDevTotalScore;
	}
	@Column(name = "AGENCY_SERV_DEV_TOTAL_PAY",length=10)
	public Float getAgencyServDevTotalPay() {
		return agencyServDevTotalPay;
	}

	public void setAgencyServDevTotalPay(Float agencyServDevTotalPay) {
		this.agencyServDevTotalPay = agencyServDevTotalPay;
	};
	
	

	
}

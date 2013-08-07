package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table (name="TB_CHNL_MAGR_TOP_ORDER_10_D",schema="qinhuangdao")
public class TbCountryTopDay {
//	县区渠道经理排名前十名
//	TB_CHNL_MAGR_TOP_ORDER_10_D
	private String statisDate;//  统计日期          varchar(10)  ,
	private String county;//    区县             varchar(100)  ,
	private Integer countyOrder;//  区县排名        integer  ,
	private String chnlMagrName;//  渠道经理名称      varchar(40)  ,
	private Integer cityOrder;//   市排名         integer  ,
	private Integer chnlMagrCurMonTotalScore;// 渠道经理当月总积分  decimal(18,4)  ,
	private Float chnlMagrCurMonTotalPay;// 渠道经理当月总薪酬  decimal(18,4)  
	
	
	public TbCountryTopDay(){}


	
	@Column(name = "STATIS_Date",length=10)
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
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "COUNTY_ORDER",length=10)
	public Integer getCountyOrder() {
		return countyOrder;
	}


	public void setCountyOrder(Integer countyOrder) {
		this.countyOrder = countyOrder;
	}
	
	@Column(name = "CHNL_MAGR_NAME",length=10)
	public String getChnlMagrName() {
		return chnlMagrName;
	}


	public void setChnlMagrName(String chnlMagrName) {
		this.chnlMagrName = chnlMagrName;
	}

	@Column(name = "CITY_ORDER",length=10)
	public Integer getCityOrder() {
		return cityOrder;
	}


	public void setCityOrder(Integer cityOrder) {
		this.cityOrder = cityOrder;
	}

	@Column(name = "CHNL_MAGR_CUR_MON_TOTAL_SCORE",length=10)
	public Integer getChnlMagrCurMonTotalScore() {
		return chnlMagrCurMonTotalScore;
	}


	public void setChnlMagrCurMonTotalScore(Integer chnlMagrCurMonTotalScore) {
		this.chnlMagrCurMonTotalScore = chnlMagrCurMonTotalScore;
	}

	@Column(name = "CHNL_MAGR_CUR_MON_TOTAL_PAY",length=10)
	public Float getChnlMagrCurMonTotalPay() {
		return chnlMagrCurMonTotalPay;
	}


	public void setChnlMagrCurMonTotalPay(Float chnlMagrCurMonTotalPay) {
		this.chnlMagrCurMonTotalPay = chnlMagrCurMonTotalPay;
	};
}

package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name="TB_COUNTY_SCORE_STATIS_M",schema="qinhuangdao")
public class TbCountryCountsMonth {
//	.TB_COUNTY_SCORE_STATIS_M
//	区县负责人月统计
	private String statisMonth;//   日期      varchar(10)  ,
	private String county;//       区县    varchar(100)  ,
	private Integer curCountyChnlMagrCnt;// 本区县渠道经理数量  decimal(18,4)  ,
	private Integer curCountyChnlMnt;// 本区县渠道数量  decimal(18,4)  ,
	private Integer cardNumServScoreTotalCnt;// 卡号业务当月积分总量 decimal(18,4)  ,
	private Integer dataServScoreTotalCnt;// 数据业务当月积分总量 decimal(18,4)  ,
	private Integer actServScoreTotalCnt;// 活动业务当月积分总量 decimal(18,4)  ,
	private Integer tmnlServScoreTotalCnt;// 终端业务当月积分总量 decimal(18,4)  ,
	private Integer agencyServScoreTotalCnt;// 代办业务当月积分总量  decimal(18,4)  
	
	public TbCountryCountsMonth(){}
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_MONTH",length=10)
	public String getStatisMonth() {
		return statisMonth;
	}

	public void setStatisMonth(String statisMonth) {
		this.statisMonth = statisMonth;
	}

	@Column(name = "COUNTY",length=10)
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name = "CUR_COUNTY_CHNL_MAGR_CNT",length=10)
	public Integer getCurCountyChnlMagrCnt() {
		return curCountyChnlMagrCnt;
	}

	public void setCurCountyChnlMagrCnt(Integer curCountyChnlMagrCnt) {
		this.curCountyChnlMagrCnt = curCountyChnlMagrCnt;
	}

	@Column(name = "CUR_COUNTY_CHNL_CNT",length=10)
	public Integer getCurCountyChnlMnt() {
		return curCountyChnlMnt;
	}

	public void setCurCountyChnlMnt(Integer curCountyChnlMnt) {
		this.curCountyChnlMnt = curCountyChnlMnt;
	}

	@Column(name = "CARD_NUM_SERV_SCORE_TOTAL_CNT",length=10)
	public Integer getCardNumServScoreTotalCnt() {
		return cardNumServScoreTotalCnt;
	}

	public void setCardNumServScoreTotalCnt(Integer cardNumServScoreTotalCnt) {
		this.cardNumServScoreTotalCnt = cardNumServScoreTotalCnt;
	}

	@Column(name = "DATA_SERV_SCORE_TOTAL_CNT",length=10)
	public Integer getDataServScoreTotalCnt() {
		return dataServScoreTotalCnt;
	}

	public void setDataServScoreTotalCnt(Integer dataServScoreTotalCnt) {
		this.dataServScoreTotalCnt = dataServScoreTotalCnt;
	}

	@Column(name = "ACT_SERV_SCORE_TOTAL_CNT",length=10)
	public Integer getActServScoreTotalCnt() {
		return actServScoreTotalCnt;
	}

	public void setActServScoreTotalCnt(Integer actServScoreTotalCnt) {
		this.actServScoreTotalCnt = actServScoreTotalCnt;
	}

	@Column(name = "TMNL_SERV_SCORE_TOTAL_CNT",length=10)
	public Integer getTmnlServScoreTotalCnt() {
		return tmnlServScoreTotalCnt;
	}

	public void setTmnlServScoreTotalCnt(Integer tmnlServScoreTotalCnt) {
		this.tmnlServScoreTotalCnt = tmnlServScoreTotalCnt;
	}

	@Column(name = "AGENCY_SERV_SCORE_TOTAL_CNT",length=10)
	public Integer getAgencyServScoreTotalCnt() {
		return agencyServScoreTotalCnt;
	}

	public void setAgencyServScoreTotalCnt(Integer agencyServScoreTotalCnt) {
		this.agencyServScoreTotalCnt = agencyServScoreTotalCnt;
	};
	
}

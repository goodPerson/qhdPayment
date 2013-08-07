package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TbCityScoreTopMonth {
//	渠道经理前10名
//	tableName TB_CHNL_MAGR_SCORE_TOP_10_M
	
	private String statisMonth;//          varchar(10)  ,
	private Integer chnlMagrOrder;//       integer  ,
	private String chnlMagrName;//        varchar(40)  ,
	private Float chnlMagrMonTotalScore;//  decimal(18,2)  ,
	private Float chnlMagrMonTotalSay;//  decimal(18,2)  

	public TbCityScoreTopMonth(){}

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_MONTH",length=10)
	public String getStatisMonth() {
		return statisMonth;
	}

	public void setStatisMonth(String statisMonth) {
		this.statisMonth = statisMonth;
	}
	@Column(name = "CHNL_MAGR_ORDER",length=10)
	public Integer getChnlMagrOrder() {
		return chnlMagrOrder;
	}

	public void setChnlMagrOrder(Integer chnlMagrOrder) {
		this.chnlMagrOrder = chnlMagrOrder;
	}
	@Column(name = "CHNL_MAGR_NAME",length=40)
	public String getChnlMagrName() {
		return chnlMagrName;
	}

	public void setChnlMagrName(String chnlMagrName) {
		this.chnlMagrName = chnlMagrName;
	}
	@Column(name = "CHNL_MAGR_MON_TOTAL_SCORE",length=18)
	public Float getChnlMagrMonTotalScore() {
		return chnlMagrMonTotalScore;
	}

	public void setChnlMagrMonTotalScore(Float chnlMagrMonTotalScore) {
		this.chnlMagrMonTotalScore = chnlMagrMonTotalScore;
	}
	@Column(name = "CHNL_MAGR_MON_TOTAL_PAY",length=18)
	public Float getChnlMagrMonTotalSay() {
		return chnlMagrMonTotalSay;
	}

	public void setChnlMagrMonTotalSay(Float chnlMagrMonTotalSay) {
		this.chnlMagrMonTotalSay = chnlMagrMonTotalSay;
	};
	
	
}

package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TbCityScoreDescMonth {
//	���������10��
//	tableName TB_CHNL_MAGR_SCORE_DESC_10_M
	
	private String statisMonth;//    ͳ���·�      varchar(10)  ,
	private Integer descOrder;//     ��������       integer  ,
	private String chnlMagrName;//   ������������     varchar(40)  ,
	private Float chnlMagrMonTotalScore;// �����������ܻ��� decimal(18,4)  
	
	public TbCityScoreDescMonth(){}

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_MONTH",length=10)
	public String getStatisMonth() {
		return statisMonth;
	}

	public void setStatisMonth(String statisMonth) {
		this.statisMonth = statisMonth;
	}
	@Column(name = "DESC_ORDER",length=10)
	public Integer getDescOrder() {
		return descOrder;
	}

	public void setDescOrder(Integer descOrder) {
		this.descOrder = descOrder;
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
	};
	
	

}

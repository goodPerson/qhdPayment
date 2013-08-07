package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="TB_COUNTY_DEV_CNT_STATIS_INFO_D",schema="QINHUANGDAO")
public class TbCountyDevCntStatisInfoD {
	//@Id 
//	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_DATE",length=10)
	private String	STATIS_DATE  ;//         VARCHAR(10)  ,统计日期
	@Id 
	@Column(name = "COUNTY",length=100)
	private String	COUNTY;//                VARCHAR(100)  ,区县
	@Column(name = "CHNL_MAGR_TOTAL_CNT",length=8)
	private Float	CHNL_MAGR_TOTAL_CNT;//   DECIMAL(8,4)  ,渠道经理总量
	@Column(name = "CHNL_TOTAL_CNT",length=8)
	private Float	CHNL_TOTAL_CNT ;//       DECIMAL(8,4)  ,渠道总量
	@Column(name = "DAY_TOTAL_SCORE_CNT",length=8)
	private Float	DAY_TOTAL_SCORE_CNT;//   DECIMAL(8,4)  ,日总积分量
	@Column(name = "CUR_MON_TOTAL_SCORE_CNT",length=8)
	private Float	CUR_MON_TOTAL_SCORE_CNT;//  DECIMAL(8,4)  ,当前月总积分量
	@Column(name = "CUR_MON_TOTAL_PAY",length=8)
	private Float	CUR_MON_TOTAL_PAY  ;//   DECIMAL(8,4)  当前月总薪酬


	public String getSTATIS_DATE() {
		return STATIS_DATE;
	}
	public void setSTATIS_DATE(String sTATIS_DATE) {
		STATIS_DATE = sTATIS_DATE;
	}
	public String getCOUNTY() {
		return COUNTY;
	}
	public void setCOUNTY(String cOUNTY) {
		COUNTY = cOUNTY;
	}
	public Float getCHNL_MAGR_TOTAL_CNT() {
		return CHNL_MAGR_TOTAL_CNT;
	}
	public void setCHNL_MAGR_TOTAL_CNT(Float cHNL_MAGR_TOTAL_CNT) {
		CHNL_MAGR_TOTAL_CNT = cHNL_MAGR_TOTAL_CNT;
	}
	public Float getCHNL_TOTAL_CNT() {
		return CHNL_TOTAL_CNT;
	}
	public void setCHNL_TOTAL_CNT(Float cHNL_TOTAL_CNT) {
		CHNL_TOTAL_CNT = cHNL_TOTAL_CNT;
	}
	public Float getDAY_TOTAL_SCORE_CNT() {
		return DAY_TOTAL_SCORE_CNT;
	}
	public void setDAY_TOTAL_SCORE_CNT(Float dAY_TOTAL_SCORE_CNT) {
		DAY_TOTAL_SCORE_CNT = dAY_TOTAL_SCORE_CNT;
	}
	public Float getCUR_MON_TOTAL_SCORE_CNT() {
		return CUR_MON_TOTAL_SCORE_CNT;
	}
	public void setCUR_MON_TOTAL_SCORE_CNT(Float cUR_MON_TOTAL_SCORE_CNT) {
		CUR_MON_TOTAL_SCORE_CNT = cUR_MON_TOTAL_SCORE_CNT;
	}
	public Float getCUR_MON_TOTAL_PAY() {
		return CUR_MON_TOTAL_PAY;
	}
	public void setCUR_MON_TOTAL_PAY(Float cUR_MON_TOTAL_PAY) {
		CUR_MON_TOTAL_PAY = cUR_MON_TOTAL_PAY;
	}

}

package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ���ظ�����ÿ��ͳ��
 * */
@SuppressWarnings("serial")
@Entity
@Table (name="TB_COUNTY_DEV_CNT_STATIS_INFO_D",schema="qinhuangdao")
public class TbCountryCntDay {
//	���ظ�������ͳ�Ʊ�
//	TB_COUNTY_DEV_CNT_STATIS_INFO_D
	private String statisDate;//    ͳ������       varchar(10)  ,
	private String county;//   ����             varchar(100)  ,
	private Integer chnlMagrTotalCnt;// ������������  decimal(8,4)  ,
	private Integer chnlTotalCnt;//  ������������      decimal(8,4)  ,
	private Integer dayTotalScoreCnt;// ���ܻ�����   decimal(8,4)  ,
	private Integer curMonTotalScoreCnt;// ��ǰ���ܻ�����  decimal(8,4)  ,
	private Float curMonTotalPay;//  ��ǰ����н��   decimal(8,4)  

	public TbCountryCntDay(){}

	@Column(name = "STATIS_DATE",length=10)
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

	@Column(name = "CHNL_MAGR_TOTAL_CNT",length=8)
	public Integer getChnlMagrTotalCnt() {
		return chnlMagrTotalCnt;
	}

	public void setChnlMagrTotalCnt(Integer chnlMagrTotalCnt) {
		this.chnlMagrTotalCnt = chnlMagrTotalCnt;
	}

	@Column(name = "CHNL_TOTAL_CNT",length=8)
	public Integer getChnlTotalCnt() {
		return chnlTotalCnt;
	}

	public void setChnlTotalCnt(Integer chnlTotalCnt) {
		this.chnlTotalCnt = chnlTotalCnt;
	}

	@Column(name = "DAY_TOTAL_SCORE_CNT",length=8)
	public Integer getDayTotalScoreCnt() {
		return dayTotalScoreCnt;
	}

	
	public void setDayTotalScoreCnt(Integer dayTotalScoreCnt) {
		this.dayTotalScoreCnt = dayTotalScoreCnt;
	}
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "CUR_MON_TOTAL_SCORE_CNT",length=8)
	public Integer getCurMonTotalScoreCnt() {
		return curMonTotalScoreCnt;
	}

	public void setCurMonTotalScoreCnt(Integer curMonTotalScoreCnt) {
		this.curMonTotalScoreCnt = curMonTotalScoreCnt;
	}

	@Column(name = "CUR_MON_TOTAL_PAY",length=8)
	public Float getCurMonTotalPay() {
		return curMonTotalPay;
	}

	public void setCurMonTotalPay(Float curMonTotalPay) {
		this.curMonTotalPay = curMonTotalPay;
	};
	
	
}

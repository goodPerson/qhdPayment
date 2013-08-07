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
//	���ظ�������ͳ��
	private String statisMonth;//   ����      varchar(10)  ,
	private String county;//       ����    varchar(100)  ,
	private Integer curCountyChnlMagrCnt;// ������������������  decimal(18,4)  ,
	private Integer curCountyChnlMnt;// ��������������  decimal(18,4)  ,
	private Integer cardNumServScoreTotalCnt;// ����ҵ���»������� decimal(18,4)  ,
	private Integer dataServScoreTotalCnt;// ����ҵ���»������� decimal(18,4)  ,
	private Integer actServScoreTotalCnt;// �ҵ���»������� decimal(18,4)  ,
	private Integer tmnlServScoreTotalCnt;// �ն�ҵ���»������� decimal(18,4)  ,
	private Integer agencyServScoreTotalCnt;// ����ҵ���»�������  decimal(18,4)  
	
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

package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TbCityClassScoreCnt {
//	�и���ҵ��չ������ͳ��
//	tableName TB_CITY_MON_DEV_SCORE_INFO_M
	private String statisMonth;//       ͳ���·�   varchar(10)  ,
	private Integer chnlMagrTotalCnt;// ������������  integer;//  ,
	private Integer agtChnlTotalCnt;//    '������������     integer;//  ,
	private Float cardNumServMonTotalScore;// ����ҵ��չ���ܻ���  decimal(18,2)  ,
	private Float tmnlServM_monTotalScore;// �ն�ҵ��չ���ܻ���  decimal(18,2)  ,
	private Float dataServMonTotalScore;// ����ҵ��չ���ܻ��� decimal(18,2)  ,
	private Float actServMonScore;//  ��ҵ��չ�»���  decimal(18,2)  ,
	private Float agencServMonTotalScore;// ����ҵ��չ���ܻ���  decimal(18,2)  ,
	private Float totalPiecePay;//  �ܼƼ�н��     decimal(18,2)  ,
	private Float totalMoney;//   �ܽ���        decimal(18,2)  
	
	public TbCityClassScoreCnt(){}

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_MONTH",length=10)
	public String getStatisMonth() {
		return statisMonth;
	}

	public void setStatisMonth(String statisMonth) {
		this.statisMonth = statisMonth;
	}
	@Column(name = "CHNL_MAGR_TOTAL_CNT",length=10)
	public Integer getChnlMagrTotalCnt() {
		return chnlMagrTotalCnt;
	}

	public void setChnlMagrTotalCnt(Integer chnlMagrTotalCnt) {
		this.chnlMagrTotalCnt = chnlMagrTotalCnt;
	}
	@Column(name = "AGT_CHNL_TOTAL_CNT",length=10)
	public Integer getAgtChnlTotalCnt() {
		return agtChnlTotalCnt;
	}

	public void setAgtChnlTotalCnt(Integer agtChnlTotalCnt) {
		this.agtChnlTotalCnt = agtChnlTotalCnt;
	}

	@Column(name = "CARD_NUM_SERV_MON_TOTAL_SCORE",length=10)
	public Float getCardNumServMonTotalScore() {
		return cardNumServMonTotalScore;
	}

	public void setCardNumServMonTotalScore(Float cardNumServMonTotalScore) {
		this.cardNumServMonTotalScore = cardNumServMonTotalScore;
	}

	@Column(name = "TMNL_SERV_MON_TOTAL_SCORE",length=10)
	public Float getTmnlServM_monTotalScore() {
		return tmnlServM_monTotalScore;
	}

	public void setTmnlServM_monTotalScore(Float tmnlServM_monTotalScore) {
		this.tmnlServM_monTotalScore = tmnlServM_monTotalScore;
	}

	@Column(name = "DATA_SERV_MON_TOTAL_SCORE",length=10)
	public Float getDataServMonTotalScore() {
		return dataServMonTotalScore;
	}

	public void setDataServMonTotalScore(Float dataServMonTotalScore) {
		this.dataServMonTotalScore = dataServMonTotalScore;
	}

	@Column(name = "ACT_SERV_MON_SCORE",length=10)
	public Float getActServMonScore() {
		return actServMonScore;
	}

	public void setActServMonScore(Float actServMonScore) {
		this.actServMonScore = actServMonScore;
	}

	@Column(name = "AGENC_SERV_MON_TOTAL_SCORE",length=10)
	public Float getAgencServMonTotalScore() {
		return agencServMonTotalScore;
	}

	public void setAgencServMonTotalScore(Float agencServMonTotalScore) {
		this.agencServMonTotalScore = agencServMonTotalScore;
	}

	@Column(name = "TOTAL_PIECE_PAY",length=10)
	public Float getTotalPiecePay() {
		return totalPiecePay;
	}

	public void setTotalPiecePay(Float totalPiecePay) {
		this.totalPiecePay = totalPiecePay;
	}

	@Column(name = "TOTAL_MONEY",length=10)
	public Float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Float totalMoney) {
		this.totalMoney = totalMoney;
	};
	
}

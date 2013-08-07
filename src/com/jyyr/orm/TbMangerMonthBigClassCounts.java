package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="TB_PIECE_M_CLAS_STATIS_INFO_M",schema="qinhuangdao")
public class TbMangerMonthBigClassCounts {
//	TB_PIECE_M_CLAS_STATIS_INFO_M
//	���¼Ƽ�����н��ͳ�Ʊ�
	
	private String staffId;//     ���ֹ���         varchar(32)  ,
	private String name;//����
	private String statisMonth;//          varchar(10)  ,
	private String county;//                varchar(100)  ,
	private String area;//                  varchar(100)  ,
	private Float chnlCounts;  //����������������
	private Float cardNumServTotalScore;//  decimal(18,4)  ,
	private Float cardNumServTotalPay;//  decimal(18,4)  ,
	private Float marktActServTotalScore;//  decimal(18,4)  ,
	private Float marktActServTotalPay;//  decimal(18,4)  ,
	private Float tmnlServTotalScore;//  decimal(18,4)  ,
	private Float tmnlServTotalPay;//   decimal(18,4)  ,
	private Float dataServTotalScore;//  decimal(18,4)  ,
	private Float dataServTotalPay;//   decimal(18,4)  ,
	private Float agencyServTotalScore;//  decimal(18,4)  ,
	private Float agencyServTotalPay;//   decimal(18,4)  
	private Float sunPay; //��н��
//	private TbBasicInfoM tbBasicInfoM; //�������������Ϣ
	private Float moneyPay; //�ܽ���


	/**default construct*/
	public TbMangerMonthBigClassCounts(){}


	@Column(name = "STAFF_ID",length=32)
	public String getStaffId() {
		return staffId;
	}

    @Column(name = "Name",length=32)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_DATE",length=10)
	public String getStatisMonth() {
		return statisMonth;
	}


	public void setStatisMonth(String statisMonth) {
		this.statisMonth = statisMonth;
	}

    
	@Column(name = "COUNTY",length=100)
	public String getCounty() {
		return county;
	}


	public void setCounty(String county) {
		this.county = county;
	}
	@Column(name = "Chnl_num",length=18)
	public Float getChnlCounts() {
		return chnlCounts;
	}

	public void setChnlCounts(Float chnlCounts) {
		this.chnlCounts = chnlCounts;
	}

	//ʹ��@ManyToOneע����@JoinColumnע��ʵ��
	//��ÿ�쵱��ͳ�Ʊ�TB_PIECE_M_CLAS_STATIS_INFO_M�����������������Ϣ��TB_CHNL_MANAGER_BASIC_INFO_M�Ķ��һ����
//	@ManyToOne
//	@JoinColumn(name="ID")
//	public TbBasicInfoM getTbBasicInfoM() {
//		return tbBasicInfoM;
//	}
//
//	public void setTbBasicInfoM(TbBasicInfoM tbBasicInfoM) {
//		this.tbBasicInfoM = tbBasicInfoM;
//	}

	@Column(name = "AREA",length=100)
	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "CARD_NUM_SERV_TOTAL_SCORE",length=32)
	public Float getCardNumServTotalScore() {
		return cardNumServTotalScore;
	}

	public void setCardNumServTotalScore(Float cardNumServTotalScore) {
		this.cardNumServTotalScore = cardNumServTotalScore;
	}

	@Column(name = "CARD_NUM_SERV_TOTAL_PAY",length=32)
	public Float getCardNumServTotalPay() {
		return cardNumServTotalPay;
	}

	public void setCardNumServTotalPay(Float cardNumServTotalPay) {
		this.cardNumServTotalPay = cardNumServTotalPay;
	}

	@Column(name = "MARKT_ACT_SERV_TOTAL_SCORE",length=32)
	public Float getMarktActServTotalScore() {
		return marktActServTotalScore;
	}

	public void setMarktActServTotalScore(Float marktActServTotalScore) {
		this.marktActServTotalScore = marktActServTotalScore;
	}

	@Column(name = "MARKT_ACT_SERV_TOTAL_PAY",length=32)
	public Float getMarktActServTotalPay() {
		return marktActServTotalPay;
	}

	public void setMarktActServTotalPay(Float marktActServTotalPay) {
		this.marktActServTotalPay = marktActServTotalPay;
	}

	@Column(name = "TMNL_SERV_TOTAL_SCORE",length=32)
	public Float getTmnlServTotalScore() {
		return tmnlServTotalScore;
	}

	public void setTmnlServTotalScore(Float tmnlServTotalScore) {
		this.tmnlServTotalScore = tmnlServTotalScore;
	}

	@Column(name = "TMNL_SERV_TOTAL_PAY",length=32)
	public Float getTmnlServTotalPay() {
		return tmnlServTotalPay;
	}

	public void setTmnlServTotalPay(Float tmnlServTotalPay) {
		this.tmnlServTotalPay = tmnlServTotalPay;
	}

	@Column(name = "DATA_SERV_TOTAL_SCORE",length=32)
	public Float getDataServTotalScore() {
		return dataServTotalScore;
	}

	public void setDataServTotalScore(Float dataServTotalScore) {
		this.dataServTotalScore = dataServTotalScore;
	}

	@Column(name = "DATA_SERV_TOTAL_PAY",length=32)
	public Float getDataServTotalPay() {
		return dataServTotalPay;
	}

	public void setDataServTotalPay(Float dataServTotalPay) {
		this.dataServTotalPay = dataServTotalPay;
	}

	@Column(name = "AGENCY_SERV_TOTAL_SCORE",length=32)
	public Float getAgencyServTotalScore() {
		return agencyServTotalScore;
	}

	public void setAgencyServTotalScore(Float agencyServTotalScore) {
		this.agencyServTotalScore = agencyServTotalScore;
	}

	@Column(name = "AGENCY_SERV_TOTAL_PAY",length=32)
	public Float getAgencyServTotalPay() {
		return agencyServTotalPay;
	}

	public void setAgencyServTotalPay(Float agencyServTotalPay) {
		this.agencyServTotalPay = agencyServTotalPay;
	}
	@Column(name = "SUM_Pay",length=18)
	public Float getSunPay() {
		return sunPay;
	}

	public void setSunPay(Float sunPay) {
		this.sunPay = sunPay;
	}
	
	@Column(name = "Money_Pay",length=18)
	public Float getMoneyPay() {
		return moneyPay;
	}
	
	public void setMoneyPay(Float moneyPay) {
		this.moneyPay = moneyPay;
	}
	
	
}

package com.jyyr.orm;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


/**
 * 3������ϵ����Ϣ��ѯ��ά��
 * @author ywz
 *
 */
@Entity
@Table (name="TB_CHNL_MANAGER_ACCOMD_COFFCNT_INFO_M",schema="qinhuangdao")
public class TbAccomdCoffcntLinfoM {
	

//	@GeneratedValue(strategy = IDENTITY)
	private String statisMonth;	//�·�	
	private String county;		//����	
	private String area;		//����	
	private Double cardAccomdCoffcnt;	//���ŵ���ϵ��	
	private Double tmnlAccmdCoffcnt;	//�ն˵���ϵ��	
	private Double dataActAccomdCoffcnt;	//����ҵ�����ϵ��	
	private Double marktActAccomdCoffcnt;	//Ӫ�������ϵ��	
	private Double generChargeAccomdCofcnt; //���շѵ���ϵ��
	/**Ĭ�ϵĹ��췽��*/
	
	public TbAccomdCoffcntLinfoM(){};
	
	
	@Column(name = "STATIS_MONTH",length=10)
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
	@Id 
   // @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "AREA",length=128)
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "CARD_ACCOMD_COFFCNT",length=18)
	public Double getCardAccomdCoffcnt() {
		return cardAccomdCoffcnt;
	}

	public void setCardAccomdCoffcnt(Double cardAccomdCoffcnt) {
		this.cardAccomdCoffcnt = cardAccomdCoffcnt;
	}

	@Column(name = "TMNL_ACCOMD_COFFCNT",length=18)
	public Double getTmnlAccmdCoffcnt() {
		return tmnlAccmdCoffcnt;
	}

	public void setTmnlAccmdCoffcnt(Double tmnlAccmdCoffcnt) {
		this.tmnlAccmdCoffcnt = tmnlAccmdCoffcnt;
	}

	@Column(name = "DATA_SERV_ACCOMD_COFFCNT",length=18)
	public Double getDataActAccomdCoffcnt() {
		return dataActAccomdCoffcnt;
	}

	public void setDataActAccomdCoffcnt(Double dataActAccomdCoffcnt) {
		this.dataActAccomdCoffcnt = dataActAccomdCoffcnt;
	}

	@Column(name = "MARKT_ACT_ACCOMD_COFFCNT",length=18)
	public Double getMarktActAccomdCoffcnt() {
		return marktActAccomdCoffcnt;
	}

	public void setMarktActAccomdCoffcnt(Double marktActAccomdCoffcnt) {
		this.marktActAccomdCoffcnt = marktActAccomdCoffcnt;
	}

	@Column(name = "GENER_CHARGE_ACCOMD_COFFCNT",length=18)
	public Double getGenerChargeAccomdCofcnt() {
		return generChargeAccomdCofcnt;
	}

	public void setGenerChargeAccomdCofcnt(Double generChargeAccomdCofcnt) {
		this.generChargeAccomdCofcnt = generChargeAccomdCofcnt;
	}


}

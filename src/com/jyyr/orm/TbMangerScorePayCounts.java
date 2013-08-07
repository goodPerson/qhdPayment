package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TbMangerScorePayCounts {
//	TB_COUNTY_SCORE_PAY_STATIS_D
//	ÿ�ջ���н��ͳ��
	private String staffId;//   ���ֹ���           varchar(32)  ,
	private String statisDate ;// ͳ������          varchar(10)  ,
	private String county;//  ����              varchar(100)  ,
	private String area;//  ����               varchar(100)  ,
	private float  dayTotalScoreStatis;// ���ܻ���ͳ��    decimal(18,4)  ,
	private float  dayTotalPayStatis;// ����н��ͳ��     decimal(18,4) 
	
	public TbMangerScorePayCounts(){}

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STAFF_ID",length=32)
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	@Column(name = "STATIS_DATE",length=10)
	public String getStatisDate() {
		return statisDate;
	}

	public void setStatisDate(String statisDate) {
		this.statisDate = statisDate;
	}

	@Column(name = "COUNTY",length=100)
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name = "AREA",length=100)
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "DAY_TOTAL_SCORE_STATIS",length=18)
	public float getDayTotalScoreStatis() {
		return dayTotalScoreStatis;
	}

	public void setDayTotalScoreStatis(float dayTotalScoreStatis) {
		this.dayTotalScoreStatis = dayTotalScoreStatis;
	}

	@Column(name = "DAY_TOTAL_PAY_STATIS",length=18)
	public float getDayTotalPayStatis() {
		return dayTotalPayStatis;
	}

	public void setDayTotalPayStatis(float dayTotalPayStatis) {
		this.dayTotalPayStatis = dayTotalPayStatis;
	};

}

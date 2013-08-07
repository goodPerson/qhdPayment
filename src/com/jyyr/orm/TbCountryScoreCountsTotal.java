package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TbCountryScoreCountsTotal {
//	TB_COUNTY_SCORE_PAY_STATIS_INFO_D
//	������ͳ��
	private String statisDate;//    ͳ������      varchar(10)  ,
	private String	county;//        '����        varchar(100)  ,
	private Float dayTotalScore;//   ���ܻ���    decimal(18,4)  ,
	private Float dayTotalPay;//   ����н��      decimal(18,4)  

	public TbCountryScoreCountsTotal(){};

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_MONTH",length=10)
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

	@Column(name = "DAY_TOTAL_SCORE",length=10)
	public Float getDayTotalScore() {
		return dayTotalScore;
	}

	public void setDayTotalScore(Float dayTotalScore) {
		this.dayTotalScore = dayTotalScore;
	}

	@Column(name = "DAY_TOTAL_PAY",length=10)
	public Float getDayTotalPay() {
		return dayTotalPay;
	}

	public void setDayTotalPay(Float dayTotalPay) {
		this.dayTotalPay = dayTotalPay;
	};
	
	
}

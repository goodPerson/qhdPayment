package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TbCityBigClassTotal {
//	市负责人大类统计表
//tableName TB_CITY_PIECE_M_CLS_INFO_M
	private String statisMonth;//      统计月份    varchar(10)  ,
	private String piecemClsServName;// 计件大类业务名称 varchar(40)  ,
	private float piecemClsServTotalPay;// 计件大类业务当月总薪酬  decimal(18,2)  ,
	private float piecemClsServTotalCnt;//  计件大类业务当月总发展量 decimal(18,2)  

	public TbCityBigClassTotal(){}

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "STATIS_MONTH",length=10)
	public String getStatisMonth() {
		return statisMonth;
	}

	public void setStatisMonth(String statisMonth) {
		this.statisMonth = statisMonth;
	}
	@Column(name = "PIECE_M_CLS_SERV_NAME",length=10)
	public String getPiecemClsServName() {
		return piecemClsServName;
	}

	public void setPiecemClsServName(String piecemClsServName) {
		this.piecemClsServName = piecemClsServName;
	}
	
	@Column(name = "PIECE_M_CLS_SERV_TOTAL_PAY",length=10)
	public float getPiecemClsServTotalPay() {
		return piecemClsServTotalPay;
	}

	public void setPiecemClsServTotalPay(float piecemClsServTotalPay) {
		this.piecemClsServTotalPay = piecemClsServTotalPay;
	}

	@Column(name = "PIECE_M_CLS_SERV_TOTAL_CNT",length=10)
	public float getPiecemClsServTotalCnt() {
		return piecemClsServTotalCnt;
	}

	public void setPiecemClsServTotalCnt(float piecemClsServTotalCnt) {
		this.piecemClsServTotalCnt = piecemClsServTotalCnt;
	};
		
}

package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="TB_CITY_PIECE_M_CLS_INFO_M",schema="qinhuangdao")
	public class TbCityPieceMClsInfoM {
//	            市负责人大类统计表
//		tableName TB_CITY_PIECE_M_CLS_INFO_M
		
		private String statisDate;//    统计日期      varchar(10)  ,
		private String pieceMClsServName;//     大类名称      varchar(40)  ,
		private Float pieceMClsServTotalPay;//   计件大类业务当月总薪酬      decimal(18,4)  ,
		private Float pieceMClsServTotalCnt;// 计件大类业务当月总发展量 decimal(18,4)  
		
		public TbCityPieceMClsInfoM(){}
		@Column(name = "STATIS_DATE",length=10)
		public String getStatisDate() {
			return statisDate;
		}

		public void setStatisDate(String statisDate) {
			this.statisDate = statisDate;
		}
		@Id 
	    @GeneratedValue(strategy = GenerationType.AUTO) 
		@Column(name = "PIECE_M_CLS_SERV_NAME",length=40)
		public String getPieceMClsServName() {
			return pieceMClsServName;
		}

		public void setPieceMClsServName(String pieceMClsServName) {
			this.pieceMClsServName = pieceMClsServName;
		}
		@Column(name = "PIECE_M_CLS_SERV_TOTAL_PAY",length=18)
		public Float getPieceMClsServTotalPay() {
			return pieceMClsServTotalPay;
		}

		public void setPieceMClsServTotalPay(Float pieceMClsServTotalPay) {
			this.pieceMClsServTotalPay = pieceMClsServTotalPay;
		}
		@Column(name = "PIECE_M_CLS_SERV_TOTAL_CNT",length=18)
		public Float getPieceMClsServTotalCnt() {
			return pieceMClsServTotalCnt;
		}

		public void setPieceMClsServTotalCnt(Float pieceMClsServTotalCnt) {
			this.pieceMClsServTotalCnt = pieceMClsServTotalCnt;
		}

		
	
}

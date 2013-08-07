package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="TB_CITY_MON_DEV_SCORE_PAY_INFO_MON",schema="qinhuangdao")
	public class TbCityMonDevScorePayInfoMon {
//		市负责人负责人日统计表
//		TB_COUNTY_DEV_CNT_STATIS_INFO_D
		private String statisMonth;//    统计月份       varchar(10)  ,
		private Float totalDevCnt;//  月累计发展量 decimal(8,4)  ,
		private Float totalDevScore;//  月累计发展积分     decimal(8,4)  ,
		private Float totalDevPay;// 月累计薪酬   decimal(18,4)  ,
		

		public TbCityMonDevScorePayInfoMon(){}

		@Id 
	    @GeneratedValue(strategy = GenerationType.AUTO) 
		@Column(name = "STATIS_MONTH",length=10)
		public String getStatisMonth() {
			return statisMonth;
		}


		public void setStatisMonth(String statisMonth) {
			this.statisMonth = statisMonth;
		}

		@Column(name = "TOTAL_DEV_CNT",length=18)
		public Float getTotalDevCnt() {
			return totalDevCnt;
		}


		public void setTotalDevCnt(Float totalDevCnt) {
			this.totalDevCnt = totalDevCnt;
		}

		@Column(name = "TOTAL_DEV_SCORE",length=18)
		public Float getTotalDevScore() {
			return totalDevScore;
		}


		public void setTotalDevScore(Float totalDevScore) {
			this.totalDevScore = totalDevScore;
		}

		@Column(name = "TOTAL_DEV_PAY",length=18)
		public Float getTotalDevPay() {
			return totalDevPay;
		}


		public void setTotalDevPay(Float totalDevPay) {
			this.totalDevPay = totalDevPay;
		}

		
		
}

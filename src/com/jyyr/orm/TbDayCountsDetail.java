package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="TB_COUNTY_SCORE_PAY_STATIS_D",schema="qinhuangdao")
public class TbDayCountsDetail {
//	TB_CHNL_MAGR_STATIS_INFO_D
//	����������ͳ����ϸ    ��ҳ����������ͼ

			private String staffId;  //���ֹ���
			private String statisDate ; //ͳ������
			private String country; //����
			private String area; //����
			private Integer prncpChnlCnt; //������������
			private Float curDaytotalScore; //ǰһ�����
			private Float curDaytotalPay; //ǰһ�����
			
			public TbDayCountsDetail(){}
	
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

			@Column(name = "COUNTY",length=50)
			public String getCountry() {
				return country;
			}

			
			public void setCountry(String country) {
				this.country = country;
			}

			@Column(name = "AREA",length=200)
			public String getArea() {
				return area;
			}

			public void setArea(String area) {
				this.area = area;
			}

			@Column(name = "DAY_DEV_TOTAL_CNT",length=10)
			public Integer getPrncpChnlCnt() {
				return prncpChnlCnt;
			}


			public void setPrncpChnlCnt(Integer prncpChnlCnt) {
				this.prncpChnlCnt = prncpChnlCnt;
			}
			
			@Column(name = "DAY_TOTAL_SCORE_STATIS",length=10)
			public Float getCurDaytotalScore() {
				return curDaytotalScore;
			}

			public void setCurDaytotalScore(Float curDaytotalScore) {
				this.curDaytotalScore = curDaytotalScore;
			}
			
			@Column(name = "DAY_TOTAL_PAY_STATIS",length=10)
			public Float getCurDaytotalPay() {
				return curDaytotalPay;
			}

			public void setCurDaytotalPay(Float curDaytotalPay) {
				this.curDaytotalPay = curDaytotalPay;
			}


}

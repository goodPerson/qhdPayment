package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="TB_CHNL_MAGR_STATIS_INFO_D",schema="qinhuangdao")
public class TbMagerDayCounts {
//	TB_CHNL_MAGR_STATIS_INFO_D
//	����������ͳ�Ʊ�

			private String staffId;  //���ֹ���
			private String statisDate ; //ͳ������
			private String name; //����
			private String country; //����
			private String area; //����
			private Integer prncpChnlCnt; //������������
			private Integer curDaytotalScore; //ǰһ�����
			private Integer curMonTotalScore; //��ǰ���ܻ���
			private Float curMonTotalPay; //��ǰ����н��
			
			
			@Column(name = "NAME",length=32)
			public String getName() {
				return name;
			}



			public void setName(String name) {
				this.name = name;
			}


			@Column(name = "DAY_SCORE_CNT",length=32)
			public Integer getCurDaytotalScore() {
				return curDaytotalScore;
			}



			public void setCurDaytotalScore(Integer curDaytotalScore) {
				this.curDaytotalScore = curDaytotalScore;
			}



			public TbMagerDayCounts(){}
	

	
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

			@Column(name = "PRNCP_CHNL_CNT",length=10)
			public Integer getPrncpChnlCnt() {
				return prncpChnlCnt;
			}


			public void setPrncpChnlCnt(Integer prncpChnlCnt) {
				this.prncpChnlCnt = prncpChnlCnt;
			}

			@Column(name = "CUR_MON_TOTAL_SCORE",length=18)
			public Integer getCurMonTotalScore() {
				return curMonTotalScore;
			}


			public void setCurMonTotalScore(Integer curMonTotalScore) {
				this.curMonTotalScore = curMonTotalScore;
			}

			@Column(name = "CUR_MON_TOTAL_PAY",length=18)
			public Float getCurMonTotalPay() {
				return curMonTotalPay;
			}


			public void setCurMonTotalPay(Float curMonTotalPay) {
				this.curMonTotalPay = curMonTotalPay;
			}

}

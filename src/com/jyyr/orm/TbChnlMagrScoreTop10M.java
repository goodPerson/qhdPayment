package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="TB_CHNL_MAGR_SCORE_TOP_10_M",schema="QINHUANGDAO")
public class TbChnlMagrScoreTop10M {
	@Column(name="STATIS_MONTH",length=10)
	private String	STATIS_MONTH      ;//    VARCHAR(10)  ,统计月份
	@Id
	@Column(name="CHNL_MAGR_ORDER")
	private int	CHNL_MAGR_ORDER  ;//     INTEGER  ,渠道经理排名
	@Column(name="CHNL_MAGR_NAME",length=40)
	private String	CHNL_MAGR_NAME  ;//      VARCHAR(40)  ,渠道经理姓名
	@Column(name="CHNL_MAGR_MON_TOTAL_SCORE",length=18)
	private Integer	CHNL_MAGR_MON_TOTAL_SCORE;//  DECIMAL(18,2)  ,渠道经理月积分总和
	@Column(name="CHNL_MAGR_MON_TOTAL_PAY",length=18)
	private float CHNL_MAGR_MON_TOTAL_PAY ;// DECIMAL(18,2) 渠道经理月累计薪酬


	public String getSTATIS_MONTH() {
		return STATIS_MONTH;
	}
	public void setSTATIS_MONTH(String sTATIS_MONTH) {
		STATIS_MONTH = sTATIS_MONTH;
	}
	public int getCHNL_MAGR_ORDER() {
		return CHNL_MAGR_ORDER;
	}
	public void setCHNL_MAGR_ORDER(int cHNL_MAGR_ORDER) {
		CHNL_MAGR_ORDER = cHNL_MAGR_ORDER;
	}
	public String getCHNL_MAGR_NAME() {
		return CHNL_MAGR_NAME;
	}
	public void setCHNL_MAGR_NAME(String cHNL_MAGR_NAME) {
		CHNL_MAGR_NAME = cHNL_MAGR_NAME;
	}
	public Integer getCHNL_MAGR_MON_TOTAL_SCORE() {
		return CHNL_MAGR_MON_TOTAL_SCORE;
	}
	public void setCHNL_MAGR_MON_TOTAL_SCORE(Integer cHNL_MAGR_MON_TOTAL_SCORE) {
		CHNL_MAGR_MON_TOTAL_SCORE = cHNL_MAGR_MON_TOTAL_SCORE;
	}
	public float getCHNL_MAGR_MON_TOTAL_PAY() {
		return CHNL_MAGR_MON_TOTAL_PAY;
	}
	public void setCHNL_MAGR_MON_TOTAL_PAY(float cHNL_MAGR_MON_TOTAL_PAY) {
		CHNL_MAGR_MON_TOTAL_PAY = cHNL_MAGR_MON_TOTAL_PAY;
	} 
}

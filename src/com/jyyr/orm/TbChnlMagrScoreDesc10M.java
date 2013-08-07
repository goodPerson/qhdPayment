package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="TB_CHNL_MAGR_SCORE_DESC_10_M",schema="QINHUANGDAO")
public class TbChnlMagrScoreDesc10M {
	@Column(name="STATIS_MONTH",length=10)
	private String	STATIS_MONTH  ;//        VARCHAR(10)  ,统计月份
	@Id
	@Column(name="DESC_ORDER")
	private int	DESC_ORDER;//            INTEGER  ,倒数排名
	@Column(name="CHNL_MAGR_NAME",length=40)
	private String	CHNL_MAGR_NAME;//        VARCHAR(40)  ,渠道经理姓名
	@Column(name="CHNL_MAGR_MON_TOTAL_SCORE",length=18)
	private Integer	CHNL_MAGR_MON_TOTAL_SCORE;//  DECIMAL(18,4)  渠道经理月总积分
	public String getSTATIS_MONTH() {
		return STATIS_MONTH;
	}
	public void setSTATIS_MONTH(String sTATIS_MONTH) {
		STATIS_MONTH = sTATIS_MONTH;
	}
	public int getDESC_ORDER() {
		return DESC_ORDER;
	}
	public void setDESC_ORDER(int dESC_ORDER) {
		DESC_ORDER = dESC_ORDER;
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

}

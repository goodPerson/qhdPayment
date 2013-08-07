package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_CITY_MON_DEV_SCORE_INFO_M",schema="QINHUANGDAO")
public class TbCityMonDevScoreInfoM {

@Id
@Column(name="STATIS_MONTH",length=10)
private String	STATIS_MONTH ;//         VARCHAR(10)  ,统计月份

@Column(name="CHNL_MAGR_TOTAL_CNT")
private int	CHNL_MAGR_TOTAL_CNT;//   INTEGER  ,渠道经理总数

@Column(name="AGT_CHNL_TOTAL_CNT")
private int	AGT_CHNL_TOTAL_CNT;//    INTEGER  ,代理渠道总数

@Column(name="CARD_NUM_SERV_MON_TOTAL_SCORE",length=18)
private Integer	CARD_NUM_SERV_MON_TOTAL_SCORE;//  DECIMAL(18,2)  ,卡号业务发展月总积分

@Column(name="TMNL_SERV_MON_TOTAL_SCORE",length=18)
private Integer	TMNL_SERV_MON_TOTAL_SCORE;//  DECIMAL(18,2)  ,终端业务发展月总积分

@Column(name="DATA_SERV_MON_TOTAL_SCORE",length=18)
private Integer	DATA_SERV_MON_TOTAL_SCORE;//  DECIMAL(18,2)  ,数据业务发展月总积分

@Column(name="ACT_SERV_MON_SCORE",length=18)
private Integer	ACT_SERV_MON_SCORE;//    DECIMAL(18,2)  ,活动业务发展月积分

@Column(name="AGENC_SERV_MON_TOTAL_SCORE",length=18)
private Integer	AGENC_SERV_MON_TOTAL_SCORE;//  DECIMAL(18,2)  ,代办业务发展月总积分

@Column(name="TOTAL_PIECE_PAY",length=18)
private float	TOTAL_PIECE_PAY;//       DECIMAL(18,2)  ,总计件薪酬

@Column(name="TOTAL_MONEY",length=18)
private Float	TOTAL_MONEY;//           DECIMAL(18,2)  总奖金


public String getSTATIS_MONTH() {
	return STATIS_MONTH;
}
public void setSTATIS_MONTH(String sTATIS_MONTH) {
	STATIS_MONTH = sTATIS_MONTH;
}
public int getCHNL_MAGR_TOTAL_CNT() {
	return CHNL_MAGR_TOTAL_CNT;
}
public void setCHNL_MAGR_TOTAL_CNT(int cHNL_MAGR_TOTAL_CNT) {
	CHNL_MAGR_TOTAL_CNT = cHNL_MAGR_TOTAL_CNT;
}
public int getAGT_CHNL_TOTAL_CNT() {
	return AGT_CHNL_TOTAL_CNT;
}
public void setAGT_CHNL_TOTAL_CNT(int aGT_CHNL_TOTAL_CNT) {
	AGT_CHNL_TOTAL_CNT = aGT_CHNL_TOTAL_CNT;
}
public Integer getCARD_NUM_SERV_MON_TOTAL_SCORE() {
	return CARD_NUM_SERV_MON_TOTAL_SCORE;
}
public void setCARD_NUM_SERV_MON_TOTAL_SCORE(Integer cARD_NUM_SERV_MON_TOTAL_SCORE) {
	CARD_NUM_SERV_MON_TOTAL_SCORE = cARD_NUM_SERV_MON_TOTAL_SCORE;
}
public Integer getTMNL_SERV_MON_TOTAL_SCORE() {
	return TMNL_SERV_MON_TOTAL_SCORE;
}
public void setTMNL_SERV_MON_TOTAL_SCORE(Integer tMNL_SERV_MON_TOTAL_SCORE) {
	TMNL_SERV_MON_TOTAL_SCORE = tMNL_SERV_MON_TOTAL_SCORE;
}
public Integer getDATA_SERV_MON_TOTAL_SCORE() {
	return DATA_SERV_MON_TOTAL_SCORE;
}
public void setDATA_SERV_MON_TOTAL_SCORE(Integer dATA_SERV_MON_TOTAL_SCORE) {
	DATA_SERV_MON_TOTAL_SCORE = dATA_SERV_MON_TOTAL_SCORE;
}
public Integer getACT_SERV_MON_SCORE() {
	return ACT_SERV_MON_SCORE;
}
public void setACT_SERV_MON_SCORE(Integer aCT_SERV_MON_SCORE) {
	ACT_SERV_MON_SCORE = aCT_SERV_MON_SCORE;
}
public Integer getAGENC_SERV_MON_TOTAL_SCORE() {
	return AGENC_SERV_MON_TOTAL_SCORE;
}
public void setAGENC_SERV_MON_TOTAL_SCORE(Integer aGENC_SERV_MON_TOTAL_SCORE) {
	AGENC_SERV_MON_TOTAL_SCORE = aGENC_SERV_MON_TOTAL_SCORE;
}
public float getTOTAL_PIECE_PAY() {
	return TOTAL_PIECE_PAY;
}
public void setTOTAL_PIECE_PAY(float tOTAL_PIECE_PAY) {
	TOTAL_PIECE_PAY = tOTAL_PIECE_PAY;
}
public Float getTOTAL_MONEY() {
	return TOTAL_MONEY;
}
public void setTOTAL_MONEY(Float total_money) {
	TOTAL_MONEY = total_money;
}




}
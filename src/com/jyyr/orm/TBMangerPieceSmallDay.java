package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 渠道经理计件分项日统计
 * @author ywz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table (name="TB_CHNL_MANAGER_RECKON_PIECE_PAY_DEAL_INFO_D",schema="qinhuangdao")
public class TBMangerPieceSmallDay {
	  @Id
	  @Column(name = "STATIS_DATE",length=10)
	  private String  statisDate;  //日期
	  @Column(name = "COUNTY_NAME",length=10)
	  private String  countyName;//县区
	  @Column(name = "NAME",length=10)
	  private String  name;//姓名
	  @Column(name = "STAFF_ID",length=10)
	  private String  id; //员工编号
	  @Column(name = "PRNCP_AREA",length=10)
	  private String  prncpArea;//负责区域
	  @Column(name = "CHNL_ID",length=20)
	  private String prncpChnlId; //渠道编码
	  @Column(name = "CHNL_NAME",length=10)
	  private String prncpChnlName;//渠道名称
	  @Column(name = "RECKON_PIECE_M_CLS_NAME",length=20)
	  private String bigPieceName;//计件项目大类名称
	  @Column(name = "RECKON_PIECE_S_CLS_NAME",length=20)
	  private String smallPieceName;//计件项目小类名称
	  @Column(name = "CUR_DAY_DEV_CNT",length=10)
	  private Integer dateCnt; //当日发展量
	  @Column(name = "CUR_DAY_DEV_SCORE",length=10)
	  private Integer dateScore;//当日发展积分
	  @Column(name = "CUR_DAY_PAY",length=10)
	  private Float datePay;//当日发展薪酬
	  @Column(name = "MON_SUM_DEV_CNT",length=10)
	  private Integer monthCnt; //月累计发展量
	  @Column(name = "MON_SUM_DEV_SCORE",length=10)
	  private Integer monthScore;//月发展积分
	  @Column(name = "MON_SUM_PAY",length=10)
	  private Float   monthPay;//月累计发展薪酬
	public String getStatisDate() {
		return statisDate;
	}
	public void setStatisDate(String statisDate) {
		this.statisDate = statisDate;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrncpArea() {
		return prncpArea;
	}
	public void setPrncpArea(String prncpArea) {
		this.prncpArea = prncpArea;
	}
	public String getPrncpChnlId() {
		return prncpChnlId;
	}
	public void setPrncpChnlId(String prncpChnlId) {
		this.prncpChnlId = prncpChnlId;
	}
	public String getPrncpChnlName() {
		return prncpChnlName;
	}
	public void setPrncpChnlName(String prncpChnlName) {
		this.prncpChnlName = prncpChnlName;
	}
	public String getBigPieceName() {
		return bigPieceName;
	}
	public void setBigPieceName(String bigPieceName) {
		this.bigPieceName = bigPieceName;
	}
	public String getSmallPieceName() {
		return smallPieceName;
	}
	public void setSmallPieceName(String smallPieceName) {
		this.smallPieceName = smallPieceName;
	}
	public Integer getDateCnt() {
		return dateCnt;
	}
	public void setDateCnt(Integer dateCnt) {
		this.dateCnt = dateCnt;
	}
	public Integer getDateScore() {
		return dateScore;
	}
	public void setDateScore(Integer dateScore) {
		this.dateScore = dateScore;
	}
	public Float getDatePay() {
		return datePay;
	}
	public void setDatePay(Float datePay) {
		this.datePay = datePay;
	}
	public Integer getMonthCnt() {
		return monthCnt;
	}
	public void setMonthCnt(Integer monthCnt) {
		this.monthCnt = monthCnt;
	}
	public Integer getMonthScore() {
		return monthScore;
	}
	public void setMonthScore(Integer monthScore) {
		this.monthScore = monthScore;
	}
	public Float getMonthPay() {
		return monthPay;
	}
	public void setMonthPay(Float monthPay) {
		this.monthPay = monthPay;
	}


}

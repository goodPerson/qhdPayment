package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="TB_CHNL_MAGR_DESC_ORDER_10_D",schema="qinhuangdao")
public class TbCountryChnlDescDay {
//	渠道经理排名后十名
//	TB_CHNL_MAGR_DESC_ORDER_10_D
	
	private String statisDate;//    统计日期       varchar(10)  ,
	private String  county;//     区县           varchar(100)  ,
	private Integer descOrder;//    倒数排名        integer  ,
	private String chnlMagrName;//  渠道经理姓名       varchar(40)  ,
	private Integer chnlMagrNcore;//  渠道经理积分     decimal(18,4)  
	
	public TbCountryChnlDescDay(){}

	
	@Column(name = "STATIS_Date",length=10)
	public String getStatisDate() {
		return statisDate;
	}

	public void setStatisDate(String statisDate) {
		this.statisDate = statisDate;
	}
	@Column(name = "COUNTY",length=100)
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "DESC_ORDER",length=10)
	public Integer getDescOrder() {
		return descOrder;
	}

	public void setDescOrder(Integer descOrder) {
		this.descOrder = descOrder;
	}
	@Column(name = "CHNL_MAGR_NAME",length=40)
	public String getChnlMagrName() {
		return chnlMagrName;
	}

	public void setChnlMagrName(String chnlMagrName) {
		this.chnlMagrName = chnlMagrName;
	}
	@Column(name = "CHNL_MAGR_SCORE",length=18)
	public Integer getChnlMagrNcore() {
		return chnlMagrNcore;
	}

	public void setChnlMagrNcore(Integer chnlMagrNcore) {
		this.chnlMagrNcore = chnlMagrNcore;
	};	

}

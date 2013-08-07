package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="MONTH_LINE_CHART",schema="qinhuangdao")
public class TbMonthLineChart {
	/**
	 * 月统计折线图
	 */
	private String curyear;// 年	varchar	10	否
	private String stype;// 类型 	varchar	10	否
	private String one;// 1月	varchar	10	否
	private String tow;// 2月	varchar	10	否
	private String three;// 3月	varchar	10	否
	private String four;// 4月	varchar	10	否
	private String five;// 5月	varchar	10	否
	private String six;//6月
	private String seven;// 6月	varchar	10	否
	private String eight;// 7月	varchar	10	否
	private String nine;// 8月	varchar	10	否
	private String ten;// 9月	varchar	10	否
	private String eleven;// 10月	varchar	10	否
	private String twelve;// 1月	varchar	10	否
	private Integer id;// 经分编号	integer	4	否
	private String county;// 区县	varchar	20	是
	
	public TbMonthLineChart(){}
	@Column(name = "CURYEAR",length=20)
	public String getCuryear() {
		return curyear;
	}

	public void setCuryear(String curyear) {
		this.curyear = curyear;
	}
	
	@Column(name = "sType",length=20)
	public String getStype() {
		return stype;
	}
	
	public void setStype(String stype) {
		this.stype = stype;
	}
	
	@Column(name = "SIX",length=20)
	public String getSix() {
		return six;
	}

	public void setSix(String six) {
		this.six = six;
	}


	@Column(name = "ONE",length=20)
	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}
	@Column(name = "TOW",length=20)
	public String getTow() {
		return tow;
	}

	public void setTow(String tow) {
		this.tow = tow;
	}
	@Column(name = "THREE",length=20)
	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}
	@Column(name = "FOUR",length=20)
	public String getFour() {
		return four;
	}

	public void setFour(String four) {
		this.four = four;
	}
	@Column(name = "FIVE",length=20)
	public String getFive() {
		return five;
	}

	public void setFive(String five) {
		this.five = five;
	}
	@Column(name = "SEVEN",length=20)
	public String getSeven() {
		return seven;
	}

	public void setSeven(String seven) {
		this.seven = seven;
	}
	@Column(name = "EIGHT",length=20)
	public String getEight() {
		return eight;
	}

	public void setEight(String eight) {
		this.eight = eight;
	}
	@Column(name = "NINE",length=20)
	public String getNine() {
		return nine;
	}

	public void setNine(String nine) {
		this.nine = nine;
	}
	@Column(name = "TEN",length=20)
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	@Column(name = "ELEVEN",length=20)
	public String getEleven() {
		return eleven;
	}

	public void setEleven(String eleven) {
		this.eleven = eleven;
	}
	@Column(name = "TWELVE",length=20)
	public String getTwelve() {
		return twelve;
	}

	
	public void setTwelve(String twelve) {
		this.twelve = twelve;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "ID",length=10)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "COUNTY",length=20)
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}	

}

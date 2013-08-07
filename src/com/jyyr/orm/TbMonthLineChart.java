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
	 * ��ͳ������ͼ
	 */
	private String curyear;// ��	varchar	10	��
	private String stype;// ���� 	varchar	10	��
	private String one;// 1��	varchar	10	��
	private String tow;// 2��	varchar	10	��
	private String three;// 3��	varchar	10	��
	private String four;// 4��	varchar	10	��
	private String five;// 5��	varchar	10	��
	private String six;//6��
	private String seven;// 6��	varchar	10	��
	private String eight;// 7��	varchar	10	��
	private String nine;// 8��	varchar	10	��
	private String ten;// 9��	varchar	10	��
	private String eleven;// 10��	varchar	10	��
	private String twelve;// 1��	varchar	10	��
	private Integer id;// ���ֱ��	integer	4	��
	private String county;// ����	varchar	20	��
	
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

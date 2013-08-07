package com.jyyr.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name="county_static",schema="qinhuangdao")
public class TbCountyStaticMonth {

  private String static_month;//  VARCHAR(100) ,
  private String  county_name;// VARCHAR(100) ,
  private String one;// VARCHAR(100) ,
  private String two;
  private String three;// VARCHAR(80),
  private String four;// VARCHAR(80),
  private String five;// VARCHAR(80),
  private String six;// VARCHAR(80),
  private String seven;// VARCHAR(80),
  private String eight;// VARCHAR(80),
  private String nine;// VARCHAR(80),
  private String ten;// VARCHAR(80),
  private String eleven;// VARCHAR(80),
  private String twelve;// VARCHAR(80)
  private String stype;// VARCHAR(80)
  public TbCountyStaticMonth(){}

  @Id 
  @GeneratedValue(strategy = GenerationType.AUTO) 
  @Column(name = "static_month",length=10)
public String getStatic_month() {
	return static_month;
}

public void setStatic_month(String static_month) {
	this.static_month = static_month;
}
@Column(name = "County_name",length=10)
public String getCounty_name() {
	return county_name;
}

public void setCounty_name(String county_name) {
	this.county_name = county_name;
}
@Column(name = "One",length=10)
public String getOne() {
	return one;
}

public void setOne(String one) {
	this.one = one;
}
@Column(name = "two",length=10)
public String getTwo() {
	return two;
}

public void setTwo(String two) {
	this.two = two;
}

@Column(name = "Three",length=10)
public String getThree() {
	return three;
}

public void setThree(String three) {
	this.three = three;
}
@Column(name = "Four",length=10)
public String getFour() {
	return four;
}

public void setFour(String four) {
	this.four = four;
}
@Column(name = "Five",length=10)
public String getFive() {
	return five;
}

public void setFive(String five) {
	this.five = five;
}
@Column(name = "Six",length=10)
public String getSix() {
	return six;
}

public void setSix(String six) {
	this.six = six;
}
@Column(name = "Seven",length=10)
public String getSeven() {
	return seven;
}

public void setSeven(String seven) {
	this.seven = seven;
}
@Column(name = "Eight",length=10)
public String getEight() {
	return eight;
}

public void setEight(String eight) {
	this.eight = eight;
}
@Column(name = "Nine",length=10)
public String getNine() {
	return nine;
}

public void setNine(String nine) {
	this.nine = nine;
}
@Column(name = "Ten",length=10)
public String getTen() {
	return ten;
}

public void setTen(String ten) {
	this.ten = ten;
}
@Column(name = "Eleven",length=10)
public String getEleven() {
	return eleven;
}

public void setEleven(String eleven) {
	this.eleven = eleven;
}
@Column(name = "Twelve",length=10)
public String getTwelve() {
	return twelve;
}

public void setTwelve(String twelve) {
	this.twelve = twelve;
}
@Column(name = "stype",length=10)
public String getStype() {
	return stype;
}

public void setStype(String stype) {
	this.stype = stype;
}
  
}

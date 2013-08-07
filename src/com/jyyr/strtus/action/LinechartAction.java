package com.jyyr.strtus.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jyyr.orm.TbCityMonDevScorePayInfoMon;
import com.jyyr.service.TbCityMonDevScorePayInfoMonService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class LinechartAction  extends ActionSupport implements ModelDriven<TbCityMonDevScorePayInfoMon>{
	
	TbCityMonDevScorePayInfoMonService Service;
	private List<TbCityMonDevScorePayInfoMon> monList;
	private List<TbCityMonDevScorePayInfoMon> monlast;
	private TbCityMonDevScorePayInfoMon mon1;
	private TbCityMonDevScorePayInfoMon mon;
	private ArrayList a;
	private Float[] list1;
	private Float[] list2;
	private  String msg;
	private Float d;
	private Float e;
	
	TbCityMonDevScorePayInfoMon model=new TbCityMonDevScorePayInfoMon();	
	public String line() throws IOException {
		
		monList=Service.findall();
		if (monList != null) {
			list1=new Float [monList.size()-1];
			for (int i=0;i<monList.size()-1;i++) {
				mon=monList.get(i);
			    list1[i]=monList.get(i).getTotalDevCnt();
			    System.out.println(list1[i]);
		   }
			d=monList.get(monList.size()-1).getTotalDevCnt();
			
			
		}
		monlast=Service.findall1();
		if (monlast != null) {
			list2=new Float [monlast.size()-1];
			for (int i=0;i<monlast.size()-1;i++) {
				mon1=monlast.get(i);
			    list2[i]=monlast.get(i).getTotalDevCnt();
			    System.out.println(list2[i]);
		   }
			e=monlast.get(monlast.size()-1).getTotalDevCnt();
			
			
		}
		
		return SUCCESS;
	}
	public TbCityMonDevScorePayInfoMonService getService() {
		return Service;
	}
	public void setService(TbCityMonDevScorePayInfoMonService service) {
		Service = service;
	}
	public List<TbCityMonDevScorePayInfoMon> getMonList() {
		return monList;
	}
	public void setMonList(List<TbCityMonDevScorePayInfoMon> monList) {
		this.monList = monList;
	}
	public TbCityMonDevScorePayInfoMon getMon() {
		return mon;
	}
	public void setMon(TbCityMonDevScorePayInfoMon mon) {
		this.mon = mon;
	}
	
	public ArrayList getA() {
		return a;
	}
	public void setA(ArrayList a) {
		this.a = a;
	}
	public Float[] getList1() {
		return list1;
	}
	public void setList1(Float[] list1) {
		this.list1 = list1;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public TbCityMonDevScorePayInfoMon getModel() {
		return model;
	}
	public void setModel(TbCityMonDevScorePayInfoMon model) {
		this.model = model;
	}
	public Float getD() {
		return d;
	}
	public void setD(Float d) {
		this.d = d;
	}
	public List<TbCityMonDevScorePayInfoMon> getMonlast() {
		return monlast;
	}
	public void setMonlast(List<TbCityMonDevScorePayInfoMon> monlast) {
		this.monlast = monlast;
	}
	public TbCityMonDevScorePayInfoMon getMon1() {
		return mon1;
	}
	public void setMon1(TbCityMonDevScorePayInfoMon mon1) {
		this.mon1 = mon1;
	}
	public Float[] getList2() {
		return list2;
	}
	public void setList2(Float[] list2) {
		this.list2 = list2;
	}
	public Float getE() {
		return e;
	}
	public void setE(Float e) {
		this.e = e;
	}
	
	

}

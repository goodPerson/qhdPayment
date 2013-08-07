package com.jyyr.strtus.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.jyyr.orm.TbCityPieceMClsInfoM;
import com.jyyr.orm.TbCountyServCntInfoD;
import com.jyyr.service.TbCityPieceMClsInfoMService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PiechartAction  extends ActionSupport implements ModelDriven<TbCityPieceMClsInfoM>{
	
	TbCityPieceMClsInfoMService Service;
	private List<TbCityPieceMClsInfoM> pieceList;
	private List<TbCountyServCntInfoD> countylist;
	private TbCityPieceMClsInfoM piece ;
	private TbCountyServCntInfoD county;
	private ArrayList a;
	private Float[] list1;
	private Float[] list2;
	private String msg;
	private Float card;
	private Float data;
	private Float tmnl;
	private Float market;
	private Float dai;
	private Float qinglong;
	private Float lulong;
	private Float bdh;
	private Float shg;
	private Float changli;
	private Float funing;
	
	TbCityPieceMClsInfoM model=new TbCityPieceMClsInfoM();	
	public String pie() throws IOException {
		Calendar date=Calendar.getInstance();
		date.add(Calendar.DATE,-1);
		String statisDate=new SimpleDateFormat( "yyyyMMdd ").format(date.getTime());

		
		
		pieceList=Service.findpiece(statisDate);
		if (pieceList != null) {
			list1=new Float [pieceList.size()];
			for (int i=0;i<pieceList.size();i++) {
				piece=pieceList.get(i);
			    list1[i]=pieceList.get(i).getPieceMClsServTotalCnt();
			    System.out.println(list1[i]);
		   }
			dai=list1[0];card=list1[1];data=list1[2];market=list1[3];tmnl=list1[4];
			
			
		}
		countylist=Service.findcounty(statisDate);
		if (countylist != null) {
			list2=new Float [countylist.size()];
			for (int i=0;i<countylist.size();i++) {
				county=countylist.get(i);
			    list2[i]=countylist.get(i).getCountyServTotalCnt();
			    System.out.println(list2[i]);
		   }
			
			lulong=list2[0];bdh=list2[1];changli=list2[2];funing=list2[3];qinglong=list2[4];shg=list2[5];
			
		}
		
		return SUCCESS;
	}
	public TbCityPieceMClsInfoM getModel() {
		return model;
	}
	public void setModel(TbCityPieceMClsInfoM model) {
		this.model = model;
	}
	public TbCityPieceMClsInfoMService getService() {
		return Service;
	}
	public void setService(TbCityPieceMClsInfoMService service) {
		Service = service;
	}
	public List<TbCityPieceMClsInfoM> getPieceList() {
		return pieceList;
	}
	public void setPieceList(List<TbCityPieceMClsInfoM> pieceList) {
		this.pieceList = pieceList;
	}
	public List<TbCountyServCntInfoD> getCountylist() {
		return countylist;
	}
	public void setCountylist(List<TbCountyServCntInfoD> countylist) {
		this.countylist = countylist;
	}
	public TbCityPieceMClsInfoM getPiece() {
		return piece;
	}
	public void setPiece(TbCityPieceMClsInfoM piece) {
		this.piece = piece;
	}
	public TbCountyServCntInfoD getCounty() {
		return county;
	}
	public void setCounty(TbCountyServCntInfoD county) {
		this.county = county;
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
	public Float[] getList2() {
		return list2;
	}
	public void setList2(Float[] list2) {
		this.list2 = list2;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Float getCard() {
		return card;
	}
	public void setCard(Float card) {
		this.card = card;
	}
	public Float getData() {
		return data;
	}
	public void setData(Float data) {
		this.data = data;
	}
	public Float getTmnl() {
		return tmnl;
	}
	public void setTmnl(Float tmnl) {
		this.tmnl = tmnl;
	}
	public Float getMarket() {
		return market;
	}
	public void setMarket(Float market) {
		this.market = market;
	}
	public Float getDai() {
		return dai;
	}
	public void setDai(Float dai) {
		this.dai = dai;
	}
	public Float getQinglong() {
		return qinglong;
	}
	public void setQinglong(Float qinglong) {
		this.qinglong = qinglong;
	}
	public Float getLulong() {
		return lulong;
	}
	public void setLulong(Float lulong) {
		this.lulong = lulong;
	}
	public Float getBdh() {
		return bdh;
	}
	public void setBdh(Float bdh) {
		this.bdh = bdh;
	}
	public Float getShg() {
		return shg;
	}
	public void setShg(Float shg) {
		this.shg = shg;
	}
	public Float getChangli() {
		return changli;
	}
	public void setChangli(Float changli) {
		this.changli = changli;
	}
	public Float getFuning() {
		return funing;
	}
	public void setFuning(Float funing) {
		this.funing = funing;
	}

	
}

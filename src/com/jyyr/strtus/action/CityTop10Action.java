package com.jyyr.strtus.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jyyr.orm.TbChnlMagrScoreDesc10M;
import com.jyyr.orm.TbChnlMagrScoreTop10M;
import com.jyyr.orm.TbCityMonDevScoreInfoM;
import com.jyyr.orm.TbCityMonDevScorePayInfoMon;
import com.jyyr.orm.TbCityPieceMClsInfoM;
import com.jyyr.orm.TbCountyServCntInfoD;
import com.jyyr.service.CityDesc10Service;
import com.jyyr.service.CityTop10Service;
import com.jyyr.service.TbCityMonDevScoreInfoMService;
import com.jyyr.service.TbCityMonDevScorePayInfoMonService;
import com.jyyr.service.TbCityPieceMClsInfoMService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class CityTop10Action extends ActionSupport implements ModelDriven<TbChnlMagrScoreTop10M> {

	CityTop10Service cityTop10Service;
	CityDesc10Service cityDesc10Service;
	TbCityMonDevScoreInfoMService tbCityMonDevScoreInfoMService;
	TbCityMonDevScorePayInfoMonService linService;
	TbCityPieceMClsInfoMService pieService;
	
	private TbChnlMagrScoreTop10M tbChnlMagrScoreTop10M; 
	private List<TbChnlMagrScoreTop10M> tbChnlMagrScoreTop10MList;
	
	private TbChnlMagrScoreDesc10M tbChnlMagrScoreDesc10M;
	private List<TbChnlMagrScoreDesc10M> tbChnlMagrScoreDesc10MList;
	
	private TbCityMonDevScoreInfoM tbCityMonDevScoreInfoM;
	private List<TbCityMonDevScoreInfoM> tbCityMonDevScoreInfoMList;
	
	//line
	private List<TbCityMonDevScorePayInfoMon> monList;
	private List<TbCityMonDevScorePayInfoMon> monlast;
	private TbCityMonDevScorePayInfoMon mon1;
	private TbCityMonDevScorePayInfoMon mon;
	private Float[] list1;
	private Float[] list2;
	private Float d;
	private Float e;
	//pie
	private List<TbCityPieceMClsInfoM> pieceList;
	private List<TbCountyServCntInfoD> countylist;
	private TbCityPieceMClsInfoM piece ;
	private TbCountyServCntInfoD county;
	private ArrayList a;
	private Float[] list3;
	private Float[] list4;
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
	private String userId;
    private String staticId;
    private String roleName;
	private String userName;
	private String regionId;
    private String regionName;

	private  String msg;
	private String msg1;

	TbChnlMagrScoreTop10M model=new TbChnlMagrScoreTop10M();	
	
	public String browserCityTop10() throws IOException {		
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		String statisMonth=cityTop10Service.findmaxmonth().getSTATIS_MONTH();
		tbChnlMagrScoreTop10MList=cityTop10Service.top10(statisMonth);
		if (tbChnlMagrScoreTop10MList != null) {
			for (int i=0;i<tbChnlMagrScoreTop10MList.size();i++) {
				tbChnlMagrScoreTop10M=tbChnlMagrScoreTop10MList.get(i);
				if (null==tbChnlMagrScoreTop10M){
					msg="没有您最新的数据";
				}else{
					msg="";
				}
			}
		}
		
		tbChnlMagrScoreDesc10MList=cityDesc10Service.desc10(statisMonth);
		if (tbChnlMagrScoreDesc10MList != null) {
			for (int i=0;i<tbChnlMagrScoreDesc10MList.size();i++) {
				tbChnlMagrScoreDesc10M=tbChnlMagrScoreDesc10MList.get(i);
				if (null==tbChnlMagrScoreDesc10M){
					msg="没有您最新的数据";
				}else{
					msg="";
				}
			}
		}
		
		tbCityMonDevScoreInfoMList=tbCityMonDevScoreInfoMService.getData(statisMonth);
		if (tbCityMonDevScoreInfoMList != null) {
			for (int i=0;i<tbCityMonDevScoreInfoMList.size();i++) {
				tbCityMonDevScoreInfoM=tbCityMonDevScoreInfoMList.get(i);
				if (null==tbCityMonDevScoreInfoM){
					msg="没有您最新的数据";
				}else{
					msg="";
				}
			}
		}
		
		monList=linService.findall();
		if (monList != null) {
			list1=new Float [monList.size()-1];
			for (int i=0;i<monList.size()-1;i++) {
				mon=monList.get(i);
			    list1[i]=monList.get(i).getTotalDevCnt();
			    System.out.println(list1[i]);
		   }
			d=monList.get(monList.size()-1).getTotalDevCnt();
			
			
		}
		
//		Calendar date=Calendar.getInstance();
//		date.add(Calendar.DATE,-1);
//		String statisDate=new SimpleDateFormat( "yyyyMMdd ").format(date.getTime());
		String statisDate=pieService.findmaxdate().get(0).getStatisDate();
		System.out.print(statisDate);

		
		
		pieceList=pieService.findpiece(statisDate);
		if (pieceList.size()==0){
		  msg="没有最新的数据";
		}else {
		  msg="";
		  list3=new Float [pieceList.size()];
			for (int i=0;i<pieceList.size();i++) {
				piece=pieceList.get(i);
			    list3[i]=pieceList.get(i).getPieceMClsServTotalCnt();
			    //System.out.println(list3[i]);
		   }
			//dai=list3[0];card=list3[1];
			data=list3[0];
			market=list3[1];tmnl=list3[2];
			
		}
			
			
		
		countylist=pieService.findcounty(statisDate);
		if(countylist.size()==0){
			msg1="没有最新的数据";
		}else {
			msg1="";
			list4=new Float [countylist.size()];
			for (int i=0;i<countylist.size();i++) {
				county=countylist.get(i);
			    list4[i]=countylist.get(i).getCountyServTotalCnt();
			    //System.out.println(list4[i]);
		   }
			
			bdh=list4[0];changli=list4[1];funing=list4[2];qinglong=list4[3];lulong=list4[4];shg=list4[5];
		}
	
		return SUCCESS;
	}
	public CityTop10Service getCityTop10Service() {
		return cityTop10Service;
	}
	public void setCityTop10Service(CityTop10Service cityTop10Service) {
		this.cityTop10Service = cityTop10Service;
	}

	public TbChnlMagrScoreTop10M getModel() {
		return model;
	}
	public void setModel(TbChnlMagrScoreTop10M model) {
		this.model = model;
	}

	public TbChnlMagrScoreTop10M getTbChnlMagrScoreTop10M() {
		return tbChnlMagrScoreTop10M;
	}
	public void setTbChnlMagrScoreTop10M(TbChnlMagrScoreTop10M tbChnlMagrScoreTop10M) {
		this.tbChnlMagrScoreTop10M = tbChnlMagrScoreTop10M;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<TbChnlMagrScoreTop10M> getTbChnlMagrScoreTop10MList() {
		return tbChnlMagrScoreTop10MList;
	}
	public void setTbChnlMagrScoreTop10MList(
			List<TbChnlMagrScoreTop10M> tbChnlMagrScoreTop10MList) {
		this.tbChnlMagrScoreTop10MList = tbChnlMagrScoreTop10MList;
	}

	public CityDesc10Service getCityDesc10Service() {
		return cityDesc10Service;
	}

	public void setCityDesc10Service(CityDesc10Service cityDesc10Service) {
		this.cityDesc10Service = cityDesc10Service;
	}

	public TbChnlMagrScoreDesc10M getTbChnlMagrScoreDesc10M() {
		return tbChnlMagrScoreDesc10M;
	}

	public void setTbChnlMagrScoreDesc10M(
			TbChnlMagrScoreDesc10M tbChnlMagrScoreDesc10M) {
		this.tbChnlMagrScoreDesc10M = tbChnlMagrScoreDesc10M;
	}

	public List<TbChnlMagrScoreDesc10M> getTbChnlMagrScoreDesc10MList() {
		return tbChnlMagrScoreDesc10MList;
	}

	public void setTbChnlMagrScoreDesc10MList(
			List<TbChnlMagrScoreDesc10M> tbChnlMagrScoreDesc10MList) {
		this.tbChnlMagrScoreDesc10MList = tbChnlMagrScoreDesc10MList;
	}
	public TbCityMonDevScoreInfoMService getTbCityMonDevScoreInfoMService() {
		return tbCityMonDevScoreInfoMService;
	}
	public void setTbCityMonDevScoreInfoMService(
			TbCityMonDevScoreInfoMService tbCityMonDevScoreInfoMService) {
		this.tbCityMonDevScoreInfoMService = tbCityMonDevScoreInfoMService;
	}
	public TbCityMonDevScoreInfoM getTbCityMonDevScoreInfoM() {
		return tbCityMonDevScoreInfoM;
	}
	public void setTbCityMonDevScoreInfoM(
			TbCityMonDevScoreInfoM tbCityMonDevScoreInfoM) {
		this.tbCityMonDevScoreInfoM = tbCityMonDevScoreInfoM;
	}
	public List<TbCityMonDevScoreInfoM> getTbCityMonDevScoreInfoMList() {
		return tbCityMonDevScoreInfoMList;
	}
	public void setTbCityMonDevScoreInfoMList(
			List<TbCityMonDevScoreInfoM> tbCityMonDevScoreInfoMList) {
		this.tbCityMonDevScoreInfoMList = tbCityMonDevScoreInfoMList;
	}
	public TbCityMonDevScorePayInfoMonService getLinService() {
		return linService;
	}
	public void setLinService(TbCityMonDevScorePayInfoMonService linService) {
		this.linService = linService;
	}
	public List<TbCityMonDevScorePayInfoMon> getMonList() {
		return monList;
	}
	public void setMonList(List<TbCityMonDevScorePayInfoMon> monList) {
		this.monList = monList;
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
	public TbCityMonDevScorePayInfoMon getMon() {
		return mon;
	}
	public void setMon(TbCityMonDevScorePayInfoMon mon) {
		this.mon = mon;
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
	public Float getD() {
		return d;
	}
	public void setD(Float d) {
		this.d = d;
	}
	public Float getE() {
		return e;
	}
	public void setE(Float e) {
		this.e = e;
	}
	public TbCityPieceMClsInfoMService getPieService() {
		return pieService;
	}
	public void setPieService(TbCityPieceMClsInfoMService pieService) {
		this.pieService = pieService;
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
	public Float[] getList3() {
		return list3;
	}
	public void setList3(Float[] list3) {
		this.list3 = list3;
	}
	public Float[] getList4() {
		return list4;
	}
	public void setList4(Float[] list4) {
		this.list4 = list4;
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
	public String getMsg1() {
		return msg1;
	}
	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStaticId() {
		return staticId;
	}
	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	

	
}

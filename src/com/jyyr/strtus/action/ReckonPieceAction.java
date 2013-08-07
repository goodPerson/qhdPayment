package com.jyyr.strtus.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyyr.orm.*;
import com.jyyr.service.*;
import com.jyyr.utitly.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * �����Ƽ���Ŀ����ϸ��Ϣ��ѯAction
 * @author ywz
 *
 */

public class ReckonPieceAction extends ActionSupport implements ModelDriven<TbReckonPiecePayDealInfoD>{

	/** ͨ������ע��TbReckonPiecePayDealInfoDService���ʵ�� */
	TbReckonPiecePayDealInfoDService reckonPayService;
	/** �ҵ�н��������������г��õĲ���ֵ */
	private String workerID; //���ֱ��
	public TbReckonPiecePayDealInfoD  tbReckonInfo; //����������ϸ��Ϣ
	private int monthDayCounts;//�����������
	private StringBuffer  temptdsbTitle; //��ʱ<td>��װ
	private StringBuffer  temptdsbData; //��ʱ������װ
	private int pageSize; //ÿҳ��ʾ����
	private int pager; //��ǰҳ��	
	private TbMagerDayCounts tbMagerDayCounts;  //����������ͳ��
	private TbMangerMonthBigClassCounts tbMangerMonthBigClassCounts; //�����������ҵ��ͳ��
	DateUtil du;  //���ڹ�����
	private String staticId;//���ֹ���
	private String roleName;
    private String userName;
	private String regionId;
    private String regionName;
	//	private List<TbReckonPiecePayDealInfoD> tdList;
	private List<TbReckonPiecePayDealInfoD> tempTd;
	

	//����ģ������
	private TbReckonPiecePayDealInfoD model=new TbReckonPiecePayDealInfoD();//���ڷ�װ��Ա����ģ��
	public TbReckonPiecePayDealInfoD getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	/**
	 * ������
	 * @return
	 */
 	public String pieceDetailInfo(){
		return SUCCESS;
	}
 	
 	/**
 	 * �����������ҵ�񽱽�ͳ�ƣ�������
 	 */
 	public String magerBigClassCounts(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
//**********************�����������ҵ�񽱽�ͳ��  ��ʼ  ********************************************	
		String curDay=DateUtil.getYearMonthDay();
		String beforeDay=DateUtil.getSpecifiedDayBefore(curDay);
		tbMangerMonthBigClassCounts=reckonPayService.magerBigClassPayCount(workerID);		
//**********************�����������ҵ�񽱽�ͳ��  ����  ********************************************	
 		return SUCCESS;
 	}
 	
 	/** ����������ͳ�� ��ҳ��һ�����
	 * @throws IOException */
	public String chnlMagerDayCounts() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		
//**********************����������ͳ��  ��ʼ  ********************************************		
		String curDay=DateUtil.getYearMonthDay();
		String beforeDay=DateUtil.getSpecifiedDayBefore(curDay);
		tbMagerDayCounts=reckonPayService.ChnlMagerDayCount(workerID);
		JSONObject jsonObjectMagerDayCounts = new JSONObject();
		jsonObjectMagerDayCounts.put("date", tbMagerDayCounts.getStatisDate()); //����
		jsonObjectMagerDayCounts.put("county", tbMagerDayCounts.getCountry()); //����
		jsonObjectMagerDayCounts.put("name", tbMagerDayCounts.getName());									//����
		jsonObjectMagerDayCounts.put("nameid", tbMagerDayCounts.getStaffId());		//����
		jsonObjectMagerDayCounts.put("chnlcounts", tbMagerDayCounts.getPrncpChnlCnt()); //����������������
		jsonObjectMagerDayCounts.put("dayscore", tbMagerDayCounts.getCurDaytotalScore());								//�ջ���
		jsonObjectMagerDayCounts.put("monthscore", tbMagerDayCounts.getCurMonTotalScore()); //�����ܻ���
		jsonObjectMagerDayCounts.put("monthpay", tbMagerDayCounts.getCurMonTotalPay()); //������н��
	
		JSONObject jsonObjectFinal = new JSONObject();
		jsonObjectFinal.put("rows", jsonObjectMagerDayCounts);
		PrintWriter printWriter = response.getWriter();
		printWriter.print("["+jsonObjectMagerDayCounts.toString()+"]");
		printWriter.flush();
		printWriter.close();		
//**********************����������ͳ��  ����  ********************************************
		

		
		return SUCCESS;
}
	/** ������������Ա������ 
	 * @throws IOException */
	public String browTd() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
	
		//�������������Ϣ
		tbReckonInfo=reckonPayService.loadTbrppdinif(workerID);

        temptdsbTitle=new StringBuffer("");
        temptdsbData=new StringBuffer("");
//		�����������
        monthDayCounts=du.getCurrentMonthLastDay();
        for (int i=1;i<=monthDayCounts;i++){
        	String j="1";
        	if(i<10){
        		j="0"+i;
        	}else{
        		j=""+i;
        	}
        	temptdsbTitle.append(j+",");
        	temptdsbData.append("");
        }   
        
//        int queryCounts=reckonPayService.queryCountsDetail(workerID, reckonPayService.getYearMonthDay(), pageSize, pager);
        int queryCounts=reckonPayService.queryCountsDetail(workerID, DateUtil.getSpecifiedDayBefore(DateUtil.getYearMonthDay()).substring(0, 6), pageSize, pager);
        tempTd=reckonPayService.browserBusDetail(workerID, DateUtil.getSpecifiedDayBefore(DateUtil.getYearMonthDay()).substring(0, 6), pageSize, pager);
        JSONArray jsonArray = new JSONArray();   //json����
  		if (tempTd != null) {
  			for (TbReckonPiecePayDealInfoD tdDeal : tempTd) {
  				JSONObject jsonObject = new JSONObject();
  				jsonObject.put("month", tdDeal.getStatisDate());
  				jsonObject.put("county", tdDeal.getCountyName());
  				jsonObject.put("name", tdDeal.getName());
  				jsonObject.put("workerNo", tdDeal.getMonSumPay());
  				jsonObject.put("agency", tdDeal.getMonSumPay());
  				jsonObject.put("card", tdDeal.getMonSumPay());
  				jsonObject.put("term", tdDeal.getMonSumPay());
  				jsonObject.put("data", tdDeal.getMonSumPay());
  				jsonObject.put("active", tdDeal.getMonSumPay());
  				jsonObject.put("sumpay", tdDeal.getMonSumPay());
  				jsonObject.put("sumpay", tdDeal.getMonSumPay());
  				jsonArray.add(jsonObject);
  			}
  			JSONObject jsonObjectFinal = new JSONObject();
  			jsonObjectFinal.put("rows", jsonArray);
  			jsonObjectFinal.put("total", queryCounts);
  			PrintWriter printWriter = response.getWriter();
  			printWriter.print(jsonObjectFinal.toString());
  			printWriter.flush();
  			printWriter.close();
  		}
        return INPUT;
	}

	public TbReckonPiecePayDealInfoDService getReckonPayService() {
		return reckonPayService;
	}

	public void setReckonPayService(
			TbReckonPiecePayDealInfoDService reckonPayService) {
		this.reckonPayService = reckonPayService;
	}

	public String getWorkerID() {
		return workerID;
	}

	public void setWorkerID(String workerID) {
		this.workerID = workerID;
	}
	
	public TbReckonPiecePayDealInfoD getTbReckonInfo() {
		return tbReckonInfo;
	}

	public void setTbReckonInfo(TbReckonPiecePayDealInfoD tbReckonInfo) {
		this.tbReckonInfo = tbReckonInfo;
	}
	
	public StringBuffer getTemptdsbTitle() {
		return temptdsbTitle;
	}

	public void setTemptdsbTitle(StringBuffer temptdsbTitle) {
		this.temptdsbTitle = temptdsbTitle;
	}

	public StringBuffer getTemptdsbData() {
		return temptdsbData;
	}

	public void setTemptdsbData(StringBuffer temptdsbData) {
		this.temptdsbData = temptdsbData;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPager() {
		return pager;
	}

	public void setPager(int pager) {
		this.pager = pager;
	}

	public int getMonthDayCounts() {
		return monthDayCounts;
	}

	public void setMonthDayCounts(int monthDayCounts) {
		this.monthDayCounts = monthDayCounts;
	}
	
	public TbMagerDayCounts getTbMagerDayCounts() {
		return tbMagerDayCounts;
	}
	public void setTbMagerDayCounts(TbMagerDayCounts tbMagerDayCounts) {
		this.tbMagerDayCounts = tbMagerDayCounts;
	}
	
	public List<TbReckonPiecePayDealInfoD> getTempTd() {
		return tempTd;
	}
	public void setTempTd(List<TbReckonPiecePayDealInfoD> tempTd) {
		this.tempTd = tempTd;
	}
	
	public TbMangerMonthBigClassCounts getTbMangerMonthBigClassCounts() {
		return tbMangerMonthBigClassCounts;
	}

	public void setTbMangerMonthBigClassCounts(
			TbMangerMonthBigClassCounts tbMangerMonthBigClassCounts) {
		this.tbMangerMonthBigClassCounts = tbMangerMonthBigClassCounts;
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

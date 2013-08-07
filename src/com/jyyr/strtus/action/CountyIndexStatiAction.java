package com.jyyr.strtus.action;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import com.jyyr.service.TbBasicInfoMService;
import com.jyyr.service.TbCountryChnlDescDayService;
import com.jyyr.service.TbCountryCntDayService;
import com.jyyr.service.TbCountryCountsMonthService;
import com.jyyr.service.TbCountryTopDayService;
import com.jyyr.service.TbCountyStaticMonthService;
import com.jyyr.orm.TbCountryChnlDescDay;
import com.jyyr.orm.TbCountryCntDay;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.orm.TbCountryCountsMonth;
import com.jyyr.orm.TbCountryTopDay;
import com.jyyr.orm.TbCountyStaticMonth;
import	com.jyyr.utitly.DateUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class CountyIndexStatiAction extends ActionSupport implements ModelDriven<TbCountryCntDay> {
	/**
	 * ����Ҫ��ҵ���ӿ�
	 */
	TbCountryCntDayService service; //����������ͳ��ҵ���ӿ�
	TbBasicInfoMService basicInfoMService; //�������������Ϣ�ӿ�
	TbCountryCountsMonthService countyMonthCountsService;	//���ظ�����ÿ�����ͳ��
	TbCountyStaticMonthService countyStaticMonthService; //�»�������ͼ
	TbCountryTopDayService countryTopDayService;//��������ǰ10���ӿ�
	TbCountryChnlDescDayService countryChnlDescDayService;//���������10���ӿ�

	/**
	 * ����Ҫ�Ĳ���
	 */
    private String userId;
    private String roleName;
    private String userName;
    private String regionId;
    private String regionName;
	private	String	staticId; //���ֹ���
	private	String	countyMagerName; //���ظ���������
	private	String	countyPost; //���ظ�����ְλ
	private	String	county; //��������
	private	String	staticDate;//ͳ������
	private	String	msg="";	//������Ϣ
	/**
	 * ����Ҫ��ʵ����
	 */
	TbBasicInfoM tbBasicInfoM;  //��������ʵ����
	TbCountryCountsMonth	countyCountMonth;	//����ͳ�ƴ���
	TbCountyStaticMonth  countyStaticMonthScore; //����ÿ�»���ͳ��
	TbCountyStaticMonth  countyStaticMonthCnt; //����ÿ��ҵ������ͳ��
	List<TbCountryTopDay> countyTopDayList; //����ǰ10��
	List<TbCountryChnlDescDay>	countryChnlDescDayList;//������10��
	
	
	private TbCountryCntDay model=new TbCountryCntDay();  //����������ͳ��
	public void setModel(TbCountryCntDay model) {
		this.model = model;
	}


	public TbCountryCntDay getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	

	/**
	 * ����ͳ��
	 * @return
	 */
	public String countyStatis(){
		tbBasicInfoM=basicInfoMService.loadBasicInfo(staticId);	
		countyPost=tbBasicInfoM.getPost();//���ؾ���ְλ
		county=tbBasicInfoM.getCountyName();//��������
		countyMagerName=tbBasicInfoM.getName();//���ظ���������
//		staticDate=DateUtil.getSpecifiedDayBefore(DateUtil.getYearMonthDay()); //��ȡͳ�����ڵ�ǰһ��
		staticDate=countyMonthCountsService.findMaxdate().get(0).getStatisMonth();
		/**���ظ�������ͳ��*/
		if (service.isExists(county, staticDate))			
			model=service.loadTbCountryCntDay(county, staticDate);	//��ȡ���ظ�������ͳ������
		
			
		/**���ش���ҵ�����ͳ��*/
		if(countyMonthCountsService.isExists(staticDate, county))
			countyCountMonth=countyMonthCountsService.loadAssignCountyMonth(staticDate, county);
		else
			msg="û�����������";
		countyStaticMonthScore=countyStaticMonthService.loadrecently(county, staticDate.substring(0, 4),"score");
		countyStaticMonthCnt=countyStaticMonthService.loadrecently(county, staticDate.substring(0, 4),"cnt");

		/**��������ǰ10��*/
		if (countryTopDayService.isExists(staticDate, county)){
			countyTopDayList=countryTopDayService.loadCountyMagerTop(staticDate, county);
           // if (countyTopDayList!=null){
           // 	for(TbCountryTopDay tbtd : countyTopDayList){
           // 		System.out.println(tbtd.getCounty());
           // 		System.out.println(tbtd.getChnlMagrName());
           // 	}
           // }
			
		}
		
		/**���������10��*/
		if (countryChnlDescDayService.isExists(staticDate, county))
			countryChnlDescDayList=countryChnlDescDayService.loadTbCountryChnlDescDay(staticDate, county);
		System.out.print(countryChnlDescDayList.size());
		
		
		
		
		return SUCCESS;
	}


	public TbCountryCntDayService getService() {
		return service;
	}


	public void setService(TbCountryCntDayService service) {
		this.service = service;
	}


	public TbBasicInfoMService getBasicInfoMService() {
		return basicInfoMService;
	}


	public void setBasicInfoMService(TbBasicInfoMService basicInfoMService) {
		this.basicInfoMService = basicInfoMService;
	}


	public TbCountryCountsMonthService getCountyMonthCountsService() {
		return countyMonthCountsService;
	}


	public void setCountyMonthCountsService(
			TbCountryCountsMonthService countyMonthCountsService) {
		this.countyMonthCountsService = countyMonthCountsService;
	}


	public TbCountyStaticMonthService getCountyStaticMonthService() {
		return countyStaticMonthService;
	}


	public void setCountyStaticMonthService(
			TbCountyStaticMonthService countyStaticMonthService) {
		this.countyStaticMonthService = countyStaticMonthService;
	}

	public String getStaticId() {
		return staticId;
	}


	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}


	public String getCountyMagerName() {
		return countyMagerName;
	}


	public void setCountyMagerName(String countyMagerName) {
		this.countyMagerName = countyMagerName;
	}


	public String getCountyPost() {
		return countyPost;
	}


	public void setCountyPost(String countyPost) {
		this.countyPost = countyPost;
	}


	public String getCounty() {
		return county;
	}


	public void setCounty(String county) {
		this.county = county;
	}


	public String getStaticDate() {
		return staticDate;
	}


	public void setStaticDate(String staticDate) {
		this.staticDate = staticDate;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public TbBasicInfoM getTbBasicInfoM() {
		return tbBasicInfoM;
	}


	public void setTbBasicInfoM(TbBasicInfoM tbBasicInfoM) {
		this.tbBasicInfoM = tbBasicInfoM;
	}


	public TbCountryCountsMonth getCountyCountMonth() {
		return countyCountMonth;
	}


	public void setCountyCountMonth(TbCountryCountsMonth countyCountMonth) {
		this.countyCountMonth = countyCountMonth;
	}


	public TbCountyStaticMonth getCountyStaticMonthScore() {
		return countyStaticMonthScore;
	}


	public void setCountyStaticMonthScore(TbCountyStaticMonth countyStaticMonthScore) {
		this.countyStaticMonthScore = countyStaticMonthScore;
	}


	public TbCountyStaticMonth getCountyStaticMonthCnt() {
		return countyStaticMonthCnt;
	}


	public void setCountyStaticMonthCnt(TbCountyStaticMonth countyStaticMonthCnt) {
		this.countyStaticMonthCnt = countyStaticMonthCnt;
	}


	public List<TbCountryTopDay> getCountyTopDayList() {
		return countyTopDayList;
	}


	public void setCountyTopDayList(List<TbCountryTopDay> countyTopDayList) {
		this.countyTopDayList = countyTopDayList;
	}


	public TbCountryTopDayService getCountryTopDayService() {
		return countryTopDayService;
	}


	public void setCountryTopDayService(TbCountryTopDayService countryTopDayService) {
		this.countryTopDayService = countryTopDayService;
	}


	public TbCountryChnlDescDayService getCountryChnlDescDayService() {
		return countryChnlDescDayService;
	}


	public void setCountryChnlDescDayService(
			TbCountryChnlDescDayService countryChnlDescDayService) {
		this.countryChnlDescDayService = countryChnlDescDayService;
	}


	public List<TbCountryChnlDescDay> getCountryChnlDescDayList() {
		return countryChnlDescDayList;
	}


	public void setCountryChnlDescDayList(
			List<TbCountryChnlDescDay> countryChnlDescDayList) {
		this.countryChnlDescDayList = countryChnlDescDayList;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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

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
	 * 所需要的业务层接口
	 */
	TbCountryCntDayService service; //渠道经理日统计业务层接口
	TbBasicInfoMService basicInfoMService; //渠道经理基础信息接口
	TbCountryCountsMonthService countyMonthCountsService;	//区县负责人每天大类统计
	TbCountyStaticMonthService countyStaticMonthService; //月积分折线图
	TbCountryTopDayService countryTopDayService;//渠道经理前10名接口
	TbCountryChnlDescDayService countryChnlDescDayService;//渠道经理后10名接口

	/**
	 * 所需要的参数
	 */
    private String userId;
    private String roleName;
    private String userName;
    private String regionId;
    private String regionName;
	private	String	staticId; //经分工号
	private	String	countyMagerName; //区县负责人姓名
	private	String	countyPost; //区县负责人职位
	private	String	county; //区县名称
	private	String	staticDate;//统计日期
	private	String	msg="";	//返回消息
	/**
	 * 所需要的实体类
	 */
	TbBasicInfoM tbBasicInfoM;  //渠道经理实体类
	TbCountryCountsMonth	countyCountMonth;	//区县统计大类
	TbCountyStaticMonth  countyStaticMonthScore; //整年每月积分统计
	TbCountyStaticMonth  countyStaticMonthCnt; //整年每月业务数量统计
	List<TbCountryTopDay> countyTopDayList; //排名前10名
	List<TbCountryChnlDescDay>	countryChnlDescDayList;//排名后10名
	
	
	private TbCountryCntDay model=new TbCountryCntDay();  //渠道经理日统计
	public void setModel(TbCountryCntDay model) {
		this.model = model;
	}


	public TbCountryCntDay getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	

	/**
	 * 区县统计
	 * @return
	 */
	public String countyStatis(){
		tbBasicInfoM=basicInfoMService.loadBasicInfo(staticId);	
		countyPost=tbBasicInfoM.getPost();//区县经理职位
		county=tbBasicInfoM.getCountyName();//区县名称
		countyMagerName=tbBasicInfoM.getName();//区县负责人名称
//		staticDate=DateUtil.getSpecifiedDayBefore(DateUtil.getYearMonthDay()); //获取统计日期的前一天
		staticDate=countyMonthCountsService.findMaxdate().get(0).getStatisMonth();
		/**区县负责人日统计*/
		if (service.isExists(county, staticDate))			
			model=service.loadTbCountryCntDay(county, staticDate);	//获取区县负责人日统计数据
		
			
		/**区县大类业务积分统计*/
		if(countyMonthCountsService.isExists(staticDate, county))
			countyCountMonth=countyMonthCountsService.loadAssignCountyMonth(staticDate, county);
		else
			msg="没有昨天的数据";
		countyStaticMonthScore=countyStaticMonthService.loadrecently(county, staticDate.substring(0, 4),"score");
		countyStaticMonthCnt=countyStaticMonthService.loadrecently(county, staticDate.substring(0, 4),"cnt");

		/**渠道经理前10名*/
		if (countryTopDayService.isExists(staticDate, county)){
			countyTopDayList=countryTopDayService.loadCountyMagerTop(staticDate, county);
           // if (countyTopDayList!=null){
           // 	for(TbCountryTopDay tbtd : countyTopDayList){
           // 		System.out.println(tbtd.getCounty());
           // 		System.out.println(tbtd.getChnlMagrName());
           // 	}
           // }
			
		}
		
		/**渠道经理后10名*/
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

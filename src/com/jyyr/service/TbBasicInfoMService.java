package com.jyyr.service;
import java.util.List;


import com.jyyr.orm. TbBasicInfoM;
/**
 *  渠道经历基础信息表接口
 * @author kb
 *
 */
public interface TbBasicInfoMService {

	/** 浏览员工基础信息 */
	public List<TbBasicInfoM> browseBasicInfoMs(int pageNo, int pageSize);
	/** 统计员工总数 */
	public int countBasicInfoM();
	/** 装载指定的员工 */	
	public List<TbBasicInfoM> findBasicInfoM(String fromdate,String todate,String county,String area, String name,String id,int pageNo,int pageSize);
	public List<TbBasicInfoM> findBasicInfoM1(String fromdate,String todate,String county,String area, String name,String id);
	/** 删除指定的员工 */	
	public boolean delBasicInfoM(String id);	
	/** 新增或修改员工 */
	public boolean saveOrUpdateBasicInfoM(TbBasicInfoM basicInfoM);
	/** 浏览县区 */
	public List<String> browseCounty(String countyName);
	/** 浏览区域 */
	public List<String> browseArea(String countyName);
	/** 判断工号是否存在*/
	public boolean isIdExist(String id);
	/**根据id获得员工信息*/
	public List<TbBasicInfoM> findUserById(String id);
	/**
	 * 装载制定渠道经理的信息
	 * */
	public TbBasicInfoM loadBasicInfo(String staticId);
	
}

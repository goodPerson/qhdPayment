package com.jyyr.service.impl;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbCountryCntDay;
import com.jyyr.service.TbCountryCntDayService;

public class TbCountryCntDayServiceImpl implements TbCountryCntDayService {
	BaseDAO dao;
	/**
	 * 装载制定日期的区县日统计
	 */
	public TbCountryCntDay loadTbCountryCntDay(String county,String staticDate) {
		// TODO Auto-generated method stub
		String hql="from TbCountryCntDay as a where a.county='"+ county +"' and a.statisDate='"+ staticDate +"' ";
		return (TbCountryCntDay) dao.loadObject(hql);
	}
	
	/**
	 * 判断指定条查询是否存在记录
	 * @param county
	 * @param staticDate
	 * @return
	 */
	public boolean isExists(String county, String staticDate) {
		// TODO Auto-generated method stub
		boolean isHave=false;
		String hql="select count(*) from TbCountryCntDay as a where a.county='"+ county +"' and a.statisDate='"+ staticDate +"' ";
		if (dao.countQuery(hql)>0)
			return true;
		return isHave;
	}
	
	public BaseDAO getDao() {
		return dao;
	}
	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}


	
	

}

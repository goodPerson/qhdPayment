package com.jyyr.service.impl;

import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbCountryTopDay;
import com.jyyr.service.TbCountryTopDayService;

public class TbCountryTopDayServiceImpl implements TbCountryTopDayService {
	BaseDAO dao;

	public List<TbCountryTopDay> loadCountyMagerTop(String statisDate ,String county) {
		// TODO Auto-generated method stub
		String hql="from TbCountryTopDay as a where a.statisDate='"+ statisDate +"' and a.county='"+ county +"' order by a.countyOrder asc";
		return dao.query(hql);
	}
	/**
	 * 判断是否存在最近的记录
	 * @param statisDate
	 * @param county
	 * @return
	 */
	public boolean isExists(String statisDate, String county) {
		// TODO Auto-generated method stub
		String hql="select count(*) from TbCountryTopDay as a where a.statisDate='"+ statisDate +"' and a.county='"+ county +"'";
		if (dao.countQuery(hql)>0)
			return true;
		return false;
	}
	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}
	
	
}

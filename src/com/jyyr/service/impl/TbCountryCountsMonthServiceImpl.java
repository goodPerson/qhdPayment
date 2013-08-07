package com.jyyr.service.impl;

import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbCountryCountsMonth;
import com.jyyr.service.TbCountryCountsMonthService;

public class TbCountryCountsMonthServiceImpl implements TbCountryCountsMonthService  {
	BaseDAO dao;
	
	
	public BaseDAO getDao() {
		return dao;
	}


	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}


	/**
	 * 装载制定的区县统计
	 * @param statisMonth
	 * @param county
	 * @return
	 */
	public TbCountryCountsMonth loadAssignCountyMonth(String statisMonth,
			String county) {
		// TODO Auto-generated method stub
		String hql="from TbCountryCountsMonth as a where a.statisMonth='"+ statisMonth +"' and a.county='"+ county +"'";
		return (TbCountryCountsMonth) dao.loadObject(hql);
	}


	public boolean isExists(String statisMonth, String county) {
		// TODO Auto-generated method stub
		String hql="select count(*) from TbCountryCountsMonth as a where a.statisMonth='"+ statisMonth +"' and a.county='"+ county +"'";
		if (dao.countQuery(hql)>0)
			return true;
		return false;
	}


	public List<TbCountryCountsMonth> findMaxdate() {
		String hql="from TbCountryCountsMonth as a order by a.statisMonth desc";
		return dao.query(hql);
	}
	

}

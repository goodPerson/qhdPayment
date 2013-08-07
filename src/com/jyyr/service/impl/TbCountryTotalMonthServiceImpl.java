package com.jyyr.service.impl;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbCountryTotalMonth;
import com.jyyr.service.TbCountryTotalMonthService;

public class TbCountryTotalMonthServiceImpl implements TbCountryTotalMonthService {
	BaseDAO dao;
	public TbCountryTotalMonth loadCountryTotalMonth(String statisMonth,
			String county) {
		// TODO Auto-generated method stub
		String hql="from TbCountryTotalMonth as where a.statisMonth='"+ statisMonth +"' and a.county='"+ county +"' ";
		return (TbCountryTotalMonth) dao.loadObject(hql);
	}
	public BaseDAO getDao() {
		return dao;
	}
	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	
}

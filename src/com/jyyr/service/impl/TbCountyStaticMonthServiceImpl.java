package com.jyyr.service.impl;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbCountyStaticMonth;
import com.jyyr.service.TbCountyStaticMonthService;

public class TbCountyStaticMonthServiceImpl implements TbCountyStaticMonthService {
	BaseDAO dao;
	public TbCountyStaticMonth loadrecently(String county, String staticMonth ,String sType) {
		// TODO Auto-generated method stub
		String hql="from TbCountyStaticMonth as a where a.static_month like '%"+ staticMonth +"%' and a.county_name='"+ county +"' and a.stype='"+ sType+"'";
		return (TbCountyStaticMonth) dao.loadObject(hql);
	}
	public BaseDAO getDao() {
		return dao;
	}
	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

}

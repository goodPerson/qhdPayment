package com.jyyr.service.impl;

import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbCountryChnlDescDay;
import com.jyyr.service.TbCountryChnlDescDayService;

public class TbCountryChnlDescDayServiceImpl implements TbCountryChnlDescDayService {
	BaseDAO dao;

	/**
	 * 装载后十名
	 * @param statisDate
	 * @param county
	 * @return
	 */
	public List<TbCountryChnlDescDay> loadTbCountryChnlDescDay(
			String statisDate, String county) {
		// TODO Auto-generated method stub
		String hql="from TbCountryChnlDescDay as a where a.statisDate='"+ statisDate +"' and a.county='"+ county +"' order by a.descOrder ";
		return dao.query(hql);
	}
	/**
	 * 是否存在
	 * @param statisDate
	 * @param county
	 * @return
	 */
	public boolean isExists(String statisDate, String county) {
		// TODO Auto-generated method stub
		String hql="select count(*) from TbCountryChnlDescDay as a where a.statisDate='"+ statisDate +"' and a.county='"+ county +"'";
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

package com.jyyr.service.impl;

import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbCityPieceMClsInfoM;
import com.jyyr.orm.TbCountyServCntInfoD;
import com.jyyr.service.TbCityPieceMClsInfoMService;

public class TbCityPieceMClsInfoMServiceImpl implements  TbCityPieceMClsInfoMService{
	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	public List<TbCityPieceMClsInfoM> findpiece(String statisDate) {
		String hql="from TbCityPieceMClsInfoM as a where a.statisDate='"+statisDate+"'order by a.pieceMClsServName ";
		return dao.query(hql);
	}

	public List<TbCountyServCntInfoD> findcounty(String statisDate) {
		String hql="from TbCountyServCntInfoD as a where a.statisDate='"+statisDate+"'order by a.county";
		return dao.query(hql);
	}

	public List<TbCityPieceMClsInfoM> findmaxdate() {
		String hql=" from TbCityPieceMClsInfoM as a order by a.statisDate desc ";
		return dao.query(hql);
	}
	
	

}

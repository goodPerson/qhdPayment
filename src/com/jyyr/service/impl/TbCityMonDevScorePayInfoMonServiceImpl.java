package com.jyyr.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.record.formula.functions.Today;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbCityMonDevScorePayInfoMon;
import com.jyyr.service.TbCityMonDevScorePayInfoMonService;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;

public class TbCityMonDevScorePayInfoMonServiceImpl implements TbCityMonDevScorePayInfoMonService{
	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}
	public List<TbCityMonDevScorePayInfoMon> findall() {
		Date date=new Date();
		SimpleDateFormat dt= new SimpleDateFormat("yyyyMMdd");
		String day =dt.format(date);
		String year= day.substring(0, 4);
		String hql="from TbCityMonDevScorePayInfoMon as a where a.statisMonth like '"+year +"%'   order by a.statisMonth ";
		return dao.query(hql) ;
	}

	public List<TbCityMonDevScorePayInfoMon> findall1() {
		Date date=new Date();
		SimpleDateFormat dt= new SimpleDateFormat("yyyyMMdd");
		String day =dt.format(date);
		String year= day.substring(0, 4);
		int y=Integer.parseInt(year);
		String year1=Integer.toString(y-1);
		String hql="from TbCityMonDevScorePayInfoMon as a where a.statisMonth like '"+year1 +"%'   order by a.statisMonth ";
		return dao.query(hql) ;
		
	}
	

	
}

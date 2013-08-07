package com.jyyr.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbMangerMonthBigClassCounts;
import com.jyyr.service.TbMangerMonthBigClassCountsService;

public class TbMangerMonthBigClassCountsServiceImpl implements TbMangerMonthBigClassCountsService {
 
	BaseDAO dao;
	
	public List<TbMangerMonthBigClassCounts> browerTbMangerMonthBigClassCounts(
			String staffId, String staticDate, int pageSize, int pager) {
		// TODO Auto-generated method stub
		String hql="from TbMangerMonthBigClassCounts as a where a.staffId='"+staffId+"' and a.statisMonth like '%"+ staticDate.substring(0, 6) +"%'";
//		 and a.statisMonth >='"+ getMonthFirstDay() +"'
		List temList=dao.listCondition(hql, pageSize, pager);		
		
		List<TbMangerMonthBigClassCounts> list=new ArrayList<TbMangerMonthBigClassCounts>();
		for(int i=0;i<temList.size();i++){
			TbMangerMonthBigClassCounts tbMangerMonthBigClassCounts = (TbMangerMonthBigClassCounts) temList.get(i);
			list.add(tbMangerMonthBigClassCounts);
		}		
		return list;
	}
	
	public int bigClassCounts(String staffId,String staticDate){
		String hql="select count(*) from TbMangerMonthBigClassCounts as a where a.staffId='"+ staffId +"' and a.statisMonth like '%"+ staticDate.substring(0, 6) +"%'";
		return dao.countQuery(hql);
	}

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}
	//获取当月地天
	public static String getMonthFirstDay(){

		   Calendar cal = Calendar.getInstance();

		   Calendar f = (Calendar)cal.clone();

		   f.clear();

		f.set(Calendar.YEAR,cal.get(Calendar.YEAR));

		f.set(Calendar.MONTH,cal.get(Calendar.MONTH));

		String firstday = new SimpleDateFormat("yyyyMMdd").format(f.getTime());

		return firstday;

		}

	public List<TbMangerMonthBigClassCounts> loadTbMangerMonthBigClassCounts(
			String staffId, String staticDate) {
		// TODO Auto-generated method stub
		String hql="from TbMangerMonthBigClassCounts as a where a.staffId='"+staffId+"' and a.statisMonth like '%"+ staticDate.substring(0, 6) +"%'";
		return dao.query(hql);
	}

}

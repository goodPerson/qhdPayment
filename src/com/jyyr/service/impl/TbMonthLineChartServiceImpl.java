package com.jyyr.service.impl;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbMonthLineChart;
import com.jyyr.service.TbMonthLineChartService;

public class TbMonthLineChartServiceImpl implements TbMonthLineChartService {

	/**
	 * ��ͳ������ͼ ʵ����
	 */
	BaseDAO dao;
	/**
	 * װ���ƶ������������
	 */
	public TbMonthLineChart loadtbMonthLineChart(String id, String sType) {
		// TODO Auto-generated method stub
		String hql="from TbMonthLineChart as a where a.id='"+id+"' and a.stype='"+ sType +"' order by a.curyear desc";
		return (TbMonthLineChart) dao.loadObject(hql);
	}
	
	public BaseDAO getDao() {
		return dao;
	}
	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}
	
	

}

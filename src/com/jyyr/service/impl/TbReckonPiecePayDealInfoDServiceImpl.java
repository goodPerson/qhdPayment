package com.jyyr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbMagerDayCounts;
import com.jyyr.orm.TbMangerMonthBigClassCounts;
import com.jyyr.orm.TbReckonPiecePayDealInfoD;
import com.jyyr.service.TbReckonPiecePayDealInfoDService;

public class TbReckonPiecePayDealInfoDServiceImpl implements TbReckonPiecePayDealInfoDService {

	/** 通过依赖注入DAO组件实例 */	
	BaseDAO dao;
	
	
	
	/**
	 * 渠道经理日统计
	 */
	public TbMagerDayCounts ChnlMagerDayCount(String staffId ) {
		// TODO Auto-generated method stub
		String hql="from TbMagerDayCounts as a where a.staffId='"+staffId+"' order by a.statisDate desc";
		return (TbMagerDayCounts) dao.loadObject(hql);
	}	
	
	/**
	 * 装载渠道经理负责
	 */	
	
	public TbReckonPiecePayDealInfoD loadTbrppdinif(String staffId) {
		String hql = "from TbReckonPiecePayDealInfoD as a where a.staffId='"+staffId+"'";
		return (TbReckonPiecePayDealInfoD)dao.loadObject(hql);

	}
	/**
	 * 渠道经理渠道数量
	 */	
	public int chanlCounts(String param) {
		String hql="select count(*) from TbChnlIinfoM as a where a.id='"+param+"' ";
		return dao.countQuery(hql);
	}
	/**
	 * 渠道经理积分统计
	 */	
	public float scoreCounts(String param) {
		String hql="select sum(a.monSumDevScore) from TbReckonPiecePayDealInfoD as a where a.staffId='"+param+"' ";
		return dao.countQueryD(hql);
	}
	/**
	 * 渠道经理积分统计
	 */	
	public float scoreDayCounts(String param) {
		String hql="select sum(a.monSumDevScore) from TbReckonPiecePayDealInfoD as a where a.staffId='"+param+"'";
		return dao.countQueryD(hql);
	}
	/**
	 * 渠道经理薪酬统计
	 */	
	public float payCounts(String param) {
		String hql="select sum(a.monSumPay) from TbReckonPiecePayDealInfoD as a where a.staffId='"+param+"' ";
		return dao.countQueryD(hql);
	}
	
	/**
	 * 大类业务薪酬统计
	 */	
	public float bigClassPayCounts(String bigClassName, String workerNo) {
		// TODO Auto-generated method stub
		String hql="select sum(a.monSumPay) from TbReckonPiecePayDealInfoD as a where a.reckonPieceMClsName='"+bigClassName+"' and a.staffId='"+workerNo+"' ";
		return dao.countQueryD(hql);
	}

	
	/**获取 日积分*/
	public float scoreDayCounts(String workerNo,String yearMontheDay){
		final String hql="select sum(a.curDayDevScore)from TbReckonPiecePayDealInfoD as a where a.staffId='"+workerNo+"' and a.statisDate='"+yearMontheDay+"'";
		return dao.countQueryD(hql);
		
	}
	

	public BaseDAO getDao() {
		return dao;
	}
	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}
	//获取详细信息
	public List<TbReckonPiecePayDealInfoD> browserBusDetail(String workerNo,
			String yearMontheDay, int pageSize, int pager) {
		// TODO Auto-generated method stub
		String hql="from TbReckonPiecePayDealInfoD as a where a.staffId='"+ workerNo +"'";
		if(yearMontheDay!=null || yearMontheDay.length()>0)
			hql=hql+" and a.statisDate like '%"+yearMontheDay+"%'";
		List tempList=dao.listCondition(hql, pageSize, pager); //获取符合条件的详细信息
//		System.out.println(tempList.size());
		List<TbReckonPiecePayDealInfoD> list = new ArrayList<TbReckonPiecePayDealInfoD>(); //创建对象数组
		for (int i = 0; i < tempList.size(); i++) {
			TbReckonPiecePayDealInfoD tbReckonPieceContentInfoM = (TbReckonPiecePayDealInfoD) tempList.get(i);
			list.add(tbReckonPieceContentInfoM);
		}
		return list;
	}
	
//	获取详细信息数量
	public int queryCountsDetail(String workerNo, String yearMontheDay,
			int pageSize, int pager) {
		// TODO Auto-generated method stub
		String hql="select count (a) from TbReckonPiecePayDealInfoD as a where a.staffId='"+ workerNo +"'";
		if(yearMontheDay!=null || yearMontheDay.length()>0)
			hql=hql+" and a.statisDate like '%"+yearMontheDay+"%' ";
		return dao.countQuery(hql);
	}

	/**
	 * 渠道经理大类业务统计
	 */
	public TbMangerMonthBigClassCounts magerBigClassPayCount(String staffId) {
		// TODO Auto-generated method stub
		String hql="from TbMangerMonthBigClassCounts as a where a.staffId='"+staffId+"' order by a.statisMonth desc ";
		return (TbMangerMonthBigClassCounts) dao.loadObject(hql);
	}

}

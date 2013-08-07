package com.jyyr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbMagerDayCounts;
import com.jyyr.orm.TbMangerMonthBigClassCounts;
import com.jyyr.orm.TbReckonPiecePayDealInfoD;
import com.jyyr.service.TbReckonPiecePayDealInfoDService;

public class TbReckonPiecePayDealInfoDServiceImpl implements TbReckonPiecePayDealInfoDService {

	/** ͨ������ע��DAO���ʵ�� */	
	BaseDAO dao;
	
	
	
	/**
	 * ����������ͳ��
	 */
	public TbMagerDayCounts ChnlMagerDayCount(String staffId ) {
		// TODO Auto-generated method stub
		String hql="from TbMagerDayCounts as a where a.staffId='"+staffId+"' order by a.statisDate desc";
		return (TbMagerDayCounts) dao.loadObject(hql);
	}	
	
	/**
	 * װ������������
	 */	
	
	public TbReckonPiecePayDealInfoD loadTbrppdinif(String staffId) {
		String hql = "from TbReckonPiecePayDealInfoD as a where a.staffId='"+staffId+"'";
		return (TbReckonPiecePayDealInfoD)dao.loadObject(hql);

	}
	/**
	 * ����������������
	 */	
	public int chanlCounts(String param) {
		String hql="select count(*) from TbChnlIinfoM as a where a.id='"+param+"' ";
		return dao.countQuery(hql);
	}
	/**
	 * �����������ͳ��
	 */	
	public float scoreCounts(String param) {
		String hql="select sum(a.monSumDevScore) from TbReckonPiecePayDealInfoD as a where a.staffId='"+param+"' ";
		return dao.countQueryD(hql);
	}
	/**
	 * �����������ͳ��
	 */	
	public float scoreDayCounts(String param) {
		String hql="select sum(a.monSumDevScore) from TbReckonPiecePayDealInfoD as a where a.staffId='"+param+"'";
		return dao.countQueryD(hql);
	}
	/**
	 * ��������н��ͳ��
	 */	
	public float payCounts(String param) {
		String hql="select sum(a.monSumPay) from TbReckonPiecePayDealInfoD as a where a.staffId='"+param+"' ";
		return dao.countQueryD(hql);
	}
	
	/**
	 * ����ҵ��н��ͳ��
	 */	
	public float bigClassPayCounts(String bigClassName, String workerNo) {
		// TODO Auto-generated method stub
		String hql="select sum(a.monSumPay) from TbReckonPiecePayDealInfoD as a where a.reckonPieceMClsName='"+bigClassName+"' and a.staffId='"+workerNo+"' ";
		return dao.countQueryD(hql);
	}

	
	/**��ȡ �ջ���*/
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
	//��ȡ��ϸ��Ϣ
	public List<TbReckonPiecePayDealInfoD> browserBusDetail(String workerNo,
			String yearMontheDay, int pageSize, int pager) {
		// TODO Auto-generated method stub
		String hql="from TbReckonPiecePayDealInfoD as a where a.staffId='"+ workerNo +"'";
		if(yearMontheDay!=null || yearMontheDay.length()>0)
			hql=hql+" and a.statisDate like '%"+yearMontheDay+"%'";
		List tempList=dao.listCondition(hql, pageSize, pager); //��ȡ������������ϸ��Ϣ
//		System.out.println(tempList.size());
		List<TbReckonPiecePayDealInfoD> list = new ArrayList<TbReckonPiecePayDealInfoD>(); //������������
		for (int i = 0; i < tempList.size(); i++) {
			TbReckonPiecePayDealInfoD tbReckonPieceContentInfoM = (TbReckonPiecePayDealInfoD) tempList.get(i);
			list.add(tbReckonPieceContentInfoM);
		}
		return list;
	}
	
//	��ȡ��ϸ��Ϣ����
	public int queryCountsDetail(String workerNo, String yearMontheDay,
			int pageSize, int pager) {
		// TODO Auto-generated method stub
		String hql="select count (a) from TbReckonPiecePayDealInfoD as a where a.staffId='"+ workerNo +"'";
		if(yearMontheDay!=null || yearMontheDay.length()>0)
			hql=hql+" and a.statisDate like '%"+yearMontheDay+"%' ";
		return dao.countQuery(hql);
	}

	/**
	 * �����������ҵ��ͳ��
	 */
	public TbMangerMonthBigClassCounts magerBigClassPayCount(String staffId) {
		// TODO Auto-generated method stub
		String hql="from TbMangerMonthBigClassCounts as a where a.staffId='"+staffId+"' order by a.statisMonth desc ";
		return (TbMangerMonthBigClassCounts) dao.loadObject(hql);
	}

}

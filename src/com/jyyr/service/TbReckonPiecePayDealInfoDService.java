package com.jyyr.service;
import java.util.List;

import com.jyyr.orm.TbMagerDayCounts;
import com.jyyr.orm.TbMangerMonthBigClassCounts;
import com.jyyr.orm.TbReckonPiecePayDealInfoD;
/**
 * �����Ƽ���Ŀ����ϸ��Ϣ��ѯ�ӿ�
 * @author ywz
 *
 */
public interface TbReckonPiecePayDealInfoDService {

	/**
	 * �����������ҵ��ͳ��
	 */
	public TbMangerMonthBigClassCounts magerBigClassPayCount(String staffId);
	/**
	 * ����������ͳ��
	 */
	public TbMagerDayCounts ChnlMagerDayCount(String staffId );
	
	
	/**
	 * װ��ָ����������ҵ����Ϣ
	 */
	public TbReckonPiecePayDealInfoD loadTbrppdinif(String staffId);
	
	/**
	 * ����������������
	 */
	public int chanlCounts(String param);
	
	/**
	 * �����������ͳ��
	 */	
	public float scoreCounts(String param);
	/**
	 * ��������н��ͳ��
	 */	
	public float payCounts(String param);
	/**
	 * ����ҵ��н��ͳ��
	 */	
	public float bigClassPayCounts(String bigClassName, String workerNo);
	
	
	/**��ȡ �ջ���*/
	public float scoreDayCounts(String workerNo,String yearMontheDay);
	
	/**�����ϸҵ����Ϣ*/
	public List<TbReckonPiecePayDealInfoD> browserBusDetail(String workerNo,String yearMontheDay, int pageSize, int pager);
	
	/**��ѯ��ϸҵ������*/
	public int queryCountsDetail(String workerNo,String yearMontheDay,int pageSize , int pager);
}

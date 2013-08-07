package com.jyyr.service;
import java.util.List;


import com.jyyr.orm. TbBasicInfoM;
/**
 *  ��������������Ϣ��ӿ�
 * @author kb
 *
 */
public interface TbBasicInfoMService {

	/** ���Ա��������Ϣ */
	public List<TbBasicInfoM> browseBasicInfoMs(int pageNo, int pageSize);
	/** ͳ��Ա������ */
	public int countBasicInfoM();
	/** װ��ָ����Ա�� */	
	public List<TbBasicInfoM> findBasicInfoM(String fromdate,String todate,String county,String area, String name,String id,int pageNo,int pageSize);
	public List<TbBasicInfoM> findBasicInfoM1(String fromdate,String todate,String county,String area, String name,String id);
	/** ɾ��ָ����Ա�� */	
	public boolean delBasicInfoM(String id);	
	/** �������޸�Ա�� */
	public boolean saveOrUpdateBasicInfoM(TbBasicInfoM basicInfoM);
	/** ������� */
	public List<String> browseCounty(String countyName);
	/** ������� */
	public List<String> browseArea(String countyName);
	/** �жϹ����Ƿ����*/
	public boolean isIdExist(String id);
	/**����id���Ա����Ϣ*/
	public List<TbBasicInfoM> findUserById(String id);
	/**
	 * װ���ƶ������������Ϣ
	 * */
	public TbBasicInfoM loadBasicInfo(String staticId);
	
}

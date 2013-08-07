package com.jyyr.service;
import java.util.List;

import com.jyyr.orm.TbAccomdCoffcntLinfoM;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.orm.TbChnlIinfoM;
/**
 * 2����������������Ϣ��ѯ��ά���ӿ�
 * @author kb��lyk
 *
 */
public interface TbChnlIinfoMService {
	
	/**
	 * ��ҳ��ѯ����ָ�������ļ�¼
	 */
	public List<TbChnlIinfoM> findChnl (String statisMonth,String statisMonth1,String county,String prncpArea,String id,String name,int pageNo,int pageSize );
	public List<TbChnlIinfoM> exportChnl(String statisMonth,String statisMonth1, String countyName,String prncpArea,
			String id, String name);
	/**
	 * �޸�������Ϣ
	 */
	public boolean saveOrUpdateCnl(TbChnlIinfoM cnl);
	/**
	 * ɾ��ָ��ID�ļ�¼
	 */
	public boolean delCnl (String id);
	/**
	 * ��ѯ������¼����
	 */
	public int countlist(String statisMonth,String statisMonth1,String countyName,String prncpArea,String id,String name);
	/**
	 * ��ѯ���е�����
	 */
	public List<String> findAllCounty(String countyName);
	/**
	 * ��ѯ���е��·�
	 */
	public List<String> findAllMonth();
	/**
	 * ��ѯ���е�����
	 */
	public List<String> findAllArea(String countyName);
	/**
	 * ��ѯ���е�����
	 */
	public List<String> findAllname();
	/**
	 * ��ѯָ��������ŵ���������
	 */
	public String findchnlname(String prncpChnlId);
	/**
	 * ��ѯָ��������ŵ���������
	 */
	public String findchnltype(String prncpChnlId);
	
	
	/**�ж����������Ƿ����*/
	public boolean isExistPId(String PId);
	
	/**��ȡָ��Id�Ķ��󼯺�*/
	public List<TbBasicInfoM> findUserById(String id);

}

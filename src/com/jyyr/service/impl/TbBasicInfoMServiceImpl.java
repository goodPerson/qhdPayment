package com.jyyr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.service.TbBasicInfoMService;

public class TbBasicInfoMServiceImpl implements TbBasicInfoMService {
	/** ͨ������ע��DAO���ʵ�� */

	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	/** ͳ��Ա������ */
	public int countBasicInfoM() {
		return dao.countAll("TbBasicInfoM");
	}	

	/** ���Ա��������Ϣ
	 * pageNo ��ǰҳ��
	 * pageSize ÿҳ��ʾ����
	 * */
	@SuppressWarnings({ "rawtypes" })
	public List<TbBasicInfoM> browseBasicInfoMs(int pageNo,int pageSize) {

		String hql="from TbBasicInfoM as a";
		List l =dao.query(hql, pageNo, pageSize); 
		List<TbBasicInfoM> list = new ArrayList<TbBasicInfoM>();
		for (int i = 0; i < l.size(); i++) {
			list.add( (TbBasicInfoM)l.get(i));
		}	
		return list;
	}

	/**ɾ��ָ����Ա��������Ϣ
	 * id ָ����id
	 * */
	public boolean delBasicInfoM(String id) {
		boolean status = false;
		try{
			dao.delById(TbBasicInfoM.class, id);
			status = true;
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return status;
	}

	/**  �������޸�Ա��������Ϣ */
	public boolean saveOrUpdateBasicInfoM(TbBasicInfoM basicInfoM) {

		boolean status = false;
		try{
			dao.saveOrUpdate(basicInfoM);
			status = true;
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return status;
	}

	/**  װ������������Ա����Ϣ 
	 * fromdate ��ʼ����
	 * todate ��ֹ����
	 * county ����
	 * area ����
	 * name ����
	 * id ����
	 * pageNo ��ǰҳ��
	 * pageSize ÿҳ��ʾ����
	 *  */
	@SuppressWarnings("unchecked")
	public List<TbBasicInfoM> findBasicInfoM(String fromdate,String todate,String county,String area, String name,String id,int pageNo,int pageSize) {
		if(id!=null&&!"".equals(id)){			
			return dao.query("FROM TbBasicInfoM AS A WHERE A.id = '"+id+"'", pageNo, pageSize);
		}else {
			if (fromdate!=null&&!"".equals(fromdate)&&todate!=null&&!"".equals(todate)) {
				return dao.query("FROM TbBasicInfoM AS A WHERE A.id like '%' and A.name LIKE '%"+name+"%' and A.countyName like '%"+county+"' and A.prncpArea like '%"+area+"' and A.statisMonth >= '"+fromdate+"' and A.statisMonth <=  '"+todate+"' order by A.statisMonth desc", pageNo, pageSize);
			}else if("".equals(fromdate)&&"".equals(todate)) {
				return dao.query("FROM TbBasicInfoM AS A WHERE A.id like '%' and A.name LIKE '%"+name+"%' and A.countyName like '%"+county+"' and A.prncpArea like '%"+area+"' order by A.statisMonth desc", pageNo, pageSize);
			}else if("".equals(fromdate)&&!"".equals(todate)){
				return dao.query("FROM TbBasicInfoM AS A WHERE A.id like '%' and A.name LIKE '%"+name+"%' and A.countyName like '%"+county+"' and A.prncpArea like '%"+area+"'and A.statisMonth >= '"+fromdate+"' order by A.statisMonth desc", pageNo, pageSize);
			}else {
				return dao.query("FROM TbBasicInfoM AS A WHERE A.id like '%' and A.name LIKE '%"+name+"%' and A.countyName like '%"+county+"' and A.prncpArea like '%"+area+"'and A.statisMonth <= '"+todate+"' order by A.statisMonth desc", pageNo, pageSize);
			}			
		}
	}

	/**  ��ѯ���������ĵ����б�
	 * fromdate ��ʼ����
	 * todate ��ֹ����
	 * county ����
	 * area ����
	 * name ����
	 * id ����
	 *  */
	@SuppressWarnings("unchecked")
	public List<TbBasicInfoM> findBasicInfoM1(String fromdate,String todate,String county,String area, String name,String id) {
		if(id!=null&&!"".equals(id)){			
			return dao.query("FROM TbBasicInfoM AS A WHERE A.id = '"+id+"'");
		}else {
			if (fromdate!=null&&!"".equals(fromdate)&&todate!=null&&!"".equals(todate)) {
				return dao.query("FROM TbBasicInfoM AS A WHERE A.id like '%' and A.name LIKE '%"+name+"%' and A.countyName like '%"+county+"' and A.prncpArea like '%"+area+"' and A.statisMonth >= '"+fromdate+"' and A.statisMonth <=  '"+todate+"' order by A.statisMonth desc");
			}else if("".equals(fromdate)&&"".equals(todate)) {
				return dao.query("FROM TbBasicInfoM AS A WHERE A.id like '%' and A.name LIKE '%"+name+"%' and A.countyName like '%"+county+"' and A.prncpArea like '%"+area+"' order by A.statisMonth desc");
			}else if("".equals(fromdate)&&!"".equals(todate)){
				return dao.query("FROM TbBasicInfoM AS A WHERE A.id like '%' and A.name LIKE '%"+name+"%' and A.countyName like '%"+county+"' and A.prncpArea like '%"+area+"'and A.statisMonth >= '"+fromdate+"' order by A.statisMonth desc");
			}else {
				return dao.query("FROM TbBasicInfoM AS A WHERE A.id like '%' and A.name LIKE '%"+name+"%' and A.countyName like '%"+county+"' and A.prncpArea like '%"+area+"'and A.statisMonth <= '"+todate+"' order by A.statisMonth desc");
			}			
		}
	}

	/**��ѯ���� 
	 * ��countyNameΪ�ػʵ���ʱ����ѯ������Ϊ�ػʵ�ȫ������������Ϊ��ǰ����
	 * */
	@SuppressWarnings("unchecked")
	public List<String> browseCounty(String countyName) {
		if (countyName!="�ػʵ���"&&!"�ػʵ���".equals(countyName)) {
			return dao.query("SELECT DISTINCT a.countyName FROM TbBasicInfoM as a where a.countyName='"+countyName+"'");
		}else {
			return dao.query("SELECT DISTINCT a.countyName FROM TbBasicInfoM as a");
		}

	}

	/**  �������
	 * ��������countyName��ѯ��Ӧ������
	 *  */
	@SuppressWarnings("unchecked")
	public List<String> browseArea(String countyName) {

		return dao.query("SELECT DISTINCT A.prncpArea FROM TbBasicInfoM AS A WHERE A.countyName='"+countyName+"'");
		//		return dao.query(hql);
	}

	/** �жϹ����Ƿ����
	 * �жϹ����Ƿ���ڣ��������빤�Ż򴴽������ǹ��ų�ͻ
	 * */
	public boolean isIdExist(String id) {
		if (dao.countQuery("SELECT COUNT(*) FROM TbBasicInfoM AS A WHERE ID='"+id+"'")>0) {
			return true;	//����
		}else {
			return false;//������
		}
	}
	/**��ȡָ��Id�Ķ��󼯺�
	 * ��Ҫ������ȡ��ӦId���ŵĹ��������ͽ�ɫ������Ȩ�޿��� 
	 * */
	@SuppressWarnings("unchecked")
	public List<TbBasicInfoM> findUserById(String id) {

		return dao.query("from TbBasicInfoM AS A WHERE ID='"+id+"'");
	}	
	/**
	 * װ��ָ�������������Ϣ  ywz
	 * */
	public TbBasicInfoM loadBasicInfo(String staticId) {
		if (staticId.length()>0){
		    String hql="from TbBasicInfoM as a where a.id='"+ staticId +"'";
			return (TbBasicInfoM) dao.loadObject(hql);
		}	
		return null;
		
	}
}

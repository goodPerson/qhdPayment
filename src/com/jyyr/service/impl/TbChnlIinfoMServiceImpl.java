package com.jyyr.service.impl;

import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.orm.TbChnlIinfoM;
import com.jyyr.service.TbChnlIinfoMService;

public class TbChnlIinfoMServiceImpl implements TbChnlIinfoMService{
	BaseDAO dao;
	/**ɾ��ָ��ID�ļ�¼*/
	public boolean delCnl(String prncpChnlId) {
		boolean status = false;
		try{
			dao.delById(TbChnlIinfoM.class, prncpChnlId);
			status = true;
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return status;

	}
	/**��ѯ���������ļ�¼ */
	@SuppressWarnings("unchecked")
	public List<TbChnlIinfoM> findChnl(String statisMonth,String statisMonth1, String countyName,String prncpArea,
			String id, String name, int pageNo, int pageSize) {
		
		if (!"".equals(statisMonth)&&!"".equals(statisMonth1)) {
			String hql ="from TbChnlIinfoM as a where a.statisMonth >= "+statisMonth+" and a.statisMonth <= "+statisMonth1+" and a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.query(hql, pageNo, pageSize);
		}else if(!"".equals(statisMonth)&&"".equals(statisMonth1)){
			String hql ="from TbChnlIinfoM as a where a.statisMonth >= "+statisMonth+" and a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.query(hql, pageNo, pageSize);
		}else if("".equals(statisMonth)&&!"".equals(statisMonth1)){
			String hql ="from TbChnlIinfoM as a where a.statisMonth <= "+statisMonth1+" and a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.query(hql, pageNo, pageSize);
		}else {
			String hql ="from TbChnlIinfoM as a where  a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.query(hql, pageNo, pageSize);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TbChnlIinfoM> exportChnl(String statisMonth,String statisMonth1, String countyName,String prncpArea,
			String id, String name) {
		
		if (!"".equals(statisMonth)&&!"".equals(statisMonth1)) {
			String hql ="from TbChnlIinfoM as a where a.statisMonth >= "+statisMonth+" and a.statisMonth <= "+statisMonth1+" and a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.query(hql);
		}else if(!"".equals(statisMonth)&&"".equals(statisMonth1)){
			String hql ="from TbChnlIinfoM as a where a.statisMonth >= "+statisMonth+" and a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"'  and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.query(hql);
		}else if("".equals(statisMonth)&&!"".equals(statisMonth1)){
			String hql ="from TbChnlIinfoM as a where a.statisMonth <= "+statisMonth1+" and a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.query(hql);
		}else {
			String hql ="from TbChnlIinfoM as a where  a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.query(hql);
		}
	}
	/**���¼�¼*/
	public boolean saveOrUpdateCnl(TbChnlIinfoM cnl) {
		boolean status = false;
		try{
			dao.saveOrUpdate(cnl);			
			status = true;
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return status;

	}
	/**��ѯ���������ļ�¼����*/
	public int countlist(String statisMonth,String statisMonth1, String countyName, String prncpArea,String id,
			String name) {
		if (!"".equals(statisMonth)&&!"".equals(statisMonth1)) {
			String hql ="select count(*) from TbChnlIinfoM as a where a.statisMonth >= "+statisMonth+" and a.statisMonth <= "+statisMonth1+" and a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.countQuery(hql);
		}else if(!"".equals(statisMonth)&&"".equals(statisMonth1)){
			String hql ="select count(*) from TbChnlIinfoM as a where a.statisMonth >= "+statisMonth+" and a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.countQuery(hql);
		}else if("".equals(statisMonth)&&!"".equals(statisMonth1)){
			String hql ="select count(*) from TbChnlIinfoM as a where a.statisMonth <= "+statisMonth1+" and a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.countQuery(hql);
		}else {
			String hql ="select count(*) from TbChnlIinfoM as a where  a.countyName like '%"+countyName+"' and a.prncpArea like '%"+prncpArea+"' and a.id like '%"+id+"' and a.name like '%"+name+"' ";
			return dao.countQuery(hql);
		}
		
	}
	/**��ѯ���е���*/
	@SuppressWarnings("unchecked")
	public List<String> findAllCounty(String countyName) {

		if (countyName!="�ػʵ���"&&!"�ػʵ���".equals(countyName)) {
			String hql ="select distinct a.countyName from TbChnlIinfoM as a WHERE a.countyName='"+countyName+"'";
			return dao.query(hql);
		}else {
			String hql ="select distinct a.countyName from TbChnlIinfoM as a order by a.countyName ";
			return dao.query(hql);
		}

	}
	/**��ѯ���е�����*/
	public List<String> findAllArea(String countyName) {
		String hql ="select distinct a.prncpArea from TbChnlIinfoM as a where a.countyName like '%"+countyName+ "'";
		return dao.query(hql);
	}
	/**��ѯ���е��·�*/
	public List<String> findAllMonth() {
		String hql ="select distinct statisMonth from TbChnlIinfoM order by statisMonth desc ";
		return dao.query(hql);
	}
	/**��ѯ���е�Ա������*/
	public List<String> findAllname() {
		String hql ="select distinct name from TbChnlIinfoM order by name  ";
		return dao.query(hql);
	}

	public String findchnlname(String prncpChnlId) {
		String hql ="select a.chnlName from TbDimChnlMagrChnlM as a where a.chnlId = '"+prncpChnlId+"'";
		return (String) dao.loadObject(hql);
	}
	public String findchnltype(String prncpChnlId) {
		String hql="select a.chnlType from TbDimChnlMagrChnlM as a where a.chnlId = '"+prncpChnlId+"'";
		return (String)dao.loadObject(hql);
	}

	/**�ж������������Ƿ����*/
	public boolean isExistPId(String PId) {
		if (dao.countQuery("SELECT COUNT(*) FROM TbChnlIinfoM as a WHERE a.prncpChnlId='"+PId+"'")>0) {
			return true;	//����
		}else {
			return false;//������
		}
	}

	/**��ȡָ��Id�Ķ��󼯺�*/
	public List<TbBasicInfoM> findUserById(String id) {
		return dao.query("from TbBasicInfoM AS A WHERE ID='"+id+"'");
	}

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

}

package com.jyyr.service.impl;

import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.orm.TbChnlIinfoM;
import com.jyyr.service.TbChnlIinfoMService;

public class TbChnlIinfoMServiceImpl implements TbChnlIinfoMService{
	BaseDAO dao;
	/**删除指定ID的记录*/
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
	/**查询满足条件的记录 */
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
	/**更新记录*/
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
	/**查询满足条件的记录总数*/
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
	/**查询所有的县*/
	@SuppressWarnings("unchecked")
	public List<String> findAllCounty(String countyName) {

		if (countyName!="秦皇岛市"&&!"秦皇岛市".equals(countyName)) {
			String hql ="select distinct a.countyName from TbChnlIinfoM as a WHERE a.countyName='"+countyName+"'";
			return dao.query(hql);
		}else {
			String hql ="select distinct a.countyName from TbChnlIinfoM as a order by a.countyName ";
			return dao.query(hql);
		}

	}
	/**查询所有的区域*/
	public List<String> findAllArea(String countyName) {
		String hql ="select distinct a.prncpArea from TbChnlIinfoM as a where a.countyName like '%"+countyName+ "'";
		return dao.query(hql);
	}
	/**查询所有的月份*/
	public List<String> findAllMonth() {
		String hql ="select distinct statisMonth from TbChnlIinfoM order by statisMonth desc ";
		return dao.query(hql);
	}
	/**查询所有的员工姓名*/
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

	/**判断是渠道编码是否存在*/
	public boolean isExistPId(String PId) {
		if (dao.countQuery("SELECT COUNT(*) FROM TbChnlIinfoM as a WHERE a.prncpChnlId='"+PId+"'")>0) {
			return true;	//存在
		}else {
			return false;//不存在
		}
	}

	/**获取指定Id的对象集合*/
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

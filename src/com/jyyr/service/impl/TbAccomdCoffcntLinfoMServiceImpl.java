package com.jyyr.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.ibm.db2.jcc.am.id;
import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbAccomdCoffcntLinfoM;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.service.TbAccomdCoffcntLinfoMService;

public class TbAccomdCoffcntLinfoMServiceImpl implements TbAccomdCoffcntLinfoMService {
	BaseDAO dao;
	/**查询满足条件的记录*/
	@SuppressWarnings("unchecked")
	public List<TbAccomdCoffcntLinfoM> scanneChnl(String county,String area, int pageNo,
			int pageSize) {
		String hql =" from TbAccomdCoffcntLinfoM as a where a.county like '%"+county+"' and a.area like '%"+area+"' order by a.county ";
		return dao.query(hql, pageNo, pageSize);
	}

	/**修改调节系数*/
	@SuppressWarnings("unchecked")
	public boolean saveOrUpdateCnt(TbAccomdCoffcntLinfoM cnt) {
		boolean status = false;
		try{
			dao.saveOrUpdate(cnt);
			status = true;
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return status;

	}

	/**查询所有县区*/
	@SuppressWarnings("unchecked")
	public List<String> findAllCounty(String countyName) {	
		
		if (countyName!="秦皇岛市"&&!"秦皇岛市".equals(countyName)) {
			String hql ="select distinct a.county from TbAccomdCoffcntLinfoM as a WHERE a.county='"+countyName+"' order by county";
			return dao.query(hql);
		}else {
			String hql ="select distinct a.county from TbAccomdCoffcntLinfoM as a  order by county";
			return dao.query(hql);
		}
	}
	/**查询条件记录总数*/
	@SuppressWarnings("unchecked")
	public int countlist(String county,String area) {
		String hql="select count (*) from TbAccomdCoffcntLinfoM as a where a.county like '%"+county+"' and a.area like '%"+area+"'";
		return dao.countQuery(hql);
		
	}

	/**查询指定id的记录*/
	public TbAccomdCoffcntLinfoM loadrecd(String id) {

		return (TbAccomdCoffcntLinfoM)dao.loadById(TbAccomdCoffcntLinfoM.class,id );
	}

	/**删除指定id的记录*/
	public boolean delCoff(String id) {
		boolean status = false;
		try{
			dao.delById(TbAccomdCoffcntLinfoM.class, id);
			status = true;
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return status;
	}

	/**查询指定县的记录*/
	public List<TbAccomdCoffcntLinfoM> findall(String county,String area) {

		String hql =" from TbAccomdCoffcntLinfoM as a where a.county like '%"+county+"' and a.area like '%"+area+"' order by a.county ";
		return dao.query(hql);
	}
	
	/**获取指定Id的对象集合*/
	@SuppressWarnings("unchecked")
	public List<TbBasicInfoM> findUserById(String id) {
		return dao.query("from TbBasicInfoM AS A WHERE ID='"+id+"'");
	}

	public BaseDAO getDao() {
		return dao;
	}



	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	@SuppressWarnings("unchecked")
	public List<String> browseArea(String countyName) {
		return dao.query("SELECT DISTINCT A.area FROM TbAccomdCoffcntLinfoM AS A WHERE A.county='"+countyName+"'");
	}

}
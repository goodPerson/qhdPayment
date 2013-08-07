package com.jyyr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.service.TbBasicInfoMService;

public class TbBasicInfoMServiceImpl implements TbBasicInfoMService {
	/** 通过依赖注入DAO组件实例 */

	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	/** 统计员工总数 */
	public int countBasicInfoM() {
		return dao.countAll("TbBasicInfoM");
	}	

	/** 浏览员工基础信息
	 * pageNo 当前页数
	 * pageSize 每页显示条数
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

	/**删除指定的员工基础信息
	 * id 指定的id
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

	/**  新增或修改员工基础信息 */
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

	/**  装载满足条件的员工信息 
	 * fromdate 开始日期
	 * todate 截止日期
	 * county 县区
	 * area 区域
	 * name 姓名
	 * id 工号
	 * pageNo 当前页数
	 * pageSize 每页显示条数
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

	/**  查询满足条件的导出列表
	 * fromdate 开始日期
	 * todate 截止日期
	 * county 县区
	 * area 区域
	 * name 姓名
	 * id 工号
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

	/**查询县区 
	 * 当countyName为秦皇岛市时，查询的县区为秦皇岛全部县区，否则为当前县区
	 * */
	@SuppressWarnings("unchecked")
	public List<String> browseCounty(String countyName) {
		if (countyName!="秦皇岛市"&&!"秦皇岛市".equals(countyName)) {
			return dao.query("SELECT DISTINCT a.countyName FROM TbBasicInfoM as a where a.countyName='"+countyName+"'");
		}else {
			return dao.query("SELECT DISTINCT a.countyName FROM TbBasicInfoM as a");
		}

	}

	/**  浏览区域
	 * 根据县区countyName查询对应的区域
	 *  */
	@SuppressWarnings("unchecked")
	public List<String> browseArea(String countyName) {

		return dao.query("SELECT DISTINCT A.prncpArea FROM TbBasicInfoM AS A WHERE A.countyName='"+countyName+"'");
		//		return dao.query(hql);
	}

	/** 判断工号是否存在
	 * 判断工号是否存在，来处理导入工号或创建工号是工号冲突
	 * */
	public boolean isIdExist(String id) {
		if (dao.countQuery("SELECT COUNT(*) FROM TbBasicInfoM AS A WHERE ID='"+id+"'")>0) {
			return true;	//存在
		}else {
			return false;//不存在
		}
	}
	/**获取指定Id的对象集合
	 * 主要用来获取相应Id工号的归属地区和角色，进行权限控制 
	 * */
	@SuppressWarnings("unchecked")
	public List<TbBasicInfoM> findUserById(String id) {

		return dao.query("from TbBasicInfoM AS A WHERE ID='"+id+"'");
	}	
	/**
	 * 装载指定渠道经理的信息  ywz
	 * */
	public TbBasicInfoM loadBasicInfo(String staticId) {
		if (staticId.length()>0){
		    String hql="from TbBasicInfoM as a where a.id='"+ staticId +"'";
			return (TbBasicInfoM) dao.loadObject(hql);
		}	
		return null;
		
	}
}

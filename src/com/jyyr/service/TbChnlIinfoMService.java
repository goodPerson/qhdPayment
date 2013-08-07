package com.jyyr.service;
import java.util.List;

import com.jyyr.orm.TbAccomdCoffcntLinfoM;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.orm.TbChnlIinfoM;
/**
 * 2、渠道经理渠道信息查询与维护接口
 * @author kb、lyk
 *
 */
public interface TbChnlIinfoMService {
	
	/**
	 * 分页查询满足指定条件的记录
	 */
	public List<TbChnlIinfoM> findChnl (String statisMonth,String statisMonth1,String county,String prncpArea,String id,String name,int pageNo,int pageSize );
	public List<TbChnlIinfoM> exportChnl(String statisMonth,String statisMonth1, String countyName,String prncpArea,
			String id, String name);
	/**
	 * 修改渠道信息
	 */
	public boolean saveOrUpdateCnl(TbChnlIinfoM cnl);
	/**
	 * 删除指定ID的记录
	 */
	public boolean delCnl (String id);
	/**
	 * 查询条件记录总数
	 */
	public int countlist(String statisMonth,String statisMonth1,String countyName,String prncpArea,String id,String name);
	/**
	 * 查询所有的县区
	 */
	public List<String> findAllCounty(String countyName);
	/**
	 * 查询所有的月份
	 */
	public List<String> findAllMonth();
	/**
	 * 查询所有的区域
	 */
	public List<String> findAllArea(String countyName);
	/**
	 * 查询所有的姓名
	 */
	public List<String> findAllname();
	/**
	 * 查询指定渠道编号的渠道名称
	 */
	public String findchnlname(String prncpChnlId);
	/**
	 * 查询指定渠道编号的渠道类型
	 */
	public String findchnltype(String prncpChnlId);
	
	
	/**判断渠道编码是否存在*/
	public boolean isExistPId(String PId);
	
	/**获取指定Id的对象集合*/
	public List<TbBasicInfoM> findUserById(String id);

}

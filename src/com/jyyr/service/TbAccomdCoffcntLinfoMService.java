package com.jyyr.service;
import java.util.List;
import com.jyyr.orm.TbAccomdCoffcntLinfoM;
import com.jyyr.orm.TbBasicInfoM;

/**
 * 调节系数信息查询与维护接口
 * @author lyk
 *
 */
public interface TbAccomdCoffcntLinfoMService {
	/**
	 * 分页查询满足指定条件的调节系数
	 */
	public List<TbAccomdCoffcntLinfoM> scanneChnl(String county,String area,int pageNo,int pageSize);
	/**
	 * 修改调节系数
	 */
	public boolean saveOrUpdateCnt(TbAccomdCoffcntLinfoM cnt);
	/**
	 *查询所有县区
	 */
	public List<String> findAllCounty(String countyName);
	
	/**
	 * 查询指定县区的区域
	 * */
	public List<String> browseArea(String countyName);
	
	/**
	 * 查询条件记录总数
	 */
	public int countlist(String county,String area);
	/**
	 * 查询所有的记录
	 */
	public List<TbAccomdCoffcntLinfoM> findall(String county,String area);
	/**
	 * 查询指定ＩＤ的记录
	 */
	public TbAccomdCoffcntLinfoM loadrecd (String id );
	/**
	 * 删除指定ID的记录
	 */
	public boolean delCoff (String id);
	/**
	 * 
	 * 查询用户信息
	 */
	public List<TbBasicInfoM> findUserById(String id);
	 
}

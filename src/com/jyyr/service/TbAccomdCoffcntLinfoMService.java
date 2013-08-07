package com.jyyr.service;
import java.util.List;
import com.jyyr.orm.TbAccomdCoffcntLinfoM;
import com.jyyr.orm.TbBasicInfoM;

/**
 * ����ϵ����Ϣ��ѯ��ά���ӿ�
 * @author lyk
 *
 */
public interface TbAccomdCoffcntLinfoMService {
	/**
	 * ��ҳ��ѯ����ָ�������ĵ���ϵ��
	 */
	public List<TbAccomdCoffcntLinfoM> scanneChnl(String county,String area,int pageNo,int pageSize);
	/**
	 * �޸ĵ���ϵ��
	 */
	public boolean saveOrUpdateCnt(TbAccomdCoffcntLinfoM cnt);
	/**
	 *��ѯ��������
	 */
	public List<String> findAllCounty(String countyName);
	
	/**
	 * ��ѯָ������������
	 * */
	public List<String> browseArea(String countyName);
	
	/**
	 * ��ѯ������¼����
	 */
	public int countlist(String county,String area);
	/**
	 * ��ѯ���еļ�¼
	 */
	public List<TbAccomdCoffcntLinfoM> findall(String county,String area);
	/**
	 * ��ѯָ���ɣĵļ�¼
	 */
	public TbAccomdCoffcntLinfoM loadrecd (String id );
	/**
	 * ɾ��ָ��ID�ļ�¼
	 */
	public boolean delCoff (String id);
	/**
	 * 
	 * ��ѯ�û���Ϣ
	 */
	public List<TbBasicInfoM> findUserById(String id);
	 
}

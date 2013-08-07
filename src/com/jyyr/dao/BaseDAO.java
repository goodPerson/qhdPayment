package com.jyyr.dao;


import java.sql.Connection;
import java.util.*;
import java.io.Serializable;

/** ͳһ���ݷ��ʽӿ� */
public interface BaseDAO {
	/** ����ָ��ID�ĳ־û����� */
	public Object loadById(Class clazz,Serializable id);
	
	/** �������������ĳ־û����� */
	public Object loadObject(String hql);
	
	/** ɾ��ָ��ID�ĳ־û����� */
	public void delById(Class clazz,Serializable id);
	
	/** ��������ָ���ĳ־û����� */
	public void saveOrUpdate(Object obj);
	
	/** װ��ָ��������г־û����� */
	public List listAll(String clazz);
	
	/** ��ҳװ��ָ��������г־û����� */
	public List listAll(String clazz,int pageNo,int pageSize);
	
	/** ͳ��ָ��������г־û����� */
	public int countAll(String clazz);
	
	/** ��ѯָ��������������ĳ־û����� */
	public List query(String hql);
	
	/** ��ҳ��ѯָ��������������ĳ־û����� */
	public List query(String hql,int pageNo,int pageSize);
	
	public List querysql(String sql,int pageNo,int pageSize);
	
	public List  querysql(String sql);
	
	/** ͳ��ָ����Ĳ�ѯ��� */
	public int countQuery(String hql);
	
	/** ������������ */
	public int update(String hql);
	
	/** �����ӳ���ȡ��һ��JDBC���� */
	public Connection getConnection();
	/**
	 * ��������������
	 */
	/** ��ҳװ��ָ����������������ĳ־û����� */
	public List listCondition(String hqlString, int pageNo, int pageSize);

	/** ����������ȡ��¼�� */
	public int countAllCondition(String hqlString);

	/**
	 * ��ȡ����������ȫ����¼
	 * 
	 * @param hqlString
	 * @return
	 */
	public List listConditionAll(String hqlString);
	
	/** double ͳ��ָ����Ĳ�ѯ��� */
	public float countQueryD(String hql);
}
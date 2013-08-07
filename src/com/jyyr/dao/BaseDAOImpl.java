package com.jyyr.dao;


import java.io.Serializable;

import java.sql.Connection;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/** ͳһ���ݷ��ʽӿ�ʵ�� */
@Repository("BaseDAO")
public class BaseDAOImpl extends HibernateDaoSupport implements BaseDAO {
	
	//ͨ��@Resourceע��ע��HibernateTemplateʵ��
	@Resource
	HibernateTemplate hibernateTemplate;
	
	/** ͳ��ָ��������г־û����� */
	public int countAll(String clazz) {
		final String hql = "select count(*) from "+clazz+ " as a";
		Long count = (Long)hibernateTemplate.execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
		});	
		return count.intValue();
	}

	/** ͳ��ָ����Ĳ�ѯ��� */
	public int countQuery(String hql) {
		final String counthql = hql;
		Long count = (Long)hibernateTemplate.execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(counthql);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
		});
		return count.intValue();
	}

	/** ɾ��ָ��ID�ĳ־û����� */
	public void delById(Class clazz,Serializable id) {
		hibernateTemplate.delete(hibernateTemplate.load(clazz, id));			
	}

	/** װ��ָ��������г־û����� */
	public List listAll(String clazz) {
		return hibernateTemplate.find("from "+clazz+" as a order by a.id desc");
	}
	
	/** ��ҳװ��ָ��������г־û����� */
	public List listAll(String clazz, int pageNo, int pageSize) {
		final int pNo = pageNo;
		final int pSize = pageSize;
		final String hql = "from "+clazz+ " as a order by a.id desc";
		List list = hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql);
				query.setMaxResults(pSize);
				query.setFirstResult((pNo-1)*pSize);
				List result = query.list();
				if (!Hibernate.isInitialized(result))Hibernate.initialize(result);
				return result;
			}
		});	
		return list;
	}
	
	
	
	public List querysql(String sql, int pageNo, int pageSize) {
		final int pNo = pageNo;
		final int pSize = pageSize;
		final String hql1 = sql;
		return hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createSQLQuery(hql1);
				query.setMaxResults(pSize);
				query.setFirstResult((pNo-1)*pSize);
				List result = query.list();
				if (!Hibernate.isInitialized(result))Hibernate.initialize(result);
				return result;
			}
		});	
	}

	public List querysql(String sql) {
		final String hql1 = sql;
		return hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createSQLQuery(hql1);
				return query.list();
			}
		});		}

	/** ����ָ��ID�ĳ־û����� */
	public Object loadById(Class clazz,Serializable id) {
		return hibernateTemplate.get(clazz, id);
	}
	
	/**�������������ĳ־û�����*/
	public Object loadObject(String hql) {
		final String hql1 = hql;
		Object obj = null;
		List list = hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql1);
				return query.list();
			}
		});			
		if(list.size()>0)obj=list.get(0);	
		return obj;
	}

	/** ��ѯָ��������������ĳ־û����� */
	public List query(String hql) {
		final String hql1 = hql;
		return hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql1);
				return query.list();
			}
		});	
	}

	/** ��ҳ��ѯָ��������������ĳ־û����� */
	public List query(String hql, int pageNo, int pageSize) {
		final int pNo = pageNo;
		final int pSize = pageSize;
		final String hql1 = hql;
		return hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql1);
				query.setMaxResults(pSize);
				query.setFirstResult((pNo-1)*pSize);
				List result = query.list();
				if (!Hibernate.isInitialized(result))Hibernate.initialize(result);
				return result;
			}
		});	
	}

	/** ��������ָ���ĳ־û����� */
	public void saveOrUpdate(Object obj) {
		hibernateTemplate.saveOrUpdate(obj);
	}

	/** ������������ */
	public int update(String hql) {
		final String hql1 = hql; 
		return ((Integer)hibernateTemplate.execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql1);
				return query.executeUpdate();
			}
		})).intValue();	
	}
	
	/** �����ӳ���ȡ��һ��JDBC���� */
	public Connection getConnection() {
		return hibernateTemplate.getSessionFactory().getCurrentSession().connection();
	}
	/**
	 * ��������������
	 */
	/** ��ҳװ��ָ����������������ĳ־û����� */
	public List listCondition(String hqlString, int pageSize, int pageNo) {
		final int pNo = pageNo;
		final int pSize = pageSize;
		final String hql = hqlString;
		List list = hibernateTemplate.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				query.setMaxResults(pSize);
				query.setFirstResult((pNo - 1) * pSize);
				return query.list();
			}
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllCondition(String hqlString) {
		final String hql = hqlString;
		Long count = (Long) hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
		});
		return count.intValue();
	}

	public List listConditionAll(String hqlString) {
		final String hql = hqlString;
		List list = hibernateTemplate.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				return query.list();
			}
		});
		return list;
	}
	
	/** float ͳ��ָ����Ĳ�ѯ��� */
	public float countQueryD(String hql) {
		final String counthql = hql;
		Double count = (Double)hibernateTemplate.execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(counthql);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
		});
		return count.floatValue();
	}
}
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

/** 统一数据访问接口实现 */
@Repository("BaseDAO")
public class BaseDAOImpl extends HibernateDaoSupport implements BaseDAO {
	
	//通过@Resource注解注入HibernateTemplate实例
	@Resource
	HibernateTemplate hibernateTemplate;
	
	/** 统计指定类的所有持久化对象 */
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

	/** 统计指定类的查询结果 */
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

	/** 删除指定ID的持久化对象 */
	public void delById(Class clazz,Serializable id) {
		hibernateTemplate.delete(hibernateTemplate.load(clazz, id));			
	}

	/** 装载指定类的所有持久化对象 */
	public List listAll(String clazz) {
		return hibernateTemplate.find("from "+clazz+" as a order by a.id desc");
	}
	
	/** 分页装载指定类的所有持久化对象 */
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

	/** 加载指定ID的持久化对象 */
	public Object loadById(Class clazz,Serializable id) {
		return hibernateTemplate.get(clazz, id);
	}
	
	/**加载满足条件的持久化对象*/
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

	/** 查询指定类的满足条件的持久化对象 */
	public List query(String hql) {
		final String hql1 = hql;
		return hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql1);
				return query.list();
			}
		});	
	}

	/** 分页查询指定类的满足条件的持久化对象 */
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

	/** 保存或更新指定的持久化对象 */
	public void saveOrUpdate(Object obj) {
		hibernateTemplate.saveOrUpdate(obj);
	}

	/** 条件更新数据 */
	public int update(String hql) {
		final String hql1 = hql; 
		return ((Integer)hibernateTemplate.execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql1);
				return query.executeUpdate();
			}
		})).intValue();	
	}
	
	/** 从连接池中取得一个JDBC连接 */
	public Connection getConnection() {
		return hibernateTemplate.getSessionFactory().getCurrentSession().connection();
	}
	/**
	 * 董晓斌新增方法
	 */
	/** 分页装载指定类的有条件搜索的持久化对象 */
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
	
	/** float 统计指定类的查询结果 */
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
package com.jyyr.test;


import java.util.Iterator;
import java.util.List;

import org.hibernate.validator.Length;

import com.jyyr.dao.BaseDAOImpl;
import com.jyyr.orm.TbReckonPiecePayDealInfoD;

public class TestBaseDAO {
    
	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List testList;
		BaseDAOImpl dao=new BaseDAOImpl();
		String hql="from TbReckonPiecePayDealInfoD as a where a.staffId='1'";
		testList=dao.query(hql);
		if (testList!=null||testList.size()!=0) {
			System.out.print(testList);
		}else {
			System.out.print(1);
		}
	
//		 for (Iterator iter = testList.iterator(); iter.hasNext();) {
//			  String str = (String)iter.next();
//			  System.out.println(str);
//			 }
	}

}

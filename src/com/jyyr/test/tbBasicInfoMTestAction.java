package com.jyyr.test;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.service.impl.TbBasicInfoMServiceImpl;
import com.jyyr.utitly.DateUtil;
import com.jyyr.dao.BaseDAOImpl;;

public class tbBasicInfoMTestAction {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String staticId="6";
		TbBasicInfoMServiceImpl basicInfoService=new TbBasicInfoMServiceImpl();
		boolean isHave=basicInfoService.isIdExist(staticId);
		if (isHave){
			System.out.println("已经存在");
		}else{
			System.out.println("不存在");
		}
	}	
}

package com.jyyr.utitly;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/** 
	    * ��ǰ���ڵ�ǰһ��
	    * @param specifiedDay 
	    * @return 
	    * @throws Exception 
	    */  
	    public static String getSpecifiedDayBefore(String specifiedDay){  
	        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");  
	        Calendar c = Calendar.getInstance();  
	        Date date=null;  
	        try {  
	            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        c.setTime(date);  
	        int day=c.get(Calendar.DATE);  
	        c.set(Calendar.DATE,day-1);  
	        
	        String dayBefore=new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
	        return dayBefore;  
	    }  
	    /** 
	    * ��ǰ���ڵĺ�һ�� 
	    * @param specifiedDay 
	    * @return 
	    */  
	    public static String getSpecifiedDayAfter(String specifiedDay){  
	        Calendar c = Calendar.getInstance();  
	        Date date=null;  
	        try {  
	            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        c.setTime(date);  
	        int day=c.get(Calendar.DATE);  
	        c.set(Calendar.DATE,day+1);  
	  
	        String dayAfter=new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
	        return dayAfter;  
	    } 
	    
		/**��ȡ������*/
		public static String getYearMonthDay(){
			String sMonth;
			 Calendar cal = Calendar.getInstance();
			    int month = cal.get(Calendar.MONTH) + 1;
			    if (month<10){
			    	sMonth="0"+month;
			    }else{
			    	sMonth=""+month;
			    }
			    int year = cal.get(Calendar.YEAR);
			    int sDay=cal.get(Calendar.DATE);
			    return ""+year+sMonth+sDay;
		}
		
		/**��ȡ��������*/
		public static int getCurrentMonthLastDay() {
			Calendar a = Calendar.getInstance();
			a.set(Calendar.DATE, 1);//����������Ϊ���µ�һ��
			a.roll(Calendar.DATE, -1);//���ڻع�һ�죬Ҳ�������һ��
			int maxDate = a.get(Calendar.DATE);
			return maxDate;
		}
}

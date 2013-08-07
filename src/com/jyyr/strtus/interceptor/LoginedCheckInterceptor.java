package com.jyyr.strtus.interceptor;


import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.jyyr.dao.BaseDAOImpl;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.service.impl.TbBasicInfoMServiceImpl;

/** session���ڡ���¼��Ч�Լ�������Ȩ����֤������ */
public class LoginedCheckInterceptor extends AbstractInterceptor {

	/** �������󲢽��е�¼��Ч����֤ */
	public String intercept(ActionInvocation ai) throws Exception {
		TbBasicInfoM chnlMager=(TbBasicInfoM) ServletActionContext.getRequest().getSession().getAttribute("chanlMager");// ����������Ϣ
		String post="";		//��λ		
		int index=0;
		post=chnlMager.getPost();
		//��֤Session�Ƿ����
		if (!ServletActionContext.getRequest().isRequestedSessionIdValid()){
			return "expire";
		}else{
			if (post=="��������"){
				index=1;
				return ai.invoke();
			}else if (post=="���ظ�����"){
				index=2;
				return ai.invoke();
			}else if (post=="�и�����"){
				index=3;
				return ai.invoke();
			}else if (post=="��������Ա"){
				index=4;
				return ai.invoke();
			}else{
				return "expire";
			}
			
		}		
	}
}

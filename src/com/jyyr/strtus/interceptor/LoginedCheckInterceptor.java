package com.jyyr.strtus.interceptor;


import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.jyyr.dao.BaseDAOImpl;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.service.impl.TbBasicInfoMServiceImpl;

/** session过期、登录有效性及操作的权限验证拦截器 */
public class LoginedCheckInterceptor extends AbstractInterceptor {

	/** 拦截请求并进行登录有效性验证 */
	public String intercept(ActionInvocation ai) throws Exception {
		TbBasicInfoM chnlMager=(TbBasicInfoM) ServletActionContext.getRequest().getSession().getAttribute("chanlMager");// 渠道经理信息
		String post="";		//岗位		
		int index=0;
		post=chnlMager.getPost();
		//验证Session是否过期
		if (!ServletActionContext.getRequest().isRequestedSessionIdValid()){
			return "expire";
		}else{
			if (post=="渠道经理"){
				index=1;
				return ai.invoke();
			}else if (post=="区县负责人"){
				index=2;
				return ai.invoke();
			}else if (post=="市负责人"){
				index=3;
				return ai.invoke();
			}else if (post=="超级管理员"){
				index=4;
				return ai.invoke();
			}else{
				return "expire";
			}
			
		}		
	}
}

package com.jyyr.strtus.action;

import org.apache.struts2.ServletActionContext;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.service.TbBasicInfoMService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class IndexAction  extends ActionSupport implements ModelDriven<TbBasicInfoM> {
	BaseDAO dao;
	TbBasicInfoM model;
	TbBasicInfoMService service;
	
	/**���ղ���*/
	private String userId;//���ֹ���
	private String staticId;//���ֹ���
	private String roleName;
    private String userName;
	private String regionId;
    private String regionName;
	
	
	public TbBasicInfoM getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String execute(){
		staticId=userId;
		TbBasicInfoM tempChnlInfo=service.loadBasicInfo(staticId);
		if(tempChnlInfo!=null){//			
			String post=tempChnlInfo.getPost().trim();
			if (staticId!=null || staticId.length()>0)
				ServletActionContext.getRequest().getSession().setAttribute("chanlMager",tempChnlInfo);
				ServletActionContext.getRequest().getSession().setAttribute("post",post);
				ServletActionContext.getRequest().getSession().setAttribute("staticId",staticId);
			if (post.equalsIgnoreCase("��������")){
				return "chnlmager";
			}else if (post.equalsIgnoreCase("���ظ�����")){
				return "countymager";
			}else if (post.equalsIgnoreCase("�и�����")){
				return "citymager";
			} else if (post.equalsIgnoreCase("��������Ա")){
				return "supermager";
			}else{
				return SUCCESS ;
			}
		}else{
			return "login";				
		}

	}
	
	
	
	
	
	public BaseDAO getDao() {
		return dao;
	}
	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	public TbBasicInfoMService getService() {
		return service;
	}

	public void setService(TbBasicInfoMService service) {
		this.service = service;
	}

	public String getStaticId() {
		return staticId;
	}

	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public void setModel(TbBasicInfoM model) {
		this.model = model;
	}
	
}

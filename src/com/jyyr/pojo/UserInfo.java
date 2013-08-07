package com.jyyr.pojo;

import java.util.List;

import com.jyyr.model.TbAdmRole;
import com.jyyr.model.TbAdmUserGroup;
import com.jyyr.model.TbAdmUserUnit;
import com.jyyr.model.TbDimJob;
import com.jyyr.model.TbDimRegion;

public class UserInfo implements java.io.Serializable{
	
	private static final long serialVersionUID = -2365924456109070617L;
	//�û���Ϣ 
	private TbAdmUserUnit user;
	//��ɫ��Ϣ
	private TbAdmRole role;
	//�û�����Ϣ
	private TbAdmUserGroup group;
	//�û���˾
	private TbAdmUserGroup company;
	//�û�ְλ
	private TbDimJob job;
	//�û���������
	private TbDimRegion region;
	//����Ȩ��
	private List special_role;
	//�����û�
	private List under;
	//�ϼ��û�
	private TbAdmUserUnit boss; 
	public TbAdmUserUnit getUser() {
		return user;
	}
	public void setUser(TbAdmUserUnit user) {
		this.user = user;
	}
	public TbAdmRole getRole() {
		return role;
	}
	public void setRole(TbAdmRole role) {
		this.role = role;
	}
	public TbAdmUserGroup getGroup() {
		return group;
	}
	public void setGroup(TbAdmUserGroup group) {
		this.group = group;
	}
	public TbAdmUserGroup getCompany() {
		return company;
	}
	public void setCompany(TbAdmUserGroup company) {
		this.company = company;
	}
	public TbDimJob getJob() {
		return job;
	}
	public void setJob(TbDimJob job) {
		this.job = job;
	}
	public TbDimRegion getRegion() {
		return region;
	}
	public void setRegion(TbDimRegion region) {
		this.region = region;
	}
	public List getSpecial_role() {
		return special_role;
	}
	public void setSpecial_role(List specialRole) {
		special_role = specialRole;
	}
	public List getUnder() {
		return under;
	}
	public void setUnder(List under) {
		this.under = under;
	}
	public TbAdmUserUnit getBoss() {
		return boss;
	}
	public void setBoss(TbAdmUserUnit boss) {
		this.boss = boss;
	}
}

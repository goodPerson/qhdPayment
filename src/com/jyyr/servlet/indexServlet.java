package com.jyyr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext.*;

import org.apache.struts2.ServletActionContext;

import com.jyyr.dao.BaseDAOImpl;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.service.TbBasicInfoMService;

public class indexServlet extends HttpServlet {
	BaseDAOImpl dao=new BaseDAOImpl();
	TbBasicInfoM basicInfoM=null;
	
	/**
	 * Constructor of the object.
	 */
	public indexServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String staticId=request.getParameter("staticId");
//		this.getServletContext().setAttribute("staticId", staticId);
//		String parastaticId = (String) this.getServletContext().getAttribute("staticId");
//		System.out.println(parastaticId);
//		String hql="from TbBasicInfoM as a where a.id='"+ staticId +"'";
//		basicInfoM=(TbBasicInfoM) dao.loadObject(hql);
		
		String post; //岗位
//		post=basicInfoM.getPost();
		post="渠道经理";
		if (post=="渠道经理"){			
			this.getServletContext().setAttribute("staticId",staticId);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/magerIndexStati_Action.action?staticId="+staticId);
			rd.forward(request, response);
		}else if (post=="区县负责人"){
			request.getRequestDispatcher("countyIndexStati_Action.action?staticId="+staticId).forward(request, response);  
		}else if (post=="市负责人"){
			request.getRequestDispatcher("cityIndexStati_Action.action?staticId="+staticId).forward(request, response); 
		}else if (post=="超级管理员"){
			request.getRequestDispatcher("superIndexStati_Action.action?staticId="+staticId).forward(request, response); 
		}		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}



}

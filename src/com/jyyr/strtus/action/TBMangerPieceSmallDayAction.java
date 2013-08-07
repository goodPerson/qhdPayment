// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 2013/5/16 8:55:08
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TBMangerPieceSmallDayAction.java

package com.jyyr.strtus.action;

import com.jyyr.common.PrintExcelUtil;
import com.jyyr.orm.TBMangerPieceSmallDay;
import com.jyyr.orm.TBMangerPieceSmallMonth;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.service.TBMangerPieceSmallDayService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.*;
import java.net.URLDecoder;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

public class TBMangerPieceSmallDayAction extends ActionSupport
    implements ModelDriven<TBMangerPieceSmallDay>
{


    public String pieceUrlday()
    {
        List chnlList = new ArrayList();
        basicInfoM = new TbBasicInfoM();
        HttpServletRequest request = ServletActionContext.getRequest();
        idString = request.getParameter("Id");
        if(idString != null && !"".equals(idString))
        {
            chnlList = dayservice.findUserById(idString);
            if(chnlList.size() != 0)
            {
                basicInfoM = (TbBasicInfoM)chnlList.get(0);
                quanXianname = basicInfoM.getName();
                quanXianCountyName = basicInfoM.getCountyName();
                quanXianPost = basicInfoM.getPost();
                request.setAttribute("quanXianCountyName", quanXianCountyName);
                request.setAttribute("quanXianPost", quanXianPost);
                return "success";
            } else
            {
                return "FAIL";
            }
        } else
        {
            return "FAIL";
        }
    }

    public String browDayPiect()
        throws IOException
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("gbk");
        response.addHeader("Content-Type", "text/html;charset=gbk");
        int pageno;
        if(request.getParameter("page") == null || "" == request.getParameter("page"))
            pageno = 1;
        else
            pageno = Integer.parseInt(request.getParameter("page"));
        int pagesize;
        if(request.getParameter("rows") == null || "" == request.getParameter("rows"))
            pagesize = 10;
        else
            pagesize = Integer.parseInt(request.getParameter("rows"));
        if(model.getStatisDate() != null && !"".equals(model.getStatisDate()))
            statisDate = model.getStatisDate();
        else
            statisDate = "";
        if(quanXianCountyName != "秦皇岛市" && !"秦皇岛市".equals(quanXianCountyName))
            countyName = quanXianCountyName;
        else
        if(model.getCountyName() != null && !"".equals(model.getCountyName()))
        {
            if("秦皇岛市".equals(model.getCountyName()))
                countyName = "";
            else
                countyName = URLDecoder.decode(model.getCountyName(), "utf-8");
        } else
        {
            countyName = "";
        }
        if(model.getName() != null && !"".equals(model.getName()))
            name = URLDecoder.decode(model.getName(), "utf-8");
        else
            name = "";
        if(quanXianPost != "渠道经理" && !"渠道经理".equals(quanXianPost))
        {
            if(model.getId() != null && !"".equals(model.getId()))
                id = model.getId();
            else
                id = "";
        } else
        {
            id = idString;
        }
        if(model.getPrncpChnlId() != null && !"".equals(model.getPrncpChnlId()))
            prncpChnlId = model.getPrncpChnlId();
        else
            prncpChnlId = "";
        if(model.getPrncpChnlName() != null && !"".equals(model.getPrncpChnlName()))
            prncpChnlName = URLDecoder.decode(model.getPrncpChnlName(), "utf-8");
        else
            prncpChnlName = "";
        if(model.getBigPieceName() != null && !"".equals(model.getBigPieceName()))
            bigPieceName = URLDecoder.decode(model.getBigPieceName(), "utf-8");
        else
            bigPieceName = "";
        if(model.getSmallPieceName() != null && !"".equals(model.getSmallPieceName()))
            smallPieceName = URLDecoder.decode(model.getSmallPieceName(), "utf-8");
        else
            smallPieceName = "";
        dayPiece = dayservice.findMagerPieceDay(statisDate, countyName, name, id, prncpChnlId, prncpChnlName, bigPieceName, smallPieceName, pageno, pagesize);
        if((statisDate == "" || "".equals(statisDate)) && (name == "" || "".equals(name)) && (prncpChnlId == "" || "".equals(prncpChnlId)) && (prncpChnlName == "" || "".equals(prncpChnlName)) && (bigPieceName == "" || "".equals(bigPieceName)) && (smallPieceName == "" || "".equals(smallPieceName)))
        {
            totalCount = dayservice.countMagerPieceDay(statisDate, countyName, name, id, prncpChnlId, prncpChnlName, bigPieceName, smallPieceName);
        } else
        {
            export = dayservice.findMagerPieceDayNoPage(statisDate, countyName, name, id, prncpChnlId, prncpChnlName, bigPieceName, smallPieceName);
            totalCount = export.size();
        }
        JSONArray jsonArray = new JSONArray();
        if(dayPiece != null)
        {
            JSONObject jsonObject;
            for(Iterator iterator = dayPiece.iterator(); iterator.hasNext(); jsonArray.add(jsonObject))
            {
                Object daypiece[] = (Object[])iterator.next();
                jsonObject = new JSONObject();
                for(int i = 0; i < daypiece.length; i++)
                    jsonObject.put((new StringBuilder("value")).append(i).toString(), daypiece[i]);

            }

            JSONObject jsonObjectFinal1 = new JSONObject();
            jsonObjectFinal1.put("total", Integer.valueOf(totalCount));
            jsonObjectFinal1.put("rows", jsonArray);
            PrintWriter printWriter = response.getWriter();
            printWriter.print(jsonObjectFinal1.toString());
            printWriter.flush();
            printWriter.close();
        }
        return "success";
    }

    public String makecountysday()
        throws Exception
    {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("gbk");
        response.addHeader("Content-Type", "text/html;charset=gbk");
        countys = dayservice.findAllCounty(quanXianCountyName);
        JSONArray jsonArray = new JSONArray();
        if(countys.size() > 1)
        {
            for(int i = countys.size(); i >= 0; i--)
            {
                JSONObject jsonObjectFinal = new JSONObject();
                if(i != countys.size())
                {
                    String county = (String)countys.get(i);
                    jsonObjectFinal.put("id", county);
                    jsonObjectFinal.put("text", county);
                } else
                {
                    jsonObjectFinal.put("id", "--全部--");
                    jsonObjectFinal.put("text", "--全部--");
                }
                jsonArray.add(jsonObjectFinal);
            }

        } else
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", countys.get(0));
            jsonObject.put("text", countys.get(0));
            jsonArray.add(jsonObject);
        }
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonArray.toString());
        printWriter.flush();
        printWriter.close();
        return "success";
    }

    public String makenamesday()
        throws Exception
    {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("gbk");
        response.addHeader("Content-Type", "text/html;charset=gbk");
        names = dayservice.findAllnames(quanXianname, quanXianPost, quanXianCountyName);
        JSONArray jsonArray = new JSONArray();
        if(names.size() > 1)
        {
            for(int i = names.size(); i >= 0; i--)
            {
                JSONObject jsonObjectFinal = new JSONObject();
                if(i != names.size())
                {
                    String name = (String)names.get(i);
                    jsonObjectFinal.put("id", name);
                    jsonObjectFinal.put("text", name);
                } else
                {
                    jsonObjectFinal.put("id", "--全部--");
                    jsonObjectFinal.put("text", "--全部--");
                }
                jsonArray.add(jsonObjectFinal);
            }

        } else
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", names.get(0));
            jsonObject.put("text", names.get(0));
            jsonArray.add(jsonObject);
        }
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonArray.toString());
        printWriter.flush();
        printWriter.close();
        return "success";
    }

    public String makebigpieceD()
        throws Exception
    {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("gbk");
        response.addHeader("Content-Type", "text/html;charset=gbk");
        bigpieces = dayservice.findAllbig();
        JSONArray jsonArray = new JSONArray();
        if(bigpieces.size() > 1)
        {
            for(int i = bigpieces.size(); i >= 0; i--)
            {
                JSONObject jsonObjectFinal = new JSONObject();
                if(i != bigpieces.size())
                {
                    String big = (String)bigpieces.get(i);
                    jsonObjectFinal.put("id", big);
                    jsonObjectFinal.put("text", big);
                } else
                {
                    jsonObjectFinal.put("id", "--全部--");
                    jsonObjectFinal.put("text", "--全部--");
                }
                jsonArray.add(jsonObjectFinal);
            }

        } else
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", bigpieces.get(0));
            jsonObject.put("text", bigpieces.get(0));
            jsonArray.add(jsonObject);
        }
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonArray.toString());
        printWriter.flush();
        printWriter.close();
        return "success";
    }

    public String makesmallpieceD()
        throws Exception
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("gbk");
        response.addHeader("Content-Type", "text/html;charset=gbk");
        bigPieceName = URLDecoder.decode(model.getBigPieceName(), "utf-8");
        smallpieces = dayservice.findAllsmall(bigPieceName);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        for(int i = smallpieces.size(); i >= 0; i--)
        {
            if(i != smallpieces.size())
            {
                String small = (String)smallpieces.get(i);
                jsonObject.put("id", small);
                jsonObject.put("text", small);
            } else
            {
                jsonObject.put("id", "--全部--");
                jsonObject.put("text", "--全部--");
            }
            jsonArray.add(jsonObject);
        }

        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonArray.toString());
        printWriter.flush();
        printWriter.close();
        return "success";
    }

    public String findchinlnameD()
        throws Exception
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("gbk");
        response.addHeader("Content-Type", "text/html;charset=gbk");
        prncpChnlId = model.getPrncpChnlId();
        prncpChnlName = dayservice.findchnlname(prncpChnlId);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prncpChnlName", prncpChnlName);
        jsonArray.add(jsonObject);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonArray.toString());
        printWriter.flush();
        printWriter.close();
        return "success";
    }

    public String findchinlidD()
        throws Exception
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("gbk");
        response.addHeader("Content-Type", "text/html;charset=gbk");
        prncpChnlName = URLDecoder.decode(model.getPrncpChnlName(), "utf-8");
        prncpChnlId = dayservice.findchnlid(prncpChnlName);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prncpChnlId", prncpChnlId);
        jsonArray.add(jsonObject);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonArray.toString());
        printWriter.flush();
        printWriter.close();
        return "success";
    }

    public String exportDayPiece()
        throws Exception
    {
        String exportType = "xls";
        String header = "日期 县区 姓名 渠道编码 渠道名称 计件项目大类名称 计件项目小类名称 日发展量 日发展积分 日发展薪酬 月发展量 月发展积分 月发展薪酬  ";
        List a = export;
        List datalist = new ArrayList();
        for(int i = 0; i < a.size(); i++)
        {
            Object obj[] = (Object[])a.get(i);
            Object obj1[] = {
                obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6], obj[7], obj[8], obj[9], 
                obj[10], obj[11], obj[12]
            };
            datalist.add(((Object) (obj)));
        }

        FileInputStream result = PrintExcelUtil.getDownloadFile(exportType, "渠道经理日分项统计", "渠道经理日分项统计 ", header, datalist);
        contentType = "application/vnd.ms-excel;charset=utf-8";
        downloadFile = result;
        fileName = "渠道经理当日分项统计.xls";
        fileName = new String(fileName.getBytes(), "ISO8859-1");
        return "monthDownLoad";
    }

    public static void setQuanXianCountyName(String quanXianCountyName)
    {
        quanXianCountyName = quanXianCountyName;
    }

    public static String getQuanXianPost()
    {
        return quanXianPost;
    }

    public static void setQuanXianPost(String quanXianPost)
    {
        quanXianPost = quanXianPost;
    }

    public TBMangerPieceSmallDayService getDayservice()
    {
        return dayservice;
    }

    public void setDayservice(TBMangerPieceSmallDayService dayservice)
    {
        this.dayservice = dayservice;
    }

    public List getDayPiece()
    {
        return dayPiece;
    }

    public void setDayPiece(List dayPiece)
    {
        this.dayPiece = dayPiece;
    }

    public String getStatisDate()
    {
        return statisDate;
    }

    public void setStatisDate(String statisDate)
    {
        this.statisDate = statisDate;
    }

    public String getCountyName()
    {
        return countyName;
    }

    public void setCountyName(String countyName)
    {
        this.countyName = countyName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPrncpChnlId()
    {
        return prncpChnlId;
    }

    public void setPrncpChnlId(String prncpChnlId)
    {
        this.prncpChnlId = prncpChnlId;
    }

    public String getPrncpChnlName()
    {
        return prncpChnlName;
    }

    public void setPrncpChnlName(String prncpChnlName)
    {
        this.prncpChnlName = prncpChnlName;
    }

    public String getPost()
    {
        return post;
    }

    public void setPost(String post)
    {
        this.post = post;
    }

    public TbBasicInfoM getBasicInfoM()
    {
        return basicInfoM;
    }

    public void setBasicInfoM(TbBasicInfoM basicInfoM)
    {
        this.basicInfoM = basicInfoM;
    }

    public String getPnncpChnlType()
    {
        return pnncpChnlType;
    }

    public void setPnncpChnlType(String pnncpChnlType)
    {
        this.pnncpChnlType = pnncpChnlType;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public FileInputStream getDownloadFile()
    {
        return downloadFile;
    }

    public void setDownloadFile(FileInputStream downloadFile)
    {
        this.downloadFile = downloadFile;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getRegionId()
    {
        return regionId;
    }

    public void setRegionId(String regionId)
    {
        this.regionId = regionId;
    }

    public String getRegionName()
    {
        return regionName;
    }

    public void setRegionName(String regionName)
    {
        this.regionName = regionName;
    }
    
   

    public TBMangerPieceSmallDay getModel() {
		return model;
	}

	public void setModel(TBMangerPieceSmallDay model) {
		this.model = model;
	}



	TBMangerPieceSmallDayService dayservice;
    List dayPiece;
    private TBMangerPieceSmallDay model = new TBMangerPieceSmallDay();;
    private String statisDate;
    private String countyName;
    private String name;
    private String id;
    private String prncpChnlId;
    private String prncpChnlName;
    private String post;
    private String bigPieceName;
    private String smallPieceName;
    private TbBasicInfoM basicInfoM;
    private String pnncpChnlType;
    private static String idString;
    private static String quanXianCountyName;
    private static String quanXianname;
    private static String quanXianPost;
    private List countys;
    private List names;
    private List bigpieces;
    private List smallpieces;
    private int totalCount;
    private String roleName;
    private String userName;
    private String regionId;
    private String regionName;
    private static List export = new ArrayList();
    String contentType;
    FileInputStream downloadFile;
    String fileName;

}

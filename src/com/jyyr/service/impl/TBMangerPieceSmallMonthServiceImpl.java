// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 2013/5/16 10:26:20
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TBMangerPieceSmallMonthServiceImpl.java

package com.jyyr.service.impl;

import com.jyyr.dao.BaseDAO;
import com.jyyr.service.TBMangerPieceSmallMonthService;
import java.util.ArrayList;
import java.util.List;

public class TBMangerPieceSmallMonthServiceImpl
    implements TBMangerPieceSmallMonthService
{

   

    public List findMagerPieceMonth(String statisDate, String countyName, String name, String id, String prncpChnlId, String prncpChnlName, String bigPieceName, 
            String smallPieceName, int pageNo, int pageSize)
    {
        if((statisDate == "" || "".equals(statisDate)) && (name == "" || "".equals(name)) && (prncpChnlId == "" || "".equals(prncpChnlId)) && (prncpChnlName == "" || "".equals(prncpChnlName)) && (bigPieceName == "" || "".equals(bigPieceName)) && (smallPieceName == "" || "".equals(smallPieceName)))
        {
            String sql = (new StringBuilder("select a.STATIS_MONTH,a.COUNTY_NAME,a.NAME,a.CHNL_ID,a.CHNL_NAME,a.RECKON_PIECE_M_CLS_NAME,a.RECKON_PIECE_S_CLS_NAME,a.MON_SUM_DEV_CNT,a.MON_SUM_DEV_SCORE,a.MON_SUM_PAY from QINHUANGDAO.TB_PIECE_PART_DETL_INFO_M as a where a.STAFF_ID like '%")).append(id).append("' and a.COUNTY_NAME like '%").append(countyName).append("' order by a.STATIS_MONTH ").toString();
            return dao.querysql(sql, pageNo, pageSize);
        }
        List list = new ArrayList();
        StringBuffer buffer = new StringBuffer();
        if(statisDate != "" && !"--鍏ㄩ儴--".equals(statisDate))
            buffer.append("a.STATIS_MONTH,");
        else
        if(statisDate != "" && "--鍏ㄩ儴--".equals(statisDate))
        {
            buffer.append("a.STATIS_MONTH,");
            statisDate = "";
        } else
        {
            buffer.append("'-全部-',");
        }
        if(countyName != "" && !"--全部--".equals(countyName))
            buffer.append("a.COUNTY_NAME,");
        else
        if(countyName != "" && "--全部--".equals(countyName))
        {
            buffer.append("a.COUNTY_NAME,");
            countyName = "";
        } else
        {
            buffer.append("'-全部-',");
        }
        if(name != "" && !"--全部--".equals(name))
            buffer.append("a.NAME,");
        else
        if(name != "" && "--全部--".equals(name))
        {
            buffer.append("a.NAME,");
            name = "";
        } else
        {
            buffer.append("'-全部-',");
        }
        if(prncpChnlId != "")
            buffer.append("a.CHNL_ID,");
        else
            buffer.append("'-全部-',");
        if(prncpChnlName != "")
            buffer.append("a.CHNL_NAME,");
        else
            buffer.append("'-全部-',");
        if(bigPieceName != "" && !"--全部--".equals(bigPieceName))
            buffer.append("a.RECKON_PIECE_M_CLS_NAME,");
        else
        if(bigPieceName != "" && "--全部--".equals(bigPieceName))
        {
            buffer.append("a.RECKON_PIECE_M_CLS_NAME,");
            bigPieceName = "";
        } else
        {
            buffer.append("'-全部-',");
        }
        if(smallPieceName != "" && !"--全部--".equals(smallPieceName))
            buffer.append("a.RECKON_PIECE_S_CLS_NAME,");
        else
        if(smallPieceName != "" && "--全部--".equals(smallPieceName))
        {
            buffer.append("a.RECKON_PIECE_S_CLS_NAME,");
            smallPieceName = "";
        } else
        {
            buffer.append("'-全部-',");
        }
        int a = buffer.lastIndexOf(",");
        String buffer1 = buffer.substring(0, a);
        String sql = (new StringBuilder("select  ")).append(buffer).append(" sum(a.MON_SUM_DEV_CNT),sum(a.MON_SUM_DEV_SCORE),sum(a.MON_SUM_PAY) from QINHUANGDAO.TB_PIECE_PART_DETL_INFO_M as a where a.STATIS_MONTH like '%").append(statisDate).append("' and a.COUNTY_NAME like '%").append(countyName).append("' and a.NAME like '%").append(name).append("' and a.STAFF_ID like  '%").append(id).append("' and a.CHNL_ID like '%").append(prncpChnlId).append("' and a.CHNL_NAME like '%").append(prncpChnlName).append("' and a.RECKON_PIECE_M_CLS_NAME like '%").append(bigPieceName).append("' and a.RECKON_PIECE_S_CLS_NAME like '%").append(smallPieceName).append("' group  by ").append(buffer1).append("  ").toString();
        return dao.querysql(sql, pageNo, pageSize);
    }

    public int countMagerPieceMonth(String statisDate, String countyName, String name, String id, String prncpChnlId, String prncpChnlName, String bigPieceName, 
            String smallPieceName)
    {
        String hql = (new StringBuilder("select count(*) from TBMangerPieceSmallMonth as a where a.statisDate like '%")).append(statisDate).append("' and a.countyName like '%").append(countyName).append("' and a.name like '%").append(name).append("' and a.id like  '%").append(id).append("' and a.prncpChnlId like '%").append(prncpChnlId).append("' and a.prncpChnlName like '%").append(prncpChnlName).append("' and a.bigPieceName like '%").append(bigPieceName).append("' and a.smallPieceName like '%").append(smallPieceName).append("'").toString();
        return dao.countQuery(hql);
    }

    public List findMagerPieceMonthNoPage(String statisDate, String countyName, String name, String id, String prncpChnlId, String prncpChnlName, String bigPieceName, 
            String smallPieceName)
    {
        if((statisDate == "" || "".equals(statisDate)) && (name == "" || "".equals(name)) && (prncpChnlId == "" || "".equals(prncpChnlId)) && (prncpChnlName == "" || "".equals(prncpChnlName)) && (bigPieceName == "" || "".equals(bigPieceName)) && (smallPieceName == "" || "".equals(smallPieceName)))
        {
            String sql = (new StringBuilder("select a.STATIS_MONTH,a.COUNTY_NAME,a.NAME,a.CHNL_ID,a.CHNL_NAME,a.RECKON_PIECE_M_CLS_NAME,a.RECKON_PIECE_S_CLS_NAME,a.MON_SUM_DEV_CNT,a.MON_SUM_DEV_SCORE,a.MON_SUM_PAY from QINHUANGDAO.TB_PIECE_PART_DETL_INFO_M as a where a.STAFF_ID like '%")).append(id).append("' and a.COUNTY_NAME like '%").append(countyName).append("' order by a.STATIS_MONTH ").toString();
            return dao.querysql(sql);
        }
        List list = new ArrayList();
        StringBuffer buffer = new StringBuffer();
        if(statisDate != "" && !"--鍏ㄩ儴--".equals(statisDate))
            buffer.append("a.STATIS_MONTH,");
        else
        if(statisDate != "" && "--鍏ㄩ儴--".equals(statisDate))
        {
            buffer.append("a.STATIS_MONTH,");
            statisDate = "";
        } else
        {
            buffer.append("'-全部-',");
        }
        if(countyName != "" && !"--全部--".equals(countyName))
            buffer.append("a.COUNTY_NAME,");
        else
        if(countyName != "" && "--全部--".equals(countyName))
        {
            buffer.append("a.COUNTY_NAME,");
            countyName = "";
        } else
        {
            buffer.append("'-全部-',");
        }
        if(name != "" && !"--全部--".equals(name))
            buffer.append("a.NAME,");
        else
        if(name != "" && "--全部--".equals(name))
        {
            buffer.append("a.NAME,");
            name = "";
        } else
        {
            buffer.append("'-全部-',");
        }
        if(prncpChnlId != "")
            buffer.append("a.CHNL_ID,");
        else
            buffer.append("'-全部-',");
        if(prncpChnlName != "")
            buffer.append("a.CHNL_NAME,");
        else
            buffer.append("'-全部-',");
        if(bigPieceName != "" && !"--全部--".equals(bigPieceName))
            buffer.append("a.RECKON_PIECE_M_CLS_NAME,");
        else
        if(bigPieceName != "" && "--全部--".equals(bigPieceName))
        {
            buffer.append("a.RECKON_PIECE_M_CLS_NAME,");
            bigPieceName = "";
        } else
        {
            buffer.append("'-全部-',");
        }
        if(smallPieceName != "" && !"--全部--".equals(smallPieceName))
            buffer.append("a.RECKON_PIECE_S_CLS_NAME,");
        else
        if(smallPieceName != "" && "--全部--".equals(smallPieceName))
        {
            buffer.append("a.RECKON_PIECE_S_CLS_NAME,");
            smallPieceName = "";
        } else
        {
            buffer.append("'-全部-',");
        }
        int a = buffer.lastIndexOf(",");
        String buffer1 = buffer.substring(0, a);
        String sql = (new StringBuilder("select  ")).append(buffer).append(" sum(a.MON_SUM_DEV_CNT),sum(a.MON_SUM_DEV_SCORE),sum(a.MON_SUM_PAY) from QINHUANGDAO.TB_PIECE_PART_DETL_INFO_M as a where a.STATIS_MONTH like '%").append(statisDate).append("' and a.COUNTY_NAME like '%").append(countyName).append("' and a.NAME like '%").append(name).append("' and a.STAFF_ID like  '%").append(id).append("' and a.CHNL_ID like '%").append(prncpChnlId).append("' and a.CHNL_NAME like '%").append(prncpChnlName).append("' and a.RECKON_PIECE_M_CLS_NAME like '%").append(bigPieceName).append("' and a.RECKON_PIECE_S_CLS_NAME like '%").append(smallPieceName).append("' group  by ").append(buffer1).append("  ").toString();
        return dao.querysql(sql);
    }

    public List findUserById(String id)
    {
        return dao.query((new StringBuilder("from TbBasicInfoM AS A WHERE ID='")).append(id).append("'").toString());
    }

    public List findAllCounty(String countyName)
    {
        if(countyName != "秦皇岛市" && !"秦皇岛市".equals(countyName))
        {
            String hql = (new StringBuilder("select distinct a.countyName from TBMangerPieceSmallMonth as a WHERE a.countyName='")).append(countyName).append("'").toString();
            return dao.query(hql);
        } else
        {
            String hql = "select a.region from TbRegionDimCode as a where a.region in (select distinct b.countyName from TBMangerPieceSmallMonth as b )order by a.regioncode desc";
            return dao.query(hql);
        }
    }

    public List findAllnames(String name, String post, String county)
    {
        if(county == "秦皇岛市" || "秦皇岛市".equals(county))
        {
            String hql = "select distinct a.name from TBMangerPieceSmallMonth as a ";
            return dao.query(hql);
        }
        if(county != "秦皇岛市" && !"秦皇岛市".equals(county) && "区县负责人".equals(post))
        {
            String hql = (new StringBuilder("select distinct a.name from TBMangerPieceSmallMonth as a where a.countyName ='")).append(county).append("'").toString();
            return dao.query(hql);
        } else
        {
            String hql = (new StringBuilder("select distinct a.name from TBMangerPieceSmallMonth as a where a.name ='")).append(name).append("'").toString();
            return dao.query(hql);
        }
    }

    public List findAllbig()
    {
        String hql = "select distinct a.bigPieceName from TBMangerPieceSmallMonth as a order by a.bigPieceName ";
        return dao.query(hql);
    }

    public List findAllsmall(String bigpiecename)
    {
        String hql = (new StringBuilder("select distinct a.smallPieceName from TBMangerPieceSmallMonth as a where a.bigPieceName like '%")).append(bigpiecename).append("' order by a.smallPieceName").toString();
        return dao.query(hql);
    }

    public int sumcnt(String statisDate, String countyName, String name, String id, String prncpChnlId, String prncpChnlName, String bigPieceName, 
            String smallPieceName)
    {
        String hql = (new StringBuilder("select sum(a.monthCnt) from  TBMangerPieceSmallMonth as a where a.statisDate like '%")).append(statisDate).append("' and a.countyName like '%").append(countyName).append("' and a.name like '%").append(name).append("' and a.id like  '%").append(id).append("' and a.prncpChnlId like '%").append(prncpChnlId).append("' and a.prncpChnlName like '%").append(prncpChnlName).append("' and a.bigPieceName like '%").append(bigPieceName).append("' and a.smallPieceName like '%").append(smallPieceName).append("'").toString();
        return dao.countQuery(hql);
    }

    public String findchnlname(String prncpChnlId)
    {
        String hql = (new StringBuilder("select a.chnlName from TbDimChnlMagrChnlM as a where a.chnlId = '")).append(prncpChnlId).append("'").toString();
        return (String)dao.loadObject(hql);
    }

    public String findchnlid(String prncpChnlName)
    {
        String hql = (new StringBuilder("select a.chnlId from TbDimChnlMagrChnlM as a where a.chnlName = '")).append(prncpChnlName).append("'").toString();
        return (String)dao.loadObject(hql);
    }

    public BaseDAO getDao()
    {
        return dao;
    }

    public void setDao(BaseDAO dao)
    {
        this.dao = dao;
    }

    BaseDAO dao;
    private static Integer a;
}

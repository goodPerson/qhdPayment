// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 2013/5/16 11:14:09
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TbRegionDimCode.java

package com.jyyr.orm;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="TB_REGION_DIM_CODE", schema="qinhuangdao")
public class TbRegionDimCode
{

    public TbRegionDimCode()
    {
    }

    public Integer getRegioncode()
    {
        return regioncode;
    }

    public void setRegioncode(Integer regioncode)
    {
        this.regioncode = regioncode;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    @Id
    @Column(name="REGION_CODE", length=10)
    private Integer regioncode;
    @Column(name="REGION_NAME", length=20)
    private String region;
}

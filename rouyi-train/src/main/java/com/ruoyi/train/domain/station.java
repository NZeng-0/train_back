package com.ruoyi.train.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车站对象 t_station
 * 
 * @author me
 * @date 2025-03-11
 */
public class station extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 车站编号 */
    @Excel(name = "车站编号")
    private String code;

    /** 车站名称 */
    @Excel(name = "车站名称")
    private String name;

    /** 拼音 */
    @Excel(name = "拼音")
    private String spell;

    /** 车站地区 */
    @Excel(name = "车站地区")
    private String region;

    /** 车站地区名称 */
    @Excel(name = "车站地区名称")
    private String regionName;

    /** 删除标识 */
    private Integer delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setSpell(String spell) 
    {
        this.spell = spell;
    }

    public String getSpell() 
    {
        return spell;
    }

    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }

    public void setRegionName(String regionName) 
    {
        this.regionName = regionName;
    }

    public String getRegionName() 
    {
        return regionName;
    }

    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("spell", getSpell())
            .append("region", getRegion())
            .append("regionName", getRegionName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}

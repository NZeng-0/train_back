package com.ruoyi.train.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地区对象 t_region
 * 
 * @author me
 * @date 2025-03-18
 */
public class Region extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 地区名称 */
    @Excel(name = "地区名称")
    private String name;

    /** 地区全名 */
    @Excel(name = "地区全名")
    private String fullName;

    /** 地区编码 */
    @Excel(name = "地区编码")
    private String code;

    /** 地区首字母 */
    @Excel(name = "地区首字母")
    private String initial;

    /** 拼音 */
    @Excel(name = "拼音")
    private String spell;

    /** 热门标识 */
    @Excel(name = "热门标识")
    private Integer popularFlag;

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

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setFullName(String fullName) 
    {
        this.fullName = fullName;
    }

    public String getFullName() 
    {
        return fullName;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }

    public void setInitial(String initial) 
    {
        this.initial = initial;
    }

    public String getInitial() 
    {
        return initial;
    }

    public void setSpell(String spell) 
    {
        this.spell = spell;
    }

    public String getSpell() 
    {
        return spell;
    }

    public void setPopularFlag(Integer popularFlag) 
    {
        this.popularFlag = popularFlag;
    }

    public Integer getPopularFlag() 
    {
        return popularFlag;
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
            .append("name", getName())
            .append("fullName", getFullName())
            .append("code", getCode())
            .append("initial", getInitial())
            .append("spell", getSpell())
            .append("popularFlag", getPopularFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}

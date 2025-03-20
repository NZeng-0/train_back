package com.ruoyi.train.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 列车对象 t_train
 * 
 * @author me
 * @date 2025-03-17
 */
public class Train extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 列车车次 */
    @Excel(name = "列车车次")
    private String trainNumber;

    /** 列车类型 0：高铁 1：动车 2：普通车 */
    @Excel(name = "列车类型 0：高铁 1：动车 2：普通车")
    private Long trainType;

    /** 列车标签 0：复兴号 1：智能动车组 2：静音车厢 3：支持选铺 */
    @Excel(name = "列车标签 0：复兴号 1：智能动车组 2：静音车厢 3：支持选铺")
    private String trainTag;

    /** 列车品牌 0：GC-高铁/城际 1：D-动车 2：Z-直达 3：T-特快 4：K-快速 5：其他 6：复兴号 7：智能动车组 */
    @Excel(name = "列车品牌 0：GC-高铁/城际 1：D-动车 2：Z-直达 3：T-特快 4：K-快速 5：其他 6：复兴号 7：智能动车组")
    private String trainBrand;

    /** 起始站 */
    @Excel(name = "起始站")
    private String startStation;

    /** 终点站 */
    @Excel(name = "终点站")
    private String endStation;

    /** 起始城市 */
    @Excel(name = "起始城市")
    private String startRegion;

    /** 终点城市 */
    @Excel(name = "终点城市")
    private String endRegion;

    /** 销售时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "销售时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date saleTime;

    /** 销售状态 0：可售 1：不可售 2：未知 */
    @Excel(name = "销售状态 0：可售 1：不可售 2：未知")
    private Long saleStatus;

    /** 出发时间 */
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    @Excel(name = "出发时间", width = 30, dateFormat = "HH:mm")
    private Date departureTime;

    /** 到达时间 */
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    @Excel(name = "到达时间", width = 30, dateFormat = "HH:mm")
    private Date arrivalTime;

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

    public void setTrainNumber(String trainNumber) 
    {
        this.trainNumber = trainNumber;
    }

    public String getTrainNumber() 
    {
        return trainNumber;
    }

    public void setTrainType(Long trainType) 
    {
        this.trainType = trainType;
    }

    public Long getTrainType() 
    {
        return trainType;
    }

    public void setTrainTag(String trainTag) 
    {
        this.trainTag = trainTag;
    }

    public String getTrainTag() 
    {
        return trainTag;
    }

    public void setTrainBrand(String trainBrand) 
    {
        this.trainBrand = trainBrand;
    }

    public String getTrainBrand() 
    {
        return trainBrand;
    }

    public void setStartStation(String startStation) 
    {
        this.startStation = startStation;
    }

    public String getStartStation() 
    {
        return startStation;
    }

    public void setEndStation(String endStation) 
    {
        this.endStation = endStation;
    }

    public String getEndStation() 
    {
        return endStation;
    }

    public void setStartRegion(String startRegion) 
    {
        this.startRegion = startRegion;
    }

    public String getStartRegion() 
    {
        return startRegion;
    }

    public void setEndRegion(String endRegion) 
    {
        this.endRegion = endRegion;
    }

    public String getEndRegion() 
    {
        return endRegion;
    }

    public void setSaleTime(Date saleTime) 
    {
        this.saleTime = saleTime;
    }

    public Date getSaleTime() 
    {
        return saleTime;
    }

    public void setSaleStatus(Long saleStatus) 
    {
        this.saleStatus = saleStatus;
    }

    public Long getSaleStatus() 
    {
        return saleStatus;
    }

    public void setDepartureTime(Date departureTime) 
    {
        this.departureTime = departureTime;
    }

    public Date getDepartureTime() 
    {
        return departureTime;
    }

    public void setArrivalTime(Date arrivalTime) 
    {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime() 
    {
        return arrivalTime;
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
            .append("trainNumber", getTrainNumber())
            .append("trainType", getTrainType())
            .append("trainTag", getTrainTag())
            .append("trainBrand", getTrainBrand())
            .append("startStation", getStartStation())
            .append("endStation", getEndStation())
            .append("startRegion", getStartRegion())
            .append("endRegion", getEndRegion())
            .append("saleTime", getSaleTime())
            .append("saleStatus", getSaleStatus())
            .append("departureTime", getDepartureTime())
            .append("arrivalTime", getArrivalTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}

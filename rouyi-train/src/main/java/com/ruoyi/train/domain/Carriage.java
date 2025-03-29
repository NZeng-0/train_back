package com.ruoyi.train.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车厢对象 t_carriage
 * 
 * @author me
 * @date 2025-03-28
 */
public class Carriage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 列车ID */
    @Excel(name = "列车ID")
    private Long trainId;

    /** 车厢号 */
    @Excel(name = "车厢号")
    private String carriageNumber;

    /** 车厢类型 */
    @Excel(name = "车厢类型")
    private Long carriageType;

    /** 座位数 */
    @Excel(name = "座位数")
    private Long seatCount;

    /** 删除标识 */
    private Integer delFlag;

    /** 已售座位数 */
    @Excel(name = "已售座位数")
    private Long soldSeats;

    /** 坐席价格 */
    @Excel(name = "坐席价格")
    private BigDecimal price;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setTrainId(Long trainId) 
    {
        this.trainId = trainId;
    }

    public Long getTrainId() 
    {
        return trainId;
    }

    public void setCarriageNumber(String carriageNumber) 
    {
        this.carriageNumber = carriageNumber;
    }

    public String getCarriageNumber() 
    {
        return carriageNumber;
    }

    public void setCarriageType(Long carriageType) 
    {
        this.carriageType = carriageType;
    }

    public Long getCarriageType() 
    {
        return carriageType;
    }

    public void setSeatCount(Long seatCount) 
    {
        this.seatCount = seatCount;
    }

    public Long getSeatCount() 
    {
        return seatCount;
    }

    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }

    public void setSoldSeats(Long soldSeats) 
    {
        this.soldSeats = soldSeats;
    }

    public Long getSoldSeats() 
    {
        return soldSeats;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("trainId", getTrainId())
            .append("carriageNumber", getCarriageNumber())
            .append("carriageType", getCarriageType())
            .append("seatCount", getSeatCount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("soldSeats", getSoldSeats())
            .append("price", getPrice())
            .toString();
    }
}

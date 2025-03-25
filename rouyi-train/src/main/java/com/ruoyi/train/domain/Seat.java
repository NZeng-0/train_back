package com.ruoyi.train.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 座位对象 t_seat
 * 
 * @author me
 * @date 2025-03-18
 */
public class Seat extends BaseEntity
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

    /** 座位号 */
    @Excel(name = "座位号")
    private String seatNumber;

    /** 座位类型 */
    @Excel(name = "座位类型")
    private Long seatType;

    /** 起始站 */
    @Excel(name = "起始站")
    private String startStation;

    /** 终点站 */
    @Excel(name = "终点站")
    private String endStation;

    /** 车票价格 */
    @Excel(name = "车票价格")
    private Long price;

    /** 座位状态 */
    @Excel(name = "座位状态")
    private Long seatStatus;

    /** 删除标识 */
    private Integer delFlag;

    public Seat() {

    }

    public Seat(
            Long trainId,
            String carriageNumber,
            String seatNumber,
            Long seatType,
            String startStation,
            String endStation,
            Long price,
            Long seatStatus
    ) {
        this.trainId = trainId;
        this.carriageNumber = carriageNumber;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.startStation = startStation;
        this.endStation = endStation;
        this.price = price;
        this.seatStatus = seatStatus;
        this.delFlag = 0;
    }

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

    public void setSeatNumber(String seatNumber) 
    {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() 
    {
        return seatNumber;
    }

    public void setSeatType(Long seatType) 
    {
        this.seatType = seatType;
    }

    public Long getSeatType() 
    {
        return seatType;
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

    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }

    public void setSeatStatus(Long seatStatus) 
    {
        this.seatStatus = seatStatus;
    }

    public Long getSeatStatus() 
    {
        return seatStatus;
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
            .append("trainId", getTrainId())
            .append("carriageNumber", getCarriageNumber())
            .append("seatNumber", getSeatNumber())
            .append("seatType", getSeatType())
            .append("startStation", getStartStation())
            .append("endStation", getEndStation())
            .append("price", getPrice())
            .append("seatStatus", getSeatStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}

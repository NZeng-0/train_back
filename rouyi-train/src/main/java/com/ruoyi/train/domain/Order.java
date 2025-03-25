package com.ruoyi.train.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 t_order
 * 
 * @author me
 * @date 2025-03-25
 */
public class Order extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderSn;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 列车ID */
    @Excel(name = "列车ID")
    private Long trainId;

    /** 列车车次 */
    @Excel(name = "列车车次")
    private String trainNumber;

    /** 乘车日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "乘车日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ridingDate;

    /** 出发站点 */
    @Excel(name = "出发站点")
    private String departure;

    /** 到达站点 */
    @Excel(name = "到达站点")
    private String arrival;

    /** 出发时间 */
    @JsonFormat(pattern = "HH:mm")
    @Excel(name = "出发时间", width = 30, dateFormat = "HH:mm")
    private Date departureTime;

    /** 到达时间 */
    @JsonFormat(pattern = "HH:mm")
    @Excel(name = "到达时间", width = 30, dateFormat = "HH:mm")
    private Date arrivalTime;

    /** 座位类型 */
    @Excel(name = "座位类型")
    private Long seatType;

    /** 车厢号 */
    @Excel(name = "车厢号")
    private String carriageNumber;

    /** 座位号 */
    @Excel(name = "座位号")
    private String seatNumber;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String realName;

    /** 车票类型 */
    @Excel(name = "车票类型")
    private Long ticketType;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private Long amount;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Long status;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private Long payType;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

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

    public void setOrderSn(String orderSn) 
    {
        this.orderSn = orderSn;
    }

    public String getOrderSn() 
    {
        return orderSn;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setTrainId(Long trainId) 
    {
        this.trainId = trainId;
    }

    public Long getTrainId() 
    {
        return trainId;
    }

    public void setTrainNumber(String trainNumber) 
    {
        this.trainNumber = trainNumber;
    }

    public String getTrainNumber() 
    {
        return trainNumber;
    }

    public void setRidingDate(Date ridingDate) 
    {
        this.ridingDate = ridingDate;
    }

    public Date getRidingDate() 
    {
        return ridingDate;
    }

    public void setDeparture(String departure) 
    {
        this.departure = departure;
    }

    public String getDeparture() 
    {
        return departure;
    }

    public void setArrival(String arrival) 
    {
        this.arrival = arrival;
    }

    public String getArrival() 
    {
        return arrival;
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

    public void setSeatType(Long seatType) 
    {
        this.seatType = seatType;
    }

    public Long getSeatType() 
    {
        return seatType;
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

    public void setRealName(String realName) 
    {
        this.realName = realName;
    }

    public String getRealName() 
    {
        return realName;
    }

    public void setTicketType(Long ticketType) 
    {
        this.ticketType = ticketType;
    }

    public Long getTicketType() 
    {
        return ticketType;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Long getAmount() 
    {
        return amount;
    }

    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    public void setPayType(Long payType) 
    {
        this.payType = payType;
    }

    public Long getPayType() 
    {
        return payType;
    }

    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
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
            .append("orderSn", getOrderSn())
            .append("userId", getUserId())
            .append("trainId", getTrainId())
            .append("trainNumber", getTrainNumber())
            .append("ridingDate", getRidingDate())
            .append("departure", getDeparture())
            .append("arrival", getArrival())
            .append("departureTime", getDepartureTime())
            .append("arrivalTime", getArrivalTime())
            .append("seatType", getSeatType())
            .append("carriageNumber", getCarriageNumber())
            .append("seatNumber", getSeatNumber())
            .append("realName", getRealName())
            .append("ticketType", getTicketType())
            .append("phone", getPhone())
            .append("amount", getAmount())
            .append("status", getStatus())
            .append("payType", getPayType())
            .append("payTime", getPayTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}

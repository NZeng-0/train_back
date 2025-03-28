package com.ruoyi.train.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.train.mapper.CarriageMapper;
import com.ruoyi.train.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.train.mapper.OrderMapper;
import com.ruoyi.train.domain.Order;
import com.ruoyi.train.service.IOrderService;

/**
 * 订单Service业务层处理
 * 
 * @author me
 * @date 2025-03-25
 */
@Service
public class OrderServiceImpl implements IOrderService 
{
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private CarriageMapper carriageMapper;

    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    @Override
    public Order selectOrderById(String id)
    {
        return orderMapper.selectOrderById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param order 订单
     * @return 订单
     */
    @Override
    public List<Order> selectOrderList(Order order)
    {
        return orderMapper.selectOrderList(order);
    }

    /**
     * 新增订单
     * 
     * @param order 订单
     * @return 结果
     */
    @Override
    public int insertOrder(Order order) {
        order.setOrderSn(setOrderSn());
        order.setDelFlag(0);
        order.setCreateTime(DateUtils.getNowDate());
        order.setUpdateTime(DateUtils.getNowDate());
        order.setPayTime(DateUtils.getNowDate());
        Long id = seatMapper.getSeatByCoachAndNumber(order.getCarriageNumber(), order.getSeatNumber());
        seatMapper.updateSeatStatus(String.valueOf(id), 2);
        carriageMapper.updateSoldSeats(order.getTrainId().toString(), Integer.parseInt(order.getCarriageNumber()),order.getSeatType().intValue());
        return orderMapper.insertOrder(order);
    }

    /**
     * 修改订单
     * 
     * @param order 订单
     * @return 结果
     */
    @Override
    public int updateOrder(Order order)
    {
        order.setUpdateTime(DateUtils.getNowDate());
        return orderMapper.updateOrder(order);
    }

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteOrderByIds(String[] ids)
    {
        return orderMapper.deleteOrderByIds(ids);
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    @Override
    public int deleteOrderById(String id)
    {
        return orderMapper.deleteOrderById(id);
    }

    public List<Order> getMyOrder(String id) {
        return orderMapper.selectOrderByUserId(id);
    }

    private String setOrderSn() {
        String orderSn;
        do {
            orderSn = generateOrderSn();
        } while (orderMapper.existsByOrderSn(orderSn));
        return orderSn;
    }

    private String generateOrderSn() {
        // 取时间戳后 10 位
        long timestamp = System.currentTimeMillis() % 10000000000L;
        // 生成 2 位随机数
        int randomNum = (int) (Math.random() * 100);
        // 组合成 10 位订单号
        return String.format("%08d%02d", timestamp, randomNum);
    }
}

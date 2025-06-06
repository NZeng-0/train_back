package com.ruoyi.train.service;

import java.util.List;
import com.ruoyi.train.domain.Order;

/**
 * 订单Service接口
 * 
 * @author me
 * @date 2025-03-25
 */
public interface IOrderService 
{
    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    public Order selectOrderById(String id);

    /**
     * 查询订单列表
     * 
     * @param order 订单
     * @return 订单集合
     */
    public List<Order> selectOrderList(Order order);

    /**
     * 新增订单
     * 
     * @param order 订单
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改订单
     * 
     * @param order 订单
     * @return 结果
     */
    public int updateOrder(Order order);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键集合
     * @return 结果
     */
    public int deleteOrderByIds(String[] ids);

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    public int deleteOrderById(String id);

    // 用户获取中间的订单信息
    List<Order> getMyOrder(String id, int status);

    Boolean exitsToday(String user_id, String date, String departure, String arrival);

    int cancelOrder(String id);
}

package com.ruoyi.train.mapper;

import java.util.List;
import com.ruoyi.train.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 订单Mapper接口
 * 
 * @author me
 * @date 2025-03-25
 */
@Mapper
public interface OrderMapper 
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
     * 删除订单
     * 
     * @param id 订单主键
     * @return 结果
     */
    public int deleteOrderById(String id);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderByIds(String[] ids);

    @Select("SELECT COUNT(*) FROM t_order WHERE order_sn = #{orderSn}")
    boolean existsByOrderSn(@Param("orderSn") String orderSn);

    List<Order> selectOrderByUserId(@Param("user_id")String id);
}

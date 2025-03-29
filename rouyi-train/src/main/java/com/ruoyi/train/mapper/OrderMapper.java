package com.ruoyi.train.mapper;

import java.time.LocalDateTime;
import java.util.List;
import com.ruoyi.train.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 查询用户特定状态的订单
     */
    List<Order> selectOrdersByUserIdAndStatus(@Param("userId") String userId, @Param("status") int status);


    boolean existsToday(
            @Param("user_id") String user_id,
            @Param("riding_date") String date,
            @Param("departure") String departure,
            @Param("arrival") String arrival
    );

    /**
     * 查找所有过期的订单
     * 由于riding_date和arrival_time是分开存储的，我们需要合并它们进行比较
     */
    @Select("SELECT * FROM t_order WHERE status = #{paidStatus} " +
            "AND status != #{refundedStatus} " +
            "AND status != #{completedStatus} " +
            "AND CONCAT(riding_date, ' ', arrival_time) < NOW() " +
            "AND del_flag = 0")
    List<Order> findExpiredOrders(@Param("paidStatus") int paidStatus,
                                  @Param("refundedStatus") int refundedStatus,
                                  @Param("completedStatus") int completedStatus);

    /**
     * 获取所有要处理的订单记录
     */
    @Select("SELECT * FROM t_order WHERE status = 1 AND del_flag = 0")
    List<Order> getAllPaidOrders();

    /**
     * 更新订单状态
     */
    @Update("UPDATE t_order SET status = #{status}, update_time = #{updateTime} " +
            "WHERE id = #{id}")
    int updateOrderStatus(Order order);

    /**
     * 取消订单
     */
    @Update("UPDATE t_order SET status = 2, update_time = #{updateTime} WHERE id = #{id}")
    int cancelOrder(@Param("id") String id, @Param("updateTime") LocalDateTime updateTime);

}

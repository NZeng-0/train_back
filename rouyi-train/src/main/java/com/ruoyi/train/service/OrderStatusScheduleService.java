package com.ruoyi.train.service;

import com.ruoyi.train.domain.Order;
import com.ruoyi.train.enums.OrderStatus;
import com.ruoyi.train.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 应用启动时执行的服务
 */

@Service
public class OrderStatusScheduleService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 应用启动时执行一次
     */
    @PostConstruct
    public void initOrderStatus() {
        log.info("系统启动，开始检查并更新过期订单状态...");
        updateExpiredOrders();
        log.info("过期订单状态更新完成");
    }

    /**
     * 定时任务：每天凌晨2点执行一次
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void scheduledUpdateOrderStatus() {
        log.info("定时任务开始：检查并更新过期订单状态");
        updateExpiredOrders();
        log.info("定时任务完成：过期订单状态更新完成");
    }

    /**
     * 更新所有过期未退票的订单为已完成状态
     */
    public void updateExpiredOrders() {
        try {
            // 首先输出当前系统时间，用于调试
            log.info("当前系统时间: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            // 查找所有已支付且乘车日期已过但未被标记为已完成或已退票的订单
            List<Order> expiredOrders = orderMapper.findExpiredOrders(
                    OrderStatus.PAID.getCode(),
                    OrderStatus.REFUNDED.getCode(),
                    OrderStatus.COMPLETED.getCode()
            );

            // 调试: 获取所有已支付订单并打印，检查是否有数据
            List<Order> allPaidOrders = orderMapper.getAllPaidOrders();
            log.info("当前系统中所有已支付订单数量: {}", allPaidOrders.size());
            for (Order order : allPaidOrders) {
                log.info("订单ID: {}, 订单号: {}, 乘车日期: {}, 到达时间: {}, 当前状态: {}",
                        order.getId(),
                        order.getOrderSn(),
                        new SimpleDateFormat("yyyy-MM-dd").format(order.getRidingDate()),
                        new SimpleDateFormat("HH:mm").format(order.getArrivalTime()),
                        order.getStatus());

                // 计算订单的完整乘车时间
                Calendar cal = Calendar.getInstance();
                cal.setTime(order.getRidingDate());

                Calendar arrivalCal = Calendar.getInstance();
                arrivalCal.setTime(order.getArrivalTime());

                cal.set(Calendar.HOUR_OF_DAY, arrivalCal.get(Calendar.HOUR_OF_DAY));
                cal.set(Calendar.MINUTE, arrivalCal.get(Calendar.MINUTE));
                cal.set(Calendar.SECOND, arrivalCal.get(Calendar.SECOND));

                String fullRidingTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
                log.info("订单 {} 的完整乘车到达时间: {}, 是否已过期: {}",
                        order.getOrderSn(),
                        fullRidingTime,
                        cal.getTime().before(new Date()));
            }

            if (expiredOrders == null || expiredOrders.isEmpty()) {
                log.info("没有需要更新的过期订单");
                return;
            }

            log.info("发现{}张过期未完成订单，开始更新状态", expiredOrders.size());

            for (Order order : expiredOrders) {
                try {
                    log.info("更新订单: {}, 原状态: {}", order.getOrderSn(), order.getStatus());
                    order.setStatus((long) OrderStatus.COMPLETED.getCode());
                    order.setUpdateTime(new Date());
                    int result = orderMapper.updateOrderStatus(order);
                    log.info("更新结果: {} (1表示成功)", result);
                } catch (Exception e) {
                    log.error("更新订单状态失败，订单号: {}, 错误: {}", order.getOrderSn(), e.getMessage(), e);
                }
            }
        } catch (Exception e) {
            log.error("处理过期订单时发生错误: {}", e.getMessage(), e);
        }
    }
}




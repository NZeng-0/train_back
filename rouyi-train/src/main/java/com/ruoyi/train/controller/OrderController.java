package com.ruoyi.train.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.train.domain.Order;
import com.ruoyi.train.service.IOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单Controller
 *
 * @author me
 * @date 2025-03-25
 */
@RestController
@RequestMapping("/train/order")
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;

    /**
     * 查询订单列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Order order) {
        startPage();
        List<Order> list = orderService.selectOrderList(order);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, Order order) {
        List<Order> list = orderService.selectOrderList(order);
        ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        util.exportExcel(response, list, "订单数据");
    }

    /**
     * 获取订单详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return success(orderService.selectOrderById(id));
    }

    /**
     * 新增订单
     */
    @PostMapping
    public AjaxResult add(@RequestBody Order order) {
        return toAjax(orderService.insertOrder(order));
    }

    /**
     * 修改订单
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Order order) {
        return toAjax(orderService.updateOrder(order));
    }

    /**
     * 删除订单
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(orderService.deleteOrderByIds(ids));
    }

    @GetMapping("my")
    public TableDataInfo getMyOrder(
            @RequestParam("id") String id,
            @RequestParam(value = "status", defaultValue = "-1") int status) {
        startPage();
        List<Order> list = orderService.getMyOrder(id, status);
        return getDataTable(list);
    }

    @GetMapping("exists")
    public AjaxResult existsToday(
            @RequestParam("userId") String id,
            @RequestParam("date") String date,
            @RequestParam("departure") String departure,
            @RequestParam("arrival") String arrival

    ) {
        Boolean b = orderService.exitsToday(id, date, departure, arrival);
        if (b) {
            return error("您在该日期已有相似行程，请检查");
        } else {
            return success("ok");
        }
    }

    @GetMapping("cancel")
    public AjaxResult cancelOrder(@RequestParam("id") String id) {
        int result = orderService.cancelOrder(id);
        if (result > 0) {
            return success("订单取消成功");
        } else {
            return error("订单取消失败，可能已经被取消或状态不符合");
        }
    }
}

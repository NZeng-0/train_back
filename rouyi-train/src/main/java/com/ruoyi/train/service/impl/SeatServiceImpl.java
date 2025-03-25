package com.ruoyi.train.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.train.mapper.SeatMapper;
import com.ruoyi.train.domain.Seat;
import com.ruoyi.train.service.ISeatService;

/**
 * 座位Service业务层处理
 * 
 * @author me
 * @date 2025-03-18
 */
@Service
public class SeatServiceImpl implements ISeatService 
{
    @Autowired
    private SeatMapper seatMapper;

    /**
     * 查询座位
     * 
     * @param id 座位主键
     * @return 座位
     */
    @Override
    public Seat selectSeatById(String id)
    {
        return seatMapper.selectSeatById(id);
    }

    /**
     * 查询座位列表
     * 
     * @param seat 座位
     * @return 座位
     */
    @Override
    public List<Seat> selectSeatList(Seat seat)
    {
        return seatMapper.selectSeatList(seat);
    }

    /**
     * 新增座位
     * 
     * @param seat 座位
     * @return 结果
     */
    @Override
    public int insertSeat(Seat seat)
    {
        seat.setCreateTime(DateUtils.getNowDate());
        return seatMapper.insertSeat(seat);
    }

    /**
     * 修改座位
     * 
     * @param seat 座位
     * @return 结果
     */
    @Override
    public int updateSeat(Seat seat)
    {
        seat.setUpdateTime(DateUtils.getNowDate());
        return seatMapper.updateSeat(seat);
    }

    /**
     * 批量删除座位
     * 
     * @param ids 需要删除的座位主键
     * @return 结果
     */
    @Override
    public int deleteSeatByIds(String[] ids)
    {
        return seatMapper.deleteSeatByIds(ids);
    }

    /**
     * 删除座位信息
     * 
     * @param id 座位主键
     * @return 结果
     */
    @Override
    public int deleteSeatById(String id)
    {
        return seatMapper.deleteSeatById(id);
    }

    public Seat selectSeatByTrainAndType(String id, String type, String number) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("type", type);

        List<Seat> seats = seatMapper.selectSeatByTrainIdAndType(params);
        List<Seat> seats2 = seats.stream()
                .filter(seat -> seat.getSeatNumber().endsWith(number))
                .collect(Collectors.toList());

        Random random = new Random();
        Seat selectedSeat = null;

        if (!seats2.isEmpty()) {
            selectedSeat = seats2.get(random.nextInt(seats2.size())); // 从 seats2 随机选一条
        } else if (!seats.isEmpty()) {
            selectedSeat = seats.get(random.nextInt(seats.size())); // seats2 为空时，从 seats 中随机选一条
        }

        if (selectedSeat != null) {
            // 1. 立即更新 seat_status 为 1（占用）
            seatMapper.updateSeatStatus(selectedSeat.getId(), 1);

            // 2. 开启一个定时任务，1 分钟后检查支付状态
            scheduleSeatRelease(selectedSeat);
        }

        return selectedSeat;
    }

    public void cancelSeatTicket(String id) {
        seatMapper.updateSeatStatus(id, 0);
    }

    private void scheduleSeatRelease(Seat seat) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> {
            // 再次查询该座位是否已支付
            Integer status = seatMapper.getSeatStatusById(seat.getId());
            if (status != null && status == 1) {
                // 订单未支付，恢复 seat_status = 0（可用）
                seatMapper.updateSeatStatus(seat.getId(), 0);
            }
        }, 1, TimeUnit.MINUTES); // 1分钟后执行
    }
}

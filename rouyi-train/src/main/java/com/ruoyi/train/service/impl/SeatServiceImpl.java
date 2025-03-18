package com.ruoyi.train.service.impl;

import java.util.List;
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
}

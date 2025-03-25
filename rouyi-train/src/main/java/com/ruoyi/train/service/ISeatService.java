package com.ruoyi.train.service;

import java.util.List;
import com.ruoyi.train.domain.Seat;

/**
 * 座位Service接口
 * 
 * @author me
 * @date 2025-03-18
 */
public interface ISeatService 
{
    /**
     * 查询座位
     * 
     * @param id 座位主键
     * @return 座位
     */
    public Seat selectSeatById(String id);

    /**
     * 查询座位列表
     * 
     * @param seat 座位
     * @return 座位集合
     */
    public List<Seat> selectSeatList(Seat seat);

    /**
     * 新增座位
     * 
     * @param seat 座位
     * @return 结果
     */
    public int insertSeat(Seat seat);

    /**
     * 修改座位
     * 
     * @param seat 座位
     * @return 结果
     */
    public int updateSeat(Seat seat);

    /**
     * 批量删除座位
     * 
     * @param ids 需要删除的座位主键集合
     * @return 结果
     */
    public int deleteSeatByIds(String[] ids);

    /**
     * 删除座位信息
     * 
     * @param id 座位主键
     * @return 结果
     */
    public int deleteSeatById(String id);

    Seat selectSeatByTrainAndType(String id,String type, String number);

    void cancelSeatTicket(String id);
}

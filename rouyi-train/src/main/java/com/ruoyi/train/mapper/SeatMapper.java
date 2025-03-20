package com.ruoyi.train.mapper;

import java.util.List;
import com.ruoyi.train.domain.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

/**
 * 座位Mapper接口
 * 
 * @author me
 * @date 2025-03-18
 */
@Mapper
public interface SeatMapper 
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
     * 删除座位
     * 
     * @param id 座位主键
     * @return 结果
     */
    public int deleteSeatById(String id);

    /**
     * 批量删除座位
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSeatByIds(String[] ids);

    void batchInsertSeats(@Param("list") List<Seat> seats);

}

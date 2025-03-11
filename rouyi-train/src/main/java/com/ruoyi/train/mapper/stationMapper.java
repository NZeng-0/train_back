package com.ruoyi.train.mapper;

import java.util.List;
import com.ruoyi.train.domain.station;

/**
 * 车站Mapper接口
 * 
 * @author me
 * @date 2025-03-11
 */
public interface stationMapper 
{
    /**
     * 查询车站
     * 
     * @param id 车站主键
     * @return 车站
     */
    public station selectstationById(String id);

    /**
     * 查询车站列表
     * 
     * @param station 车站
     * @return 车站集合
     */
    public List<station> selectstationList(station station);

    /**
     * 新增车站
     * 
     * @param station 车站
     * @return 结果
     */
    public int insertstation(station station);

    /**
     * 修改车站
     * 
     * @param station 车站
     * @return 结果
     */
    public int updatestation(station station);

    /**
     * 删除车站
     * 
     * @param id 车站主键
     * @return 结果
     */
    public int deletestationById(String id);

    /**
     * 批量删除车站
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletestationByIds(String[] ids);
}

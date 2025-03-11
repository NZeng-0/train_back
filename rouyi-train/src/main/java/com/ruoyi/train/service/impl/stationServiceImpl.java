package com.ruoyi.train.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.train.mapper.stationMapper;
import com.ruoyi.train.domain.station;
import com.ruoyi.train.service.IstationService;

/**
 * 车站Service业务层处理
 * 
 * @author me
 * @date 2025-03-11
 */
@Service
public class stationServiceImpl implements IstationService 
{
    @Autowired
    private stationMapper stationMapper;

    /**
     * 查询车站
     * 
     * @param id 车站主键
     * @return 车站
     */
    @Override
    public station selectstationById(String id)
    {
        return stationMapper.selectstationById(id);
    }

    /**
     * 查询车站列表
     * 
     * @param station 车站
     * @return 车站
     */
    @Override
    public List<station> selectstationList(station station)
    {
        return stationMapper.selectstationList(station);
    }

    /**
     * 新增车站
     * 
     * @param station 车站
     * @return 结果
     */
    @Override
    public int insertstation(station station)
    {
        station.setCreateTime(DateUtils.getNowDate());
        return stationMapper.insertstation(station);
    }

    /**
     * 修改车站
     * 
     * @param station 车站
     * @return 结果
     */
    @Override
    public int updatestation(station station)
    {
        station.setUpdateTime(DateUtils.getNowDate());
        return stationMapper.updatestation(station);
    }

    /**
     * 批量删除车站
     * 
     * @param ids 需要删除的车站主键
     * @return 结果
     */
    @Override
    public int deletestationByIds(String[] ids)
    {
        return stationMapper.deletestationByIds(ids);
    }

    /**
     * 删除车站信息
     * 
     * @param id 车站主键
     * @return 结果
     */
    @Override
    public int deletestationById(String id)
    {
        return stationMapper.deletestationById(id);
    }
}

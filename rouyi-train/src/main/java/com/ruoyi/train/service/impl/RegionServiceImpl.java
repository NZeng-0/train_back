package com.ruoyi.train.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.train.mapper.RegionMapper;
import com.ruoyi.train.domain.Region;
import com.ruoyi.train.service.IRegionService;

/**
 * 地区Service业务层处理
 * 
 * @author me
 * @date 2025-03-18
 */
@Service
public class RegionServiceImpl implements IRegionService 
{
    @Autowired
    private RegionMapper regionMapper;

    /**
     * 查询地区
     * 
     * @param id 地区主键
     * @return 地区
     */
    @Override
    public Region selectRegionById(String id)
    {
        return regionMapper.selectRegionById(id);
    }

    /**
     * 查询地区列表
     * 
     * @param region 地区
     * @return 地区
     */
    @Override
    public List<Region> selectRegionList(Region region)
    {
        return regionMapper.selectRegionList(region);
    }

    /**
     * 新增地区
     * 
     * @param region 地区
     * @return 结果
     */
    @Override
    public int insertRegion(Region region)
    {
        region.setCreateTime(DateUtils.getNowDate());
        return regionMapper.insertRegion(region);
    }

    /**
     * 修改地区
     * 
     * @param region 地区
     * @return 结果
     */
    @Override
    public int updateRegion(Region region)
    {
        region.setUpdateTime(DateUtils.getNowDate());
        return regionMapper.updateRegion(region);
    }

    /**
     * 批量删除地区
     * 
     * @param ids 需要删除的地区主键
     * @return 结果
     */
    @Override
    public int deleteRegionByIds(String[] ids)
    {
        return regionMapper.deleteRegionByIds(ids);
    }

    /**
     * 删除地区信息
     * 
     * @param id 地区主键
     * @return 结果
     */
    @Override
    public int deleteRegionById(String id)
    {
        return regionMapper.deleteRegionById(id);
    }
}

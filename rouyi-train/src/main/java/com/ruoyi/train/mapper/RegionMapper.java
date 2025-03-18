package com.ruoyi.train.mapper;

import java.util.List;
import com.ruoyi.train.domain.Region;
import org.apache.ibatis.annotations.Mapper;

/**
 * 地区Mapper接口
 * 
 * @author me
 * @date 2025-03-18
 */
@Mapper
public interface RegionMapper 
{
    /**
     * 查询地区
     * 
     * @param id 地区主键
     * @return 地区
     */
    public Region selectRegionById(String id);

    /**
     * 查询地区列表
     * 
     * @param region 地区
     * @return 地区集合
     */
    public List<Region> selectRegionList(Region region);

    /**
     * 新增地区
     * 
     * @param region 地区
     * @return 结果
     */
    public int insertRegion(Region region);

    /**
     * 修改地区
     * 
     * @param region 地区
     * @return 结果
     */
    public int updateRegion(Region region);

    /**
     * 删除地区
     * 
     * @param id 地区主键
     * @return 结果
     */
    public int deleteRegionById(String id);

    /**
     * 批量删除地区
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRegionByIds(String[] ids);
}

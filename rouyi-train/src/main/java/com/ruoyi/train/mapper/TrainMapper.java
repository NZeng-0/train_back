package com.ruoyi.train.mapper;

import java.util.List;
import com.ruoyi.train.domain.Train;
import org.apache.ibatis.annotations.Mapper;

/**
 * 列车Mapper接口
 * 
 * @author me
 * @date 2025-03-17
 */
@Mapper
public interface TrainMapper 
{
    /**
     * 查询列车
     * 
     * @param id 列车主键
     * @return 列车
     */
    public Train selectTrainById(String id);

    /**
     * 查询列车列表
     * 
     * @param train 列车
     * @return 列车集合
     */
    public List<Train> selectTrainList(Train train);

    /**
     * 新增列车
     * 
     * @param train 列车
     * @return 结果
     */
    public int insertTrain(Train train);

    /**
     * 修改列车
     * 
     * @param train 列车
     * @return 结果
     */
    public int updateTrain(Train train);

    /**
     * 删除列车
     * 
     * @param id 列车主键
     * @return 结果
     */
    public int deleteTrainById(String id);

    /**
     * 批量删除列车
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrainByIds(String[] ids);
}

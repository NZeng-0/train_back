package com.ruoyi.train.service;

import java.util.List;
import com.ruoyi.train.domain.Train;
import com.ruoyi.train.domain.TrainResDTO;

/**
 * 列车Service接口
 * 
 * @author me
 * @date 2025-03-17
 */
public interface ITrainService 
{
    /**
     * 查询列车
     * 
     * @param id 列车主键
     * @return 列车
     */
    public TrainResDTO selectTrainById(String id);

    /**
     * 查询列车列表
     * 
     * @param train 列车
     * @return 列车集合
     */
    public List<TrainResDTO> selectTrainList(Train train);

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
     * 批量删除列车
     * 
     * @param ids 需要删除的列车主键集合
     * @return 结果
     */
    public int deleteTrainByIds(String[] ids);

    /**
     * 删除列车信息
     * 
     * @param id 列车主键
     * @return 结果
     */
    public int deleteTrainById(String id);
}

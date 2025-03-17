package com.ruoyi.train.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.train.mapper.TrainMapper;
import com.ruoyi.train.domain.Train;
import com.ruoyi.train.service.ITrainService;

/**
 * 列车Service业务层处理
 * 
 * @author me
 * @date 2025-03-17
 */
@Service
public class TrainServiceImpl implements ITrainService 
{
    @Autowired
    private TrainMapper trainMapper;

    /**
     * 查询列车
     * 
     * @param id 列车主键
     * @return 列车
     */
    @Override
    public Train selectTrainById(String id)
    {
        return trainMapper.selectTrainById(id);
    }

    /**
     * 查询列车列表
     * 
     * @param train 列车
     * @return 列车
     */
    @Override
    public List<Train> selectTrainList(Train train)
    {
        return trainMapper.selectTrainList(train);
    }

    /**
     * 新增列车
     * 
     * @param train 列车
     * @return 结果
     */
    @Override
    public int insertTrain(Train train)
    {
        train.setCreateTime(DateUtils.getNowDate());
        return trainMapper.insertTrain(train);
    }

    /**
     * 修改列车
     * 
     * @param train 列车
     * @return 结果
     */
    @Override
    public int updateTrain(Train train)
    {
        train.setUpdateTime(DateUtils.getNowDate());
        return trainMapper.updateTrain(train);
    }

    /**
     * 批量删除列车
     * 
     * @param ids 需要删除的列车主键
     * @return 结果
     */
    @Override
    public int deleteTrainByIds(String[] ids)
    {
        return trainMapper.deleteTrainByIds(ids);
    }

    /**
     * 删除列车信息
     * 
     * @param id 列车主键
     * @return 结果
     */
    @Override
    public int deleteTrainById(String id)
    {
        return trainMapper.deleteTrainById(id);
    }
}

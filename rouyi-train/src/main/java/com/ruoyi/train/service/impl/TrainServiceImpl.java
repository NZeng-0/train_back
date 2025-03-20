package com.ruoyi.train.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.train.domain.Seat;
import com.ruoyi.train.mapper.SeatMapper;
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

    @Autowired
    private SeatMapper seatMapper;

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
        // 先插入列车，获取自增的 trainId
        int result = trainMapper.insertTrain(train);
        if (result > 0) {
            addTrainWithSeats(train);
        }
        return result;
    }

    public void addTrainWithSeats(Train train) {
        long trainId = Long.parseLong(train.getId());
        String end = train.getEndStation();
        String start = train.getStartStation();
        // 2. 生成座位列表
        List<Seat> seats = new ArrayList<>();

        // 车厢与座位格式映射
        Map<String, String[]> seatFormats = new HashMap<>();
        seatFormats.put("01", new String[]{"A", "C", "F"}); // 商务座
        seatFormats.put("02", new String[]{"A", "C", "D", "F"}); // 一等座
        seatFormats.put("03", new String[]{"A", "B", "C", "D", "F"}); // 二等座
        seatFormats.put("04", new String[]{"A", "C", "F"}); // 商务座

        // 车厢对应的座位数量
        Map<String, Integer> seatCounts = new HashMap<>();
        seatCounts.put("01", 5);
        seatCounts.put("02", 20);
        seatCounts.put("03", 30);
        seatCounts.put("04", 5);

        // 生成座位数据
        for (Map.Entry<String, Integer> entry : seatCounts.entrySet()) {
            String carriageNumber = entry.getKey();
            int totalSeats = entry.getValue();
            String[] seatFormat = seatFormats.get(carriageNumber);

            int row = 1; // 行号从1开始
            for (int i = 0; i < totalSeats; i++) {
                String seatNumber = row + seatFormat[i % seatFormat.length];
                seats.add(new Seat(trainId, carriageNumber, seatNumber, getSeatType(carriageNumber),
                        start, end , getPrice(carriageNumber), 0L));

                // 当所有座位格式用完一次，增加行号
                if ((i + 1) % seatFormat.length == 0) {
                    row++;
                }
            }
        }

        // 3. 批量插入座位
        seatMapper.batchInsertSeats(seats);
    }
    private Long getSeatType(String carriageNumber) {
        switch (carriageNumber) {
            case "02":
                return 1L;
            case "03":
                return 2L;
            default:
                return 0L;
        }
    }

    private Long getPrice(String carriageNumber) {
        switch (carriageNumber) {
            case "01":
            case "04":
                return 80L;
            case "02":
                return 50L;
            case "03":
                return 30L;
            default:
                return 0L;
        }
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

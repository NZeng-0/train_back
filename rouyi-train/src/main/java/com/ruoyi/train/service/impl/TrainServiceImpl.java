package com.ruoyi.train.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.train.domain.Carriage;
import com.ruoyi.train.domain.Seat;
import com.ruoyi.train.domain.TrainResDTO;
import com.ruoyi.train.mapper.CarriageMapper;
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

    @Autowired
    private CarriageMapper carriageMapper;

    /**
     * 查询列车
     * 
     * @param id 列车主键
     * @return 列车
     */
    @Override
    public TrainResDTO selectTrainById(String id)
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
    public List<TrainResDTO> selectTrainList(Train train)
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

        // 1. 生成车厢列表
        List<Carriage> carriages = new ArrayList<>();

        // 车厢类型映射
        Map<String, Integer> carriageTypes = new HashMap<>();
        carriageTypes.put("01", 0); // 商务座
        carriageTypes.put("02", 1); // 一等座
        carriageTypes.put("03", 2); // 二等座
        carriageTypes.put("04", 1); // 商务座

        // 车厢对应的座位数量和价格
        Map<String, Integer> seatCounts = new HashMap<>();
        seatCounts.put("01", 5);
        seatCounts.put("02", 20);
        seatCounts.put("03", 30);
        seatCounts.put("04", 5);

        Map<String, BigDecimal> carriagePrices = new HashMap<>();
        carriagePrices.put("01", new BigDecimal("1000.00")); // 商务座
        carriagePrices.put("02", new BigDecimal("500.00"));  // 一等座
        carriagePrices.put("03", new BigDecimal("250.00"));  // 二等座
        carriagePrices.put("04", new BigDecimal("1000.00")); // 商务座

        // 车厢与座位格式映射
        Map<String, String[]> seatFormats = new HashMap<>();
        seatFormats.put("01", new String[]{"A", "C", "F"}); // 商务座
        seatFormats.put("02", new String[]{"A", "C", "D", "F"}); // 一等座
        seatFormats.put("03", new String[]{"A", "B", "C", "D", "F"}); // 二等座
        seatFormats.put("04", new String[]{"A", "C", "F"}); // 商务座

        // 2. 生成座位列表
        List<Seat> seats = new ArrayList<>();
        List<Carriage> carriageList = new ArrayList<>();

        // 遍历生成车厢和座位
        for (Map.Entry<String, Integer> entry : seatCounts.entrySet()) {
            String carriageNumber = entry.getKey();
            int totalSeats = entry.getValue();
            String[] seatFormat = seatFormats.get(carriageNumber);

            // 创建车厢对象
            Carriage carriage = new Carriage();
            carriage.setTrainId(trainId);
            carriage.setCarriageNumber(carriageNumber);
            carriage.setCarriageType(carriageTypes.get(carriageNumber).longValue());
            carriage.setSeatCount((long) totalSeats);
            carriage.setCreateTime(DateUtils.getNowDate());
            carriage.setDelFlag(0);
            carriage.setSoldSeats(0L);
            carriage.setPrice(carriagePrices.get(carriageNumber));
            carriageList.add(carriage);

            // 生成座位数据
            int row = 1; // 行号从1开始
            for (int i = 0; i < totalSeats; i++) {
                String seatNumber = row + seatFormat[i % seatFormat.length];
                seats.add(new Seat(trainId, carriageNumber, seatNumber,
                        getSeatType(carriageNumber).longValue(), start, end,
                        getPrice(carriageNumber).longValue(), 0L));

                // 当所有座位格式用完一次，增加行号
                if ((i + 1) % seatFormat.length == 0) {
                    row++;
                }
            }
        }

        // 3. 批量插入车厢
        carriageMapper.batchInsertCarriages(carriageList);

        // 4. 批量插入座位
        seatMapper.batchInsertSeats(seats);
    }

    // 假设需要添加这些方法来支持车厢和座位创建
    private Integer getSeatType(String carriageNumber) {
        // 根据车厢号返回座位类型
        switch(carriageNumber) {
            case "01":
            case "04":
                return 1; // 商务座
            case "02":
                return 2; // 一等座
            case "03":
                return 3; // 二等座
            default:
                return 0; // 未知类型
        }
    }

    private BigDecimal getPrice(String carriageNumber) {
        // 根据车厢号返回座位价格
        switch(carriageNumber) {
            case "01":
            case "04":
                return new BigDecimal("80.00");
            case "02":
                return new BigDecimal("50.00");
            case "03":
                return new BigDecimal("30.00");
            default:
                return BigDecimal.ZERO;
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

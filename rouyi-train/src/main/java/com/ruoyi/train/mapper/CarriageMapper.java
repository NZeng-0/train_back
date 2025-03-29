package com.ruoyi.train.mapper;

import com.ruoyi.train.domain.Carriage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CarriageMapper {

    // 更新车次剩余座位
    @Update("UPDATE t_carriage SET sold_seats = sold_seats + 1 WHERE train_id = train_id AND carriage_number = #{carriage_number} " +
            "AND carriage_type = #{carriage_type} AND sold_seats < seat_count")
    void updateSoldSeats(@Param("train_id")String id, @Param("carriage_number") int number, @Param("carriage_type") int type);

    void batchInsertCarriages(List<Carriage> carriages);
}

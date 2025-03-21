package com.ruoyi.train.domain;

public class TrainResDTO extends Train{
    /** 商务座余票 */
    private Integer businessSeat;

    /** 一等座余票 */
    private Integer firstSeat;

    /** 二等座余票 */
    private Integer secondSeat;

    public Integer getBusinessSeat() {
        return businessSeat;
    }

    public void setBusinessSeat(Integer businessSeat) {
        this.businessSeat = businessSeat;
    }

    public Integer getFirstSeat() {
        return firstSeat;
    }

    public void setFirstSeat(Integer firstSeat) {
        this.firstSeat = firstSeat;
    }

    public Integer getSecondSeat() {
        return secondSeat;
    }

    public void setSecondSeat(Integer secondSeat) {
        this.secondSeat = secondSeat;
    }
}

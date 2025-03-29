package com.ruoyi.train.enums;

/**
 * 订单状态枚举
 */
public enum OrderStatus {
    PENDING(0, "待支付"),
    PAID(1, "已支付"),
    REFUNDED(2, "已退票"),
    COMPLETED(3, "已完成");

    private final int code;
    private final String desc;

    OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

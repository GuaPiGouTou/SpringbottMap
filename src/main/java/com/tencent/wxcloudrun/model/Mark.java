package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Mark {
    private Long markId; // 标记id
    private Long id; // 房源id
    private BigDecimal longitude; // 经度(地图选择上传)
    private BigDecimal latitude;  // 纬度(地图选择上传)
}

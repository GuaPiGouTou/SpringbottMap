package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;
@Data
public class HouseInfo {
    //索引
    private Long id;
    // 位置信息 - 建议使用BigDecimal保证精度
    private BigDecimal longitude; // 经度(地图选择上传)
    private BigDecimal latitude;  // 纬度(地图选择上传)
    private String address;      // 详细地址

    // 房源信息
    private String title;         // 标题
    private String location;      // 具体地点
    private String area;          // 面积
    private String houseType;     // 房型
    private int roomCount;        // 房间数 - 建议使用roomCount而非count

    // 联系方式
    private String wechat;        // 微信
    private String phone;         // 手机号

    // 支付方式与价格映射
    private Map<String, BigDecimal> paymentOptions;

    // 设施信息 - 建议使用boolean数组或List<Boolean>
    private boolean[] houseFacilities;

    // 媒体上传后的UID组 - 建议使用数组或List
    private String[] videoIds;


}
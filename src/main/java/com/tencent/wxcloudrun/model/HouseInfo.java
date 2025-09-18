package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
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
    private int roomcount;        // 房间数 - 建议使用roomCount而非count

    // 联系方式
    private String wechat;        // 微信
    private String phone;         // 手机号

    private Room[] room;

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", address='" + address + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", area='" + area + '\'' +
                ", roomcount=" + roomcount +
                ", wechat='" + wechat + '\'' +
                ", phone='" + phone + '\'' +
                ", room=" + Arrays.toString(room) +
                '}';
    }
//    // 支付方式与价格映射
//    private Map<String, BigDecimal> paymentOptions;
//
//    // 设施信息 - 建议使用boolean数组或List<Boolean>
//    private boolean[] houseFacilities;
//
//    // 媒体上传后的UID组 - 建议使用数组或List
//    private String[] videoIds;
/*
*  #{paymentOptions, typeHandler=com.tencent.wxcloudrun.utils.JsonTypeHandler},
                   #{houseFacilities, typeHandler=com.tencent.wxcloudrun.utils.JsonTypeHandler},
                   #{videoIds, typeHandler=com.tencent.wxcloudrun.utils.JsonTypeHandler}
* */
/*
*    <result property="paymentOptions" column="payment_options"
                typeHandler="com.tencent.wxcloudrun.utils.JsonTypeHandler"/>
        <result property="houseFacilities" column="house_facilities"
                typeHandler="com.tencent.wxcloudrun.utils.JsonTypeHandler"/>
        <result property="videoIds" column="video_ids"
                typeHandler="com.tencent.wxcloudrun.utils.JsonTypeHandler"/>
* */
}
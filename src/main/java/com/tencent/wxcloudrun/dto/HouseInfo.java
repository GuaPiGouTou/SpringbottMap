package com.tencent.wxcloudrun.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class HouseInfo {
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

    // 构造方法
    public HouseInfo() {
    }

    // Getter和Setter方法 (必须提供)
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<String, BigDecimal> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(Map<String, BigDecimal> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public boolean[] getHouseFacilities() {
        return houseFacilities;
    }

    public void setHouseFacilities(boolean[] houseFacilities) {
        this.houseFacilities = houseFacilities;
    }

    public String[] getVideoIds() {
        return videoIds;
    }

    public void setVideoIds(String[] videoIds) {
        this.videoIds = videoIds;
    }
}
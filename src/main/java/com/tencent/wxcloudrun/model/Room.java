package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Room {
    private  Long  RoomId; //房间信息ID
    private String RoomNumber;//房间号
    private String RoomAddress;//房间具体地址
    private BigDecimal RoomArea;//房间面积
    private String RoomType;//房型
    private Map<String, BigDecimal> RoomPayment;// 支付方式与价格映射
    private boolean[] RoomFurniture;// 设施信息 - 建议使用boolean数组或List<Boolean>
    private String[] RoomVideo;// 媒体上传后的UID组 - 建议使用数组或List
    private Long PropertyId; //所属房源ID
}


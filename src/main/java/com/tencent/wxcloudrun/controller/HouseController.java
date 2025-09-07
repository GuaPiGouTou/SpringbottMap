package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.JsonResult;
import com.tencent.wxcloudrun.model.HouseInfo;
import com.tencent.wxcloudrun.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HouseController {
    @Autowired
    private HouseInfoService houseInfoService;
    @PostMapping(value = "/api/house/submit")
    public JsonResult<HouseInfo> submit(@RequestBody HouseInfo houseInfo) {
        HouseInfo houseInfo1 = houseInfoService.saveHouse(houseInfo);
//        HouseInfo  testHouseInfo = new HouseInfo();
//        testHouseInfo.setId(1L);
//        testHouseInfo.setLongitude(new BigDecimal("116.404"));
//        testHouseInfo.setLatitude(new BigDecimal("39.915"));
//        testHouseInfo.setAddress("北京市东城区");
//        testHouseInfo.setTitle("测试房源");
//        testHouseInfo.setLocation("王府井");
//        testHouseInfo.setArea("80平米");
//        testHouseInfo.setHouseType("两室一厅");
//        testHouseInfo.setRoomCount(2);
//        testHouseInfo.setWechat("test_wechat");
//        testHouseInfo.setPhone("13800138000");
//
//        // 设置支付选项
//        Map<String, BigDecimal> paymentOptions = new HashMap<>();
//        paymentOptions.put("月租", new BigDecimal("5000"));
//        paymentOptions.put("季付", new BigDecimal("14500"));
//        testHouseInfo.setPaymentOptions(paymentOptions);
//
//        // 设置设施信息
//        boolean[] facilities = {true, false, true, true, false};
//        testHouseInfo.setHouseFacilities(facilities);
//
//        // 设置视频ID
//        String[] videoIds = {"video1", "video2"};
//        testHouseInfo.setVideoIds(videoIds);
//        HouseInfo houseInfo1 = houseInfoService.saveHouse(testHouseInfo);
        return new JsonResult<>(houseInfo1);
    }


}

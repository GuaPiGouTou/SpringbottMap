package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.JsonResult;
import com.tencent.wxcloudrun.model.HouseInfo;
import com.tencent.wxcloudrun.service.HouseInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HouseController {
    @Autowired
    private HouseInfoService houseInfoService;
    @PostMapping(value = "/api/house/submit")
    public JsonResult<HouseInfo> submit(@RequestBody HouseInfo houseInfo) {
        int code = houseInfoService.saveHouse(houseInfo);
        if (code == 200)
        {
            return new JsonResult<>("200", "提交房源信息成功");
        } else if (code == 705) {
            return new JsonResult<>("705", "提交房源信息失败");
        } else if (code == 805) {
            return new JsonResult<>("805", "提交房源标记失败");
        }

        return new JsonResult<>("905", "系统异常");
    }

    @GetMapping(value = "/api/house/gethouse")
    public JsonResult<HouseInfo> gethouse(@Param("id") Long id) {
        if(id == null|| id <= 0)
            return new JsonResult<>("705", "参数错误");
        HouseInfo houseInfo = houseInfoService.getHouseByPropertyId(id);
        if(houseInfo.getId() == null)
            return new JsonResult<>("705", "没有此房源信息");
        if(houseInfo.getRoom().length==0)
            return new JsonResult<>("705", "没有此房源信息");
        return new JsonResult<>(houseInfo, "获取房源信息成功");
    }

}

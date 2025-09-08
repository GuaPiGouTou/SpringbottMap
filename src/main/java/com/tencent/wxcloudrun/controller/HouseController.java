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


}

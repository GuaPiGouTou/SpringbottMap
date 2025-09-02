package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.dto.HouseInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/house")
public class HouseController {
    @PostMapping(value = "/submit")
    ApiResponse submit(@RequestBody HouseInfo houseInfo) {
        try{
            System.out.println(houseInfo);
            return ApiResponse.ok("提交成功");
        }catch (Exception e){
            return ApiResponse.error("提交失败");
        }
    }

}

package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.config.JsonResult;
import com.tencent.wxcloudrun.service.RoomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/api/room/delete")
    public JsonResult<String> delete(@Param("RoomId")Long RoomId){
        int count = roomService.delete(RoomId);
        if(count>0)
            return new JsonResult<>("200","删除成功");
        else
            return new JsonResult<>("805","删除失败");

    }
}

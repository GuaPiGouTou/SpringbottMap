package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.JsonResult;
import com.tencent.wxcloudrun.model.Mark;
import com.tencent.wxcloudrun.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarkController {
    @Autowired
    private MarkService markService;
    @PostMapping(value = "/api/mark/insert")
    public JsonResult<Mark> insertMark(@RequestBody Mark mark) {
        int count  = markService.insertMark(mark);
        if(count>0)
            return new JsonResult<>("200","提交房源标记成功");
        else
            return new JsonResult<>("805","提交房源标记失败");
    }

    @GetMapping(value = "/api/mark/get")
    public JsonResult<List<Mark>> ALLMark(String houseId) {
        List<Mark> marks = markService.getAllMarks(houseId);
        return new JsonResult<>(marks,"获取所有标记成功");
    }
}

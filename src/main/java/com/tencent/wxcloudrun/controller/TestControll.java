package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class TestControll {
        private static final Logger logger = LoggerFactory.getLogger(TestControll.class);

        @PostMapping("/test")
        public JsonResult test(@RequestParam("name") String name,
                               @RequestParam("pass") String pass) {
            logger.info("name：{}", name);
            logger.info("pass：{}", pass);
            return new JsonResult();
        }

}

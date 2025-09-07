package com.tencent.wxcloudrun;

import org.apache.ibatis.io.ResolverUtil;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.tencent.wxcloudrun.dao"})
public class WxCloudRunApplication {
  private static final Logger logger = LoggerFactory.getLogger(ResolverUtil.Test.class);
  public static void main(String[] args) {

    SpringApplication.run(WxCloudRunApplication.class, args);
  }
}

package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.HouseInfo;
import org.apache.ibatis.annotations.Param;

public interface HouseInfoMapper {
    int insertHouseInfo(HouseInfo houseInfo);
    HouseInfo getHouseInfoById(@Param("id") Long id);
}

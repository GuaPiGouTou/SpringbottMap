package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.HouseInfo;

public interface HouseInfoService {
    int saveHouse(HouseInfo houseInfo);
    HouseInfo getHouseById(Long id);
}

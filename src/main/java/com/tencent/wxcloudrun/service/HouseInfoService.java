package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.HouseInfo;

public interface HouseInfoService {
    HouseInfo saveHouse(HouseInfo houseInfo);
    HouseInfo getHouseById(Long id);
}

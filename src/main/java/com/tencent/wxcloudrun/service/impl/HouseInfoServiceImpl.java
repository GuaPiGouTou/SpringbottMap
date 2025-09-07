package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.HouseInfoMapper;
import com.tencent.wxcloudrun.model.HouseInfo;
import com.tencent.wxcloudrun.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class HouseInfoServiceImpl implements HouseInfoService {

    private final HouseInfoMapper houseMapper;

    @Autowired
    public HouseInfoServiceImpl(HouseInfoMapper houseMapper) {
        this.houseMapper = houseMapper;
    }

    @Override
    public HouseInfo saveHouse(HouseInfo houseInfo) {
        // 插入房屋信息并返回包含生成ID的对象
        houseMapper.insertHouseInfo(houseInfo);
        return houseInfo;
    }

    @Override
    public HouseInfo getHouseById(Long id) {
        // 根据ID查询房屋信息，使用Optional避免空指针
        return Optional.ofNullable(houseMapper.getHouseById(id))
                .orElseThrow(() -> new RuntimeException("房屋信息不存在，ID: " + id));
    }
}
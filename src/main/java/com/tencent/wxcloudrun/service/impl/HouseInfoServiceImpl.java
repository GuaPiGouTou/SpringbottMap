package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.HouseInfoMapper;
import com.tencent.wxcloudrun.model.HouseInfo;
import com.tencent.wxcloudrun.model.Mark;
import com.tencent.wxcloudrun.service.HouseInfoService;
import com.tencent.wxcloudrun.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HouseInfoServiceImpl implements HouseInfoService {

    private final HouseInfoMapper houseMapper;
    @Autowired
    private MarkService markService;

    @Autowired
    public HouseInfoServiceImpl(HouseInfoMapper houseMapper) {
        this.houseMapper = houseMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveHouse(HouseInfo houseInfo) {
        int code = 200;
        // 1. 插入房屋信息
        int houseInsertCount = houseMapper.insertHouseInfo(houseInfo);
        if (houseInsertCount <= 0) {
            code = 705;
        }

        // 2. 查询标记是否插入
        int markInsertCount = markService.getMarkByPropertyId(houseInfo.getId().intValue());
        if (markInsertCount <= 0) {
            code = 805;
        }

        // 3. 返回成功状态码
        return code;
    }

  
    @Override
    @Transactional(rollbackFor = Exception.class)
    public HouseInfo getHouseById(Long id) {
        // 根据ID查询房屋信息，使用Optional避免空指针
        return Optional.ofNullable(houseMapper.getHouseById(id))
                .orElseThrow(() -> new RuntimeException("房屋信息不存在，ID: " + id));
    }
}
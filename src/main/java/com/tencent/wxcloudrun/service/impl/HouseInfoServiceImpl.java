package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.HouseInfoMapper;
import com.tencent.wxcloudrun.model.HouseInfo;
import com.tencent.wxcloudrun.model.Mark;
import com.tencent.wxcloudrun.service.HouseInfoService;
import com.tencent.wxcloudrun.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public int saveHouse(HouseInfo houseInfo) {
        int code = 200;
        // 1. 插入房屋信息
        int houseInsertCount = houseMapper.insertHouseInfo(houseInfo);
        if (houseInsertCount <= 0) {
           code = 705;
        }

        // 2. 准备标记数据
        Mark mark = createMarkFromHouseInfo(houseInfo);

        // 3. 插入标记信息
        int markInsertCount = markService.insertMark(mark);
        if (markInsertCount <= 0) {
           code = 805;
        }

        // 4. 返回成功状态码
        return code;
    }
    private Mark createMarkFromHouseInfo(HouseInfo houseInfo) {
        Mark mark = new Mark();
        mark.setId(houseInfo.getId());
        mark.setLongitude(houseInfo.getLongitude());
        mark.setLatitude(houseInfo.getLatitude());
        // 可以根据需要添加更多字段
        return mark;
    }
    @Override
    public HouseInfo getHouseById(Long id) {
        // 根据ID查询房屋信息，使用Optional避免空指针
        return Optional.ofNullable(houseMapper.getHouseById(id))
                .orElseThrow(() -> new RuntimeException("房屋信息不存在，ID: " + id));
    }
}
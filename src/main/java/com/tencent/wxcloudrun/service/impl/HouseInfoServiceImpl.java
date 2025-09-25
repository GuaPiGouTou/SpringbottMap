package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.HouseInfoMapper;
import com.tencent.wxcloudrun.model.HouseInfo;
import com.tencent.wxcloudrun.model.Mark;
import com.tencent.wxcloudrun.model.Room;
import com.tencent.wxcloudrun.service.HouseInfoService;
import com.tencent.wxcloudrun.service.MarkService;
import com.tencent.wxcloudrun.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HouseInfoServiceImpl implements HouseInfoService {

    private final HouseInfoMapper houseMapper;
    @Autowired
    private MarkService markService;

    @Autowired
    private RoomService roomService;

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
            return code;
        }

        // 2. 查询标记是否插入
        int markInsertCount = markService.getMarkByPropertyId(houseInfo.getId().intValue());
        if (markInsertCount <= 0) {
            code = 805;
            return code;
        }

        // 3. 插入房间信息

        System.out.println(houseInfo.toString());
        for (int i = 0; i < houseInfo.getRoom().length; i++) {
            houseInfo.getRoom()[i].setPropertyId(houseInfo.getId());
            int roomcount = roomService.insertRoom(houseInfo.getRoom()[i]);
            if (roomcount <= 0) {
                code = 905;
                return code;
            }
        }

        // 3. 返回成功状态码
        return code;
    }




    @Override
    public HouseInfo getHouseByPropertyId(Long propertyId) {
        HouseInfo houseInfo = houseMapper.getHouseInfoById(propertyId);
        Room [] rooms = roomService.selectByPropertyId(houseInfo.getId());
        houseInfo.setRoom( rooms);
        return houseInfo;
    }
}
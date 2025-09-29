package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.RoomMapper;
import com.tencent.wxcloudrun.model.Room;
import com.tencent.wxcloudrun.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final  RoomMapper roomMapper;

    @Autowired
    public RoomServiceImpl(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public int insertRoom(Room room) {
        int count =0;
        count = roomMapper.insert(room);

        return count;
    }

    @Override
    public int delete(Long RoomId) {
        int count = roomMapper.delete(RoomId);
        return count;
    }

    @Override
    public Room [] selectByPropertyId(Long propertyId) {
        return roomMapper.selectByPropertyId(propertyId);
    }
}

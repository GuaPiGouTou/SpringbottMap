package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Room;

import java.util.List;

public interface RoomMapper {
    int insert(Room room);
    Room [] selectByPropertyId(Long propertyId);
}

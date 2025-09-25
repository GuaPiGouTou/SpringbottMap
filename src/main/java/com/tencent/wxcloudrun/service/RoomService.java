package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Room;

import java.util.List;

public interface RoomService {
    int insertRoom(Room room);
    Room [] selectByPropertyId(Long propertyId);
}

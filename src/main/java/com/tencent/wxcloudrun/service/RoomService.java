package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Room;

import java.util.List;

public interface RoomService {
    int insertRoom(Room room);
    int delete(Long RoomId);
    Room [] selectByPropertyId(Long propertyId);
}

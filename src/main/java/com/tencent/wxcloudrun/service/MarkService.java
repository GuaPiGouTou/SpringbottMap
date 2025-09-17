package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Mark;

import java.util.List;

public interface MarkService {
    int insertMark(Mark mark);

    List<Mark> getAllMarks(String houseId);

    int getMarkByPropertyId(int id);
}

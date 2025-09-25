package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Mark;

import java.util.List;

public interface MarkMapper {
    int insertMark(Mark mark);
    List< Mark> getAllMarks();
    Integer getMarkByPropertyId(int id);
    Mark getMarkById(Integer makeID);
}

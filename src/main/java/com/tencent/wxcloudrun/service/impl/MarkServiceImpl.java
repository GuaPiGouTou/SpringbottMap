package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.MarkMapper;
import com.tencent.wxcloudrun.model.Mark;
import com.tencent.wxcloudrun.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {

    private final MarkMapper markMapper;

    @Autowired
    public MarkServiceImpl(MarkMapper markMapper) {
        this.markMapper = markMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertMark(Mark mark) {
        int count = markMapper.insertMark(mark);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Mark> getAllMarks(String houseId) {
        List< Mark> marks = markMapper.getAllMarks();
        return marks;
    }
}

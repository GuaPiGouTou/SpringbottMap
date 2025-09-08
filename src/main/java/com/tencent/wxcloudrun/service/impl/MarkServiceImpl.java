package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.MarkMapper;
import com.tencent.wxcloudrun.model.Mark;
import com.tencent.wxcloudrun.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkServiceImpl implements MarkService {

    private final MarkMapper markMapper;

    @Autowired
    public MarkServiceImpl(MarkMapper markMapper) {
        this.markMapper = markMapper;
    }

    @Override
    public int insertMark(Mark mark) {
        int count = markMapper.insertMark(mark);
        return count;
    }
}

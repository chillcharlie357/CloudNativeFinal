package com.example.cloudNative.service;

import com.example.cloudNative.entity.MsgEntity;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {
    @Override
    public MsgEntity msgEntity() {
        return new MsgEntity();
    }

    @Override
    public MsgEntity msgEntity(String content) {
        return new MsgEntity(content);
    }
}

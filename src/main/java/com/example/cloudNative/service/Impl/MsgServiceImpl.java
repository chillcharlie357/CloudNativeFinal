package com.example.cloudNative.service.Impl;

import com.example.cloudNative.entity.MsgEntity;
import com.example.cloudNative.service.MsgService;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {
    public MsgEntity msgEntity() {
        return new MsgEntity();
    }

    public MsgEntity msgEntity(String content) {
        return new MsgEntity(content);
    }

}

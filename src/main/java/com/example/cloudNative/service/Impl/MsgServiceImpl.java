package com.example.cloudNative.service.Impl;

import com.example.cloudNative.entity.MsgEntity;
import com.example.cloudNative.service.MsgService;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {
    public MsgEntity msgEntity(String content,Long count) {
        return new MsgEntity(content,count);
    }
}

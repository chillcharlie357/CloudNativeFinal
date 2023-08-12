package com.example.cloudNative.service;


import com.example.cloudNative.entity.MsgEntity;

public interface MsgService {
    MsgEntity msgEntity(String content,Long count);
}

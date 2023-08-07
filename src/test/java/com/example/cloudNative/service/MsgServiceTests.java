package com.example.cloudNative.service;

import com.example.cloudNative.entity.MsgEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MsgServiceTests {

    @Autowired
    private MsgService msgService;

    @Test
    public void test1(){
        String content = "Hello";
        MsgEntity msgEntity = msgService.msgEntity(content);
        Assertions.assertEquals(content,msgEntity.getContent());
    }
}

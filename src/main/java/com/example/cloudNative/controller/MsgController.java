package com.example.cloudNative.controller;


import com.example.cloudNative.entity.MsgEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.cloudNative.service.MsgService;

@RestController
public class MsgController {

    @Autowired
    private MsgService msgService;

    @GetMapping("/msg/{content}")
    public MsgEntity getMsg(@PathVariable(value = "content") String content){
            return msgService.msgEntity(content);
    }
}

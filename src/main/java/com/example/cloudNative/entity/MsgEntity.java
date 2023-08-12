package com.example.cloudNative.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
public class MsgEntity {

    @Setter
    private String content;

    private Long id;

    private Long requestCount;
    public MsgEntity(String msg,Long count){
        this.content = msg;
        this.id=System.currentTimeMillis();
        this.requestCount = count;
    }

}

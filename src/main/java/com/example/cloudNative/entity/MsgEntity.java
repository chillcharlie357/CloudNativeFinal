package com.example.cloudNative.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
public class MsgEntity {

    @Setter
    private String content;

    public MsgEntity(){
        this.content = "Hello";
    }
    public MsgEntity(String msg){
        this.content = msg;
    }

}

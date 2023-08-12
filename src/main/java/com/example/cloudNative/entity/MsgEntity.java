package com.example.cloudNative.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
public class MsgEntity {

    @Setter
    private String content;

    private Long id;
    public MsgEntity(){
        this.content = "Hello";
        this.id=System.currentTimeMillis();
    }
    public MsgEntity(String msg){
        this.content = msg;
        this.id=System.currentTimeMillis();
    }

}

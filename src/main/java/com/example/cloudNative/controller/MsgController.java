package com.example.cloudNative.controller;


import com.example.cloudNative.entity.MsgEntity;
import com.example.cloudNative.service.MsgService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class MsgController {

    @Autowired
    private MsgService msgService;

    private Bucket bucket;

    public MsgController(){
        this.bucket = null;
    }

    @PostConstruct
    public void init(){
          Bandwidth limit = Bandwidth.classic(
                100,
                Refill.greedy(100, Duration.ofSeconds(1))
        );
        this.bucket = Bucket.builder().addLimit(limit).build();
    }
    //TODO: 测试限流
    @GetMapping("/msg/{content}")
    public ResponseEntity<MsgEntity> getMsg(@PathVariable(value = "content") String content) {
        if (bucket.tryConsume(1)) {
            return ResponseEntity.ok(msgService.msgEntity(content));
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }


}

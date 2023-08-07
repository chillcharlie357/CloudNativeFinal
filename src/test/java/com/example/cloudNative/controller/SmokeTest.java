package com.example.cloudNative.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private MsgController msgController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(msgController).isNotNull();
    }
}

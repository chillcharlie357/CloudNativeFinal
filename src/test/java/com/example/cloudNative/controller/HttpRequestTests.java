package com.example.cloudNative.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * Note the use of webEnvironment=RANDOM_PORT to start the server with a random port
 * (useful to avoid conflicts in test environments) and
 * the injection of the port with @LocalServerPort.
 * <p>
 * start the application and listen for a connection (as it would do in production)
 * and then send an HTTP request and assert the response.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTests {
    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void HttpTest() {
        String content = "Hello";
        Assertions.assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/msg/" + content,
                String.class
        )).contains(content);
    }
}

package com.pl.springboot_vertx_metrics;

import com.pl.springboot_vertx_metrics.verticles.TestVerticle;
import io.vertx.core.Vertx;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Application.class);

    @Autowired
    Vertx vertx;

    @Autowired
    TestVerticle testVerticle;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void deployVerticles() {
        LOG.info("deploying verticle");
        vertx.deployVerticle(testVerticle);
    }
}
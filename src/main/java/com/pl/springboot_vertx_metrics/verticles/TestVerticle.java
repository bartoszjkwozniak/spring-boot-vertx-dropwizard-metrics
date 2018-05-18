package com.pl.springboot_vertx_metrics.verticles;

import com.pl.springboot_vertx_metrics.Application;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestVerticle extends AbstractVerticle {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Application.class);

    @Override
    public void start(Future<Void> future) {
        LOG.info("TestVerticle started.");
    }

    @Override
    public void stop(Future stopFuture) {
        LOG.info("TestVerticle stopped.");
    }
}

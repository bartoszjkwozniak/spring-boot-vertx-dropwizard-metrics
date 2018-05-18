package com.pl.springboot_vertx_metrics.config;

import com.codahale.metrics.MetricRegistry;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.dropwizard.DropwizardMetricsOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class VertxConfig {

    @Autowired
    private MetricRegistry metricRegistry;

    @Bean
    public Vertx vertx(){
        return Vertx.vertx(getVertxOptions());
    }

    private VertxOptions getVertxOptions(){
        VertxOptions options = new VertxOptions();
        DropwizardMetricsOptions dropwizardMetricsOptions = new DropwizardMetricsOptions()
                .setEnabled(true)
                .setJmxEnabled(true)
                .setMetricRegistry(metricRegistry);
        options.setMetricsOptions(dropwizardMetricsOptions);
        return options;
    }
}
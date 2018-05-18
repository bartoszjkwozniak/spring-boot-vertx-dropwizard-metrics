package com.pl.springboot_vertx_metrics.config;

import com.codahale.metrics.MetricRegistry;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;
import io.prometheus.client.hotspot.*;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;

@Configuration
@EnablePrometheusEndpoint
public class PrometheusConfig {

    @Autowired
    private MetricRegistry metricRegistry;

    @PostConstruct
    public void registerPrometheusCollectors() {
        CollectorRegistry.defaultRegistry.clear();
        new ClassLoadingExports().register();
        new GarbageCollectorExports().register();
        new MemoryPoolsExports().register();
        new StandardExports().register();
        new ThreadExports().register();
        new VersionInfoExports().register();
        new DropwizardExports(metricRegistry).register();
    }
}
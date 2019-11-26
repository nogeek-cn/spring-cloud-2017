package com.Darian.springcloudconfigclient.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

public class MyHealthIndicator  extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder)
            throws Exception {
//        builder.up().withDetail("MyHealthIndicator", "day day up");
        builder.down().withDetail("myhealthIndicator","DOWN");
    }
}
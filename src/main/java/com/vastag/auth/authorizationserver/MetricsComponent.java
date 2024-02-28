package com.vastag.auth.authorizationserver;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MetricsComponent {
    private final MeterRegistry meterRegistry;

    public MetricsComponent(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Bean
    public MultiTaggedCounter intentsCounter() {
        return new MultiTaggedCounter("intents", this.meterRegistry, "backend", "status");
    }

    @Bean
    public MultiTaggedCounter authorizerCounter() {
        return new MultiTaggedCounter("authorizer", this.meterRegistry, "backend", "status");
    }

    @Bean
    public MultiTaggedCounter resourcesCounter() {
        return new MultiTaggedCounter("resources", this.meterRegistry, "backend", "status");
    }

    @Bean
    public MultiTaggedCounter consentsCounter() {
        return new MultiTaggedCounter("consents", this.meterRegistry, "backend", "status");
    }

}

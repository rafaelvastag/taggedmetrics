package com.vastag.auth.authorizationserver;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiTaggedCounterTest {

    @Test
    public void multiTaggedCounterTest() {
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        MultiTaggedCounter multiTaggedCounter = new MultiTaggedCounter("intents", registry, "backend", "status");
        multiTaggedCounter.increment("itau.com", "201");
        multiTaggedCounter.increment("bradesco.com", "401");
        multiTaggedCounter.increment("nubank.com", "422");
        multiTaggedCounter.increment("itau.com", "200");
        multiTaggedCounter.increment("bradesco.com", "403");
        multiTaggedCounter.increment("nubank.com", "422");
        multiTaggedCounter.increment("itau.com", "422");
        multiTaggedCounter.increment("bradesco.com", "401");
        multiTaggedCounter.increment("bradesco.com", "401");


        assertEquals(6, registry.getMeters().size());
    }

    @Test
    public void multiTaggedCounterIllegalArgTest() {
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        MultiTaggedCounter multiTaggedCounter = new MultiTaggedCounter("sheep", registry, "color", "age-group");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            multiTaggedCounter.increment("black");
        });
    }
}
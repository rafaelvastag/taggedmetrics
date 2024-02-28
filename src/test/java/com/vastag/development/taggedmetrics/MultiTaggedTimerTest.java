package com.vastag.development.taggedmetrics;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiTaggedTimerTest {

    @Test
    public void multiTaggedTimerTest() {
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        MultiTaggedTimer multiTaggedTimer = new MultiTaggedTimer("some-timer", registry, "who", "action");
        multiTaggedTimer.getTimer("Eric", "walk-the-dog").record(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        multiTaggedTimer.getTimer("Eric", "make-dinner").record(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        multiTaggedTimer.getTimer("Benz", "make-dinner").record(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        multiTaggedTimer.getTimer("Benz", "homework").record(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        List<Meter> meters = registry.getMeters();
        assertEquals(4, meters.size());
    }


    @Test
    public void multiTaggedTimerIllegalArgsTest() {
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        MultiTaggedTimer multiTaggedTimer = new MultiTaggedTimer("some-timer", registry, "who", "action");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            multiTaggedTimer.getTimer("walk-the-dog").record(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        });
    }
}
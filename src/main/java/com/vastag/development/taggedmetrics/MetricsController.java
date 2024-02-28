package com.vastag.development.taggedmetrics;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/metrics")
public class MetricsController {

    private final MultiTaggedCounter intentsCounter;

    @GetMapping("/intents")
    public ResponseEntity get() {
        intentsCounter.increment("itau.com", "201");
        intentsCounter.increment("bradesco.com", "401");
        intentsCounter.increment("nubank.com", "422");
        intentsCounter.increment("itau.com", "200");
        intentsCounter.increment("bradesco.com", "403");
        intentsCounter.increment("nubank.com", "422");
        intentsCounter.increment("itau.com", "422");
        intentsCounter.increment("bradesco.com", "401");
        intentsCounter.increment("bradesco.com", "401");
        intentsCounter.increment("bradesco.com", "401");
        intentsCounter.increment("bradesco.com", "401");
        intentsCounter.increment("bradesco.com", "401");
        intentsCounter.increment("bradesco.com", "401");
        intentsCounter.increment("bradesco.com", "401");


        return ResponseEntity.ok().build();
    }

}

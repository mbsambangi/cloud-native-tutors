package com.cloudnative.api;

import com.cloudnative.domain.SubscriptionStatus;
import com.cloudnative.domain.subscription.Subscription;
import com.cloudnative.domain.subscription.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Subscription>> get(@PathVariable String id) {
        return ResponseEntity.ok(subscriptionRepository.findBySubscriptionId(id));
    }

    @PostMapping
    public ResponseEntity<Subscription> post(@RequestBody Subscription subscription) {
        subscription.setSubscriptionStatus(SubscriptionStatus.CREATED);
        Subscription subscription1 = subscriptionRepository.save(subscription);

        URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(subscription1.getSubscriptionId()).toUri();
        return ResponseEntity.created(uri).body(subscription1);
    }
}

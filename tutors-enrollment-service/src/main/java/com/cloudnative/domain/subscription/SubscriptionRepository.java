package com.cloudnative.domain.subscription;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {

    List<Subscription> findBySubscriptionId(String id);

}

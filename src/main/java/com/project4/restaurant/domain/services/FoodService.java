package com.project4.restaurant.domain.services;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "foodService", url = "${feign.restaurant-url}")
public interface FoodService {
    @RequestLine("PUT /project_4/restaurant/schedule/main-dish")
    void updateMainDish();
}

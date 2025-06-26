package com.project4.restaurant.domain.services;

import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "foodService", url = "${feign.restaurant-url}")
public interface FoodService {
    @RequestLine("POST /project_4/restaurant/schedule/main-dish")
    @Headers("Content-Type: application/json")
    void updateMainDish();
}

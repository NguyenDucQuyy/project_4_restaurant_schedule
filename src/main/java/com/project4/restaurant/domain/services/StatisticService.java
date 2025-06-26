package com.project4.restaurant.domain.services;

import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "statisticService", url = "${feign.restaurant-url}")
public interface StatisticService {
    @RequestLine("POST /project_4/restaurant/schedule/pre")
    @Headers("Content-Type: application/json")
    void updateStatisticsPreDay();

    @RequestLine("POST /project_4/restaurant/schedule/current")
    @Headers("Content-Type: application/json")
    void updateStatisticsToDay();
}

package com.project4.restaurant.domain.services;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "statisticService", url = "${feign.restaurant-url}")
public interface StatisticService {
    @RequestLine("POST /project_4/restaurant/schedule/pre")
    void updateStatisticsPreDay();

    @RequestLine("POST /project_4/restaurant/schedule/current")
    void updateStatisticsToDay();

    @RequestLine("PUT /project_4/restaurant/schedule/main-dish")
    void updateMainDish();
}

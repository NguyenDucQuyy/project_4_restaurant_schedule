package com.project4.restaurant.app.schedules;

import com.project4.restaurant.domain.services.FoodService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class FoodSchedule {
    @Autowired
    private FoodService foodService;

    @Scheduled(cron = "0 */10 * * * *")
    public void updateMainDish() {
        log.info("=============== processUpdateMainDish ");
        foodService.updateMainDish();
    }
}

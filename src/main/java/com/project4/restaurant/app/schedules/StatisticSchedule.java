package com.project4.restaurant.app.schedules;

import com.project4.restaurant.domain.services.StatisticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StatisticSchedule {
    @Autowired
    protected StatisticService statisticService;

    @Scheduled(cron = "0 6 * * * *")
    public void updateStatisticsPreDay() {
        log.info("=============== processStatisticPreDay ");
        statisticService.updateStatisticsPreDay();
    }

    @Scheduled(cron = "0 6 * * * *")
    public void updateStatisticsToDay() {
        log.info("=============== processStatisticToDay ");
        statisticService.updateStatisticsToDay();
    }

    @Scheduled(cron = "0 */10 * * * *")
    public void updateMainDish() {
        log.info("=============== processUpdateMainDish ");
        statisticService.updateMainDish();
    }
}

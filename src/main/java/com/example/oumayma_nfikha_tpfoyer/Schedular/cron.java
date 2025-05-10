package com.example.oumayma_nfikha_tpfoyer.Schedular;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class cron {

    @Scheduled(fixedRate = 15000)
    public void cron() {

    log.info("cron");
    }

}

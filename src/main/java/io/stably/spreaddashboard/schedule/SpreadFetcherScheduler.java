package io.stably.spreaddashboard.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Fenix truonghatsts@gmail.com
 */
@Component
public class SpreadFetcherScheduler {

    private static final Logger logger = LoggerFactory.getLogger(SpreadFetcherScheduler.class);

    @Scheduled(fixedDelay = 6000)
    public void fetch() throws Exception {
        logger.info("Fetch at {}", LocalDateTime.now());
    }
}

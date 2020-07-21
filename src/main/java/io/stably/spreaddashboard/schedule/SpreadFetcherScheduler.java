package io.stably.spreaddashboard.schedule;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.BookTicker;
import io.stably.spreaddashboard.domain.entity.Ticker;
import io.stably.spreaddashboard.service.ConfigService;
import io.stably.spreaddashboard.service.TickerService;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Fenix truonghatsts@gmail.com
 */
@Component
public class SpreadFetcherScheduler {

    private static final Logger logger = LoggerFactory.getLogger(SpreadFetcherScheduler.class);

    @Autowired
    private BinanceApiRestClient client;

    @Autowired
    private TickerService tickerService;

    @Autowired
    private ConfigService configService;

    @Scheduled(fixedDelay = 60000)
    public void fetch() throws Exception {
        List<BookTicker> bookTickers = client.getBookTickers();
        long timestamp = Instant.now().toEpochMilli();
        for (BookTicker bookTicker : bookTickers) {
            if (bookTicker.getSymbol().matches(configService.getSymbolPattern())) {
                logger.info("Fetch book ticker for {}", bookTicker.getSymbol());
                Ticker ticker = new Ticker();
                ticker.setSymbol(bookTicker.getSymbol());
                ticker.setAskPrice(new BigDecimal(bookTicker.getAskPrice()));
                ticker.setAskQty(new BigDecimal(bookTicker.getAskQty()));
                ticker.setBidPrice(new BigDecimal(bookTicker.getBidPrice()));
                ticker.setBidQty(new BigDecimal(bookTicker.getBidQty()));
                ticker.setTimestamp(timestamp);
                tickerService.save(ticker);
            }
        }
    }
}

package io.stably.spreaddashboard.service;

import io.stably.spreaddashboard.domain.entity.Ticker;
import io.stably.spreaddashboard.repository.TickerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Fenix truonghatsts@gmail.com
 */

@Service
public class TickerService {

    @Autowired
    private TickerRepository tickerRepository;

    public void save(Ticker ticker) {
        BigDecimal spreadInAmount = ticker.getAskPrice().subtract(ticker.getBidPrice());
        BigDecimal spreadInPercentage = BigDecimal.ONE;
        if(ticker.getAskPrice().compareTo(BigDecimal.ZERO) > 0) {
            spreadInPercentage = spreadInAmount.divide(ticker.getAskPrice(), 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        }
        ticker.setSpreadInAmount(spreadInAmount);
        ticker.setSpreadInPercentage(spreadInPercentage);
        tickerRepository.save(ticker);
    }
}

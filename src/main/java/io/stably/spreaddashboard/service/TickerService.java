package io.stably.spreaddashboard.service;

import io.stably.spreaddashboard.domain.entity.Ticker;
import io.stably.spreaddashboard.repository.TickerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fenix truonghatsts@gmail.com
 */

@Service
public class TickerService {

    @Autowired
    private TickerRepository tickerRepository;

    @Autowired
    private ConfigService configService;

    public void save(Ticker ticker) {
        BigDecimal spreadInAmount = ticker.getAskPrice().subtract(ticker.getBidPrice());
        BigDecimal spreadInPercentage = BigDecimal.ONE;
        if(ticker.getAskPrice().compareTo(BigDecimal.ZERO) > 0) {
            spreadInPercentage = spreadInAmount.divide(ticker.getAskPrice(), 8, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        }
        ticker.setSpreadInAmount(spreadInAmount);
        ticker.setSpreadInPercentage(spreadInPercentage);
        tickerRepository.save(ticker);
    }

    public List<String> getSymbolNames() {
        List<String> uniqueSymbolNames = tickerRepository.getUniqueSymbolNames();
        String symbolPattern = configService.getSymbolPattern();
        List<String> symbolNames = new ArrayList<>();
        uniqueSymbolNames.forEach(s -> {
            if(s.matches(symbolPattern)) {
                symbolNames.add(s);
            }
        });
        return symbolNames;
    }

    public List<Ticker> getTickers(String symbol) {
        return tickerRepository.findBySymbol(symbol);
    }

    public Ticker getLastTicker(String symbol) {
        return tickerRepository.findTopBySymbolOrderByTimestampDesc(symbol);
    }
}

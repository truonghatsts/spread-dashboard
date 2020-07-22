package io.stably.spreaddashboard.service;

import io.stably.spreaddashboard.config.ModelMapper;
import io.stably.spreaddashboard.domain.dto.AllSymbolSpreads;
import io.stably.spreaddashboard.domain.dto.SymbolSpread;
import io.stably.spreaddashboard.domain.entity.Ticker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fenix truonghatsts@gmail.com
 */
@Service
public class DataService {

    @Autowired
    private TickerService tickerService;

    @Autowired
    private ConfigService configService;

    public List<SymbolSpread> getSpreadData() {
        List<String> symbolNames = tickerService.getSymbolNames();
        List<SymbolSpread> symbolSpreads = new ArrayList<>();
        AllSymbolSpreads data = new AllSymbolSpreads();
        for (String symbol : symbolNames) {
            Ticker lastTicker = tickerService.getLastTicker(symbol);
            SymbolSpread symbolSpread = ModelMapper.INSTANCE.tickerToSymbolSpread(lastTicker);
            symbolSpreads.add(symbolSpread);
        }
        return symbolSpreads;
    }

    public List<BigDecimal> getSpreadInAmount(String symbol, int period) {
        List<Ticker> tickers = tickerService.getTickers(symbol);
        List<BigDecimal> spreads = new ArrayList<>();
        BigDecimal max = BigDecimal.ZERO;
        for (int i = 0; i < tickers.size(); i++) {
            Ticker ticker = tickers.get(i);
            if(max.compareTo(ticker.getSpreadInAmount()) < 0) {
                max = ticker.getSpreadInAmount();
            }
            if (i % period == period - 1 || i == tickers.size() - 1) {
                spreads.add(max);
                max = BigDecimal.ZERO;
            }
        }
        return spreads;
    }

    public List<BigDecimal> getSpreadInPercentage(String symbol, int period) {
        List<Ticker> tickers = tickerService.getTickers(symbol);
        List<BigDecimal> spreads = new ArrayList<>();
        BigDecimal max = BigDecimal.ZERO;
        for (int i = 0; i < tickers.size(); i++) {
            Ticker ticker = tickers.get(i);
            if(max.compareTo(ticker.getSpreadInPercentage()) < 0) {
                max = ticker.getSpreadInPercentage();
            }
            if (i % period == period - 1 || i == tickers.size() - 1) {
                spreads.add(max);
                max = BigDecimal.ZERO;
            }
        }
        return spreads;
    }
}

package io.stably.spreaddashboard.service;

import io.stably.spreaddashboard.config.ModelMapper;
import io.stably.spreaddashboard.domain.dto.AllSymbolSpreads;
import io.stably.spreaddashboard.domain.dto.SymbolSpread;
import io.stably.spreaddashboard.domain.entity.Ticker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        for(String symbol:symbolNames) {
            Ticker lastTicker = tickerService.getLastTicker(symbol);
            SymbolSpread symbolSpread = ModelMapper.INSTANCE.tickerToSymbolSpread(lastTicker);
            symbolSpreads.add(symbolSpread);
        }
        return symbolSpreads;
    }
}

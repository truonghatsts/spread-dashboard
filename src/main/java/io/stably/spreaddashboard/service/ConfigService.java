package io.stably.spreaddashboard.service;

import io.stably.spreaddashboard.config.SpreadDashboardProperties;
import io.stably.spreaddashboard.domain.entity.SpreadDashboardConfiguration;
import io.stably.spreaddashboard.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Fenix truonghatsts@gmail.com
 */

@Service
public class ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    @Autowired
    private SpreadDashboardProperties props;

    public String getSymbolPattern() {
        String symbolPattern = props.getDefaultSymbolPattern();
        Optional<SpreadDashboardConfiguration> symbolPatternFromDb = configRepository.findByKey("symbolPattern");
        if(symbolPatternFromDb.isPresent()) {
            symbolPattern = symbolPatternFromDb.get().getValue();
        }
        return symbolPattern;
    }

    public Integer getWindowSize() {
        Integer windowSize = props.getDefaultWindowSize();
        Optional<SpreadDashboardConfiguration> windowSizeFromDb = configRepository.findByKey("windowSize");
        if(windowSizeFromDb.isPresent()) {
            windowSize = Integer.parseInt(windowSizeFromDb.get().getValue());
        }
        return windowSize;
    }

}

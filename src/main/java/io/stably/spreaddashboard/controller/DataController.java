package io.stably.spreaddashboard.controller;

import io.stably.spreaddashboard.domain.dto.SymbolSpread;
import io.stably.spreaddashboard.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Fenix truonghatsts@gmail.com
 */
@RestController
@RequestMapping(path = "/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/allSymbolSpreads")
    public List<SymbolSpread> getAllSymbolSpreads() {
        return dataService.getSpreadData();
    }

    @GetMapping("/{symbol}/{period}/spreadInAmount")
    public List<BigDecimal> getSpreadInAmount(@PathVariable("symbol") String symbol, @PathVariable("period") Integer period) {
        return dataService.getSpreadInAmount(symbol, period);
    }

    @GetMapping("/{symbol}/{period}/spreadInPercentage")
    public List<BigDecimal> getSpreadInPercentage(@PathVariable("symbol") String symbol, @PathVariable("period") Integer period) {
        return dataService.getSpreadInPercentage(symbol, period);
    }
}

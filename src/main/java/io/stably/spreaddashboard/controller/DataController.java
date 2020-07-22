package io.stably.spreaddashboard.controller;

import io.stably.spreaddashboard.domain.dto.AllSymbolSpreads;
import io.stably.spreaddashboard.domain.dto.SymbolSpread;
import io.stably.spreaddashboard.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<SymbolSpread> getSpreadData() {
        return dataService.getSpreadData();
    }
}

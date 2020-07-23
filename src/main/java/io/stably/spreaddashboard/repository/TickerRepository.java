package io.stably.spreaddashboard.repository;

import io.stably.spreaddashboard.domain.entity.Ticker;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TickerRepository extends CrudRepository<Ticker, Long> {

    @Query("SELECT DISTINCT t.symbol FROM Ticker t")
    List<String> getUniqueSymbolNames();

    List<Ticker> findBySymbolOrderByTimestampDesc(String symbol, Pageable pageable);

    Ticker findTopBySymbolOrderByTimestampDesc(String symbol);



}

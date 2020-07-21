package io.stably.spreaddashboard.repository;

import io.stably.spreaddashboard.domain.entity.Ticker;
import org.springframework.data.repository.CrudRepository;

public interface TickerRepository extends CrudRepository<Ticker, Long> {
}

package io.stably.spreaddashboard.repository;

import io.stably.spreaddashboard.domain.entity.Spread;
import org.springframework.data.repository.CrudRepository;

public interface SpreadRepository extends CrudRepository<Spread, Long> {
}

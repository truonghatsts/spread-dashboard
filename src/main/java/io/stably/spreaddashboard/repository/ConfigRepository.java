package io.stably.spreaddashboard.repository;

import io.stably.spreaddashboard.domain.entity.SpreadDashboardConfiguration;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConfigRepository extends CrudRepository<SpreadDashboardConfiguration, Long> {

    Optional<SpreadDashboardConfiguration> findByKey(String symbolPattern);
}

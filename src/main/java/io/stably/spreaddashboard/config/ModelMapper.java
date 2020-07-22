package io.stably.spreaddashboard.config;

import io.stably.spreaddashboard.domain.dto.SymbolSpread;
import io.stably.spreaddashboard.domain.entity.Ticker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Fenix truonghatsts@gmail.com
 */
@Mapper
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    SymbolSpread tickerToSymbolSpread(Ticker ticker);

}

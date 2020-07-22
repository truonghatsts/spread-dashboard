package io.stably.spreaddashboard.domain.dto;

import lombok.*;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fenix truonghatsts@gmail.com
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SymbolSpread {

    private String symbol;
    private BigDecimal spreadInAmount;
    private BigDecimal spreadInPercentage;
}

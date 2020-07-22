package io.stably.spreaddashboard.domain.dto;

import lombok.*;

import java.math.BigDecimal;

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
    private BigDecimal bidPrice;
    private BigDecimal askPrice;
    private BigDecimal spreadInAmount;
    private BigDecimal spreadInPercentage;
}

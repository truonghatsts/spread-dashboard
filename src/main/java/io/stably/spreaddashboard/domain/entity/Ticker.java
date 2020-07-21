package io.stably.spreaddashboard.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
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
@Entity
public class Ticker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String symbol;
    @Column(precision = 19, scale = 8)
    private BigDecimal bidPrice;
    @Column(precision = 19, scale = 8)
    private BigDecimal bidQty;
    @Column(precision = 19, scale = 8)
    private BigDecimal askPrice;
    @Column(precision = 19, scale = 8)
    private BigDecimal askQty;
    @Column(precision = 19, scale = 8)
    private BigDecimal spreadInAmount;
    @Column(precision = 19, scale = 8)
    private BigDecimal spreadInPercentage;
    private Long timestamp;
}

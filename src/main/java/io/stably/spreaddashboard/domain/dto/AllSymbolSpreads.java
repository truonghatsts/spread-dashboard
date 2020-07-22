package io.stably.spreaddashboard.domain.dto;

import lombok.*;

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
public class AllSymbolSpreads {

    private List<SymbolSpread> symbolSpreads = new ArrayList<>();

}

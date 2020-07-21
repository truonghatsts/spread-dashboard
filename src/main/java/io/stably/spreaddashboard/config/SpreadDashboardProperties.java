package io.stably.spreaddashboard.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fenix truonghatsts@gmail.com
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Configuration
@ConfigurationProperties("sdb")
public class SpreadDashboardProperties {

    private String apiKey;
    private String secretKey;
}

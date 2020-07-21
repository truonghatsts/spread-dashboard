package io.stably.spreaddashboard;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import io.stably.spreaddashboard.config.SpreadDashboardProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpreadDashboardApplication extends SpringBootServletInitializer {

	@Autowired
	private SpreadDashboardProperties props;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpreadDashboardApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpreadDashboardApplication.class);
	}

	@Bean
	public BinanceApiRestClient getBinanceClient() {
		BinanceApiClientFactory binanceApiClientFactory = BinanceApiClientFactory.newInstance(props.getApiKey(), props.getSecretKey());
		return binanceApiClientFactory.newRestClient();
	}

}

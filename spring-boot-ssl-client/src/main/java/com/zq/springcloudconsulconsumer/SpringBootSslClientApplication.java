package com.zq.springcloudconsulconsumer;

import com.zq.springcloudconsulconsumer.support.CustomConnectionKeepAliveStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootApplication
public class SpringBootSslClientApplication {

	@Value("${security.key-store}")
	private Resource keyStore;

	@Value("${security.key-pass}")
	private String keyPass;

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(SpringBootSslClientApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.web(WebApplicationType.NONE)
				.run(args);
	}

	@Bean
	public Jackson2HalModule jackson2HalModule() {
		return new Jackson2HalModule();
	}

	@Bean
	public HttpComponentsClientHttpRequestFactory requestFactory() {
		SSLContext sslContext = null;
		try {
			sslContext = SSLContextBuilder.create()
					// 会校验证书
					.loadTrustMaterial(keyStore.getURL(), keyPass.toCharArray())
					// 放过所有证书校验
//					.loadTrustMaterial(null, (certificate, authType) -> true)
					.build();
		} catch(Exception e) {
			log.error("Exception occurred while creating SSLContext.", e);
		}

		CloseableHttpClient httpClient = HttpClients.custom()
				.evictIdleConnections(30, TimeUnit.SECONDS)
				.setMaxConnTotal(200)
				.setMaxConnPerRoute(20)
				.disableAutomaticRetries()
				.setKeepAliveStrategy(new CustomConnectionKeepAliveStrategy())
				.setSSLContext(sslContext)
				.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
				.build();

		HttpComponentsClientHttpRequestFactory requestFactory =
				new HttpComponentsClientHttpRequestFactory(httpClient);

		return requestFactory;
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.setConnectTimeout(Duration.ofMillis(100))
				.setReadTimeout(Duration.ofMillis(500))
				.requestFactory(this::requestFactory)
				.build();
	}
}

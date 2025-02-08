package com.user.management.app.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${user.management.url.base}")
    private String baseURL;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(baseURL).build(); // Ensure base URL is set
    }
}
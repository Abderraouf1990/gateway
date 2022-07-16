package com.gateway.poc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

	@Value("${product.base.uri}")
	private String productBaseUri;
	  
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route( p -> p.path("/messages/**")
	            .uri(this.productBaseUri)
	            )
	        .route( p -> p.path("/products/**")
		            .uri(this.productBaseUri)
		            )
	        /*.route(p -> p
	            .host("*.circuitbreaker.com")
	            .filters(f -> f.circuitBreaker(config -> config
	                .setName("mycmd")
	                //.setFallbackUri("forward:/fallback")
	                ))
	            .uri("http://httpbin.org:80"))*/
	        .build();
	}
}

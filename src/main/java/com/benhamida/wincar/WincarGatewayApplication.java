package com.benhamida.wincar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WincarGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WincarGatewayApplication.class, args);
	}
	
	/**
	 * Configuration dynamique de la gateway en récuperant les url des microservice via eureka
	 * @param rdc
	 * @param dlp
	 * @return
	 */
	@Bean
	DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
		
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}

}

package org.fasttrackit.restaurant.client.resttemplate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties("restaurant-service.rt")
@EnableConfigurationProperties(value = RestaurantClientRTConfig.class)
public record RestaurantClientRTConfig(String location) {
}

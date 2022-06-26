package org.fasttrackit.restaurant.app.model.mapper;

import org.fasttrackit.restaurant.app.entity.RestaurantEntity;
import org.fasttrackit.restaurant.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper implements ModelMapper<Restaurant, RestaurantEntity>{

    public Restaurant toApi(RestaurantEntity source){
        return Restaurant.builder()
                .id(source.getId())
                .name(source.getName())
                .stars(source.getStars())
                .city(source.getCity())
                .since(source.getSince())
                .build();
    }

    public RestaurantEntity toEntity(Restaurant source){
        return RestaurantEntity.builder()
                .id(source.id())
                .name(source.name())
                .stars(source.stars())
                .city(source.city())
                .since(source.since())
                .build();
    }
}

package org.fasttrackit.restaurant.app.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.restaurant.app.entity.RestaurantEntity;
import org.fasttrackit.restaurant.app.exception.RestaurantNotFoundException;
import org.fasttrackit.restaurant.app.model.RestaurantFilter;
import org.fasttrackit.restaurant.app.model.mapper.RestaurantMapper;
import org.fasttrackit.restaurant.app.service.RestaurantService;
import org.fasttrackit.restaurant.model.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("restaurants")
public class RestaurantController {

    private final RestaurantService service;
    private final RestaurantMapper mapper;

    @GetMapping
    List<Restaurant> getAll(RestaurantFilter filter){
        return service.getAll(filter).stream()
                .map(mapper::toApi)
                .toList();
    }

    @GetMapping("{restaurantId}")
    Restaurant getOne(@PathVariable int restaurantId){
        return service.get(restaurantId)
                .map(entity -> getRestaurant(entity))
                .orElseThrow(() ->new RestaurantNotFoundException("Could not find restaurant with id " + restaurantId));
    }

    private Restaurant getRestaurant(RestaurantEntity entity) {
        return new Restaurant(
                entity.getId(),
                entity.getName(),
                entity.getStars(),
                entity.getCity(),
                entity.getSince());
    }
}

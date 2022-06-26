package org.fasttrackit.restaurant.app.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.restaurant.app.model.RestaurantFilter;
import org.fasttrackit.restaurant.app.model.mapper.RestaurantMapper;
import org.fasttrackit.restaurant.app.service.RestaurantService;
import org.fasttrackit.restaurant.model.Restaurant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("restaurants")
public class RestaurantController {

    private final RestaurantService service;
    private final RestaurantMapper mapper;

    List<Restaurant> getAll(RestaurantFilter filter){
        return service.getAll(filter).stream()
                .map(mapper::toApi)
                .toList();
    }
}

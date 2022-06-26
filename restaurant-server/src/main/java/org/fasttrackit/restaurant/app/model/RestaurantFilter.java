package org.fasttrackit.restaurant.app.model;

import java.util.List;

public record RestaurantFilter(
        List<String> city,
        Integer minStars,
        Integer maxStars){
}


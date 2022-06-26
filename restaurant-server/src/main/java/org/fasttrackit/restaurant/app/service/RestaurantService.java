package org.fasttrackit.restaurant.app.service;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.restaurant.app.entity.RestaurantEntity;
import org.fasttrackit.restaurant.app.model.RestaurantFilter;
import org.fasttrackit.restaurant.app.model.mapper.RestaurantMapper;
import org.fasttrackit.restaurant.app.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repository;
    private final RestaurantMapper mapper;

    public List<RestaurantEntity> getAll(RestaurantFilter filter){
        return repository.findAll().stream()
                .filter(restaurant -> applyNameFilter(filter, restaurant))
                .filter(restaurant -> filter.minStars() == null || restaurant.getStars() >= filter.minStars())
                .toList();
    }

    private boolean applyNameFilter(RestaurantFilter filter, RestaurantEntity restaurant) {
        return filter.city() == null
                || filter.city().stream()
                .allMatch(name -> restaurant.getName().contains(name));
    }
}

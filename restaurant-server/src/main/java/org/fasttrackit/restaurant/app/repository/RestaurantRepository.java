package org.fasttrackit.restaurant.app.repository;

import org.fasttrackit.restaurant.app.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {
}

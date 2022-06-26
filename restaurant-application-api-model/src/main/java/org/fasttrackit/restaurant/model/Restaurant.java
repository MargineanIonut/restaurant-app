package org.fasttrackit.restaurant.model;

import lombok.Builder;

import java.time.LocalDate;

public record Restaurant(long id, String name, int stars, String city, LocalDate since) {
    @Builder public Restaurant{}
}

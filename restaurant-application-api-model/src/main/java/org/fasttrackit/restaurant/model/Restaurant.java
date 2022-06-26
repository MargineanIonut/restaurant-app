package org.fasttrackit.restaurant.model;

import java.time.LocalDate;

public record Restaurant(long id, String name, int stars, String city, LocalDate since) {
}

package org.fasttrackit.restaurant.app.model.mapper;

import java.util.List;

public interface ModelMapper<T, S> {

    default List<T> toApi(List<S> entities) {
        return entities.stream()
                .map(this::toApi)
                .toList();
    }

    default List<S> toEntity(List<T> entities) {
        return entities.stream()
                .map(this::toEntity)
                .toList();
    }

    T toApi(S entity);

    S toEntity(T entity);
}

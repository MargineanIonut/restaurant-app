package org.fasttrackit.restaurant.client.resttemplate;
import lombok.RequiredArgsConstructor;
import org.fasttrackit.restaurant.client.resttemplate.config.RestaurantClientRTConfig;
import org.fasttrackit.restaurant.model.Restaurant;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RestaurantClientRT {

    private final RestaurantClientRTConfig config;


    public RestaurantClient restaurants(){
        return new RestaurantClient(config.location());
    }

    public class RestaurantClient {
        private final String url;

        public RestaurantClient(String location) {
            this.url = UriComponentsBuilder.fromHttpUrl(location)
                    .pathSegment("restaurants")
                    .toUriString();
        }

        public Optional<Restaurant> get(int restaurantId){
            var url = UriComponentsBuilder.fromHttpUrl(this.url)
                    .pathSegment(String.valueOf(restaurantId))
                    .toUriString();
            return Optional.ofNullable(new RestTemplate().getForObject(url, Restaurant.class));
        }

        public List<Restaurant> get(){
            return new RestTemplate()
                    .exchange(this.url, HttpMethod.GET, new HttpEntity<>(null), new ParameterizedTypeReference<List<Restaurant>>() {
                    })
                    .getBody();
        }
    }


}

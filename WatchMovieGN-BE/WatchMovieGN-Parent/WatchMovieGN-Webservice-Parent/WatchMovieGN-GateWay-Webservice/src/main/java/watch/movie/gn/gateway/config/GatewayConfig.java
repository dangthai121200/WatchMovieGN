package watch.movie.gn.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

@Configuration
@EnableHystrix
public class GatewayConfig {

//    @Value( "${jdbc.url}" )
    private String movieServiceName;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("movieservice", r -> r.path("/movieservice/**")
                        .uri("lb://movieservice"))
                .build();
    }
}

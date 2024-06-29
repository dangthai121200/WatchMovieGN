package watch.movie.gn.eureka;

import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class EurekaConfigClientProd {
    @Bean
    @Profile("prod")
    public EurekaClientConfigBean eurekaInstanceConfig() {
        EurekaClientConfigBean eurekaInstanceConfigBean = new EurekaClientConfigBean();
        return eurekaInstanceConfigBean;
    }
}

package watch.movie.gn.eureka;

import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import watch.movie.gn.exception.WatchMovieException;

@Configuration
public class EurekaConfigClientDev {

    @Value("${watch.movie.gn.eureka.server.servlet.port}")
    private String eurekaPort;

    @Value("${watch.movie.gn.eureka.server.servlet.context-path}")
    private String eurekaContextPath;

    @PostConstruct
    public void init() throws WatchMovieException {
        if (Strings.isEmpty(eurekaPort) || Strings.isEmpty(eurekaContextPath)) {
            throw new WatchMovieException("eurekaPort and eurekaContextPath is not set");
        }
    }

    @Bean
    @Profile("dev")
    public EurekaClientConfigBean eurekaInstanceConfig() {
        EurekaClientConfigBean eurekaInstanceConfigBean = new EurekaClientConfigBean();
        eurekaInstanceConfigBean.setEurekaServerPort(eurekaPort);
//        eurekaInstanceConfigBean.setEurekaServerURLContext(eurekaContextPath);
        return eurekaInstanceConfigBean;
    }
}

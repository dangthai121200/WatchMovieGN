package watch.movie.gn.configuration.elastic;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchConfiguration;

@Configuration
@Profile("dev")
public class ReactiveElasticSearchConnectDev extends ReactiveElasticsearchConfiguration {

	@Override
	public ClientConfiguration clientConfiguration() {
		return ClientConfiguration.localhost();
	}
}

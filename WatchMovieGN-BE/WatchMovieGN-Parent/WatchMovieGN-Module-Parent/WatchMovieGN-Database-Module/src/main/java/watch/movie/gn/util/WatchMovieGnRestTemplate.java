package watch.movie.gn.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import watch.movie.gn.entity.RequestHistoryEntity;
import watch.movie.gn.enums.StatusRequestEnum;
import watch.movie.gn.repository.RequestHistoryRepository;

@Component
public class WatchMovieGnRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RequestHistoryRepository requestHistoryRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public <T> T sendPostRequest(String url, String start, String callTo, Object object, Class<T> responseType) {
        T reponse = null;
        StatusRequestEnum status = StatusRequestEnum.SUCCESS;
        String body = Strings.EMPTY;
        String reasonError = Strings.EMPTY;
        try {
            body = objectMapper.writeValueAsString(object);
            reponse = restTemplate.postForObject(url, object, responseType);
        } catch (JsonProcessingException ex) {
            body = String.valueOf(object);
        } catch (Exception ex) {
            status = StatusRequestEnum.FAIL;
            reasonError = ex.getMessage();
        }

        RequestHistoryEntity requestHistoryEntity = RequestHistoryEntity.builder()
                .className(object.getClass().getName())
                .body(body)
                .callTo(callTo)
                .start(start)
                .status(status)
                .reasonError(reasonError)
                .build();
        requestHistoryRepository.save(requestHistoryEntity);

        return reponse;
    }

}

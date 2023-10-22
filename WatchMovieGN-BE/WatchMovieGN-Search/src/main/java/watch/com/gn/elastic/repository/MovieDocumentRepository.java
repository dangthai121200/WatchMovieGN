package watch.com.gn.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import watch.movie.gn.elastic.document.MovieDocument;

public interface MovieDocumentRepository extends ElasticsearchRepository<MovieDocument, Integer> {

}

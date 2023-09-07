package watch.movie.gn.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import watch.movie.gn.elastic.document.MovieDocument;

@Repository
public interface MovieDocumentRepository extends ElasticsearchRepository<MovieDocument, Integer> {

}

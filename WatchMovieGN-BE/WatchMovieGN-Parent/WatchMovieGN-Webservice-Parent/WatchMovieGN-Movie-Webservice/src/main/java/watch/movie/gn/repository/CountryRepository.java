package watch.movie.gn.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import watch.movie.gn.entity.Country;
import watch.movie.gn.util.CacheConstant;

import java.util.List;

@Transactional
public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Cacheable(CacheConstant.CACHE_COUNTRIES)
    @Override
    List<Country> findAll();
}

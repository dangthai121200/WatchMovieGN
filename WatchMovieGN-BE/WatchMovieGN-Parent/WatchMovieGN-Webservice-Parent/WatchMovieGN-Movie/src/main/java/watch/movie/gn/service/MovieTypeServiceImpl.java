package watch.movie.gn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watch.movie.gn.domain.type.GetAllMovieTypeDomain;
import watch.movie.gn.entity.Type;
import watch.movie.gn.enums.MovieTypeEnum;
import watch.movie.gn.repository.TypeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieTypeServiceImpl implements MovieTypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public GetAllMovieTypeDomain getAllMovieType() {
        return null;
    }

    @Override
    public void updateMovieTypeEnumsIntoDatabase() {
        List<Type> types = new ArrayList<>();
        for (MovieTypeEnum movieTypeEnum : MovieTypeEnum.values()) {
            Type type = new Type();
            type.setPkIdType(movieTypeEnum.getPkIdMovieType());
            type.setName(movieTypeEnum.getName());
            types.add(type);
        }
        typeRepository.saveAll(types);
    }
}

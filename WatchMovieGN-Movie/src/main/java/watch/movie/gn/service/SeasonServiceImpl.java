package watch.movie.gn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import watch.movie.gn.entity.Season;
import watch.movie.gn.enums.SeasonEnum;
import watch.movie.gn.repository.SeasonRepository;

@Service
public class SeasonServiceImpl implements SeasonService {

	@Autowired
	private SeasonRepository seasonRepository;

	@Override
	public void updateSeasonEnumsIntoDatabase() {
		List<Season> seasons = new ArrayList<>();
		for (SeasonEnum seasonEnum : SeasonEnum.values()) {
			Season season = new Season();
			season.setPkIdSeason(seasonEnum.getPkIdSeason());
			season.setName(seasonEnum.getName());
			season.setYear(seasonEnum.getYear());
			seasons.add(season);
		}
		seasonRepository.saveAll(seasons);
	}

}

package watch.movie.gn.enums;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public enum MovieTypeEnum {
    TV_SERIES(1, "TV Series"),
    OVA(2, "OVA"),
    MOVIES(3, "Movies"),
    ONA(4, "ONA"),
    BLURAY(5, "Bluray"),
    ANIME(6, "Anime"),
    CARTOON(7, "Cartoon"),
    LIVE_ACTION(8, "Live Action");

    private Integer pkIdMovieType;
    private String name;

    MovieTypeEnum(Integer pkIdMovieType, String name) {
        this.pkIdMovieType = pkIdMovieType;
        this.name = name;
    }
}

package subway.domain.setting;

import java.util.List;
import subway.domain.vo.Station;
import subway.repository.StationRepository;

public class StationInitializer {

    public static void initStation() {
        for (Station station : setStations()) {
            StationRepository.addStation(station);
        }
    }

    private static List<Station> setStations() {
        return List.of(
                new Station("강남역"),
                new Station("역삼역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("양재시민의숲역"),
                new Station("매봉역")
        );
    }
}

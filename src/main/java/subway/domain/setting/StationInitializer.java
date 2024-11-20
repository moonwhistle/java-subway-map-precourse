package subway.domain.setting;

import java.util.List;
import subway.domain.vo.Station;
import subway.repository.StationRepository;

public class StationInitializer {

    public static void initStation() {
        List<Station> stations = setStationData();

        for(Station station : stations) {
            StationRepository.addStation(station);
        }
    }

    private static List<Station> setStationData() {
        return List.of(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("양재시민의숲역"),
                new Station("매봉역")
        );
    }
}


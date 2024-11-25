package subway.domain.setting;

import java.util.List;
import subway.domain.LineStation;
import subway.domain.vo.Line;
import subway.domain.vo.Station;
import subway.repository.LineStationRepository;

public class LineStationInitializer {

    public static void initLineStation() {
        for (LineStation lineStation : setLineStations()) {
            LineStationRepository.addLineStation(lineStation);
        }
    }

    private static List<LineStation> setLineStations() {
        return List.of(
                new LineStation(
                        new Line("2호선"),
                        List.of(
                                new Station("교대역"),
                                new Station("강남역"),
                                new Station("역삼역")
                        )
                ),
                new LineStation(
                        new Line("3호선"),
                        List.of(
                                new Station("교대역"),
                                new Station("남부터미널역"),
                                new Station("양재역"),
                                new Station("매봉역")
                        )
                ),
                new LineStation(
                        new Line("신분당선"),
                        List.of(
                                new Station("강남역"),
                                new Station("양재역"),
                                new Station("양재시민의숲역")
                        )
                )
        );
    }
}

package subway.domain.setting;

import java.util.List;
import subway.domain.LineStation;
import subway.domain.vo.Line;
import subway.domain.vo.Station;
import subway.repository.LineStationRepository;

public class LineStationInitializer {

    public static void initLineStations() {
        LineStationRepository.addLineStation(setTwoLineStations());
        LineStationRepository.addLineStation(setThreeLineStations());
        LineStationRepository.addLineStation(setSinBunDangStations());
    }

    private static LineStation setSinBunDangStations() {
        return new LineStation(
                new Line("신분당선"),
                makeSinBunDangLineStations()
        );
    }

    private static LineStation setThreeLineStations() {
        return new LineStation(
                new Line("3호선"),
                makeThreeLineStations()
        );
    }

    private static LineStation setTwoLineStations() {
        return new LineStation(
                new Line("2호선"),
                makeTwoLineStations()
        );
    }

    private static List<Station> makeTwoLineStations() {
        return List.of(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역")
        );
    }

    private static List<Station> makeThreeLineStations() {
        return List.of(
                new Station("교대역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("매봉역")
        );
    }

    private static List<Station> makeSinBunDangLineStations() {
        return List.of(
                new Station("강남역"),
                new Station("양재역"),
                new Station("양재시민의숲역")
        );
    }
}

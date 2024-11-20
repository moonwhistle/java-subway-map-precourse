package subway.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import subway.domain.LineStation;
import subway.domain.vo.Line;
import subway.domain.vo.Station;

public class LineStationRepository {

    private static final List<LineStation> lineStations = new ArrayList<>();

    public static void addLineStation(LineStation lineStation) {
        lineStations.add(lineStation);
    }

    public static void deleteLineStation(String lineName) {
        lineStations.removeIf(lineStation -> Objects.equals(lineStation.getLine(), lineName));
    }

    public static void checkAlreadyResisterStation(String stationName) {
        Station station = new Station(stationName);

        for (LineStation lineStation : lineStations) {
            lineStation.checkAlreadyRegisteredStation(station);
        }
    }
}

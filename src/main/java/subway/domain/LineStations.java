package subway.domain;

import java.util.List;
import subway.domain.vo.Station;

public class LineStations {

    private final List<LineStation> lineStations;

    public LineStations(List<LineStation> lineStations) {
        this.lineStations = lineStations;
    }

    public void checkAlreadyResisterStation(String stationName) {
        Station station = new Station(stationName);

        for (LineStation lineStation : lineStations) {
            lineStation.checkAlreadyRegisteredStation(station);
        }
    }
}

package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.LineStation;
import subway.domain.vo.Line;
import subway.domain.vo.Station;

public class LineStationRepository {

    private static final List<LineStation> lineStations = new ArrayList<>();

    public static void addLineStation(LineStation lineStation) {
        lineStations.add(lineStation);
    }

    public static boolean hasLineStation(Station station) {
        for (LineStation lineStation : lineStations) {
            if (lineStation.getStations().contains(station)) {
                return true;
            }
        }
        return false;
    }

    public static void deleteLineStation(Line line) {
        lineStations.removeIf(lineStation -> lineStation.getLine() == line);
    }

    public static LineStation getLineStation(Line line) {
        for (LineStation lineStation : lineStations) {
            if (lineStation.getLine().equals(line)) {
                return lineStation;
            }
        }
        return null;
    }

    public static List<LineStation> getLineStations() {
        return Collections.unmodifiableList(lineStations);
    }
}

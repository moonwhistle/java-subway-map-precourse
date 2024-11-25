package subway.repository;

import java.util.ArrayList;
import java.util.List;
import subway.domain.LineStation;

public class LineStationRepository {

    private static final List<LineStation> lineStations = new ArrayList<>();

    public static void addLineStation(LineStation lineStation) {
        lineStations.add(lineStation);
    }
}

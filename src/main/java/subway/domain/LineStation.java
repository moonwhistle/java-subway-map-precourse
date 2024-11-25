package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.vo.Line;
import subway.domain.vo.Station;

public class LineStation {

    private final Line line;
    private final List<Station> stations;

    public LineStation(Line line, List<Station> stations) {
        this.line = line;
        this.stations = new ArrayList<>(stations);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public Line getLine() {
        return line;
    }

    public void addStation(Station station, int order) {
        stations.add(order - 1, station);
    }

    public void removeStation(Station station) {
        stations.remove(station);
    }
}

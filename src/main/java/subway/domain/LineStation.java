package subway.domain;

import java.util.List;
import subway.domain.vo.Line;
import subway.domain.vo.Station;

public class LineStation {

    private final Line line;
    private final List<Station> stations;

    public LineStation(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }
}

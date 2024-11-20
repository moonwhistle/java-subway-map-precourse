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

    public String getLine() {
        return line.getName();
    }

    public void checkAlreadyRegisteredStation(Station station) {
        if(stations.contains(station)) {
            throw new IllegalArgumentException("이미 노선에 등록되어 있는 역입니다.");
        }
    }
}

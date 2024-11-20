package subway.domain.setting;

import java.util.List;
import subway.domain.vo.Line;
import subway.repository.LineRepository;

public class LineInitializer {

    public static void initLine() {
        List<Line> lines = setLineData();

        for(Line line : lines) {
            LineRepository.addLine(line);
        }
    }

    private static List<Line> setLineData() {
        return List.of(
                new Line("2호선"),
                new Line("3호선"),
                new Line("신분당선")
        );
    }
}

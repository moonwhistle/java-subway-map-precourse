package subway.view;

import java.util.List;
import subway.domain.vo.Line;
import subway.domain.vo.Station;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String INFO = "[INFO]";

    public void mainGuide() {
        System.out.println(
                "\n## 메인 화면" + LINE_SEPARATOR
                        + "1. 역 관리" + LINE_SEPARATOR
                        + "2. 노선 관리" + LINE_SEPARATOR
                        + "3. 구간 관리" + LINE_SEPARATOR
                        + "4. 지하철 노선도 출력" + LINE_SEPARATOR
                        + "Q. 종료" + LINE_SEPARATOR
        );
    }

    public void stationGuide() {
        System.out.println(
                "\n## 역 관리 화면" + LINE_SEPARATOR
                        + "1. 역 등록" + LINE_SEPARATOR
                        + "2. 역 삭제" + LINE_SEPARATOR
                        + "3. 역 조회" + LINE_SEPARATOR
                        + "B. 돌아가기" + LINE_SEPARATOR
        );
    }

    public void showStations(List<Station> stations) {
        System.out.println("\n## 역 목록");

        for (Station station : stations) {
            System.out.println(
                    INFO + station.getName()
            );
        }
    }

    public void lineGuide() {
        System.out.println(
                "\n## 노선 관리 화면" + LINE_SEPARATOR
                        + "1. 노선 등록" + LINE_SEPARATOR
                        + "2. 노선 삭제" + LINE_SEPARATOR
                        + "3. 노선 조회" + LINE_SEPARATOR
                        + "B. 돌아가기" + LINE_SEPARATOR
        );
    }

    public void successLineRegister() {
        System.out.println(
                LINE_SEPARATOR + INFO + "지하철 노선이 등록되었습니다."
        );
    }

    public void successLineDelete() {
        System.out.println(
                LINE_SEPARATOR + INFO + "지하철 노선이 삭제되었습니다."
        );
    }

    public void showLines(List<Line> lines) {
        System.out.println("\n##노선 목록");
        for (Line line : lines) {
            System.out.println(
                    INFO + line.getName()
            );
        }
    }

    public void sectionGide() {
        System.out.println(
                "\n## 구간 관리 화면" + LINE_SEPARATOR
                        + "1. 구간 등록" + LINE_SEPARATOR
                        + "2. 구간 삭제" + LINE_SEPARATOR
                        + "B. 돌아가기" + LINE_SEPARATOR
        );
    }

    public void showError() {

    }
}

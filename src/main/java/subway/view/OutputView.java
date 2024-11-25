package subway.view;

import java.util.List;
import subway.domain.LineStation;
import subway.domain.vo.Line;
import subway.domain.vo.Station;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void guideMainSystem() {
        System.out.println(
                LINE_SEPARATOR + "## 메인 화면" + LINE_SEPARATOR
                        + "1. 역 관리" + LINE_SEPARATOR
                        + "2. 노선 관리" + LINE_SEPARATOR
                        + "3. 구간 관리" + LINE_SEPARATOR
                        + "4. 지하철 노선도 출력" + LINE_SEPARATOR
                        + "Q. 종료" + LINE_SEPARATOR
        );
    }

    public void getCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void guideStationSystem() {
        System.out.println(
                LINE_SEPARATOR + "## 역 관리 화면" + LINE_SEPARATOR
                        + "1. 역 등록" + LINE_SEPARATOR
                        + "2. 역 삭제" + LINE_SEPARATOR
                        + "3. 역 조회" + LINE_SEPARATOR
                        + "B. 돌아가기" + LINE_SEPARATOR
        );
    }

    public void registerStation() {
        System.out.println(LINE_SEPARATOR + "## 등록할 역 이름을 입력하세요.");
    }

    public void successRegisterStation() {
        System.out.println(LINE_SEPARATOR + "지하철 역이 등록되었습니다.");
    }

    public void deleteStation() {
        System.out.println(LINE_SEPARATOR + "## 삭제할 역 이름을 입력하세요.");
    }

    public void successDeleteStation() {
        System.out.println(LINE_SEPARATOR + "지하철 역이 삭제되었습니다.");
    }

    public void showStations(List<Station> stations) {
        for (Station station : stations) {
            System.out.println(station.getName());
        }
    }

    public void guideLineSystem() {
        System.out.println(
                LINE_SEPARATOR + "## 노선 관리 화면" + LINE_SEPARATOR
                        + "1. 노선 등록" + LINE_SEPARATOR
                        + "2. 노선 삭제" + LINE_SEPARATOR
                        + "3. 노선 조회" + LINE_SEPARATOR
                        + "B. 돌아가기" + LINE_SEPARATOR
        );
    }

    public void registerLine() {
        System.out.println(LINE_SEPARATOR + "## 등록할 노선 이름을 입력하세요.");
    }

    public void registerLineUpStation() {
        System.out.println(LINE_SEPARATOR + "## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public void registerLineDownStation() {
        System.out.println(LINE_SEPARATOR + "## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public void successRegisterLine() {
        System.out.println(LINE_SEPARATOR + "노선이 등록되었습니다.");
    }

    public void deleteLine() {
        System.out.println(LINE_SEPARATOR + "삭제할 노선 이름을 입력하세요.");
    }

    public void successDeleteLine() {
        System.out.println(LINE_SEPARATOR + "지하철 노선이 삭제되었습니다.");
    }

    public void showLines(List<Line> lines) {
        System.out.println("## 노선 목록");
        for (Line line : lines) {
            System.out.println(line.getName());
        }
    }

    public void guideSectionSystem() {
        System.out.println(
                LINE_SEPARATOR + "## 구간 관리 화면" + LINE_SEPARATOR
                        + "1. 구간 등록" + LINE_SEPARATOR
                        + "2. 구간 삭제" + LINE_SEPARATOR
                        + "B. 돌아가기" + LINE_SEPARATOR
        );
    }

    public void registerSectionLine() {
        System.out.println(LINE_SEPARATOR + "## 노선을 입력하세요.");
    }

    public void registerSectionStation() {
        System.out.println(LINE_SEPARATOR + "## 역이름을 입력하세요.");
    }

    public void registerSectionOrder() {
        System.out.println(LINE_SEPARATOR + "## 순서를 입력하세요.");
    }

    public void successRegisterSection() {
        System.out.println(LINE_SEPARATOR + "구간이 등록되었습니다.");
    }

    public void deleteSectionLine() {
        System.out.println(LINE_SEPARATOR + "## 삭제할 구간의 노선을 입력하세요.");
    }

    public void deleteSectionStation() {
        System.out.println(LINE_SEPARATOR + "## 삭제할 구간의 역을 입력하세요.");
    }

    public void successDeleteSection() {
        System.out.println(LINE_SEPARATOR + "구간이 삭제되었습니다.");
    }

    public void showLineStations(LineStation lineStations) {
        System.out.println(
                LINE_SEPARATOR +
                "## 지하철 노선도" + LINE_SEPARATOR
                + lineStations.getLine().getName() + LINE_SEPARATOR
                + "---" + LINE_SEPARATOR
        );

        for(Station station : lineStations.getStations()) {
            System.out.println(station.getName());
        }
    }
}

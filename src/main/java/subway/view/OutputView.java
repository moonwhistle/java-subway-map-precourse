package subway.view;

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
}

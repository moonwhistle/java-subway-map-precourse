package subway.view;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void mainGuide() {
        System.out.println(
                "## 메인 화면" + LINE_SEPARATOR
                + "1. 역 관리" + LINE_SEPARATOR
                + "2. 노선 관리" + LINE_SEPARATOR
                + "3. 구간 관리" +  LINE_SEPARATOR
                + "4. 지하철 노선도 출력" + LINE_SEPARATOR
                + "Q. 종료" + LINE_SEPARATOR
        );
    }
}

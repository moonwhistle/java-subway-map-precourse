package subway.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public String registerStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String deleteStation() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String registerLine() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String registerLineUpStation() {
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String registerLineDownStation() {
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String deleteLine() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }
}

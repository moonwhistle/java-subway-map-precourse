package subway.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getCommand() {
        return scanner.nextLine();
    }

    public String getStationName() {
        return scanner.nextLine();
    }
}

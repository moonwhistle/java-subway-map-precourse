package subway;

import java.util.Scanner;
import subway.controller.MainController;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        final OutputView outputView = new OutputView();
        final MainController mainController = new MainController(inputView, outputView);
        mainController.run();
    }
}

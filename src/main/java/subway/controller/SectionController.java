package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {

    private final InputView inputView;
    private final OutputView outputView;

    public SectionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}

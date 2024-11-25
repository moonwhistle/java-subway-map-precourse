package subway.controller;

import subway.domain.setting.LineInitializer;
import subway.domain.setting.LineStationInitializer;
import subway.domain.setting.StationInitializer;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initSetting();


    }

    private void initSetting() {
        StationInitializer.initStation();
        LineInitializer.initLine();
        LineStationInitializer.initLineStation();
    }
}

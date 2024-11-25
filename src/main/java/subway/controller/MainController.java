package subway.controller;

import subway.domain.setting.LineInitializer;
import subway.domain.setting.LineStationInitializer;
import subway.domain.setting.StationInitializer;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputController inputController;
    private final StationController stationController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputController = new InputController(inputView, outputView);
        this.stationController = new StationController(inputView, outputView);
    }

    public void run() {
        initSetting();

        while(true) {
            outputView.guideMainSystem();
            runByCommand(inputController.getCommand());
        }
    }

    private void runByCommand(String command) {
        if(command.equals("1")) {
            stationController.run();
        }
    }

    private void initSetting() {
        StationInitializer.initStation();
        LineInitializer.initLine();
        LineStationInitializer.initLineStation();
    }
}

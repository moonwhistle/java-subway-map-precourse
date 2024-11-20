package subway.controller;

import subway.domain.setting.LineInitializer;
import subway.domain.setting.LineStationInitializer;
import subway.domain.setting.StationInitializer;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StationController stationController;
    private final LineController lineController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stationController = new StationController(inputView, outputView);
        this.lineController = new LineController(inputView, outputView);
    }


    public void run() {
        initSetting();
        while(true) {
            String command = getCommand();
            runByCommand(command);
        }
    }

    private void runByCommand(String command) {
        if(command.equals("1")) {
            stationController.run();
        }
        if(command.equals("2")) {
            lineController.run();
        }
    }

    private String getCommand() {
        outputView.mainGuide();
        return inputView.getCommand();
    }

    private void initSetting() {
        LineInitializer.initLine();
        LineStationInitializer.initLineStations();
        StationInitializer.initStation();
    }
}

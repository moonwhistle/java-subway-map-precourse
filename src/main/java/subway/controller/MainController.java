package subway.controller;

import subway.domain.setting.LineInitializer;
import subway.domain.setting.LineStationInitializer;
import subway.domain.setting.StationInitializer;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private final OutputView outputView;
    private final InputController inputController;
    private final StationController stationController;
    private final LineController lineController;
    private final SectionController sectionController;

    public MainController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputController = new InputController(inputView, outputView);
        this.stationController = new StationController(inputView, outputView);
        this.lineController = new LineController(inputView, outputView);
        this.sectionController = new SectionController(inputView, outputView);
    }

    public void run() {
        initSetting();
        boolean runByCommand = true;
        while(runByCommand) {
            outputView.guideMainSystem();
            runByCommand = runByCommand(inputController.getCommand());
        }
    }

    private boolean runByCommand(String command) {
        if(command.equals("1")) {
            stationController.run();
            return true;
        }
        if(command.equals("2")) {
            lineController.run();
            return true;
        }
        if(command.equals("3")) {
            sectionController.run();
            return true;
        }
        return false;
    }

    private void initSetting() {
        StationInitializer.initStation();
        LineInitializer.initLine();
        LineStationInitializer.initLineStation();
    }
}

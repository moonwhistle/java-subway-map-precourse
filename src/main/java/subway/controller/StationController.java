package subway.controller;

import subway.domain.vo.Station;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputController inputController;

    public StationController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputController = new InputController(inputView, outputView);
    }

    public void run() {
        outputView.guideStationSystem();
        runByCommand(inputController.getCommand());
    }

    private void runByCommand(String command) {
        if(command.equals("1")) {
            registerStation();
        }
    }

    private void registerStation() {
        StationRepository.addStation(getStation());
        outputView.successRegisterStation();
    }

    private Station getStation() {
        outputView.registerStation();
        while(true) {
            Station station = inputController.getStation();
            if(!StationRepository.hasDuplicatedStation(station.getName())) {
                return station;
            }
            outputView.printError("\n이미 등록되어 있는 역입니다.");
        }
    }
}

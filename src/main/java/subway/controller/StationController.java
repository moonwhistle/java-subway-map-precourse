package subway.controller;

import subway.domain.vo.Station;
import subway.repository.LineStationRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private final OutputView outputView;
    private final InputController inputController;

    public StationController(InputView inputView, OutputView outputView) {
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
        if(command.equals("2")) {
            deleteStation();
        }
        if(command.equals("3")) {
            showStations();
        }
    }

    private void registerStation() {
        StationRepository.addStation(getRegisterStation());
        outputView.successRegisterStation();
    }

    private Station getRegisterStation() {
        outputView.registerStation();
        while(true) {
            Station station = inputController.getStation();
            if(!StationRepository.hasDuplicatedStation(station)) {
                return station;
            }
            outputView.printError("\n이미 등록되어 있는 역입니다.");
        }
    }

    private void deleteStation() {
        if(StationRepository.deleteStation(getDeleteStation().getName())){
            outputView.successDeleteStation();
        }
    }

    private Station getDeleteStation() {
        outputView.deleteStation();
        while(true) {
            Station station = inputController.getStation();
            if(!StationRepository.hasDuplicatedStation(station)) {
                outputView.printError("\n등록되지 않은 역입니다.");
            }
            if(LineStationRepository.hasLineStation(station)) {
                outputView.printError("\n노선에 등록되어 있는 역입니다.");
            }
            if(!LineStationRepository.hasLineStation(station) && StationRepository.hasDuplicatedStation(station)) {
                return station;
            }
        }
    }

    private void showStations() {
        outputView.showStations(StationRepository.stations());
    }
}

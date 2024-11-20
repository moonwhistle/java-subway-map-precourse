package subway.controller;

import subway.repository.LineStationRepository;
import subway.domain.vo.Station;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private final InputView inputView;
    private final OutputView outputView;

    public StationController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String command = getCommand();
        runByCommand(command);
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

    private String getCommand() {
        outputView.stationGuide();
        return inputView.getCommand();
    }

    private void registerStation() {
        Station station = new Station(inputView.registerStation());
        StationRepository.addStation(station);
    }

    private void deleteStation() {
        String stationName = inputView.deleteStation();
        LineStationRepository.checkAlreadyResisterStation(stationName);

        if(!StationRepository.deleteStation(stationName)){
            throw new IllegalArgumentException("존재하지 않는 역 입니다.");
        }
    }

    private void showStations() {
        outputView.showStations(StationRepository.stations());
    }
}

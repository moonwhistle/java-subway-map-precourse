package subway.controller;

import subway.domain.LineStation;
import subway.domain.LineStations;
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

    }

    public String getCommand() {
        outputView.stationGuide();
        return inputView.getCommand();
    }

    public void registerStation() {
        Station station = new Station(inputView.registerStation());
        StationRepository.addStation(station);
    }

    public void deleteStation(LineStations lineStations) {
        String stationName = inputView.deleteStation();
        lineStations.checkAlreadyResisterStation(stationName);
        StationRepository.deleteStation(stationName);
    }
}

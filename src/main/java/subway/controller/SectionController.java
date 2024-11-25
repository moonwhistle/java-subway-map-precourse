package subway.controller;

import java.util.List;
import subway.domain.LineStation;
import subway.domain.vo.Line;
import subway.domain.vo.Station;
import subway.repository.LineRepository;
import subway.repository.LineStationRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {

    private final OutputView outputView;
    private final InputController inputController;

    public SectionController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputController = new InputController(inputView, outputView);
    }

    public void run() {
        outputView.guideSectionSystem();
        runByCommand(inputController.getCommand());
    }

    private void runByCommand(String command) {
        if(command.equals("1")){
            registerSection();
        }
    }

    private void registerSection() {
        Line line =  getRegisterSectionLine();
        LineStation lineStation = LineStationRepository.getLineStation(line);
        Station station = getRegisterSectionStation(lineStation);
        int order = getRegisterSectionOrder(lineStation.getStations());
        lineStation.addStation(station, order);
    }

    private Line getRegisterSectionLine() {
        outputView.registerSectionLine();
        while(true) {
            Line line = inputController.getLine();
            if(LineRepository.hasDuplicatedLine(line)) {
                return line;
            }
            outputView.printError("존재하지 않는 노선입니다.");
        }
    }

    private Station getRegisterSectionStation(LineStation lineStation) {
        outputView.registerSectionStation();
        while(true) {
            Station station = inputController.getStation();
            if(!StationRepository.hasDuplicatedStation(station)){
                outputView.printError("존재하지 않는 역입니다.");
            }
            if(lineStation.getStations().contains(station)) {
                outputView.printError("이미 등록되어 있는 역입니다.");
            }
            if(StationRepository.hasDuplicatedStation(station) && !lineStation.getStations().contains(station)) {
                return station;
            }
        }
    }

    private int getRegisterSectionOrder(List<Station> stations) {
        outputView.registerSectionOrder();
        return inputController.getOrder(stations);
    }
}

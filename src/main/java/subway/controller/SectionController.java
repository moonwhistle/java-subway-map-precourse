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
        if(command.equals("2")){
            deleteSection();
        }
    }

    private void deleteSection() {
        Line line = getDeleteSectionLine();
        LineStation lineStation = LineStationRepository.getLineStation(line);
        if(lineStation.getStations().size() > 2) {
            Station station = getDeleteSectionStation(lineStation);
            lineStation.removeStation(station);
            outputView.successDeleteSection();
        }
        outputView.printError("구간의 길이가 2 이하입니다.");
    }

    private Line getDeleteSectionLine() {
        outputView.deleteSectionLine();
        return getSectionLine();
    }

    private Station getDeleteSectionStation(LineStation lineStation) {
        outputView.deleteSectionStation();
        while(true) {
            Station station = inputController.getStation();
            if(lineStation.getStations().contains(station)) {
                return station;
            }
            outputView.printError("역 존재 X");
        }
    }

    private void registerSection() {
        Line line =  getRegisterSectionLine();
        LineStation lineStation = LineStationRepository.getLineStation(line);
        Station station = getRegisterSectionStation(lineStation);
        int order = getRegisterSectionOrder(lineStation.getStations());
        lineStation.addStation(station, order);
        outputView.successRegisterSection();
    }

    private Line getRegisterSectionLine() {
        outputView.registerSectionLine();
        return getSectionLine();
    }

    private Line getSectionLine() {
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

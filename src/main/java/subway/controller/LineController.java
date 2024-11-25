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

public class LineController {

    private final OutputView outputView;
    private final InputController inputController;

    public LineController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputController = new InputController(inputView, outputView);
    }

    public void run() {
        outputView.guideLineSystem();
        runByCommand(inputController.getCommand());
    }

    private void runByCommand(String command) {
        if (command.equals("1")) {
            registerLineStation();
        }
        if (command.equals("2")) {
            deleteLineStation();
        }
    }

    private void deleteLineStation() {
        Line line = getDeleteLine();
        if(LineRepository.deleteLineByName(line.getName())) {
            LineStationRepository.deleteLineStation(line);
            outputView.successDeleteLine();
        }
    }

    private Line getDeleteLine() {
        outputView.deleteLine();
        while (true) {
            Line line = inputController.getLine();
            if (LineRepository.hasDuplicatedLine(line)) {
                return line;
            }
            outputView.printError("등록된 노선이 없습니다.");
        }
    }

    private void registerLineStation() {
        Line line = getRegisterLine();
        List<Station> stations = List.of(
                getUpStation(),
                getDownStation()
        );
        LineStation lineStation = new LineStation(line, stations);
        LineStationRepository.addLineStation(lineStation);
        outputView.successRegisterLine();
    }

    private Line getRegisterLine() {
        outputView.registerLine();
        while (true) {
            Line line = inputController.getLine();
            if (!LineRepository.hasDuplicatedLine(line)) {
                return line;
            }
            outputView.printError("\n이미 등록되어 있는 노선입니다.");
        }
    }

    private Station getUpStation() {
        outputView.registerLineUpStation();
        return getStation();
    }

    private Station getDownStation() {
        outputView.registerLineDownStation();
        return getStation();
    }

    private Station getStation() {
        while (true) {
            Station station = inputController.getStation();
            if (StationRepository.hasDuplicatedStation(station)) {
                return station;
            }
            outputView.printError("\n등록된 역이 없습니다.");
        }
    }
}

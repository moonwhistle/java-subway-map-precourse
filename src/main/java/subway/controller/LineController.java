package subway.controller;

import java.util.List;
import subway.domain.LineStation;
import subway.domain.vo.Line;
import subway.domain.vo.Station;
import subway.repository.LineRepository;
import subway.repository.LineStationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    private final InputView inputView;
    private final OutputView outputView;

    public LineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String command = getCommand();
        runByCommand(command);
    }

    private void runByCommand(String command) {
        if(command.equals("1")) {
            registerLine();
        }
        if(command.equals("2")) {
            deleteLine();
        }
    }

    private String getCommand() {
        outputView.lineGuide();
        return inputView.getCommand();
    }

    private void registerLine() {
        Line line = new Line(inputView.registerLine());
        LineRepository.addLine(line);
        makeLineStation(line);
        outputView.successLineRegister();
    }

    private void makeLineStation(Line line) {
        List<Station> stations = List.of(
                new Station(inputView.registerLineUpStation()),
                new Station(inputView.registerLineDownStation())
        );
        LineStationRepository.addLineStation(new LineStation(line, stations));
    }

    private void deleteLine() {
        String lineName = inputView.deleteLine();
        removeLine(lineName);
        outputView.successLineDelete();
    }

    private void removeLine(String lineName) {
        if(!LineRepository.deleteLineByName(lineName)){
            throw new IllegalArgumentException("등록된 노선이 없습니다.");
        }
        LineStationRepository.deleteLineStation(lineName);
    }
}

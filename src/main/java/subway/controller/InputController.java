package subway.controller;

import subway.domain.command.Command;
import subway.domain.vo.Line;
import subway.domain.vo.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;


    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getCommand() {
        outputView.getCommand();
        while(true) {
            try {
                return Command.getCommandByInputCommand(inputView.getCommand());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    public Station getStation() {
        while(true) {
            try {
                return new Station(inputView.getStationName());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    public Line getLine() {
        while(true) {
            try {
                return new Line(inputView.getLineName());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}

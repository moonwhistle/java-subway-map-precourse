package subway.domain.command;

public enum Command {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    BACK("B"),
    END("Q");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static String getCommandByInputCommand(String inputCommand) {
        for(Command command : Command.values()) {
            if(command.command.equals(inputCommand)) {
                return command.command;
            }
        }
        throw new IllegalArgumentException("올바른 커맨드를 입력해주세요");
    }
}

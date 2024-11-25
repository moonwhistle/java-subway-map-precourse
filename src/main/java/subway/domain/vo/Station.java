package subway.domain.vo;

public class Station {
    private final String name;

    public Station(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private void validateNameLength(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("지하철 역 이름은 2글자 이상이어야 한다.");
        }
    }
}

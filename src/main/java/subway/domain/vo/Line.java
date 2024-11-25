package subway.domain.vo;

import java.util.Objects;

public class Line {
    private final String name;

    public Line(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Line line = (Line) obj;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    private void validateNameLength(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("노선 이름은 2글자 이상이어야 한다.");
        }
    }
}

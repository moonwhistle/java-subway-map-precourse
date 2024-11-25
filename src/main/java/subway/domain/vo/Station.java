package subway.domain.vo;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Station station = (Station) obj;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    private void validateNameLength(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("지하철 역 이름은 2글자 이상이어야 한다.");
        }
    }
}

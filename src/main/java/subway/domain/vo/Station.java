package subway.domain.vo;

import java.util.Objects;

public class Station {
    private final String name;

    public Station(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

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

    private void validateName(String name) {
        if(name.length() < 3) {
            throw new IllegalArgumentException("지하철 노선 이름은 2글자 이상이어야 한다.");
        }
    }
}

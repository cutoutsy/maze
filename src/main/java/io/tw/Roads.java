package io.tw;


import java.util.Set;

public class Roads {
    private final Set<Position> roads;

    Roads(Set<Position> roads) {
        this.roads = roads;
    }

    Set<Position> getRoads() {
        return roads;
    }
}

package io.tw;

import java.util.*;

public class Maze {

    public static final String ROAD = "[R]";
    public static final String WALL = "[W]";

    private final int row;
    private final int column;
    public Roads roads;

    Maze(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isValidPosition(Position position) {
        return position.x < row && position.y < column &&
               position.x >= 0 && position.y >= 0;
    }

    boolean isConnect(Position p1, Position p2) {
        return (p1.x == p2.x && Math.abs(p1.y - p2.y) == 1) ||
                (p1.y == p2.y && Math.abs(p1.x - p2.x) == 1);
    }

    public String check(Position[] positions) {
        for (int i = 0; i < positions.length; i += 2) {
            if (!isValidPosition(positions[i]) || !isValidPosition(positions[i+1])) {
                return "Number out of range.";
            }
            if (!isConnect(positions[i], positions[i+1])) {
                return "Maze format error.";
            }
        }
        return null;
    }

    void create(Position[] positions) {
        final Set<Position> positionAsRoad = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                positionAsRoad.add(Position.of(2 * i + 1, 2 * j + 1));
            }
        }
        for (int i = 0; i < positions.length; i = i + 2) {
            Position tmp1 = positions[i];
            Position tmp2 = positions[i+1];
//            positionAsRoad.add(Position.of(2 * tmp1.x + 1, 2 * tmp1.y + 1));
//            positionAsRoad.add(Position.of(2 * tmp2.x + 1, 2 * tmp2.y + 1));
            positionAsRoad.add(Position.of(tmp1.x + tmp2.x + 1, tmp1.y + tmp2.y + 1));
        }
        this.roads = new Roads(positionAsRoad);
    }

    private String[][] createScreenMatrix() {
        final  String[][] screen = new String[2*row + 1][2*column + 1];
        for (String[] line : screen) {
            Arrays.fill(line, WALL);
        }
        for (Position p : roads.getRoads()) {
            screen[p.x][p.y] = ROAD;
        }
        return screen;
    }

    String render() {
        List<String> lines = new LinkedList<>();
        final String[][] screen = createScreenMatrix();
        for (String[] line : screen) {
            lines.add(String.join(" ", line));
        }
        return String.join("\n", lines);
    }
}

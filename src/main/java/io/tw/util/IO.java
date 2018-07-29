package io.tw.util;


import io.tw.Position;
import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.List;

public class IO {
    public static Position[] scanPositions(String input) {
        final List<Position> positions = new LinkedList<>();
        String[] connects = input.split(";");
        try {
            for (String ele : connects) {
                String[] temp = ele.split(" ");
                int x1 = Integer.valueOf(temp[0].split(",")[0]);
                int y1 = Integer.valueOf(temp[0].split(",")[1]);
                int x2 = Integer.valueOf(temp[1].split(",")[0]);
                int y2 = Integer.valueOf(temp[1].split(",")[1]);
                positions.add(Position.of(x1, y1));
                positions.add(Position.of(x2, y2));
            }
        } catch (Exception e) {
            System.out.println("Number out of range.");
            return null;
        }

        Position[] initialPositions = new Position[positions.size()];

        return positions.toArray(initialPositions);
    }
}

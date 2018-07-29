package io.tw;


import io.tw.util.IO;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> command = new ArrayList<String>();
        String command1 = sc.nextLine();
        String command2 = sc.nextLine();
        if (!checkCmd1(command1) || !checkCmd2(command2)) {
            System.out.println("Incorrect command format");
            return;
        }
        final int row;
        final int column;
        try {
            row = Integer.valueOf(command1.split(" ")[0]);
            column = Integer.valueOf(command1.split(" ")[1]);
        } catch (Exception e) {
            System.out.println("Number out of range");
            return;
        }
        Position[] positions = IO.scanPositions(command2);
        if (positions == null) {
            return;
        }

        Maze maze = new Maze(row, column);
        if (maze.check(positions) != null) {
            System.out.println(maze.check(positions));
            return;
        }
        maze.create(positions);
        String mazeText = maze.render();
        System.out.println(mazeText);
    }

    public static boolean checkCmd1(String str) {
        String cmdFormat = "^\\d+\\s\\d+$";
        Pattern p = Pattern.compile(cmdFormat);
        Matcher m = p.matcher(str);
        if (m.matches()) {
            return true;
        }
        return false;
    }

    public static boolean checkCmd2(String str) {
        String cmdFormat = "(\\d+,\\d+\\s\\d+,\\d+;)*(\\d+,\\d+\\s\\d+,\\d+)$";
        Pattern p = Pattern.compile(cmdFormat);
        Matcher m = p.matcher(str);
        if (m.matches()) {
            return true;
        }
        return false;
    }
}

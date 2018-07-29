package io.tw;


import javafx.geometry.Pos;
import junit.framework.TestCase;

public class MazeTest extends TestCase{

    public void testIsValidPosition() {
        Maze maze = new Maze(9, 9);

        assertFalse(maze.isValidPosition(Position.of(9, 9)));
        assertFalse(maze.isValidPosition(Position.of(10, 9)));
        assertFalse(maze.isValidPosition(Position.of(-1, 9)));
        assertTrue(maze.isValidPosition(Position.of(0, 7)));
        assertTrue(maze.isValidPosition(Position.of(2, 3)));
    }

    public void testIsConnect() {
        Maze maze = new Maze(9, 9);
        assertTrue(maze.isConnect(Position.of(0, 1), Position.of(0, 2)));
        assertFalse(maze.isConnect(Position.of(0, 1), Position.of(0, 3)));
        assertFalse(maze.isConnect(Position.of(0, 2), Position.of(1, 1)));
    }


    public void testCheck() {
        Maze maze = new Maze(9, 9);
        assertEquals("Number out of range.", maze.check(new Position[] {Position.of(1, 9), Position.of(1, 8)}));
        assertEquals("Maze format error.", maze.check(new Position[] {Position.of(1, 2), Position.of(2, 1)}));
        assertEquals(null, maze.check(new Position[] {Position.of(1, 2), Position.of(1, 3)}));
    }

    public void testCreate() {
        Maze maze = new Maze(3, 3);
        Position[] pos = {Position.of(0, 1), Position.of(0, 2), Position.of(0, 0), Position.of(1, 0)};
        maze.create(pos);
        assertTrue(maze.roads.getRoads().contains(Position.of(1, 4)));
        assertTrue(maze.roads.getRoads().contains(Position.of(2, 1)));
        assertFalse(maze.roads.getRoads().contains(Position.of(2, 2)));
    }


    public void testRender() {
        Maze maze = new Maze(2, 2);
        Position[] pos = {Position.of(0, 0), Position.of(1, 0)};
        maze.create(pos);
        final String lines = maze.render();
        final String result =
                "[W] [W] [W] [W] [W]\n"+
                "[W] [R] [W] [R] [W]\n"+
                "[W] [R] [W] [W] [W]\n"+
                "[W] [R] [W] [R] [W]\n"+
                "[W] [W] [W] [W] [W]";
        assertEquals(result, lines);
    }

}

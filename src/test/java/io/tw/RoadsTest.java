package io.tw;


import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class RoadsTest extends TestCase{

    public void testGetRoads() {
        final Set<Position> initialStates = new HashSet<>();
        initialStates.add(Position.of(1, 2));
        initialStates.add(Position.of(10, 20));

        final Roads roads = new Roads(initialStates);

        assertTrue(roads.getRoads().contains(Position.of(1, 2)));
        assertFalse(roads.getRoads().contains(Position.of(2, 1)));
    }

}

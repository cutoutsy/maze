package io.tw.util;

import io.tw.Position;
import junit.framework.TestCase;

public class IOTest extends TestCase{

    public void testScanPositions() {
        final String input =  "0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1";
        final Position[] positions = IO.scanPositions(input);
        assertEquals(18, positions.length);
        assertEquals(Position.of(0, 1), positions[0]);
        assertEquals(Position.of(0, 0), positions[2]);
        assertEquals(Position.of(2, 1), positions[17]);
    }

}

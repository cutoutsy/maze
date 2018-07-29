package io.tw;


import junit.framework.TestCase;

public class AppTest extends TestCase{

    public void testCheckCmd1() {
        String cmd1 = "3 3";
        String cmd2 = "3 3j";
        String cmd3 = "3";
        assertEquals(true, App.checkCmd1(cmd1));
        assertEquals(false, App.checkCmd1(cmd2));
        assertEquals(false, App.checkCmd1(cmd3));
    }


    public void testCheckCmd2() {
        String cmd1 = "0,1 0,2;0,0 1,0;0,1 1,1";
        String cmd2 = "0,10,2;0,0 1,0;0,1 1,1";
        String cmd3 = "0,1 0;7;0,0 1,0;0,1 1,1";
        assertEquals(true, App.checkCmd2(cmd1));
        assertEquals(false, App.checkCmd2(cmd2));
        assertEquals(false, App.checkCmd2(cmd3));
    }

}

package com.course.testng.mouse;

import java.awt.*;
import java.awt.event.InputEvent;

public class AutoMousePress {
    public static void main(String[] args) throws AWTException {
        try {
            int i=0;
            while(i<10) {
                Robot robot = new Robot();
                robot.delay(100);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.delay(100);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                ++i;
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaremotedestop;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER
 */
public class ClickMouse implements RobotAction {

    private final int mouseButton;
    private final int clicks;

    public ClickMouse(int mouseButton, int clicks) {
        this.mouseButton = mouseButton;
        this.clicks = clicks;
    }

    public ClickMouse(MouseEvent event) {
        this(event.getButton(), event.getClickCount());
    }

    public Object execute(Robot robot) {
        for (int i = 0; i < clicks; i++) {
            robot.mousePress(mouseButton);
            robot.mouseRelease(mouseButton);
        }
        return null;
    }

    public String toString() {
        return "ClickMouse: " + mouseButton + ", " + clicks;
    }
}

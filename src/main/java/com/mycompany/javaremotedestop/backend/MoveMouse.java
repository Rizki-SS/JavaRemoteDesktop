/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaremotedestop.backend;

/**
 *
 * @author ACER
 */
import static com.mycompany.javaremotedestop.SETUP.SKALA;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveMouse implements RobotAction {

    private final int x;
    private final int y;

    public MoveMouse(Point to) {
        x = (int) to.getX() * SKALA;
        y = (int) to.getY() * SKALA;
    }

    public MoveMouse(MouseEvent event) {
        this(event.getPoint());
    }

    @Override
    public Object execute(Robot robot) {
        robot.mouseMove(x, y);
        return null;
    }

    @Override
    public String toString() {
        return "MoveMouse: x=" + x + ", y=" + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

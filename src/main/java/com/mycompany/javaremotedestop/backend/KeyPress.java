/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaremotedestop.backend;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *
 * @author ACER
 */
public class KeyPress implements RobotAction{

    private final int keyCode;
    private final char key;

    public KeyPress(int keycode, char key) {
        this.keyCode = keycode;
        this.key = key;
    }
    
    public KeyPress(KeyEvent event){
        this(event.getKeyCode(), event.getKeyChar());
    }
    
    @Override
    public Object execute(Robot robot){
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
        return null;
    }

    @Override
    public String toString() {
        return "Key press : " + keyCode;
    }
}

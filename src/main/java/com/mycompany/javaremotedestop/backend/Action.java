/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaremotedestop.backend;

import java.awt.Robot;
import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class Action implements Serializable {

    private MoveMouse mm;
    private ClickMouse cm;
    private KeyPress kp;

    public Action(MoveMouse mm, ClickMouse cm, KeyPress kp) {
        this.mm = mm;
        this.cm = cm;
        this.kp = kp;
    }

    public MoveMouse getMm() {
        return mm;
    }

    public ClickMouse getCm() {
        return cm;
    }

    public KeyPress getKp() {
        return kp;
    }

    public void execute(Robot robot) {
        if (mm != null) {
            mm.execute(robot);
//                    System.out.println(paket.getMm().toString());
        }
        if (cm != null) {
            cm.execute(robot);
//                    System.out.println(paket.getCm().toString());
        }
        if (kp != null) {
            kp.execute(robot);
//                    System.out.println(paket.getKp().toString());
        }
    }
}

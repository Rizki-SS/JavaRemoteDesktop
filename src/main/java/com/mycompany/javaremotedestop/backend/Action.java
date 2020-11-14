/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaremotedestop.backend;

import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class Action implements Serializable{
    private MoveMouse mm;
    private ClickMouse cm;

    public Action(MoveMouse mm, ClickMouse cm) {
        this.mm = mm;
        this.cm = cm;
    }

    public MoveMouse getMm() {
        return mm;
    }

    public ClickMouse getCm() {
        return cm;
    }
}

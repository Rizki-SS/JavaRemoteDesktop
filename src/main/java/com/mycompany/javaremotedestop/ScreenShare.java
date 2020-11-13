/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaremotedestop;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class ScreenShare implements Serializable{
    BufferedImage image;
    int screenX, screenY;

    public ScreenShare(BufferedImage image, int screenX, int screenY) {
        this.image = image;
        this.screenX = screenX;
        this.screenY = screenY;
    }

    ScreenShare(BufferedImage image, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }
}

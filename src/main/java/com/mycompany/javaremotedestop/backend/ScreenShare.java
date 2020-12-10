/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaremotedestop.backend;

import static com.mycompany.javaremotedestop.SETUP.SKALA;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class ScreenShare{

    public BufferedImage takeScreen(Robot robot) {
        BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        BufferedImage newImg = new BufferedImage(image.getWidth() / SKALA, image.getHeight() / SKALA, BufferedImage.TYPE_INT_RGB);
        Graphics g = newImg.createGraphics();
        g.drawImage(image, 0, 0, image.getWidth() / SKALA, image.getHeight() / SKALA, null);
        g.dispose();
        return newImg;
    }
}

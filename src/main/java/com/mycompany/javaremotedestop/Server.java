/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaremotedestop;

import com.mycompany.javaremotedestop.backend.Action;
import static com.mycompany.javaremotedestop.SETUP.*;
import com.mycompany.javaremotedestop.backend.ScreenShare;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import javax.imageio.ImageIO;

/**
 *
 * @author ACER
 */
public class Server {

    static Robot robot;
    static private ScreenShare ss = new ScreenShare();

    public static void main(String[] args) {
        sendPaket.start();

        try {
            byte[] dataMsg = new byte[65555];
            DatagramPacket dp = new DatagramPacket(dataMsg, dataMsg.length);
            DatagramSocket ds = new DatagramSocket(1111);
            robot = new Robot();
            while (true) {
                ds.receive(dp);
                ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(dataMsg));
                Action paket = (Action) ois.readObject();
                paket.execute(robot);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static Thread sendPaket = new Thread() {
        public void run() {
            while (true) {
                try {
                    
//            ImageIO.write(newImg, "jpg", new File("D://sad.jpg"));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(ss.takeScreen(robot), "jpg", baos);
                    byte[] bs = baos.toByteArray();

                    //send action datas
                    DatagramPacket dp = new DatagramPacket(
                            bs, bs.length, new InetSocketAddress(IPCLIENT, CLIENT_PORT));
                    DatagramSocket ds = new DatagramSocket();
                    ds.send(dp);
//                    System.out.println("send");
                    sleep(100);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    };

}

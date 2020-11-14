/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaremotedestop;

import com.mycompany.javaremotedestop.Action;
import static com.mycompany.javaremotedestop.SETUP.*;
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
                if (paket.getMm() != null) {
                    //menjalankan perintah
                    paket.getMm().execute(robot);
//                    System.out.println(paket.getMm().toString());
                }
                if (paket.getCm() != null) {
                    //menjalankan perintah
                    paket.getCm().execute(robot);
//                    System.out.println(paket.getCm().toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static Thread sendPaket = new Thread() {
        public void run() {
            while (true) {
                try {
                    BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                    BufferedImage newImg = new BufferedImage(image.getWidth() / SKALA, image.getHeight() / SKALA, BufferedImage.TYPE_INT_RGB);
                    Graphics g = newImg.createGraphics();
                    g.drawImage(image, 0, 0, image.getWidth() / SKALA, image.getHeight() / SKALA, null);
                    g.dispose();
//            ImageIO.write(newImg, "jpg", new File("D://sad.jpg"));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(newImg, "jpg", baos);
                    byte[] bs = baos.toByteArray();

                    //send action datas
                    DatagramPacket dp = new DatagramPacket(
                            bs, bs.length, new InetSocketAddress(IPCLIENT, CLIENT_PORT));
                    DatagramSocket ds = new DatagramSocket();
                    ds.send(dp);
                    System.out.println("send");
                    sleep(100);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    };

}

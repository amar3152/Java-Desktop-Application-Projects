package com.digitalClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame
{
    private  JLabel heading;

    private  JLabel clockLabel;

    private Font font = new Font("",Font.BOLD,35);
    MyWindow(){
        super.setTitle("Digital Clock");
        super.setSize(400,400);
        super.setLocation(300,50);
        this.createGUI();
        this.startClock();
        super.setVisible(true);
    }

    public void createGUI(){
        //Creating GUI Of Clock

        heading = new JLabel("My Clock");

        clockLabel = new JLabel("Clock");

        //Adding Font in GUI Label
        heading.setFont(font);
        clockLabel.setFont(font);

        // Adding Layout To GUI
        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);

    }

    public void startClock(){
//        Timer timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Print Date and Timer
//                //String dateTime = new Date().toString();
//
//                // Print Date and Time IN AM and PM Format
//                //String dateTime = new Date().toLocaleString();
//
//
//            }
//        });
//        timer.start();

        Thread thread = new Thread(){
            public void run(){
                try {
                    while (true) {
                        // Print Time and Date in Simple Format
                        Date date = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
                        String dateTime = simpleDateFormat.format(date);
                        clockLabel.setText(dateTime);
                        // Thread.sleep(1000);
                        Thread.currentThread().sleep(1000);
                    }
                }catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };
        thread.start();
    }
}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Main {

    public static void main(String[] args) {
        mangosorbet(1);
    }

    public static int mangosorbet(int n) {
        int q;
        if (n > 2673) {
            q = 12000;
        } else {
            q= 6000;
        }
        while (q < 24000) {
            q++;
        }
        return 2*n*n*n;
    }

    /*public static void main(String[] args) throws Exception {
        //assert(false);
        //fail("hello");
        //assertTrue("af"=="he");
        String a = "ah";
        if(a!="afewev"){
            System.out.println("oh my gosh");
        }
        System.out.println("Hello World!");
    }*/

    /*public static void main(String[] args) throws Exception {
    *    boolean yippee = false;
    *    try{
    *        happy(yippee);
    *        System.out.println("You're happy!");
    *        System.exit(0);
    *        System.out.println("That's marvellous");
    *    }catch (Exception e){
    *        System.out.println("Sorry you are sad...");
    *        System.out.println("That's terrible! =(");
    *    }finally {
    *        System.out.println("Have a great day!");
    *    }
    *}
    *
    *public static void happy(boolean yippee) throws Exception {
    *    if(!yippee){
    *        throw new Exception("aww so sad");
    *    }
    *}*/

    /*for(String x = ""; !x.contains("XXX"); x+="X"){
            System.out.println("hooha");
    }*/

    /*public static boolean isPrime(int n){
        for(int i = 2; i<=Math.sqrt(n); i++) if(n%i==0) return false;
        return true;
    }*/


    /*
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        frame.getContentPane().add(panel);
        JButton startButton = new JButton("Start");
        panel.add(startButton);
        frame.setSize(new Dimension(1000,1000));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Menu");
        frame.setResizable(false);
    */
}

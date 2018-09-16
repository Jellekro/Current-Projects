package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    private static VennDiagram vennD;

    public static void main(String[] args) throws FileNotFoundException {
        start();
        exit();
    }

    public static void start() throws FileNotFoundException {
        System.out.println("Please enjoy my Venn Diagrammer app and remember you can type \"quit\" at any time to exit.\n");
        vennD = new VennDiagram();
    }

    public static void update(){

    }

    public static void exit(){
        //have option to save current venn diagram data to a file before exiting
        System.out.println("Thank you for using my Venn Diagrammer app!");
        System.exit(0);
    }
}
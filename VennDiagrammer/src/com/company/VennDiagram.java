package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VennDiagram extends Main {

    private Map<String, HashSet<String>> diagram = new TreeMap<>(); //each category is mapped to things that are in it
    private Map<String, HashSet<String>> inverse = new TreeMap<>(); //each thing is mapped to the categories it's in

    public VennDiagram() throws FileNotFoundException {
        readFile("Categories.txt");
        readFile("Things.txt");
        invert();
        Map<Integer, HashSet<String>> weight = weigh();
        /*
        * partially incorrect rn as this shows which things have same occurrence
        * it should actually differentiate between the count of things with the exact same occurrences vs same number of occurrences
        */
    }

    public Map<Integer, HashSet<String>> weigh(){ //weighs which thing is most common in descending order
        Map<Integer, HashSet<String>> count = new TreeMap<>();
        for(String thing: inverse.keySet()) {
            int size = inverse.get(thing).size()-1;
            if(!count.keySet().contains(size)) {
                count.put(size, new HashSet<>());
            }
            count.get(size).add(thing);
        }
        return count;
    }

    public boolean readFile(String fileName) throws FileNotFoundException {
        boolean valFile = false;
        File file = new File(fileName);
        if(file.exists()){
            Scanner read = new Scanner(file);
            if(read.hasNextLine()){
                read.nextLine(); //throwaway instruction line
                if(fileName.equals("Categories.txt")){
                    catsInput(fileName, read);
                }else if(fileName.equals("Things.txt")){
                    thingsInput(file);
                }
            }else{
                System.out.println("ERROR #: missing file instruction line.");
                System.out.print("Please copy and paste the following line into the \""+fileName+"\":\n> ");
                switch(fileName){
                    case "Categories.txt":
                        System.out.println("\"List your category descriptors here:\"");
                        break;
                    case "Things.txt":
                        System.out.println("\"List the things you want to categorize:\"");
                        break;
                }
            }
        }else{
            System.out.println("ERROR #: file does not exit.");
        }
        return valFile; //this will only turn true if the file was formatted properly
    }

    public void catsInput(String fileName, Scanner read){ //handles categories input process
        while(read.hasNextLine()){
            diagram.put(read.nextLine(), new HashSet<>());
        }
    }

    public void thingsInput(File file) throws FileNotFoundException { //handles thingss input process
        Scanner input = new Scanner(System.in);
        System.out.println("Please answer each question with \"yes\" or \"no\".");
        for(String descriptor: diagram.keySet()){
            Scanner reRead = new Scanner(file);
            reRead.nextLine();
            while(reRead.hasNextLine()){
                String currThing = reRead.nextLine();
                if(descriptor.equals("Things")){
                    diagram.get(descriptor).add(currThing);
                }else{
                    boolean valEntry = false;
                    while(!valEntry){
                        System.out.println("Is \""+currThing+"\" a fitting description of \""+descriptor+"\"?");
                        String entry = input.nextLine().trim();
                        valEntry = true;
                        if(entry.equals("quit")){
                            exit();
                        }else if(entry.equals("no")){
                        }else if(entry.equals("yes")){
                            diagram.get(descriptor).add(currThing);
                        }else{
                            valEntry = false;
                            System.out.println("ERROR #: invalid response to yes or no question.");
                        }
                    }
                }
            }
        }
    }

    public void invert() throws FileNotFoundException {
        for(String thing: diagram.get("Things")){
            inverse.put(thing, new HashSet<>());
        }
        for(String category: diagram.keySet()){
            for(String thing: inverse.keySet()){
                if(diagram.get(category).contains(thing)){
                    inverse.get(thing).add(category);
                }
            }
        }
    }

    public String toString(){
        String text = "";
        for(String category: diagram.keySet()){
            text += category+"\n";
            for(String thing: diagram.get(category)){
                text += "\t>"+thing+"\n";
            }
        }
        return text;
    }

    public String inverseToString(){
        String text = "";
        for(String thing: inverse.keySet()){
            text += thing+"\n";
            for(String category: inverse.get(thing)){
                text += "\t>"+category+"\n";
            }
        }
        return text;
    }

}
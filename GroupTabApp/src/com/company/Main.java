package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static Set<String> members; //TODO: make this set saved
    private static Set<String> payers;
    private static ArrayList<ArrayList<Integer>> owances; //describes who owes who what

    public static void main(String[] args) {
        members = new HashSet<>();
        payers = new HashSet<>();
        getPayers();
        System.out.println("Thanks for using the Group Tab App; please send any feedback to andyworthit@gmail.com!");
    }

    public static void getPayers(){
        do {
            tryForPlayer(getPayerName());
        } while (!tryForDone());
    }

    private static void tryForPlayer(String payerName) {
        if ((members.contains(payerName))) {
            payers.add(payerName);
        } else {
            System.out.println("This payer has not been previously processed by our system.");
            if (yesNoGetter("Did you mean to enter that name? (Yes/No)")) {
                members.add(payerName);
                payers.add(payerName);
            }
        }
    }

    private static boolean tryForDone(){
        if (!payers.isEmpty()){
            if (!yesNoGetter("Was there another payer?")) {
                return true;
            }
        } else {
            System.out.println("Try typing the name again.");
        }
        return false;
    }

    private static String getPayerName(){
        String temp;
        do {
            temp = textEntryChecker("Please enter the payer's name.");
        } while (temp == null);
        return temp;
    }

    private static boolean yesNoGetter(String prompt){
        while (true) {
            String response;
            do {
                response = textEntryChecker(prompt);
            } while (response == null);
            response = response.toLowerCase();
            if (response.equals("yes")) {
                return true;
            } else if (response.equals("no")) {
                return false;
            } else {
                System.out.println("Please enter a \"yes\" or \"no\" answer.");
            }
        }
    }

    private static String textEntryChecker(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        String entry = input.nextLine();
        if (entry.equalsIgnoreCase("quit")){
            System.exit(0);
        } else if (entry.trim().isEmpty()) {
            System.out.println("Your entry was blank, please try again.");
            return null;
        }
        return entry;
    }
}

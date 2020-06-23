package ca.cmpt213.a2.textui;

import java.util.Scanner;

public class screen {
    private static final String HEADER = " Start  ";
    private static final String HEADER1 = " Map Reveal  ";
    private static final String HEADER2 = " Illegal Move  ";
    private static final String HEADER3 = " Help Menu  ";
    private static final String HEADER4 = " Grabbing a power  ";
    private static final String HEADER5 = " Kill a monster  ";
    private static final String HEADER6 = " Getting killed/eaten by a monster  ";
    private static final String HEADER7 = " Cheat code  ";

    private static final String[] MENU = {"#: Wall", "@: You (a hero)", "!: Monster", "$: Power", ".: Unexplored space"};

    public static void main(String[] args) {
        int counter = 1;
        int demons = 3;
        int stayed = 3;
        int ability = 1;
        int taken = 0;
        boolean alreadyIn = true;

        String x;
        options menu = new options(HEADER, MENU);
        menu.displayTitle(counter);
        menu.displayMainMenu();
        //graph game = new graph();
        menu.displayOptions(demons, taken, stayed);
        String input = "";

        while (alreadyIn) {
            input = menu.getUserInput();
            switch (input) {
                case "m":
                    counter++;
                    options menu1 = new options(HEADER1, MENU);
                    menu1.displayTitle(counter);
                    graph game = new graph();
                    System.out.println();
                    //game.displayGraph();
                    menu1.displayOptions(demons, taken, stayed);
                    break;
                case "?":
                    counter++;
                    options menu2 = new options(HEADER3, MENU);
                    menu2.displayTitle(counter);
                    menu2.displayOptions(demons, taken, stayed);
                    break;
                case "c":
                    counter++;
                    options menu3 = new options(HEADER7, MENU);
                    menu3.displayTitle(counter);
                    menu3.displayOptions(demons, taken, stayed);
                    break;
                case "w":
                    moveUp();
                    break;
                case "a":
                    moveLeft();
                    break;
                case "s":
                    moveDown();
                    break;
                case "d":
                    moveRight();
                    break;
                case "q":
                    alreadyIn = false;
                    counter = 0;
                    break;
                default:
                    break;

            }

        }
    }

    private static void moveUp() {

    }

    private static void moveLeft() {

    }

    private static void moveDown() {

    }

    private static void moveRight() {

    }


}

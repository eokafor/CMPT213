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

    static graph game = new graph();
    static boolean alreadyIn = true;
    static int taken = 0;
    static int stayed = 3;
    static String input = "";
    public static void main(String[] args) {
        int counter = 1;
        int demons = 3;

        int ability = 1;



        String x;
        options menu = new options(HEADER, MENU);
        menu.displayTitle(counter);
        menu.displayMainMenu();
        game.newGraph();
        menu.displayOptions(demons, taken, stayed);


        while (alreadyIn) {
            input = menu.getUserInput();
            switch (input) {
                case "m":
                    counter++;
                    menu = new options(HEADER1, MENU);
                    menu.displayTitle(counter);
                    System.out.println();
                    game.displayGraph();
                    System.out.println();
                    menu.displayOptions(demons, taken, stayed);
                    break;
                case "?":
                    counter++;
                    menu = new options(HEADER3, MENU);
                    menu.displayTitle(counter);
                    menu.displayMainMenu();
                    menu.displayOptions(demons, taken, stayed);
                    break;
                case "c":
                    counter++;
                    menu = new options(HEADER7, MENU);
                    menu.displayTitle(counter);
                    menu.displayOptions(demons, taken, stayed);
                    break;
                case "w":
                    int a = 1;
                    moveUp(a);
                    break;
                case "a":
                    int b = 2;
                    moveLeft(b);
                    break;
                case "s":
                    int c = 3;
                    moveDown(c);
                    break;
                case "d":
                    int d = 4;
                    moveRight(d);
                    break;
                case "q":
                    end();
                    counter = 0;
                    break;
                default:
                    break;

            }

        }
    }

    private static void moveUp(int s) {
        int d = game.motion(s);
        if (d == 1){
            System.out.println("Invalid move: you cannot move through walls");

        }
        else if(d == 2)
        {
            if(taken == 0)
            {
                System.out.println("Im sorry, you've been eaten!");
                end();
            }
            else
            {
                taken--;
                stayed--;

            }

        }
        else if(d == 3)
        {
            taken++;
        }
    }

    private static void moveLeft(int q) {
        int d = game.motion(q);
        if (d == 1){
            System.out.println("Invalid move: you cannot move through walls");

        }
        else if(d == 2)
        {
            if(taken == 0)
            {
                System.out.println("Im sorry, you've been eaten!");
                end();
            }
            else
            {
                taken--;
                stayed--;

            }

        }
        else if(d == 3)
        {
            taken++;
        }
    }

    private static void moveDown(int v) {
        int d = game.motion(v);
        if (d == 1){
            System.out.println("Invalid move: you cannot move through walls");

        }
        else if(d == 2)
        {
            if(taken == 0)
            {
                System.out.println("Im sorry, you've been eaten!");
                end();
            }
            else
            {
                taken--;
                stayed--;

            }

        }
        else if(d == 3)
        {
            taken++;
        }
    }

    private static void moveRight(int o) {
        int d = game.motion(o);
        if (d == 1){
            System.out.println("Invalid move: you cannot move through walls");

        }
        else if(d == 2)
        {
            if(taken == 0)
            {
                System.out.println("Im sorry, you've been eaten!");
                end();
            }
            else
            {
                taken--;
                stayed--;

            }

        }
        else if(d == 3)
        {
            taken++;
        }
    }

    public static void end()
    {
        alreadyIn = false;
    }


}

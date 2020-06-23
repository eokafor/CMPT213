package ca.cmpt213.a2.textui;

import ca.cmpt213.a2.model.Cell;
import ca.cmpt213.a2.model.maze;

import java.util.Random;

public class graph {

    maze grid;
    int cols;
    int rows;
    Cell newCell;
    int w = 0;
    int h = 0;

    public graph() {

        grid = new maze();
        cols = grid.getNUM_COLS();
        rows = grid.getNUM_ROWS();

    }

    public void newGraph(){

        int num = 0;
        int p = 0;
        int l = 0;
        while(num != 1){
            p = generateX();
            l = generateY();
            boolean see = checkXY(p,l);
            if(see == false){
                num = 1;
            }
        }
        for(int x = 0; x < cols+2; x++){
            System.out.print("#\t");
        }
        System.out.println();

        for(int x = 0; x < rows; x++){
            System.out.print("#\t");
            for(int y = 0; y < cols; y++){
                newCell = grid.getCell(x,y);
                if((newCell.wall != true) && (x == 0) && (y == 0)){
                    System.out.print("@" + "\t");
                    //newCell.reveal = true;
                    newCell.hero = true;
                    w = x;
                    h = y;
                }
                else if ((x == 0) && (y == 12)){
                    System.out.print("!" + "\t");
                    //newCell.reveal = true;
                    newCell.monster = true;
                }
                else if ((x == 17) && (y == 0)){
                    System.out.print("!" + "\t");
                    //newCell.reveal = true;
                    newCell.monster = true;
                }
                else if ( (x == 17) && (y == 12)){
                    System.out.print("!" + "\t");
                    //newCell.reveal = true;
                    newCell.monster = true;
                }
                else if ((x == p) && (y == l) && (newCell.hero != true)){
                    if(newCell.monster == true)
                    {
                        newCell.power = true;

                    }
                    else{
                        System.out.print("$" + "\t");
                        newCell.power = true;

                    }
                }
                else
                {
                    System.out.print("." + "\t");
                    if(newCell.wall == true)
                    {
                        newCell.wall = true;
                    }
                    else
                    {
                        newCell.wall = false;
                    }
                }
            }
            System.out.print('#');
            System.out.println();
        }
        for(int x = 0; x < cols+2; x++){
            System.out.print("#\t");
        }
        System.out.println();

    }





    public void displayGraph(){

        for(int x = 0; x < cols+2; x++){
            System.out.print("#\t");
        }
        System.out.println();

        for(int x = 0; x < rows; x++){
            System.out.print("#\t");
            for(int y = 0; y < cols; y++){
                //newCell = grid.getCell(x,y);
                if(newCell.wall == true)
                {
                    System.out.print("#" + "\t");
                }
                else if (newCell.hero == true){
                    System.out.print("@" + "\t");
                }
                else if (newCell.monster == true){
                    System.out.print("!" + "\t");
                }
                else if (newCell.power == true){
                    if(newCell.monster != true) {
                        System.out.print("$" + "\t");
                    }
                }
                else
                {
                    System.out.print(" " + "\t");
                }

            }
            System.out.print('#');
            System.out.println();
        }
        for(int x = 0; x < cols+2; x++){
            System.out.print("#\t");
        }
        System.out.println();

    }

    public int generateX(){
        Random rand = new Random();
        int xbound = 17;
        int u = rand.nextInt(xbound);
        return u;
    }

    public int generateY(){
        Random rand = new Random();
        int ybound = 12;
        int r = rand.nextInt(ybound);
        return r;
    }

    public boolean checkXY(int a, int b){
        newCell = grid.getCell(a,b);
        if(newCell.wall == true){
            return true;
        }
        return false;
    }



    public int motion(int j){
        if(j == 1)
        {
            int k = 0;
            if(w == 0)
            {
                return 1;
            }
            else
            {
                k = w-1;
            }
            newCell = grid.getCell(k,h);
            if(newCell.wall == true)
            {
                return 1;
            }
            else if((newCell.monster == true) || ((newCell.monster == true) && (newCell.power == true)))
            {
                newCell.hero = true;
                newCell.monster = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 2;
            }
            else if(newCell.power == true)
            {
                newCell.hero = true;
                newCell.power = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 3;
            }
            else
            {
                newCell.hero = true;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 0;
            }

        }
        else if(j == 2)
        {
            int k = 0;
            if(h == 0)
            {
                return 1;
            }
            else
            {
                k = h - 1;
            }
            newCell = grid.getCell(w,k);
            if(newCell.wall == true)
            {
                return 1;
            }
            else if((newCell.monster == true) || ((newCell.monster == true) && (newCell.power == true)))
            {
                newCell.hero = true;
                newCell.monster = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 2;
            }
            else if(newCell.power == true)
            {
                newCell.hero = true;
                newCell.power = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 3;
            }
            else
            {
                newCell.hero = true;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 0;
            }
        }
        else if (j == 3)
        {

            int k = 0;
            if(w == 17)
            {
                return 1;
            }
            else
            {
                k = w + 1;
            }
            newCell = grid.getCell(k,h);
            if(newCell.wall == true)
            {
                return 1;
            }
            else if((newCell.monster == true) || ((newCell.monster == true) && (newCell.power == true)))
            {
                newCell.hero = true;
                newCell.monster = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 2;
            }
            else if(newCell.power == true)
            {
                newCell.hero = true;
                newCell.power = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 3;
            }
            else
            {
                newCell.hero = true;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 0;
            }

        }
        else if (j == 4)
        {

            int k = 0;
            if(h == 12)
            {
                return 1;
            }
            else
            {
                k = h + 1;
            }
            newCell = grid.getCell(w,k);
            if(newCell.wall == true)
            {
                return 1;
            }
            else if((newCell.monster == true) || ((newCell.monster == true) && (newCell.power == true)))
            {
                newCell.hero = true;
                newCell.monster = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 2;
            }
            else if(newCell.power == true)
            {
                newCell.hero = true;
                newCell.power = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 3;
            }
            else
            {
                newCell.hero = true;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                return 0;
            }
        }
        return 0;
    }

}

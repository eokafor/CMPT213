package ca.cmpt213.a2.textui;

import ca.cmpt213.a2.model.Cell;
import ca.cmpt213.a2.model.maze;

import java.util.Random;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR:
LAST MODIFIED DATE:
DESCRIPTION: This graph class is responsible for printing out the respective game maze based on certain conditions like if the game is initially started, if the user wants to see the full maze with no hidden cells and if the user moves throught the maze.
 */

public class graph {

    maze grid;
    int cols;
    int rows;
    Cell newCell;
    int w = 0; //temp x value
    int h = 0; //temp y value
    int e = 0; //buffer for x value
    int f = 0; //buffer for y value
    int life = 0; //counter for the power in maze
    int t = 0; //global x value for power while loop
    int v = 0; //global y value for power while loop

    public graph() {
        grid = new maze();
        cols = grid.getNUM_COLS();
        rows = grid.getNUM_ROWS();
    }

    public void newGraph(){ //default graph shown at the start of the game
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
        for(int x = 0; x < cols + 2; x++){
            System.out.print("#\t");
        }
        System.out.println();
        for(int x = 0; x < rows; x++){
            System.out.print("#\t");
            for(int y = 0; y < cols; y++){
                newCell = grid.getCell(x,y);
                if((newCell.wall != true) && (x == 0) && (y == 0)){
                    System.out.print("@" + "\t");
                    newCell.hero = true;
                    w = x;
                    h = y;
                }
                else if ((x == 0)&&(y == 1))
                {
                    newCell.reveal = true;
                    if(newCell.wall == true)
                    {
                        System.out.print("#" + "\t");
                    }
                    else
                    {
                        System.out.print(" " + "\t");
                    }
                }
                else if ((x == 1)&&(y == 0))
                {
                    newCell.reveal = true;
                    if(newCell.wall == true)
                    {
                        System.out.print("#" + "\t");
                    }
                    else
                    {
                        System.out.print(" " + "\t");
                    }
                }
                else if ((x == 1)&&(y == 1))
                {
                    newCell.reveal = true;
                    if(newCell.wall == true)
                    {
                        System.out.print("#" + "\t");
                    }
                    else
                    {
                        System.out.print(" " + "\t");
                    }
                }
                else if ((x == 0) && (y == 12)){
                    System.out.print("!" + "\t");
                    newCell.monster = true;
                }
                else if ((x == 17) && (y == 0)){
                    System.out.print("!" + "\t");
                    newCell.monster = true;
                }
                else if ((x == 17) && (y == 12)){
                    System.out.print("!" + "\t");
                    newCell.monster = true;
                }
                else if ((x == p) && (y == l) && (newCell.hero != true)){
                    if(newCell.monster == true)
                    {
                        newCell.power = true;
                        life = 1;
                    }
                    else{
                        System.out.print("$" + "\t");
                        life = 1;
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
        for(int x = 0; x < cols + 2; x++){
            System.out.print("#\t");
        }
        System.out.println();

    }

    public void displayGraph(){ //displays the entire graph with walls and spaces
        for(int x = 0; x < cols+2; x++){
            System.out.print("#\t");
        }
        System.out.println();
        for(int x = 0; x < rows; x++){
            System.out.print("#\t");
            for(int y = 0; y < cols; y++){
                newCell = grid.getCell(x,y);
                if(newCell.wall == true)
                {
                    System.out.print("#" + "\t");
                }
                else if (newCell.hero == true)
                {
                    System.out.print("@" + "\t");
                }
                else if (newCell.monster == true)
                {
                    System.out.print("!" + "\t");
                }
                else if (newCell.power == true)
                {
                    if(newCell.monster != true)
                    {
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
        for(int x = 0; x < cols + 2; x++){
            System.out.print("#\t");
        }
        System.out.println();
    }

    public void checkGraph(){ //checks all 8 neighbouring cell to the hero cell
        for(int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                newCell = grid.getCell(x, y);
                if ((x == e - 1) && (y == f)) {
                    newCell.reveal = true;
                } else if ((x == e + 1) && (y == f)) {
                    newCell.reveal = true;
                } else if ((x == e - 1) && (y == f + 1)) {
                    newCell.reveal = true;
                } else if ((x == e) && (y == f + 1)) {
                    newCell.reveal = true;
                } else if ((x == e + 1) && (y == f + 1)) {
                    newCell.reveal = true;
                } else if ((x == e - 1) && (y == f - 1) ) {
                    newCell.reveal = true;
                } else if ((x == e) && (y == f - 1)) {
                    newCell.reveal = true;
                } else if ((x == e + 1) && (y == f - 1)) {
                    newCell.reveal = true;
                }
            }
        }
    }

    public void motionGraph(){ //graph shown when the hero is moved in the game
        for(int x = 0; x < cols+2; x++){
            System.out.print("#\t");
        }
        System.out.println();
        for(int x = 0; x < rows; x++){
            System.out.print("#\t");
            for(int y = 0; y < cols; y++){
                newCell = grid.getCell(x,y);
                if ((x == t) && (y == v) && (newCell.hero != true) && (life == 0)){
                    if(newCell.monster == true)
                    {
                        newCell.power = true;
                        life = 1;
                        System.out.print("!" + "\t");
                    }
                    else{
                        System.out.print("$" + "\t");
                        life = 1;
                        newCell.power = true;
                    }
                }
                else if(newCell.hero == true)
                {
                    System.out.print("@" + "\t");
                }
                else if(newCell.monster == true)
                {
                    System.out.print("!" + "\t");
                }
                else if(newCell.power == true)
                {
                    System.out.print("$" + "\t");
                    life = 1;
                }
                else if (newCell.reveal == true)
                {
                    if(newCell.wall == true)
                    {
                        System.out.print("#" + "\t");
                    }
                    else
                    {
                        System.out.print(" " + "\t");
                    }
                }
                else
                {
                    System.out.print("." + "\t");
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
        //int u = rand.nextInt(xbound);
        return rand.nextInt(xbound);
    }

    public int generateY(){
        Random rand = new Random();
        int ybound = 12;
        //int r = rand.nextInt(ybound);
        return rand.nextInt(ybound);
    }

    public boolean checkXY(int a, int b){
        newCell = grid.getCell(a,b);
        if(newCell.wall == true){
            return true;
        }
        return false;
    }

    public boolean modifyXY(int a, int b){
        newCell = grid.getCell(a,b);
        if((newCell.wall == true) || (newCell.hero == true)){
            return true;
        }
        return false;
    }

    public int motion(int j){
        int counter = 0;
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
            else if ((newCell.monster == true) && (newCell.power == true))
            {
                newCell.hero = true;
                life = 0;
                while(counter != 1){
                    t = generateX();
                    v = generateY();
                    boolean see = modifyXY(t,v);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                e = k;
                f = h;
                newCell.monster = false;
                //newCell.power = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 4;
            }
            else if(newCell.monster == true)
            {
                newCell.hero = true;
                e = k;
                f = h;
                newCell.monster = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 2;
            }
            else if(newCell.power == true)
            {
                newCell.power = false;
                newCell.hero = true;
                life = 0;
                while(counter != 1){
                    t = generateX();
                    v = generateY();
                    boolean see = modifyXY(t,v);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                e = k;
                f = h;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 3;
            }
            else
            {
                newCell.hero = true;
                e = k;
                f = h;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
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
            else if ((newCell.monster == true) && (newCell.power == true))
            {
                newCell.hero = true;
                life = 0;
                while(counter != 1){
                    t = generateX();
                    v = generateY();
                    boolean see = modifyXY(t,v);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                e = k;
                f = h;
                newCell.monster = false;
                //newCell.power = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 4;
            }
            else if(newCell.monster == true)
            {
                newCell.hero = true;
                e = w;
                f = k;
                newCell.monster = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 2;
            }
            else if(newCell.power == true)
            {
                newCell.power = false;
                newCell.hero = true;
                life = 0;
                while(counter != 1){
                    t = generateX();
                    v = generateY();
                    boolean see = modifyXY(t,v);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                e = w;
                f = k;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 3;
            }
            else
            {
                newCell.hero = true;
                e = w;
                f = k;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
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
            else if ((newCell.monster == true) && (newCell.power == true))
            {
                newCell.hero = true;
                life = 0;
                while(counter != 1){
                    t = generateX();
                    v = generateY();
                    boolean see = modifyXY(t,v);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                e = k;
                f = h;
                newCell.monster = false;
                // newCell.power = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 4;

            }
            else if(newCell.monster == true)
            {
                newCell.hero = true;
                e = k;
                f = h;
                newCell.monster = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 2;
            }
            else if(newCell.power == true)
            {
                newCell.power = false;
                newCell.hero = true;
                life = 0;
                while(counter != 1){
                    t = generateX();
                    v = generateY();
                    boolean see = modifyXY(t,v);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                e = k;
                f = h;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 3;
            }
            else
            {
                newCell.hero = true;
                e = k;
                f = h;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
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
            else if ((newCell.monster == true) && (newCell.power == true))
            {
                newCell.hero = true;
                life = 0;
                while(counter != 1){
                    t = generateX();
                    v = generateY();
                    boolean see = modifyXY(t,v);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                e = k;
                f = h;
                newCell.monster = false;
                //newCell.power = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 4;
            }
            else if(newCell.monster == true)
            {
                newCell.hero = true;
                e = w;
                f = k;
                newCell.monster = false;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 2;
            }
            else if(newCell.power == true)
            {
                newCell.power = false;
                newCell.hero = true;
                life = 0;
                while(counter != 1){
                    t = generateX();
                    v = generateY();
                    boolean see = modifyXY(t,v);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                e = w;
                f = k;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 3;
            }
            else
            {
                newCell.hero = true;
                e = w;
                f = k;
                newCell = grid.getCell(w,h);
                newCell.hero = false;
                w = e;
                h = f;
                checkGraph();
                return 0;
            }
        }
        return 0;
    }
}

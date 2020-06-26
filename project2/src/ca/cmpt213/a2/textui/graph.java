package ca.cmpt213.a2.textui;

import ca.cmpt213.a2.model.Cell;
import ca.cmpt213.a2.model.maze;

import java.util.Random;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR:
LAST MODIFIED DATE:
DESCRIPTION: This graph class is responsible for printing the maze initially when the game starts and initializes cells where needed
 */

public class graph {

    static maze grid;
    int cols;
    int rows;
    Cell newCell;
    static int w = 0; //temp x value
    static int h = 0; //temp y value
    static int e = 0; //buffer for x value
    static int f = 0; //buffer for y value
    static int life = 0; //counter for the power in maze
    static int t = 0; //global x value for power while loop
    static int v = 0; //global y value for power while loop


    public graph() {
        grid = new maze();
        cols = grid.getNUM_COLS();
        rows = grid.getNUM_ROWS();
    }

    public static maze getGrid() {
        return grid;
    }

    public static int getW() {
        return w;
    }

    public static void setW(int w) {
        graph.w = w;
    }

    public static int getH() {
        return h;
    }

    public static void setH(int h) {
        graph.h = h;
    }

    public static int getE() {
        return e;
    }

    public static void setE(int e) {
        graph.e = e;
    }

    public static int getF() {
        return f;
    }

    public static void setF(int f) {
        graph.f = f;
    }

    public static int getT() {
        return t;
    }

    public static void setT(int t) {
        graph.t = t;
    }

    public static int getV() {
        return v;
    }

    public static void setV(int v) {
        graph.v = v;
    }

    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        graph.life = life;
    }

    public void newGraph(){ //default graph shown at the start of the game
        int num = 0;
        int p = 0;
        int l = 0;
        while(num != 1){
            p = generateX(rows-1);
            l = generateY(cols-1);
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

    public static int generateX(int a){
        Random rand = new Random();
        return rand.nextInt(a);
    }

    public static int generateY(int b){
        Random rand = new Random();
        return rand.nextInt(b);
    }

    public boolean checkXY(int a, int b){
        newCell = grid.getCell(a,b);
        if(newCell.wall == true){
            return true;
        }
        return false;
    }

    /*public void displayGraph(){ //displays the entire graph with walls and spaces
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
    }*/

    /*public void checkGraph(){ //checks all 8 neighbouring cell to the hero cell
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
    }*/

    /*public void motionGraph(){ //graph shown when the hero is moved in the game
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
    }*/



    /*public boolean modifyXY(int a, int b){
        newCell = grid.getCell(a,b);
        if((newCell.wall == true) || (newCell.hero == true)){
            return true;
        }
        return false;
    }*/

    /*public int motion(int j){
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
                    t = generateX(rows-1);
                    v = generateY(cols-1);
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
            else if((newCell.monster == true))
            {
                int verify = 0;
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
                    t = generateX(rows-1);
                    v = generateY(cols-1);
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
                    t = generateX(rows-1);
                    v = generateY(cols-1);
                    boolean see = modifyXY(t,v);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                e = w;
                f = k;
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
                    t = generateX(rows-1);
                    v = generateY(cols-1);
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
                    t = generateX(rows-1);
                    v = generateY(cols-1);
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
                    t = generateX(rows-1);
                    v = generateY(cols-1);
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
                    t = generateX(rows-1);
                    v = generateY(cols-1);
                    boolean see = modifyXY(t,v);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                e = w;
                f = k;
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
                    t = generateX(rows-1);
                    v = generateY(cols-1);
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
    }*/
}

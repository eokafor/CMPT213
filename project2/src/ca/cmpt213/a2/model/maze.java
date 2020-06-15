package ca.cmpt213.a2.model;


import java.util.Random;

public class maze {

    int NUM_ROWS;
    int NUM_COLS;
    Cells cell[][];
    int heroX,heroY;
    int M1X,M1Y;
    int M2X,M2Y;
    int M3X,M3Y;


    public maze() {
        this.NUM_ROWS = 18;
        this.NUM_COLS = 13;
        cell = new Cells[NUM_ROWS][NUM_COLS];
        //grid = new int[NUM_ROWS][NUM_COLS];
        //Random objGenerator=new Random();
        heroX=0;
        heroY=0;
        M1X=0;
        M1Y=NUM_COLS-1;
        M2X=NUM_ROWS-1;
        M2Y=0;
        M3X=NUM_ROWS-1;
        M3Y=NUM_COLS-1;
        for(int i=0;i<NUM_ROWS;i++) {
            for (int j = 0; j <NUM_COLS; j++) {
                cell[i][j]= new Cells();
            }
        }
        for(int i=0;i<NUM_ROWS;i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if(i!=0){//UP
                    cell[i][j].neighbours.add(cell[i-1][j]);
                }
                if(j!=0){//left
                    cell[i][j].neighbours.add(cell[i][j-1]);
                }
                if(j!=NUM_COLS){//right
                    cell[i][j].neighbours.add(cell[i][j+1]);
                }
                if(i!=NUM_ROWS){//down
                    cell[i][j].neighbours.add(cell[i+1][j]);
                }
            }
        }
        Explorer explorer=new Explorer(cell[0][0]);

    }

}

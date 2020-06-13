package ca.cmpt213.a2.model;


public class maze {

    int NUM_ROWS;
    int NUM_COLS;
    int grid[][];
    int x0,y0,x1,y1;


    public maze(int NUM_ROWS, int NUM_COLS, int x0, int y0, int x1, int y1) {
        this.NUM_ROWS = NUM_ROWS;
        this.NUM_COLS = NUM_COLS;
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;


        grid = new int[NUM_ROWS][NUM_COLS];
        

    }
}

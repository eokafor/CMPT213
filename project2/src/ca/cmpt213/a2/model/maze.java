package ca.cmpt213.a2.model;


public class maze {

    int NUM_ROWS;
    int NUM_COLS;
    int grid[][];
    int heroX,heroY;
    int M1X,M1Y;
    int M2X,M2Y;
    int M3X,M3Y;


    public maze(int NUM_ROWS, int NUM_COLS) {
        this.NUM_ROWS = NUM_ROWS;
        this.NUM_COLS = NUM_COLS;
        grid = new int[NUM_ROWS][NUM_COLS];
        Random objGenerator=new Random();
        heroX=objGenerator.nextInt(NUM_COLS);
        heroY=objGenerator.nextInt(NUM_ROWS);
        do {
            M1X = objGenerator.nextInt(NUM_COLS);
        }while(M1X==heroX);
        do {
            M1Y = objGenerator.nextInt(NUM_ROWS);
        }while(M1Y==heroY);
        do {
            M2X = objGenerator.nextInt(NUM_COLS);
        }while(M2X==heroX||M2X==M1X);
        do {
            M2Y = objGenerator.nextInt(NUM_ROWS);
        }while(M2Y==heroY||M2Y==M1Y);
        do {
            M3X = objGenerator.nextInt(NUM_COLS);
        }while(M3X==heroX||M3X==M1X||M3X==M2X);
        do{
        M3Y=objGenerator.nextInt(NUM_ROWS);
        }while(M3Y==heroY||M3Y==M1Y||M3Y==M2Y);
}

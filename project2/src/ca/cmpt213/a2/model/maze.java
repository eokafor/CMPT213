package ca.cmpt213.a2.model;


public class maze {

    int NUM_ROWS;
    int NUM_COLS;
    Cell cell[18][13];
    int heroX,heroY;
    int M1X,M1Y;
    int M2X,M2Y;
    int M3X,M3Y;


    public maze() {
        this.NUM_ROWS = 18;
        this.NUM_COLS = 13;
        grid = new int[NUM_ROWS][NUM_COLS];
        Random objGenerator=new Random();
        heroX=0;
        heroY=0;
        M1X=0;
        M1Y=12;
        M2X=17;
        M2Y=0;
        M3X=17;
        M3Y=12;
        for(int i=0;i<18;i++) {
            for (int j = 0; j <13; j++) {
               cell[i][j]=new cell();
            }
        }
        for(int i=0;i<18;i++) {
            for (int j = 0; j <13; j++) {
                if(i!=0){//UP
                    cell[i][j].neighbours.add(cell[i-1][j]);
                }
                if(j!=0){//left
                    cell[i][j].neighbour.add(cell[i][j-1]);
                }
                if(j!=NUM_COLS){//right
                    cell[i][j].neighbour.add(cell[i][j+1]);
                }
                if(i!=NUM_ROWS){//down
                    cell[i][j].neighbour.add(cell[i+1][j])
                }
            }
        }
        Explorer explorer=new explorer(cell[0][0]);

    }

}

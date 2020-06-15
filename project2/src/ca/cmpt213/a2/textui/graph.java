package ca.cmpt213.a2.textui;

import ca.cmpt213.a2.model.Cells;
import ca.cmpt213.a2.model.maze;

public class graph {

    maze grid;
    int cols;
    int rows;
    Cells newCell;

    public graph(){

        grid = new maze();
        cols = grid.getNUM_COLS();
        rows = grid.getNUM_ROWS();

        for(int x = 0; x < rows; x++){
            for(int y = 0; y < cols; y++){
                newCell = grid.getCell(x,y);
                if(newCell.wall == true)
                {
                    System.out.print("#" + "\t");
                }
                else
                {
                    System.out.print("." + "\t");
                }
            }
            System.out.println();
        }

    }




}

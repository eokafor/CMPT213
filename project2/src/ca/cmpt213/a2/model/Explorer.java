package ca.cmpt213.a2.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR:
LAST MODIFIED DATE:
DESCRIPTION:
 */


public class Explorer {

    Stack path=new Stack();
    Cell current;
    private Cell cells[][];


    public Explorer(Cell current,Cell[][] cells) {
        this.current = current;
        this.cells=cells;
        pathexplorer();

        removeOpenCells();
        removeLockedCells();

        CornerCleaner();
        openPath();

    }


    private void pathexplorer(){
        current.visited=true;
        path.push(current);
        while(!path.empty()){
            current = (Cell) path.pop();
            Collections.shuffle(current.neighbours);
            for(Cell neighbour:current.neighbours){
                if(!neighbour.visited) {
                    path.push(current);

                    current.wall=false;
                    neighbour.visited=true;
                    path.push(neighbour);
                    break;

                }
            }
        }
    }
    private void removeOpenCells(){
        for(int i=0;i<18;i++){
            for(int j=0;j<13;j++){
                if(cells[i][j].wall==false){
                    boolean neighbourWall=false;
                    if(j<12){
                        if(cells[i][j+1].wall==true){
                            neighbourWall=true;
                        }
                    }
                    if(i<17){
                        if(cells[i+1][j].wall==true){
                            neighbourWall=true;
                        }
                    }
                    if(i<17&&j<12){
                        if(cells[i+1][j+1].wall==true){
                            neighbourWall=true;
                        }
                    }
                    if (neighbourWall==false){
                        cells[i][j].wall=true;
                    }
                }
            }
        }
    }

    private void removeLockedCells() {
        for(int i=0;i<18;i++){
            for(int j=0;j<13;j++){
                if(cells[i][j].wall){
                    boolean neighbourWall=true;
                    if(j<12){
                        if(!cells[i][j+1].wall){
                            neighbourWall=false;
                        }
                    }
                    if(i<17){
                        if(!cells[i+1][j].wall){
                            neighbourWall=false;
                        }
                    }
                    if(i<17&&j<12){
                        if(!cells[i+1][j+1].wall){
                            neighbourWall=false;
                        }
                    }
                    if (neighbourWall==true){
                        cells[i][j].wall=false;
                    }
                }
            }
        }
    }
    private void CornerCleaner(){
        cells[0][0].wall=false;
        cells[0][12].wall=false;
        cells[17][0].wall=false;
        cells[17][12].wall=false;
    }
    private void trackingCells() {
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 13; j++) {
                if(!cells[i][j].wall){
                    cells[i][j].tracker=0;
                }
            }

        }
    }
    private void bfs(Cell start){
        Queue<Cell> path=new LinkedList<>();
        path.add(start);
        while(!path.isEmpty()){
            Cell blockcurrent=path.remove();
            blockcurrent.tracker=1;
            for(Cell neighbor:blockcurrent.neighbours){
                if(neighbor.tracker==0){
                    path.add(neighbor);
                }
            }
        }
    }

    private void openPath(){
        trackingCells();
        bfs(cells[0][0]);
        boolean repeat;
        do {
            repeat=false;
            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 13; j++) {
                    Cell newCurrent = cells[i][j];
                    if (newCurrent.tracker == 0) {
                        bfs(newCurrent);
                        for (Cell neighbour : newCurrent.neighbours) {
                            if (neighbour.wall == true) {
                                neighbour.wall = false;
                                break;
                            }
                        }
                    }

                }
            }
            trackingCells();
            bfs(cells[0][0]);
            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 13; j++) {
                 if(cells[i][j].tracker==0)
                     repeat=true;

                }
                }
            //removeOpenCells();

        }while(repeat);

    }
}
package ca.cmpt213.a2.model;

import java.util.ArrayList;

public class Cell {
    public boolean visited;
    public boolean wall;
    public int tracker;
    public ArrayList<Cell> neighbours;


    public Cell(){
        this.visited=false;
        wall=true;
        tracker=-1;
        neighbours=new ArrayList<Cell>();

    }



}
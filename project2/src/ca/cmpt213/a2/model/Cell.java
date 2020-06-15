package ca.cmpt213.a2.model;

public class Cell {
    public boolean visited;
    public boolean wall;
    public ArrayList<Cell> neighbours;


    public Cell(){
        this.visited=false;
        wall=true;
        neighbours=new ArrayList<Cell>();

    }








}

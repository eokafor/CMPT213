package ca.cmpt213.a2.model;

import java.util.ArrayList;

public class Cells {
    public boolean visited;
    public boolean wall;
    public ArrayList<Cells> neighbours;


    public Cells(){
        this.visited=false;
        wall=true;
        neighbours=new ArrayList<Cells>();

    }


}
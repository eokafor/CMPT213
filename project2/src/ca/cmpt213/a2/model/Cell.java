package ca.cmpt213.a2.model;

import java.util.ArrayList;

public class Cell {
    public boolean visited;
    public boolean wall;
    public boolean reveal;
    public boolean power ;
    public boolean monster;
    public boolean hero;
    public int tracker;
    public ArrayList<Cell> neighbours;


    public Cell(){
        this.visited=false;
        this.wall = true;
        this.hero = false;
        this.reveal = false;
        this.power = false;
        this.monster = false;
        tracker=-1;
        neighbours=new ArrayList<Cell>();
    }



}
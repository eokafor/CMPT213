package ca.cmpt213.a2.model;

public class Cell {
    public boolean visited;
    public ArrayList<Cell> neighbours;
    public enum Occupancy {S, M, E}
    public enum Status {N ,E, S, W}
    private Status check;
    private State state;
    private Occupancy occupancy;

    public Cell(){
        this.visited=false;
        neighbours=new ArrayList<Cell>();
        this.occupancy = Occupancy.E;
    }

    public Cell(Occupancy occupancy1){
        this.state = State.UNVISITED;
        this.occupancy = occupancy1;
    }





}

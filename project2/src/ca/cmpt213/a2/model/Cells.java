package ca.cmpt213.a2.model;

public class Cells {
    public enum State {VISITED, UNVISITED}
    public enum Occupancy {S, M, E}
    public enum Status {N ,E, S, W}
    private Status check;
    private State state;
    private Occupancy occupancy;

    public Cells(){
        this.state = State.UNVISITED;
        this.occupancy = Occupancy.E;
    }

    public Cells(Occupancy occupancy1){
        this.state = State.UNVISITED;
        this.occupancy = occupancy1;
    }





}

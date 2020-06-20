package ca.cmpt213.a2.model;

import java.util.Stack;

public class Explorer {

    Stack path=new Stack();
    Cells current;


    public Explorer(Cells current) {
        this.current = current;
        pathexplorer();

    }
    private void pathexplorer(){
        current.visited=true;
        path.push(current);
        while(!path.empty()){
            current = (Cells) path.pop();
            for(Cells neighbour:current.neighbours){
                if(!neighbour.visited) {
                    path.push(current);

                    current.wall=false;
                    neighbour.visited=true;
                    path.push(neighbour);
                } }
        }
    }
}
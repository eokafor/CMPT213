package ca.cmpt213.a2.model;


public class Explorer {

   Stack path=new Stack();
   Cell current;


    public Explorer(Cell current) {
        this.current= current;
        pathexplorer();

    }
    private void pathexplorer(){
        current.visited=true;
        path.push(current);
        while(!path.empty){
            current=path.pop();
            for(Cell neighbour:current.neighbour){
                if(!neighbour.visited) {
                    path.push(current);
                    break;
                } }
            for(Cell neighbour:current.neighbour){
                if(!neighbour.visited) {
                    wall=false;
                    neighbour.visited=true;
                    path.push(neighbour);
                } }
        }
    }
}

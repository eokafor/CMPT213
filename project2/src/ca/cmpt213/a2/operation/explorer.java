package ca.cmpt213.a2.model;


public class explorer {

   Stack path=new Stack();
   Cell current;


    public explorer(Cell current) {
        this.current= current;

    }
    public pathexplorer(){
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
                    //remove wall stufff.
                    neighbour.visited=true;
                    path.push(neighbour);
                } }
        }
    }
}

// import java.util.LinkedList;
// import java.util.List.*;
// import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Vertex{
    public int data;
    public boolean visited;
    public Map<Vertex,Integer> Neighours;

    public Vertex(int data){
        this.data=data;
        this.visited=false;
        this.Neighours=new HashMap<>();
    }
}
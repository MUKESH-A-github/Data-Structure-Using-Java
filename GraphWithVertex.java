import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
public class GraphWithVertex{
    static Vertex start,end;
    static  int MinSum=Integer.MAX_VALUE;
    public GraphWithVertex(Vertex v,Vertex e){
        this.start=v;
        this.end=e;
    }
    public static void main(String[] args) {
        Vertex v1=new Vertex(1);
        Vertex v2=new Vertex(2);
        Vertex v3=new Vertex(3);
        Vertex v4=new Vertex(4);
        Vertex v5=new Vertex(5);
        Vertex v6=new Vertex(6);
        GraphWithVertex gh=new GraphWithVertex(v1,v6);
        Map<Vertex,Integer> v1map=new HashMap<>(){
            {
            put(v2,1);
            put(v3,3);
            }
        };
        v1.Neighours.putAll(v1map);
        Map<Vertex,Integer> v2map=new HashMap<>(){
            {
            put(v4,4);
            put(v3,2);
            }
        };
        v2.Neighours=v2map;
        Map<Vertex,Integer> v3map=new HashMap<>(){
            {
            put(v5,1);
            put(v4,2);
            }
        };
        v3.Neighours.putAll(v3map);
        Map<Vertex,Integer> v4map=new HashMap<>(){
            {
            put(v6,2);
            }
        };
        v4.Neighours.putAll(v4map);
        Map<Vertex,Integer> v5map=new HashMap<>(){
            {
            put(v6,1);
            put(v1,5);
            }
        };
        v5.Neighours.putAll(v5map);
        //BFS();
        MinSum();
    }
    public static void BFS(){
        Queue<Vertex> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            Vertex current=queue.poll();
            if(!current.visited){
            current.visited=true;
            System.out.print(current.data+"->");
            queue.addAll(current.Neighours.keySet());
            }
        }
    }
    public static void MinSum(){
        Set<Vertex> set=new HashSet<>();
        TraversalPath(start,0,set);
        System.out.println("Minimum Shortest path Between"+start.data+"to"+end.data+"Minimum Sum = "+MinSum);
    }
    public static void TraversalPath(Vertex Current,int sum,Set<Vertex> visited){
        if(Current == null || visited.contains(Current)){
            return;
        }
        if(Current == end){
            MinSum = Math.min(MinSum,sum);
            return;
        }
        visited.add(Current);
        if(!Current.Neighours.isEmpty()){
            for(Vertex v1:Current.Neighours.keySet()){
                int weight=Current.Neighours.get(v1);
                TraversalPath(v1, sum+weight, visited);
            }
        }
        visited.remove(Current);
    }
}
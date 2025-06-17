import java.util.ArrayList;
import java.util.List;
public class Heap {
    List<Integer> heap=new ArrayList<>();
    public int getParent(int Index){
        return (Index/2);
    }
    public int LeftChild(int Index){
        return (Index*2);
    }
    public int RightChild(int Index){
        return (Index*2)+1;
    }
    public void insert(int data){
        heap.add(data);
        int i=heap.size()-1;
        while(i>0 && heap.get(getParent(i))>heap.get(i)){
            int temp=heap.get(getParent(i));
            heap.set(getParent(i),heap.get(i));
            heap.set(i,temp);
            i=getParent(i);
        }
    }
    public void Heapify(int currentIndex,List<Integer> arr){
        int left=LeftChild(currentIndex);
        int right=RightChild(currentIndex);
        int min=currentIndex;
        if(left<arr.size() && arr.get(left)<arr.get(min)){
            min=left;
        }if(right<arr.size() && arr.get(right)<arr.get(min)){
            min=right;
        }
        if(min!=currentIndex){
            int temp=arr.get(min);
            arr.set(min,arr.get(currentIndex));
            arr.set(currentIndex,temp);
            Heapify(min, arr);
        }
    }
    public int remove(){
        int first=heap.get(0);
        if(heap.size()==1){
            heap.remove(0);
            return first;
        }
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        Heapify(0,heap);
        return first;
    }
    public List<Integer> HeapSort(){
        List<Integer> arr=new ArrayList<>();
        while(!heap.isEmpty()){
            arr.add(remove());
        }
        return arr;
    }
    public static void main(String[] args) {
        Heap heap=new Heap();
        heap.insert(10);
        heap.insert(2);
        heap.insert(5);
        heap.insert(11);
        heap.insert(12);
        heap.insert(13);
        heap.insert(14);
        System.out.println(heap.heap);
        System.out.println(heap.HeapSort());
    }
}

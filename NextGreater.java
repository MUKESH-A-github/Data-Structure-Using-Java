import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class NextGreater{
    static List<Integer> list=new ArrayList<>();
    static List<Integer> nextGreaterElement(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            list.add(-1);
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                list.set(i,stack.peek());
            }
            stack.push(arr[i]);
        }
        return list;
    }

    public static void main(String args[]){
        int arr[]=new int[]{ 6, 8, 0, 1, 3 };
        System.out.print(nextGreaterElement(arr));
    }
}

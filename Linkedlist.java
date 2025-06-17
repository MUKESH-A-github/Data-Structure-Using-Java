public class Linkedlist{
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
        }
    }
    public static Node Head;
    public static Node insert(int data,Node node){
        if(node==null){
            return node=new Node(data);
        }else if(data<node.data){
            node.left=insert(data, node.left);
        }else if(data>=node.data){
            node.right=insert(data, node.right);
        }
        return node;
    }
    public static void insertOne(int data){
        if(Head==null){
            Head=new Node(data);
        }
        if(Head.data>data){
            Head.left=insert(data, Head.left);
        }else{
            Head.right=insert(data,Head.right);
        }
    }
    public static void InOrder(Node node){
        if(node!=null){
            InOrder(node.left);
            System.out.println(node.data+" ");
            InOrder(node.right);
        }
    }
    public static void main(String args[]){
        insertOne(10);
        insertOne(20);
        insertOne(30);
        insertOne(5);
        insertOne(1);
        InOrder(Head);
    }
}
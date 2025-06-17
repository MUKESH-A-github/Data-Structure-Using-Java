
public class AvlTree{
    class Node{
        int val;
        Node left,right;
        int height;
        public Node(int val){
            this.val=val;
            this.height=1;
        }
    }
    public int Height(Node node){
        if(node==null) return 0;
        return node.height;
    }
    public int getBalance(Node node){
        return Height(node.left)-Height(node.right);
    }
    public Node insertNode(Node node,int key){
        if(node==null){
            return node=new Node(key);
        }else if(node.val>key){
            node.left=insertNode(node.left,key);
        }else if(node.val<key){
            node.right=insertNode(node.right,key);
        }else{
            return node;
        }
        node.height=1+Math.max(Height(node.left),Height(node.right));
        int balance=getBalance(node);
        if(balance>1 && node.left.val>key){
            return RotateRight(node);   
        }else if(balance <-1 && node.right.val<key){
            return RotateLeft(node);
        }else if(balance>1 && key>node.left.val){
            node.left=RotateLeft(node.left);
            return RotateRight(node);
        }else if(balance<-1 && key<node.right.val){
            node.right=RotateRight(node.right);
            return RotateLeft(node);
        }
        return node;
    }
    public Node RotateRight(Node x){
        Node Y=x.left;
        x.left=Y.right;
        Y.right=x;
        x.height=1+Math.max(Height(x.left),Height(x.right));
        Y.height=1+Math.max(Height(Y.left),Height(Y.right));
        return Y;
    }
    public Node RotateLeft(Node Y){
        Node x=Y.right;
        Y.right=x.left;
        x.left=Y;
        x.height=1+Math.max(Height(x.left),Height(x.right));
        Y.height=1+Math.max(Height(Y.left),Height(Y.right));
        return x;
    }
    public Node root;
    public void insert(int data){
        if(root==null){
            root=new Node(data);
        }else{
            root=insertNode(root, data);
        }
    }
    public void inOrder(Node node){
        if(node==null) return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }
    public static void main(String ars[]){
        AvlTree tree=new AvlTree();
        tree.insert(9);
        tree.insert(5);
        tree.insert(10);
        tree.insert(2);
        tree.insert(40);
        tree.insert(3);
        tree.insert(22);
        tree.insert(7);
        tree.inOrder(tree.root);
    }
}
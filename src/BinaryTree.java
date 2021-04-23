import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    int data;
    Node left,right;

    Node(int data){
        this.data = data;
        left = right =null;
    }


}


public class BinaryTree {

    static int i = 1;

    public static void main(String args[]){

        Node root = new  Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> inorderList = new ArrayList<>();

        inorderList.add(0);

        storingInorderTraversal(root, inorderList);

        inorderList.add(0);

        inorderTraversal(root);

        changingNodewithPrecedessorAndSuccessor(root, inorderList);

        System.out.println();

        inorderTraversal(root);

    }

    private static void inorderTraversal(Node root){

        if(root == null){
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);

    }

    private static void inorderTraversalwithoutRecursion(Node root){

        Stack<Node> stack = new Stack<>();

        stack.push(root);
        Node current = root.left;


        while(!stack.empty() || current != null){

            while(current != null ){
                stack.push(current);
                current = current.left;
            }



            current = stack.pop();
            System.out.print(current.data+ " ");

            current = current.right;

        }
    }

    private static void storingInorderTraversal(Node root, List<Integer> inorderArray){

        if(root == null){
            return;
        }

        storingInorderTraversal(root.left, inorderArray);
        inorderArray.add(root.data);
        storingInorderTraversal(root.right, inorderArray);
    }

    private static void changingNodewithPrecedessorAndSuccessor(Node root, List<Integer> inorderArray){

        if(root == null){
            return;
        }

        changingNodewithPrecedessorAndSuccessor(root.left, inorderArray);
        root.data = inorderArray.get(i-1) + inorderArray.get(i+1);
        i++;
        changingNodewithPrecedessorAndSuccessor(root.right, inorderArray);
    }

}

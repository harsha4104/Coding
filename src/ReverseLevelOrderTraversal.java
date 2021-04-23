import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);
        root.right.left.left = new Node(8);


        reverseLevelOrder(root);

        int height = heightOfBinaryTree(root);

        System.out.println();

        for(int i= height; i>=1; i--){
            recursiveLevelOrderTraversal(root, i);
        }

    }

    private static void reverseLevelOrder(Node root){
        Stack<Integer> stack = new Stack<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            Node temp = queue.poll();
            stack.push(temp.data);

            if(temp.right != null){
                queue.add(temp.right);
            }

            if(temp.left != null){
                queue.add(temp.left);
            }
        }

        while(!stack.isEmpty()){

            int item = stack.pop();
            System.out.print(item + " ");
        }
    }

    private static int heightOfBinaryTree(Node root){

        if(root == null){
            return 0;
        }

        int lheight = heightOfBinaryTree(root.left);
        int rheight = heightOfBinaryTree(root.right);

        if(lheight > rheight)
            return lheight+1;
        else
            return rheight+1;
    }

    private static void recursiveLevelOrderTraversal(Node root, int level){

        if(root == null)
            return;

        if(level == 1)
        {
            System.out.print(root.data + " ");
        }

        recursiveLevelOrderTraversal(root.left, level-1);
        recursiveLevelOrderTraversal(root.right, level-1);
    }
}

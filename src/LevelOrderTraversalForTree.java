import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalForTree {

    public static void main(String args[]){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);
        root.right.left.left = new Node(8);


        int height = heightOfBinaryTree(root);

        for(int i = 1; i <= height ;i++){
            levelOrderTraversal(root, i);
        }

        System.out.println();
        levelOrderTraversalUsingQueue(root);
    }

    private static int heightOfBinaryTree(Node root){

        if(root == null)
            return 0;

        int lheight = heightOfBinaryTree(root.left);
        int rheight = heightOfBinaryTree(root.right);

        if(lheight > rheight)
            return lheight+1;
        else
            return rheight+1;
    }

    private static void levelOrderTraversal(Node root, int level){

        if(root == null)
            return;

        if(level == 1)
            System.out.print(root.data+ " ");

        levelOrderTraversal(root.left, level-1);
        levelOrderTraversal(root.right,level-1);
    }

    private static void levelOrderTraversalUsingQueue(Node root){

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while(!queue.isEmpty()){

            Node node = queue.poll();
            System.out.print(node.data+ " ");

            if(node.left != null) {
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }

        }

    }
}



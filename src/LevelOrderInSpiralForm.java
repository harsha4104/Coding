import java.util.Stack;

public class LevelOrderInSpiralForm {


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

        boolean flag = false;
        for(int i = 1; i <= height ;i++){
            levelOrderTraversal(root, i, flag);
            flag = !flag;
        }

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


    private static void levelOrderTraversal(Node root, int level, boolean flag){

        if(root == null)
            return;

        if(level == 1)
            System.out.print(root.data+ " ");

        if(flag) {
            levelOrderTraversal(root.left, level - 1, flag);
            levelOrderTraversal(root.right, level - 1, flag);
        }
        else{
            levelOrderTraversal(root.right, level - 1, flag);
            levelOrderTraversal(root.left, level - 1, flag);
        }
    }

    private static void levelOrderUsingTwoStacks(Node root){
        Stack<Node> stack1 = new Stack<>();

        Stack<Node> stack2 = new Stack<>();


        while(!stack1.empty() || !stack2.empty()){

        }
    }

}

import java.util.*;

public class PerfectBiinaryTreeSpecificOrderTraversal {

    public static void main(String args[]){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node(5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node (10);
        root.left.right.right = new Node (11);
        root.right.left.left =  new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        int height = heightOfBinaryTree(root);

        System.out.print(root.data + " ");

        for(int i =2; i<= height; i++){
            List<Integer> dataList = new ArrayList<>();
            levelOrderTraversal(root, i, dataList);
            int k = (int) Math.pow(2, i-1) -1;
            for(int j = 0; j < k ;j++,k--){
                System.out.print(dataList.get(j) + " " + dataList.get(k) + " ");
            }
        }

        System.out.println();

        usingQueue(root);

        System.out.println();

        reverseSpecificLevelOrderTraversal(root);
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

    private static void levelOrderTraversal(Node root, int level, List<Integer> dataList){

        if(root == null)
            return;

        if(level == 1){
            dataList.add(root.data);
        }

        levelOrderTraversal(root.left,level-1, dataList);
        levelOrderTraversal(root.right, level-1, dataList);
    }

    private static void usingQueue(Node root){
        Queue<Node> queue = new LinkedList<>();

        System.out.print(root.data + " ");

        Node first = null;
        Node second = null;

        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){

            first = queue.poll();
            second = queue.poll();

            System.out.print(first.data + " ");
            System.out.print(second.data+ " ");

            if(first.left != null) {
                queue.add(first.left);
            }

            if(second.right != null) {
                queue.add(second.right);
            }

            if(first.right != null) {
                queue.add(first.right);
            }

            if(second.left != null) {
                queue.add(second.left);
            }
        }
    }

    public static void reverseSpecificLevelOrderTraversal(Node root){
        Stack<Integer> stack = new Stack<>();

        stack.push(root.data);

        Queue<Node> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);

        Node first,second = null;

        while(!queue.isEmpty()){

            first = queue.poll();
            second = queue.poll();

            stack.push(second.data);
            stack.push(first.data);

            if(first.right != null){
                queue.add(first.right);
            }

            if(second.left != null){
                queue.add(second.left);
            }


            if(first.left != null){
                queue.add(first.left);
            }

            if(second.right != null){
                queue.add(second.right);
            }

        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() +" ");
        }
    }
}

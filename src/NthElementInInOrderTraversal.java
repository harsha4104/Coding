import java.util.ArrayList;
import java.util.List;

public class NthElementInInOrderTraversal {

    static int nthNodeData = -1;
    static int count = 0;
    public static void main(String args[]){

        Node root = new Node(5);
        int n = 5;
        root.left = new Node(6);
        root.right = new Node(7);
        root.right.left = new Node (10);
        root.right.right = new Node(15);
        root.right.right.left = new Node (30);


        List<Integer> integerList  = new ArrayList<>();

        inorderTraversal(root, integerList);

        System.out.println(integerList.get(n-1));

        for(int i = 0; i < integerList.size(); i++){
            System.out.print(integerList.get(i) + " ");
        }

        secondApproach(root, n);

        System.out.println();

        System.out.println(nthNodeData);
    }

    private static void inorderTraversal(Node root, List<Integer> integerList){

        if(root == null){
            return;
        }

        inorderTraversal(root.left, integerList);
        integerList.add(root.data);
        inorderTraversal(root.right, integerList);
    }

    private static void secondApproach(Node root, int n){

        if(root == null){
            return;
        }

        secondApproach(root.left, n);
        count++;

        if(count == n){
            nthNodeData = root.data;
        }
        secondApproach(root.right, n);
    }
}

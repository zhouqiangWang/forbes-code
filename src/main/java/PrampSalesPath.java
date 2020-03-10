import java.io.*;
import java.util.*;

class PrampSalesPath {

    static class Node {
        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {
        int minCost = Integer.MAX_VALUE;
        int getCheapestCost(Node rootNode) {
            // your code goes here
            if (rootNode == null) {
                return -1;
            }
            dfs(rootNode, 0);
            return minCost;
        }
        void dfs(Node root, int cost) {
            if (root.children == null) {
                minCost = Math.min(cost, minCost);
                return;
            }
            for (Node child : root.children) {
//                if (child.children != null) {
                    dfs(child, cost + child.cost);
//                }
            }
        }
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    /**
     *
     *
     **/

    public static void main(String[] args) {
        Node root = new Node(0);
        Node node5 = new Node(5);
        Node node4 = new Node(4);

        node5.children = new Node[]{node4};

        Node node3 = new Node(3);

        root.children = new Node[]{node5, node3};

        Node node2 = new Node(2);
        Node node0 = new Node(0);
        node3.children = new Node[]{node2, node0};

        Node node1 = new Node(1);
        node2.children = new Node[]{node1};

        Node node11 = new Node(1);
        node1.children = new Node[]{node11};

        Node node10 = new Node(10);
        node0.children = new Node[]{node10};

        SalesPath instance = new SalesPath();

        System.out.println(instance.getCheapestCost(root));
    }
}
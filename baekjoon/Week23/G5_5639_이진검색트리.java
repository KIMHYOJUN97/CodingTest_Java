package baekjoon.Week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_5639_이진검색트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int root = Integer.parseInt(br.readLine());
        Node head = new Node(root, null, null);
        while (true) {
            String value = br.readLine();
            if(value==null || value.equals("")) break;
            head.insert(Integer.parseInt(value));
        }

        postOrder(head);
    }

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void insert(int value) {
            if (value < this.value) {
                if (this.left == null) this.left = new Node(value, null, null);
                else this.left.insert(value);
            } else {
                if(this. right == null) this.right = new Node(value, null, null);
                else this.right.insert(value);
            }
        }
    }

    static void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}

package baekjoon.Week3_Tree;

import java.util.*;
import java.io.*;

public class 트리순회_1991 {
    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node tmp, char root, char left, char right) {
        if (tmp.value == root) {
            tmp.left = (left == '.' ? null : new Node(left, null, null));
            tmp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if(tmp.left!=null) insertNode(tmp.left, root, left, right);
            if(tmp.right!=null) insertNode(tmp.right,root,left,right);
        }
    }

    public static void preorder(Node node) {
        if(node==null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if(node==null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node head = new Node('A', null, null);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head,root,left,right);
        }

        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);
    }
}

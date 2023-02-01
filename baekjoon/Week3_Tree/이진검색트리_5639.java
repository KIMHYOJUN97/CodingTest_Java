package baekjoon.Week3_Tree;

import java.util.*;
import java.io.*;

public class 이진검색트리_5639 {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        //v가 현재 root의 value보다 작다면 왼쪽서브트리에 크다면 오른쪽 서브트리에 insert해서 트리를 구성하여 준다.
        void insert(int v) {
            if (v < this.value) {
                if (this.left == null) this.left = new Node(v, null, null);
                else this.left.insert(v);
            } else {
                if(this.right == null) this.right = new Node(v, null, null);
                else this.right.insert(v);
            }
        }
    }

    static void post(Node node) {
        if(node==null) return;

        post(node.left);
        post(node.right);
        System.out.println(node.value);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int root = Integer.parseInt(br.readLine());
        Node head = new Node(root, null, null);
        while (true) {
            String value = br.readLine();
            if(value == null || value.equals("")) break;
            head.insert(Integer.parseInt(value));
        }

        post(head);
    }
}

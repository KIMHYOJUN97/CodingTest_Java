package baekjoon.Week3_Tree;

import java.util.*;
import java.io.*;

public class 트리_1068 {

    static class Node {
        int root;
        int value;
        Node left;
        Node right;

        public Node(int root, int value, Node left, Node right) {
            this.root = root;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

//    static void insertNode(Node tmp,int root, int value )

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int del_num = Integer.parseInt(br.readLine());

        Node head = new Node(-1,0,null,null);
        for (int i = 1; i < input.length; i++) {

        }
    }
}

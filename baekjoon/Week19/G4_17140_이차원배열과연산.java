package baekjoon.Week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_17140_이차원배열과연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = stoi(st.nextToken())-1;
        int c = stoi(st.nextToken())-1;
        int k = stoi(st.nextToken());
        List<List<Integer>> board = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            board.add(new ArrayList<>());
        }
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board.get(i).add(stoi(st.nextToken()));
            }
        }
        int i = 0;
        boolean flag = false;
        while (i < 100) {
            if (board.size() > r && board.get(0).size() > c) {
                if (board.get(r).get(c) == k) {
                    flag = true;
                    break;
                }
            }
            if (checkRC(board)) {
                board = rSort(board);
            }else{
                board = cSort(board);
            }
            i++;
        }

        if(flag) System.out.println(i);
        else System.out.println(-1);
    }

    //R정렬
    static public List<List<Integer>> rSort(List<List<Integer>> list) {

        //행마다 각각 포함된 숫자와 숫자의 개수를 알아야 함. 맵으로 알고 Node에 넣어서 정렬해주기
        List<List<Integer>> newList = new ArrayList<>();

        //가장 긴 행의 열개수를 알아야 함.->나머지를 0으로 채워넣기 위해
        int maxCount = 0;

        for (int i = 0; i < list.size(); i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < list.get(i).size(); j++) {
                map.put(list.get(i).get(j), map.getOrDefault(list.get(i).get(j), 0) + 1);
            }
            //map에 각각 뭐있는지 넣고 Node로 돌려줌
            List<Node> nodes = new ArrayList<>();
            for (Integer k : map.keySet()) {
                nodes.add(new Node(k, map.get(k)));
            }
            //정해진 순서대로 정렬
            Collections.sort(nodes);
            newList.add(new ArrayList<>());
            for (Node node : nodes) {
                //0이면 제외시켜주기
                if(node.number==0)continue;
                newList.get(i).add(node.number);
                newList.get(i).add(node.count);
            }
            maxCount = Math.max(newList.get(i).size(), maxCount);
        }

        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i).size() < maxCount) {
                int diff = maxCount - newList.get(i).size();
                for (int j = 0; j < diff; j++) {
                    newList.get(i).add(0);
                }
            }
        }

        return newList;
    }


    //C정렬
    static public List<List<Integer>> cSort(List<List<Integer>> list) {
        List<List<Integer>> newList = new ArrayList<>();

        //0채워넣기 위해 행이 젤 긴거 찾기
        int maxCount = 0;

        //가로검사 해야함!
        for (int i = 0; i < list.get(0).size(); i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                map.put(list.get(j).get(i), map.getOrDefault(list.get(j).get(i), 0) + 1);
            }
            List<Node> nodes = new ArrayList<>();
            for (int k : map.keySet()) {
                if(k==0)continue;
                nodes.add(new Node(k, map.get(k)));
            }
            maxCount = Math.max(maxCount, nodes.size());
            Collections.sort(nodes);
            //maxCount만큼 배열길이 늘려줘야 함
            if (newList.size() < maxCount * 2) {
                int diff = maxCount * 2 - newList.size();
                for (int j = 0; j < diff; j++) {
                    newList.add(new ArrayList<>());
                }
            }

            //늘어났으니 이제 넣어줘도 됨.
            int nodeSize = nodes.size();
            for (int j = 0; j < nodeSize; j++) {
                newList.get(j).add(nodes.get(j).number);
                newList.get(j+1).add(nodes.get(j).count);
            }
        }

        maxCount = 0;
        for (int i = 0; i < newList.size(); i++) {
            maxCount = Math.max(newList.get(i).size(), maxCount);
        }

        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i).size() < maxCount) {
                int diff = maxCount - newList.get(i).size();
                for (int j = 0; j < diff; j++) {
                    newList.get(i).add(0);
                }
            }
        }

        return newList;
    }


    //가로 세로 길이 체크 로직
    //R정렬일때 true
    //C정렬일때 false
    static boolean checkRC(List<List<Integer>> list) {
        int maxR = 0;
        int maxC = 0;

        maxR = list.size();
        for (List<Integer> lists : list) {
            maxC = Math.max(maxC, lists.size());
        }

        if(maxR>=maxC)return true;
        else return false;
    }

    static class Node implements Comparable<Node>{
        int number;
        int count;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public int compareTo(Node node) {
            if (count == node.count) {
                return number - node.number;
            } else {
                return count - node.count;
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

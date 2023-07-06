package programmers;

import java.util.*;

public class lv2_1차프렌즈4블록 {
    class Solution {
        int[] dx = {1,0,1,0};
        int[] dy = {0,1,1,0};

        public int solution(int m, int n, String[] boards) {
            int answer = 0;
            String[][] board = new String[m][n];
            for(int i=0;i<boards.length;i++){
                String[] inputs = boards[i].split("");
                for(int j=0;j<n;j++){
                    board[i][j] = inputs[j];
                }
            }
            //삭제큐가 없을때까지 수행
            while(true){
                //삭제가 실행될 좌표값들을 모아놓는 큐
                Queue<Node> queue = new LinkedList<>();
                for(int i=0;i<board.length;i++){
                    for(int j=0;j<board[i].length;j++){
                        //now가 빈 칸을 나타내면 넘어감!
                        String now = board[i][j];
                        int cnt = 0;
                        for(int k=0;k<3;k++){
                            int nx = j + dx[k];
                            int ny = i + dy[k];
                            if(nx>=0 && ny>=0 && nx<n && ny<m && !board[ny][nx].equals("1")){
                                if(board[ny][nx].equals(now))cnt++;
                                else break;
                            }
                        }
                        if(cnt==3){
                            for(int k=0;k<4;k++){
                                Node node = new Node(j+dx[k],i+dy[k]);
                                //일단 넣어놓고 없앨 때, board[i][j]가 이미 -1이면 그땐 answer을 추가 안해주는 방식으로 풀어내기
                                queue.add(node);
                            }
                        }
                    }
                }

                //큐에 더이상 값이 없으면 탈출!
                if(queue.isEmpty())break;

                //큐에 넣은 값들 하나씩 빼보기
                while(!queue.isEmpty()){
                    Node q = queue.poll();
                    if(!board[q.y][q.x].equals("1")){
                        answer++;
                        board[q.y][q.x] = "1";
                    }
                }

                //아래로 블록 내려주기,x축 돌면서
                for(int i=0;i<n;i++){
                    //맨 아래 블록부터 위로 보는 관점의 전환.
                    for(int j=m-1;j>0;j--){
                        if(board[j][i].equals("1")){
                            int k = j-1;
                            int target = -1;
                            while(k>=0){
                                if(!board[k][i].equals("1")){
                                    target=k;
                                    break;
                                }
                                k--;
                            }
                            //만약 위에 발견됐으면
                            if(target != -1){
                                board[j][i]=board[target][i];
                                board[target][i] = "1";
                            }
                        }
                    }
                }

            }

            return answer;
        }

        class Node{
            int x;
            int y;

            public Node(int x,int y){
                this.x = x;
                this.y = y;
            }
        }
    }
}

package programmers;
import java.util.*;
public class lv2_리코쳇로봇 {

    static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x,int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] graph;
    public static void main(String[] args) {
            int answer = 0;
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
            graph = new int[board.length][board[0].length()];
            boolean[][] visited = new boolean[board.length][board[0].length()];
            Node goal=null;
            Node start=null;
            for(int i=0;i<board.length;i++){
                String[] inputs = board[i].split("");
                for(int j=0;j<inputs.length;j++){
                    if(inputs[j].equals("D")){
                        graph[i][j] = -1;
                    }else if(inputs[j].equals("R")){
                        graph[i][j] = 0;
                        start = new Node(j,i,0);
                    }else if(inputs[j].equals("G")){
                        graph[i][j] = 0;
                        goal = new Node(j,i,0);
                    }else{
                        graph[i][j] = 0;
                    }

                }
            }

            Queue<Node> q = new LinkedList<>();
            q.add(start);
            while(!q.isEmpty()){
                Node now = q.poll();
                visited[now.y][now.x] = true;
                for(int i=0;i<4;i++){
                    int[] xy = getXY(now.x,now.y,i);
                    int nx = xy[0];
                    int ny = xy[1];
                    if(nx >=0 && ny>=0 && nx < graph[0].length && ny <board.length
                            && visited[ny][nx] != true && graph[ny][nx] != -1
                    ){
                        if(goal.x == nx && goal.y == ny){
                            System.out.println(now.cnt+1);
                            return;
                        }
                        visited[ny][nx] = true;
                        Node nxy = new Node(nx,ny,now.cnt+1);
                        q.add(nxy);
                    }
                }
            }

            System.out.println(-1);
        }

        static int[] getXY(int x,int y,int idx){
            int nx = x;
            int ny = y;
            while(nx+dx[idx]>=0 && ny+dy[idx]>=0 && nx + dx[idx] <graph[0].length
                    && ny + dy[idx] <graph.length &&
                    graph[ny+dy[idx]][nx+dx[idx]] != -1
            ){
                nx += dx[idx];
                ny += dy[idx];
            }
            int[] xy = {nx,ny};
            return xy;
        }

}

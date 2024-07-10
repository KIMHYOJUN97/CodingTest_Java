package programmers;

public class lv2_공원산책 {
    public int[] solution(String[] park, String[] routes) {
        Node start = null;
        for (int i = 0; i < park.length; i++) {
            String[] s = park[i].split("");
            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("S")) {
                    start = new Node(j, i);
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] s = routes[i].split(" ");
            int len = stoi(s[1]);
            if (s[0].equals("E")) {
                if (start.x + len < park[0].length()) {
                    boolean flag = true;
                    for (int j = start.x + 1; j < start.x + len; j++) {
                        if (park[start.y].charAt(j) == 'X') {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        start.x += len;
                    }
                }
            } else if (s[0].equals("W")) {
                if (start.x - len >= 0) {
                    boolean flag = true;
                    for (int j = start.x - 1; j >= start.x - len; j--) {
                        if (park[start.y].charAt(j) == 'X') {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        start.x -= len;
                    }
                }
            } else if (s[0].equals("S")) {
                if (start.y - len >= 0) {
                    boolean flag = false;
                    while (len >= 0) {
                        len--;
                        if (park[start.y - 1].charAt(start.x) == 'X') {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        start.y -= len;
                    }
                }
            } else {
                if (start.y + len < park.length) {
                    boolean flag = false;
                    for (int j = start.y + 1; j < start.y + len; j++) {
                        if (park[j].charAt(start.x) == 'X') {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        start.y += len;
                    }
                }
            }
        }

        int[] ans = {start.y, start.x};
        return ans;
    }

    int stoi(String s) {
        return Integer.parseInt(s);
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

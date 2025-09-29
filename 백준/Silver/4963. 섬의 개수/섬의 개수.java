import java.io.*;
import java.util.*;

public class Main {
    static int w, h;              
    static int[][] map;           
    static boolean[][] visited;   

    static final int[] dr = {-1,-1,-1, 0, 0, 1, 1, 1};
    static final int[] dc = {-1, 0, 1,-1, 1,-1, 0, 1};

    // 좌표 클래스
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // BFS 탐색
    static void bfs(int sr, int sc) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sr, sc));
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int k = 0; k < 8; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];

                // 범위 체크
                if (0 <= nr && nr < h && 0 <= nc && nc < w) {
                    // 방문하지 않은 땅이면 큐에 추가
                    if (!visited[nr][nc] && map[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        q.add(new Node(nr, nc));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            // 지도 입력
            for (int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < w; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            // 섬 개수 세기
            int count = 0;
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (!visited[r][c] && map[r][c] == 1) {
                        bfs(r, c); // 새로운 섬 탐색 시작
                        count++;
                    }
                }
            }
            out.append(count).append('\n');
        }
        System.out.print(out.toString());
    }
}

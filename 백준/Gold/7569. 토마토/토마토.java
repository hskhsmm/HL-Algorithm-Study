import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H; 
    static int[][][] arr;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로 
        N = Integer.parseInt(st.nextToken()); // 세로 
        H = Integer.parseInt(st.nextToken()); // 높이

        arr = new int[H][N][M]; //높이, 행, 열 초기화

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                    if (arr[h][n][m] == 1) {
                        q.add(new int[]{h, n, m}); 
                    }
                }
            }
        }

        System.out.println(bfs()); 
    }

    public static int bfs() {
        int days = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean ripe = false;

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int z = cur[0], y = cur[1], x = cur[2];

                for (int d = 0; d < 6; d++) {
                    int nz = z + dz[d];
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        if (arr[nz][ny][nx] == 0) { 
                            arr[nz][ny][nx] = 1; 
                            q.add(new int[]{nz, ny, nx}); // 큐에 추가
                            ripe = true;
                        }
                    }
                }
            }
            if (ripe) {
                days++; // 하루 경과
            }
        }

        // 토마토 확인
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 0) {
                        return -1;
                    }
                }
            }
        }
        return days; 
    }
}

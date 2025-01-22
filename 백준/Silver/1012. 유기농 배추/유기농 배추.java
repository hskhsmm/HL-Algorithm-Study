import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] cabbage; // 배추밭 정보를 저장하는 2차원 배열
    static boolean[][] visited; // 방문 여부를 저장하는 2차원 배열
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 x 변화량
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동을 위한 y 변화량
    static int M, N, K; // M: 가로 크기, N: 세로 크기, K: 배추 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) { // 각 테스트 케이스를 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추밭의 가로 크기
            N = Integer.parseInt(st.nextToken()); // 배추밭의 세로 크기
            K = Integer.parseInt(st.nextToken()); // 배추의 위치 개수

            // 각 테스트 케이스마다 새롭게 배열 초기화
            cabbage = new int[M][N]; // 배추밭 배열 초기화
            visited = new boolean[M][N]; // 방문 여부 배열 초기화

            // 배추 위치 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 배추의 x좌표
                int y = Integer.parseInt(st.nextToken()); // 배추의 y좌표
                cabbage[x][y] = 1; // 배추가 있는 위치를 1로 표시
                // 문제에서 배추가 심어진 위치를 기준으로 그룹을 찾아야 함.
                // 이 위치를 1로 설정하여 다른 칸(0)과 구분.
            }

            int count = 0; // 배추 그룹의 수를 세기 위한 변수

            // 배추밭 전체를 순회하며 그룹을 탐색
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 현재 위치에 배추가 있고, 아직 방문하지 않았다면 새로운 그룹 발견
                    if (cabbage[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j); // 해당 위치를 기준으로 BFS로 연결된 모든 배추 방문
                        count++; // 그룹 개수를 증가
                        // **왜?** 새로운 그룹의 시작점이므로 그룹의 수를 1 증가.
                    }
                }
            }

            // 결과 출력: 테스트 케이스별 배추 그룹의 수
            System.out.println(count);
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>(); // BFS를 위한 큐 선언
        q.add(new Point(x, y)); // 시작 위치를 큐에 추가
        visited[x][y] = true; // 시작 위치를 방문 처리
        // **왜?** 시작점을 큐에 추가하고 방문 처리함으로써 BFS를 시작할 준비함.

        while (!q.isEmpty()) { // 큐가 빌 때까지 반복
            Point p = q.poll(); // 큐에서 현재 위치를 가져옴

            for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                int nx = p.x + dx[i]; // 새로운 x 좌표
                int ny = p.y + dy[i]; // 새로운 y 좌표

                // 왜 유효성 검사?
                // 1. nx와 ny가 배추밭의 범위를 벗어나면 안 됨.
                // 2. 방문하지 않았으며 배추가 있는 위치(`1`)만 큐에 추가해야 함.
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) { // 범위 확인
                    if (!visited[nx][ny] && cabbage[nx][ny] == 1) { // 방문 가능 여부 확인
                        q.add(new Point(nx, ny)); // 큐에 추가
                        visited[nx][ny] = true; // 방문 처리
                        // 연결된 배추를 모두 탐색하며, 중복 방문을 방지
                    }
                }
            }
        }
    }
}

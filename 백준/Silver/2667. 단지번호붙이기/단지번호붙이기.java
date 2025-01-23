import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static int arr[][];  // 지도
    static boolean check[][];  // 방문 여부
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  // 지도 크기 N

        arr = new int[N][N];
        check = new boolean[N][N];

        // 지도 입력받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();  // 한 줄씩 입력받아서
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';  // '0'을 빼서 0 또는 1로 저장
            }
        }

        ArrayList<Integer> countSize = new ArrayList<>();  // 각 단지의 크기를 저장할 리스트

        // 모든 칸을 확인하여 단지를 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !check[i][j]) {  // 집이 있고, 방문하지 않았다면
                    int count = dfs(i, j);  // dfs 호출하여 단지 크기 계산
                    countSize.add(count);  // 단지 크기 리스트에 추가
                }
            }
        }

        Collections.sort(countSize);  // 단지 크기 오름차순 정렬

        System.out.println(countSize.size());  // 단지의 개수 출력
        for (int size : countSize) {
            System.out.println(size);  // 각 단지의 크기 출력
        }
    }

    // dfs 함수 : 단지의 크기를 계산하고, 방문한 곳은 check 배열에 표시
    static int dfs(int x, int y) {
        check[x][y] = true;  // 현재 칸을 방문 처리
        int count = 1;  // 현재 칸을 포함하여 시작

        // 네 방향으로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 유효한 범위 내에서 아직 방문하지 않았고 집이 있으면 dfs 호출
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!check[nx][ny] && arr[nx][ny] == 1) {
                    count += dfs(nx, ny);  // 단지 크기 누적
                }
            }
        }
        return count;  // 계산된 단지 크기 반환
    }
}

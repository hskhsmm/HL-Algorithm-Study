import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<Integer>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    int x_front = Integer.parseInt(st.nextToken());
                    deque.addFirst(x_front);
                    break;

                case "push_back":
                    int x_back = Integer.parseInt(st.nextToken());
                    deque.addLast(x_back);
                    break;

                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(deque.pollFirst()).append('\n');
                    }
                    break;

                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(deque.pollLast()).append('\n');
                    }
                    break;

                case "size":
                    sb.append(deque.size()).append('\n');
                    break;

                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "front":
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(deque.peekFirst()).append('\n');
                    }
                    break;

                case "back":
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(deque.peekLast()).append('\n'); // 제거 없이 조회
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}

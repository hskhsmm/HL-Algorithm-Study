import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //1부터 시작
        int arr1[] = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int arr2[] = new int[M+1];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1, 1, N + 1);  // 인덱스 1 ~ N만 정렬

        //이진탐색으로 존재 여부 확인
        StringBuilder result = new StringBuilder();
        for(int i=1; i<=M; i++) {
            if(binarySearch(arr1,arr2[i])) {
                result.append(1).append("\n");
            } else {
                result.append(0).append("\n");
            }
        }
        System.out.println(result);
    }

    public static boolean binarySearch(int[] arr, int target) {

        int left = 1, right = arr.length-1;
        while(left <= right) {
            int mid = (left + right)/2;
            if(arr[mid] == target) {
                return true;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

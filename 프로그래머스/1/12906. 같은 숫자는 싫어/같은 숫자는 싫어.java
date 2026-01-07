import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int prev = arr[0];      // 이전 값
        list.add(prev);         // 첫 값은 무조건 추가

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != prev) {
                list.add(arr[i]);
                prev = arr[i];  // 이전 값 갱신
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

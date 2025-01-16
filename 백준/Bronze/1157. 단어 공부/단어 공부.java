import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toUpperCase();
        int[] count = new int[26];

        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i) - 'A']++;
        }

        int maxCount = 0;
        char result = '?';

        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                result = (char) (i+'A');
            } else if (count[i] == maxCount) {
                result = '?';
            }
        }
        System.out.println(result);
    }
}
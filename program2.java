import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (s.length() >= 1 && s.length() <= 20000) {
            System.out.println(maxSheriffs(s));
        } else {
            System.out.println("Вы ввели слишком длинную строку или же ничего не ввели");
        }
    }

    public static int maxSheriffs(String s) {
        Map<Character, Integer> letters = new HashMap<>();

        for (char c : s.toCharArray()) {
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }

        int maxWords = 20000 / 7;

        for (char c : "sheriff".toCharArray()) {
            if (letters.containsKey(c)) {
                maxWords = Math.min(maxWords, letters.get(c));
            } else {
                maxWords = 0;
                break;
            }
        }

        return maxWords;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        String[] prices = scanner.nextLine().split(" ");

        int n = Integer.parseInt(numbers[0]);
        int s = Integer.parseInt(numbers[1]);

        List<Integer> availableRev = new ArrayList<>();

        if (numbers.length == 2) {
            if (n < 1 || n > 20000 || s < 1 || s > 1000000000) {
                System.out.println("Вы ввели неверные числа");
            } else if (prices.length == n) {
                for (String price : prices) {
                    int revolverPrice = Integer.parseInt(price);
                    if (revolverPrice < s) {
                        availableRev.add(s - revolverPrice);
                    }
                }
                if (!availableRev.isEmpty()) {
                    int minAvailableRev = s - availableRev.stream().min(Integer::compare).orElse(0);
                    System.out.println(minAvailableRev);
                } else {
                    System.out.println(0);
                }
            } else {
                System.out.println("Пожалуйста, введите верное количество цен на револьверы");
            }
        } else {
            System.out.println("Пожалуйста, введите два числа через пробел.");
        }
    }
}
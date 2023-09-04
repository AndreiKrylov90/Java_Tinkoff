import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class program4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        String[] nominalStrings = scanner.nextLine().split(" ");

        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);

        List<Integer> nominals = new ArrayList<>();
        List<Integer> doubleNominals = new ArrayList<>();

        boolean check = true;

        for (String nominalString : nominalStrings) {
            int nominal = Integer.parseInt(nominalString);
            nominals.add(nominal);
            doubleNominals.add(nominal);
            doubleNominals.add(nominal);
            if (nominal < 1 || nominal > 1000000000) {
                check = false;
            }
        }

        doubleNominals.sort((a, b) -> b - a);

        int count = 0;
        List<Integer> winNominals = new ArrayList<>();

        if (numbers.length == 2 && nominals.size() == m && n >= 1 && n <= 1000000000 && m >= 1 && m <= 10 && check) {
            for (int i : doubleNominals) {
                if (n >= i) {
                    n -= i;
                    count++;
                    winNominals.add(i);
                }
            }

            winNominals.sort(null);
            String finalNominals = String.join(" ", winNominals.stream().map(String::valueOf).toArray(String[]::new));

            if (n == 0) {
                System.out.println(count);
                System.out.println(finalNominals);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println("Вы ввели что-то не то");
        }
    }
}
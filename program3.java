import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> aNumbers = new ArrayList<>();
        List<Integer> winNumbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            aNumbers.add(scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            winNumbers.add(scanner.nextInt());
        }

        int result = 0;
        List<Integer> tempWinNumbers = new ArrayList<>(aNumbers);

        boolean firstCheck = true;
        boolean secondCheck = true;

        for (int i : aNumbers) {
            if (i < 1 || i > 1000000000) {
                firstCheck = false;
                break;
            }
        }

        for (int i : winNumbers) {
            if (i < 1 || i > 1000000000) {
                secondCheck = false;
                break;
            }
        }

        if (n >= 1 && n <= 200000 && aNumbers.size() == winNumbers.size() && firstCheck && secondCheck) {
            for (int i = 0; i < aNumbers.size(); i++) {
                for (int j = i; j < aNumbers.size(); j++) {
                    for (int a = 0; a < aNumbers.size(); a++) {
                        tempWinNumbers.set(a, aNumbers.get(a));
                    }

                    List<Integer> tempWins = new ArrayList<>(aNumbers.subList(i, j + 1));
                    tempWins.sort(null);
                    for (int k = i; k <= j; k++) {
                        tempWinNumbers.set(k, tempWins.get(k - i));
                    }

                    boolean check = false;

                    if (tempWinNumbers.equals(winNumbers)) {
                        check = true;
                        result++;
                    }

                    if (check) {
                        break;
                    }
                }
            }

            if (result > 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("Вы ввели что-то не то");
        }
    }
}
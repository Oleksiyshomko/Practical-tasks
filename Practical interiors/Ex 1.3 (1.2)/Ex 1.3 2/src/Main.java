import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ex12(16, "шістнадцятковий");
        Ex12(2, "двійковий");
    }

    static void Ex12(int x, String text) {
        System.out.println("Введіть " + text + " код для перетворення в ціле число ");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            String input = scanner.next();
            try {
                int intValue = Integer.parseInt(input, x);
                System.out.println(text + " перетворене на ціле число, має значення" + "\n" + intValue + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Введене значення не є шістнадцятковим або двійковим");
            }
        } else {
            System.out.println("Введене значення не є шістнадцятковим або двійковим");
        }
    }
}

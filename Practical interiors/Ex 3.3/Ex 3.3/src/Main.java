import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
            MyQueue<Integer> queue = new MyQueue<>();
            queue.offer(50);
            queue.offer(70);
            System.out.println(queue.peek());
        } catch (InputMismatchException e) {
            System.out.println("Некоректне введення. Будь ласка, введіть число.");
        }
    }
}

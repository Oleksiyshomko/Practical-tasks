import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмір масива: ");
        byte size = scanner.nextByte();
        double[] arr = new double[size];
        int count = -1;
        System.out.println("Введіть елементи масива: ");

        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextDouble();
            count++;
            System.out.printf("%s %d %s %-+1.1f%n", "mas[", count, "]=", arr[i]);
        }

        scanner.close();
    }
}
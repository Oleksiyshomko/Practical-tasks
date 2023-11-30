import java.util.Locale;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        new MyArrayList();
        Plane[] planesArray = new Plane[]{
                new PassangerPlane("Airbus A320", 180.0, 2.0, 2300.0, 250, 9000),
                new CargoPlane("Lockheed C-130 Hercules", 18000.0, 1200.0, 3.5, 1000.0, 150.0),
                new SportPlane("Cessna 172", 150.0, 15.0, 1200.0, 850.0, 2.0),
                new CargoPlane("Antonov An-12", 13000.0, 800.0, 2100.0, 550.0, 90.0),
                new SportPlane("Piper PA-28 Cherokee", 160.0, 10.0, 950.0, 800.0, 3.0)
        };
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int choice;
        do {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Загальна кількість пасажирів");
            System.out.println("2. Загальна вантажопідйомність");
            System.out.println("3. Сортування літаків");
            System.out.println("4. Пошук літака за параметрами");
            System.out.println("5. Інформація про літак");
            System.out.println("6. Вихід");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    int totalPassengers = AviaCompani.countPassengers(planesArray);
                    System.out.println("Загальна кількість пасажирів: " + totalPassengers);
                }
                case 2 -> {
                    double sumCargo = AviaCompani.countCargo(planesArray);
                    System.out.println("Загальна вантажопідйомність: " + sumCargo);
                }
                case 3 -> AviaCompani.sortFlightRange(planesArray);
                case 4 -> {
                    System.out.print("Введіть параметри для пошуку:\nНазва: ");
                    String searchName = scanner.next();
                    System.out.print("Дальність польоту: ");
                    double searchFlightRange = scanner.nextDouble();
                    System.out.print("Вантажопідйомність: ");
                    double searchCarryingCapacity = scanner.nextDouble();
                    System.out.print("Витрата пального: ");
                    double searchFuelConsumption = scanner.nextDouble();
                    Plane foundPlane = AviaCompani.findPlaneByParams(planesArray, searchName, searchFlightRange, searchCarryingCapacity, searchFuelConsumption);
                    if (foundPlane != null) {
                        System.out.println("Знайдений літак:");
                        System.out.println(foundPlane);
                    } else {
                        System.out.println("Літак із вказаними параметрами не знайдено.");
                    }
                }
                case 5 -> {
                    for (Plane plane : planesArray) {
                        plane.displayInfo();
                        if (plane instanceof CargoPlane cargoPlane) {
                            cargoPlane.displayCargoInfo();
                        } else if (plane instanceof SportPlane sportPlane) {
                            sportPlane.displaySportInfo();
                        }
                        System.out.println();
                    }
                }
                case 6 -> {
                    System.out.println("До нової зустрічі");
                    System.exit(0);
                }
            }
        } while (choice != 5);
    }
}

import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;
import java.util.ArrayList;

public class CityTravelCard {
    public static final int MAX_SCHOOL_TRIP_COUNT = 50;
    public static final int FARE_AMOUNT = 8;
    private static final ArrayList<MetroPass> internalCardStorage = new ArrayList<>();
    private static int countOfPermissions = 0;
    private static int countOfProhibitions = 0;

    public static MetroPass createPass(PassType passType) {
        MetroPass metroPass;
        switch (passType) {
            case SCHOOL_PASS -> metroPass = new SchoolPass(MAX_SCHOOL_TRIP_COUNT);
            case STUDENT_PASS -> metroPass = new StudentPass();
            case REGULAR_PASS -> metroPass = new RegularPass();
            default -> metroPass = new MetroPass();
        }
        internalCardStorage.add(metroPass);
        metroPass.setUid(metroPass.getUid() + 1);
        return metroPass;
    }

    public static void addPermission() {
        countOfPermissions++;
    }

    public static void addProhibition() {
        countOfProhibitions++;
    }

    public static int getCountOfPermissions() {
        return countOfPermissions;
    }

    public static int getCountOfProhibitions() {
        return countOfProhibitions;
    }

    // Removed unused methods
    public static int getTotalOfOverdueAndEmptyPass() {
        int count = 0;
        for (MetroPass metropass : internalCardStorage) {
            if (metropass instanceof SchoolPass pass) {
                if (pass.getCountOfTrip() == 0 || pass.getMonth().isBefore(YearMonth.now())) {
                    count++;
                }
            } else if (metropass instanceof StudentPass pass) {
                if (pass.getMonth().isBefore(YearMonth.now())) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void subtractFare(RegularPass regularPass) {
        if (regularPass.getAmountOfMoney() >= FARE_AMOUNT) {
            regularPass.setAmountOfMoney(regularPass.getAmountOfMoney() - FARE_AMOUNT);
        } else {
            System.out.println("Недостатньо коштів на картці");
        }
    }
}

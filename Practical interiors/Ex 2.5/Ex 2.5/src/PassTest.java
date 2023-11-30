import exception.RegularPassNotEnoughMoneyException;
import exception.SchoolPassOverdueException;
import exception.SchoolPassTripFinishedException;
import exception.StudentPassOverdueException;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

public class PassTest {
    public static void main(String[] args) {
        Turnstile turnstile = new Turnstile();
        var pass = CityTravelCard.createPass(PassType.SCHOOL_PASS);
        var pass2 = CityTravelCard.createPass(PassType.STUDENT_PASS);
        var pass3 = CityTravelCard.createPass(PassType.REGULAR_PASS);
        SchoolPass schoolPass = (SchoolPass) pass;
        StudentPass studentPass = (StudentPass) pass2;
        RegularPass regularPass = (RegularPass) pass3;
        regularPass.setAmountOfMoney(10);
        schoolPass.setMonth(YearMonth.now());

        studentPass.setMonth(YearMonth.of(2023, 8));
        try {
            turnstile.validateEntryPermission(schoolPass);
        } catch (SchoolPassOverdueException | StudentPassOverdueException |
                 SchoolPassTripFinishedException | RegularPassNotEnoughMoneyException exception) {
            System.err.println(exception.getMessage());
        }
    }
}

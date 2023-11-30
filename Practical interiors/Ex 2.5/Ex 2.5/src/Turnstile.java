import exception.RegularPassNotEnoughMoneyException;
import exception.SchoolPassOverdueException;
import exception.SchoolPassTripFinishedException;
import exception.StudentPassOverdueException;
import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

public class Turnstile {
    public void validateEntryPermission(MetroPass pass) throws SchoolPassOverdueException,
            StudentPassOverdueException, SchoolPassTripFinishedException, RegularPassNotEnoughMoneyException {
        if (pass instanceof SchoolPass schoolPass) {
            if (schoolPass.getMonth().isBefore(YearMonth.now())) {
                CityTravelCard.addProhibition();
                throw new SchoolPassOverdueException(schoolPass);
            } else if (schoolPass.getCountOfTrip() < 1) {
                CityTravelCard.addProhibition();
                throw new SchoolPassTripFinishedException(schoolPass);
            } else {
                CityTravelCard.addPermission();
                schoolPass.setCountOfTrip(schoolPass.getCountOfTrip() - 1);
            }
        } else if (pass instanceof StudentPass studentPass) {
            if (studentPass.getMonth().isBefore(YearMonth.now())) {
                CityTravelCard.addProhibition();
                throw new StudentPassOverdueException(studentPass);
            } else {
                CityTravelCard.addProhibition();
            }
        } else if (pass instanceof RegularPass regularPass) {
            if (regularPass.getAmountOfMoney() < 8) {
                CityTravelCard.addProhibition();
                throw new RegularPassNotEnoughMoneyException(regularPass);
            } else {
                CityTravelCard.subtractFare(regularPass);
                CityTravelCard.addPermission();
            }
        }
    }
}

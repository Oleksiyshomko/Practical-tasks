package exception;

import passes.SchoolPass;

import java.time.YearMonth;

public class SchoolPassOverdueException extends PassWithTermException {
    private final SchoolPass pass;

    public SchoolPassOverdueException(SchoolPass schoolPass) {
        this.pass = schoolPass;
    }

    public int calculateTermOfOverdue() {
        int countMonth = YearMonth.now().getMonthValue() - pass.getMonth().getMonthValue();
        int yearMonth = YearMonth.now().getYear() - pass.getMonth().getYear();
        return countMonth + yearMonth * 12;
    }

    @Override
    public String toString() {
        return "Помилка: Термін абонемента минув " + calculateTermOfOverdue() + " місяці(в) тому";
    }

}

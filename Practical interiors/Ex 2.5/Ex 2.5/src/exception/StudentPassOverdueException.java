package exception;

import passes.StudentPass;

import java.time.YearMonth;

public class StudentPassOverdueException extends PassWithTermException {
    private final StudentPass pass;

    public StudentPassOverdueException(StudentPass pass) {
        this.pass = pass;
    }

    public int calculateTermOfOverdue() {
        int countMonth = YearMonth.now().getMonthValue() - pass.getMonth().getMonthValue();
        int yearMonth = YearMonth.now().getYear() - pass.getMonth().getYear();
        return countMonth + yearMonth * 12;
    }

    @Override
    public String toString() {
        return "Помилка: Термін дії пропуску студента минув " + calculateTermOfOverdue() + " місяці(в) тому";
    }

}

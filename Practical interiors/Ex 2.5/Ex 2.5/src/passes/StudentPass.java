package passes;

import java.time.YearMonth;

public class StudentPass extends MetroPass {
    private YearMonth month;

    public StudentPass() {
    }

    public void setMonth(YearMonth month) {
        this.month = month;
    }

    public YearMonth getMonth() {
        return month;
    }
}

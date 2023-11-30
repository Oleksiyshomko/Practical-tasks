package exception;

import passes.SchoolPass;

public class SchoolPassTripFinishedException extends java.lang.Exception {
    private final SchoolPass pass;

    public SchoolPassTripFinishedException(SchoolPass schoolPass) {
        this.pass = schoolPass;
    }

    @Override
    public String toString() {
        return "Помилка: Шкільний абонемент " + pass.getUid() + " вичерпав ліміт поїздок";
    }

}

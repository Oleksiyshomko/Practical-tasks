package exception;

import passes.RegularPass;

public class RegularPassNotEnoughMoneyException extends java.lang.Exception {
    private final RegularPass pass;

    public RegularPassNotEnoughMoneyException(RegularPass regularPass) {
        this.pass = regularPass;
    }

    @Override
    public String toString() {
        return "Помилка: Недостатньо коштів на картці " + pass.getUid() +
                ". Залишилося тільки " + pass.getAmountOfMoney() + " грн";
    }

}

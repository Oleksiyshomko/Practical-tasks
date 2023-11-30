import java.util.Objects;

public class SportPlane extends Plane {
    private double maxSpeed;
    private double flightDuration;

    public SportPlane(String name, double flightRange, double carryingCapacity, double fuelConsumption, double maxSpeed, double flightDuration) {
        super(name, flightRange, carryingCapacity, fuelConsumption);
        this.maxSpeed = maxSpeed;
        this.flightDuration = flightDuration;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            SportPlane that = (SportPlane)o;
            return Double.compare(this.maxSpeed, that.maxSpeed) == 0 && Double.compare(this.flightDuration, that.flightDuration) == 0;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.maxSpeed, this.flightDuration});
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + "Спортивний літак{максимальна швидкість=" + this.maxSpeed + ", тривалість польоту=" + this.flightDuration + "}";

    }

    public void displaySportInfo() {
        System.out.println("Максимальна Швидкість: " + this.maxSpeed);
        System.out.println("Тривалість Польоту: " + this.flightDuration);
    }
}

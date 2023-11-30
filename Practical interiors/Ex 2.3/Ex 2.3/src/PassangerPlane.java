import java.util.Objects;

public class PassangerPlane extends Plane {
    private int numberPassenger;
    private int flightHeight;

    public PassangerPlane() {
    }

    public PassangerPlane(String name, double flightRange, double carryingCapacity, double fuelConsumption, int numberPassenger, int flightHeight) {
        super(name, flightRange, carryingCapacity, fuelConsumption);
        this.numberPassenger = numberPassenger;
        this.flightHeight = flightHeight;
    }

    public int getNumberPassenger() {
        return this.numberPassenger;
    }

    public int getFlightHeight() {
        return this.flightHeight;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            PassangerPlane that = (PassangerPlane) o;
            return this.getNumberPassenger() == that.getNumberPassenger() && this.getFlightHeight() == that.getFlightHeight();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getNumberPassenger(), this.getFlightHeight()});
    }

    public String toString() {
        String baseToString = super.toString();
        return baseToString + "Кількість пасажирів=" + this.numberPassenger + ", Висота польоту=" + this.flightHeight + "}";

    }

}
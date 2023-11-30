import java.util.Objects;

public class Plane implements Comparable<Plane> {
    private String name;
    private double flightRange;
    private double carryingCapacity;
    private double fuelConsumption;

    public Plane() {
    }

    public Plane(String name, double flightRange, double carryingCapacity, double fuelConsumption) {
        this.name = name;
        this.flightRange = flightRange;
        this.carryingCapacity = carryingCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public String getName() {
        return this.name;
    }

    public double getFlightRange() {
        return this.flightRange;
    }

    public double getCarryingCapacity() {
        return this.carryingCapacity;
    }

    public int compareTo(Plane other) {
        return Double.compare(this.getFlightRange(), other.getFlightRange());
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.flightRange, this.carryingCapacity, this.fuelConsumption});
    }

    public void displayInfo() {
        System.out.println("Назва: " + this.name);
        System.out.println("Дальність польоту: " + this.flightRange);
        System.out.println("Вантажопідйомність: " + this.carryingCapacity);
        System.out.println("Витрата пального: " + this.fuelConsumption);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Plane other = (Plane)obj;
            return Objects.equals(this.name, other.name) &&
                    Double.compare(this.flightRange, other.flightRange) == 0 &&
                    Double.compare(this.carryingCapacity, other.carryingCapacity) == 0 &&
                    Double.compare(this.fuelConsumption, other.fuelConsumption) == 0;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Літак{" +
                "назва='" + name + '\'' +
                ", дальність польоту=" + flightRange +
                ", вантажопідйомність=" + carryingCapacity +
                ", витрата пального=" + fuelConsumption +
                '}';
    }
}
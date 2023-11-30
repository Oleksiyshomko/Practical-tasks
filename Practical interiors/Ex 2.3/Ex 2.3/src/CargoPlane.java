import java.util.Objects;

public class CargoPlane extends Plane {
    public double maxLiftingWeight;
    private double cargoVolume;

    public CargoPlane() {
    }

    public CargoPlane(String name, double flightRange, double carryingCapacity, double fuelConsumption, double maxLiftingWeight, double cargoVolume) {
        super(name, flightRange, carryingCapacity, fuelConsumption);
        this.maxLiftingWeight = maxLiftingWeight;
        this.cargoVolume = cargoVolume;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            CargoPlane that = (CargoPlane) o;
            return Double.compare(this.maxLiftingWeight, that.maxLiftingWeight) == 0 && Double.compare(this.cargoVolume, that.cargoVolume) == 0;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.maxLiftingWeight, this.cargoVolume});
    }

    public double getMaxLiftingWeight() {
        return this.maxLiftingWeight;
    }

    public String toString() {
        String baseToString = super.toString();
        return baseToString + "Вантажний літак{максимальна вантажопідйомність=" + this.maxLiftingWeight + ", об'єм вантажу=" + this.cargoVolume + "}";
    }

    public void displayCargoInfo() {
        System.out.println("Максимальна вага підйому: " + this.maxLiftingWeight);
        System.out.println("Об'єм вантажу: " + this.cargoVolume);
    }
}

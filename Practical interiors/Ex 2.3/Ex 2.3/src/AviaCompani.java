import java.util.Arrays;

public class AviaCompani {
    public AviaCompani() {
    }

    public static double countCargo(Plane[] airplanes) {
        double sumCargo = 0.0;
        for (Plane plane : airplanes) {
            if (plane instanceof CargoPlane cargoPlane) {
                sumCargo += cargoPlane.getMaxLiftingWeight();
            }
        }
        return sumCargo;
    }

    public static int countPassengers(Plane[] airplanes) {
        int sumPassenger = 0;
        for (Plane plane : airplanes) {
            if (plane instanceof PassangerPlane passangerPlane) {
                sumPassenger += passangerPlane.getNumberPassenger();
            }
        }
        return sumPassenger;
    }

    public static void sortFlightRange(Plane[] planes) {
        Arrays.sort(planes);
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }

    public static Plane findPlaneByParams(Plane[] planesArray, String name, double flightRange, double carryingCapacity, double fuelConsumption) {
        for (Plane plane : planesArray) {
            if (plane.getName().equalsIgnoreCase(name) &&
                    Math.abs(plane.getFlightRange() - flightRange) < 0.01 &&
                    Math.abs(plane.getCarryingCapacity() - carryingCapacity) < 0.01 &&
                    Math.abs(plane.getFuelConsumption() - fuelConsumption) < 0.01) {
                return plane;
            }
        }
        return null;
    }
}

package simpletest;

public class DistanceCalc3D extends DistanceCalcEarth {
    /**
     * @param fromHeight in meters above 0
     * @param toHeight   in meters above 0
     */
    public double calcDist(double fromLat, double fromLon, double fromHeight,
                           double toLat, double toLon, double toHeight) {
        double len = super.calcDist(fromLat, fromLon, toLat, toLon);
        double delta = Math.abs(toHeight - fromHeight);
        return Math.sqrt(delta * delta + len * len);
    }

    @Override
    public String toString() {
        return "EXACT3D";
    }
}
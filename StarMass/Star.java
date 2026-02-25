import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;

    public double getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(double m) {
        this.magnitude = m;
    }

    public Star() {
        super();
        this.magnitude = 0.0;
    }

   public Star(String name, double x, double y, double z, double magnitude,  int   mass) {
    super(name, x, y, z, mass);
    this.magnitude = magnitude;
}

    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", this.name, this.magnitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Star that = (Star) obj;
        return Double.compare(that.x, this.x) == 0 &&
                Double.compare(that.y, this.y) == 0 &&
                Double.compare(that.z, this.z) == 0 &&
                Double.compare(that.magnitude, this.magnitude) == 0 &&
                Objects.equals(this.name, that.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z, magnitude);
    }

}
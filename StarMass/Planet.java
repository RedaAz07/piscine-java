import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star cenStar, double  mass) {
        super(name, x, y, z, mass);
        this.centerStar = cenStar;
    }

    public Star getCenterStar() {
        return this.centerStar;
    }

    public void setCenterStar(Star a) {
        this.centerStar = a;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Planet that = (Planet) obj;
        return Double.compare(that.x, this.x) == 0 &&
                Double.compare(that.y, this.y) == 0 &&
                Double.compare(that.z, this.z) == 0 &&
                Objects.equals(this.centerStar, that.centerStar) &&
                Objects.equals(this.name, that.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z, centerStar);
    }

    @Override
    public String toString() {
        return String.format("%s circles around %s at the %.3f AU", this.name, this.centerStar.name,
                getDistanceBetween(this, this.centerStar));
    }

}
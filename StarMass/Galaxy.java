import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Galaxy {
    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        this.celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return this.celestialObjects;
    }

    public void addCelestialObject(CelestialObject a) {

        celestialObjects.add(a);
    }

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> repartition = new HashMap<>();
        repartition.put("Star", 0);
        repartition.put("Planet", 0);
        repartition.put("Other", 0);

        for (CelestialObject obj : celestialObjects) {
            if (obj instanceof Star) {
                repartition.put("Star", repartition.get("Star") + (int)obj.getMass());
            } else if (obj instanceof Planet) {
                repartition.put("Planet", repartition.get("Planet") + (int)obj.getMass());
            } else {
                repartition.put("Other", repartition.get("Other") + (int)obj.getMass());
            }
        }
        return repartition;
    }

}
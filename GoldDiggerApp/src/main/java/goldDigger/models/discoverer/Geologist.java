package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer{
    private static final int ENERGY_GEOLOGIST = 100;

    public Geologist(String name) {
        super(name,ENERGY_GEOLOGIST);
    }
}

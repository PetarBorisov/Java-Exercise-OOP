package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer{
    private static final int ENERGY_ARCHEOLOGIST = 60;

    public Archaeologist(String name) {
        super(name, ENERGY_ARCHEOLOGIST);
    }
}

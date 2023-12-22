package goldDigger.models.discoverer;

public class Anthropologist extends BaseDiscoverer{

    private static final int ENERGY_ANTHROPOLOGIST = 40;

    public Anthropologist(String name) {
        super(name, ENERGY_ANTHROPOLOGIST);
    }
}

package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiscovererRepository implements Repository<Discoverer>{
    private Map<String,Discoverer> discovererMap;

    public DiscovererRepository() {
        this.discovererMap = new LinkedHashMap<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(this.discovererMap.values());
    }

    @Override
    public void add(Discoverer discoverer) {
       discovererMap.put(discoverer.getName(), discoverer);
    }

    @Override
    public boolean remove(Discoverer entity) {
        return discovererMap.remove(entity.getName()) != null;
    }

    @Override
    public Discoverer byName(String name) {
        return discovererMap.get(name);
    }
}

package model.piloto.inmemory;

import model.piloto.model.Pilot;
import model.piloto.repository.SavePilot;

import java.util.HashMap;
import java.util.Map;

public class InMemorySavePilot implements SavePilot {
    private final Map<String, Pilot> storage = new HashMap<>();

    @Override
    public boolean existsByDocument(String document) {
        return storage.containsKey(document);
    }

    @Override
    public void save(Pilot pilot) {
        storage.put(pilot.getDocument(), pilot);
    }

    public Pilot findByDocument(String document) {
        return storage.get(document);
    }
}

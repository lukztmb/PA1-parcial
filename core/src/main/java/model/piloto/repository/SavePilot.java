
package model.piloto.repository;

import model.piloto.model.Pilot;

public interface SavePilot {
    boolean existsByDocument(String document);

    void save(Pilot pilot);
}

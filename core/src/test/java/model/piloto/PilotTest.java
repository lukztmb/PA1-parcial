package model.piloto;

import model.piloto.exceptions.ExceptionPilot;
import model.piloto.model.Pilot;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PilotTest {

    @Test
    void createPilot_happyPath_generatesLicenseAndStoresFields() {
        LocalDate dob = LocalDate.now().minusYears(30);
        Pilot p = Pilot.create("Juan Perez", "ABC123", dob);
        assertNotNull(p.getLicense());
        assertEquals("Juan Perez", p.getName());
        assertEquals("ABC123", p.getDocument());
        assertEquals(dob, p.getBirthDate());
    }

    @Test
    void createPilot_missingName_throws() {
        LocalDate dob = LocalDate.now().minusYears(30);
        Exception ex = assertThrows(ExceptionPilot.class, () -> Pilot.create(null, "DOC1", dob));
        assertTrue(ex.getMessage().contains("Name is required"));
    }

    @Test
    void createPilot_underage_throws() {
        LocalDate dob = LocalDate.now().minusYears(10);
        Exception ex = assertThrows(ExceptionPilot.class, () -> Pilot.create("Young", "DOC2", dob));
        assertTrue(ex.getMessage().contains("at least 18"));
    }
}

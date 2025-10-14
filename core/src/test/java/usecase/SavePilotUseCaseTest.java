package usecase;

import model.piloto.exceptions.ExceptionPilot;
import model.piloto.inmemory.InMemorySavePilot;
import model.piloto.model.Pilot;
import model.piloto.usecase.SavePilotUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SavePilotUseCaseTest {

    private InMemorySavePilot repo;
    private SavePilotUseCase useCase;

    @BeforeEach
    void setUp() {
        repo = new InMemorySavePilot();
        useCase = new SavePilotUseCase(repo);
    }

    @Test
    void execute_success_returnsLicenseAndPersists() {
        LocalDate dob = LocalDate.now().minusYears(25);
        String license = useCase.execute("Fanco Colapinto", "123456ABC", dob);
        assertNotNull(license);
        Pilot saved = repo.findByDocument("123456ABC");
        assertNotNull(saved);
        assertEquals(license, saved.getLicense());
    }

    @Test
    void execute_duplicateDocument_throws() {
        LocalDate dob = LocalDate.now().minusYears(30);
        useCase.execute("One", "DUP1", dob);
        Exception ex = assertThrows(ExceptionPilot.class, () -> useCase.execute("Two", "DUP1", dob));
        assertTrue(ex.getMessage().contains("already exists"));
    }

    @Test
    void execute_underage_throws() {
        LocalDate dob = LocalDate.now().minusYears(16);
        Exception ex = assertThrows(ExceptionPilot.class, () -> useCase.execute("Kid", "KID1", dob));
        assertTrue(ex.getMessage().contains("at least 18"));
    }
}

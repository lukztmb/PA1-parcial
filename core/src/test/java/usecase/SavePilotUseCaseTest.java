package usecase;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.SavePilotOutput;
import output.existsPilotOutput;
import model.piloto.usecase.SavePilotUseCase;
import model.piloto.model.Pilot;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatcher.*;

@ExtendWith(MockitoExtension.class)

public class SavePilotUseCaseTest {

    @Mock
    SavePilotOutput repositorio;
    existsPilotOutput exists;

    @InjectMocks
    SavePilotUseCase useCase;

    @Test
    @Order(1)
    @DisplayName("Save_Pilot")
    void execute_useCase() {
        when(exists.existsByDocument("45469057")).thenReturn(false);
        doNothing().when(repositorio).pilotSaved(any(Pilot.class));

        String existe = useCase.SavePilot("nombre",
                "45469057",
                LocalDate.of(2000, 05, 02),
                null
                );

        //assert

        Assertions.assertNotNull(existe);
        verify(exists).existsByDocument("45469057");
        verify(repositorio).pilotSaved(any());
    }

    @Test
    @Order(2)
    @DisplayName("Pilot Exception")

    void execute_test_excecption(){
        String result = useCase.SavePilot(null,
                "45469057",
                LocalDate.of(2000, 05, 02)
                , null);
        Assertions.assertNull(result);
        verify(repositorio, never()).pilotSaved(any());

    }
}
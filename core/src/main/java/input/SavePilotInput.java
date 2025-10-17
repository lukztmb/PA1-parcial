package input;

import java.time.LocalDate;

public interface SavePilotInput {
    String SavePilot(String name,
                        String document,
                        LocalDate birthDate,
                        String license);


}

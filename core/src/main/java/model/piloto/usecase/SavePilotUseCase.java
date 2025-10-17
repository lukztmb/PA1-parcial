package model.piloto.usecase;

import model.piloto.exceptions.ExceptionPilot;
import model.piloto.model.Pilot;
import model.piloto.repository.SavePilot;
import input.SavePilotInput;
import output.SavePilotOutput;
import output.existsPilotOutput;

import java.time.LocalDate;

public class SavePilotUseCase implements SavePilotInput{

	private final SavePilotOutput repository1;
    private final existsPilotOutput repository2;

	public SavePilotUseCase(SavePilotOutput repository1, existsPilotOutput repository2) {
		this.repository1 = repository1;
        this.repository2 = repository2;
	}

	public String SavePilot(String name, String document, LocalDate birthDate, String license) {
		// validate and create pilot (will generate license)
        try{
            if (repository2.existsByDocument(document)) {
			throw new ExceptionPilot("Pilot with document already exists");
		    }
		    Pilot pilot = Pilot.create(name, document, birthDate);
		    repository1.pilotSaved(pilot);
		    return pilot.getLicense();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

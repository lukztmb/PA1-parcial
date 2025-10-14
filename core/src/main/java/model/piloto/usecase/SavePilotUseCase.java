package model.piloto.usecase;

import model.piloto.exceptions.ExceptionPilot;
import model.piloto.model.Pilot;
import model.piloto.repository.SavePilot;

import java.time.LocalDate;

public class SavePilotUseCase {

	private final SavePilot repository;

	public SavePilotUseCase(SavePilot repository) {
		this.repository = repository;
	}

	public String execute(String name, String document, LocalDate birthDate) {
		// validate and create pilot (will generate license)
		if (repository.existsByDocument(document)) {
			throw new ExceptionPilot("Pilot with document already exists");
		}
		Pilot pilot = Pilot.create(name, document, birthDate);
		repository.save(pilot);
		return pilot.getLicense();
	}
}

package model.piloto.model;

import java.time.LocalDate;

public class PilotData {
    private final String license;
    private final String name;
    private final String document;
    private final LocalDate birthDate;

    public PilotData(String license, String name, String document, LocalDate birthDate) {
        this.license = license;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
    }

    public String getLicense() {
        return license;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
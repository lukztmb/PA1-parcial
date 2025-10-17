package model.piloto.model;

import model.piloto.exceptions.ExceptionPilot;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;
import java.util.UUID;

public class Pilot {
    private final String license;
    private final String name;
    private final String document;
    private final LocalDate birthDate;

    private Pilot(String license, String name, String document, LocalDate birthDate) {
        this.license = license;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
    }

    public static Pilot create(String name, String document, LocalDate birthDate) {
        if (name == null || name.isBlank()) {
            throw new ExceptionPilot("Name is required");
        }
        if (document == null || document.isBlank()) {
            throw new ExceptionPilot("Document is required");
        }
        if (birthDate == null) {
            throw new ExceptionPilot("Birth date is required");
        }
        int age = calculateAge(birthDate);
        if (age < 18) {
            throw new ExceptionPilot("Pilot must be at least 18 years old");
        }
        String license = UUID.randomUUID().toString();
        return new Pilot(license, name, document, birthDate);
    }

    private static int calculateAge(LocalDate birthDate) {
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        int age = now.getYear() - birthDate.getYear();
        if (now.getDayOfYear() < birthDate.getDayOfYear()) {
            age--;
        }
        return age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return Objects.equals(license, pilot.license) && Objects.equals(document, pilot.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(license, document);
    }
}

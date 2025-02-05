package tutorial.enums;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("Admin"),
    CANDIDATE("Candidato"),
    STUDENT("Estudante"),
    COMPANY("Empresa");

    private final String description;

    Role(String description) {
        this.description = description;
    }
}

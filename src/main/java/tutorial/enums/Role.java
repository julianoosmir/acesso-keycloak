package tutorial.enums;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("Admin"),
    USER("usuario"),
    STUDENT("Estudante"),
    COMPANY("Empresa");

    private final String description;

    Role(String description) {
        this.description = description;
    }
}

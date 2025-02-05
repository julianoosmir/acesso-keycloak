package tutorial.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tutorial.enums.Role;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Person extends ModelBase {

    @Column(length = 11, name = "cpf", unique = true, nullable = false)
    private String cpf;
    @Column(name = "full_name", length = 100)

    private String fullName;
    @Column(name = "social_name", length = 100)

    private String socialName;
    @Column(length = 100)

    private String email;
    @Column(name = "cell_phone", length = 11)
    private String cellPhone;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "security_code", length = 6)
    private String securityCode;

    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "keycloak_user_id")
    private String keycloakUserId;

    @Column(name = "keycloak_login_failure")
    private Long keycloakLoginFailure;

    @Column(name = "keycloak_sync")
    private Boolean keycloakSync = false;

    @Column(name = "keycloak_end_temporary_block")
    private LocalDateTime keycloakEndTemporaryBlock;


    @JsonIgnore
    @ElementCollection(targetClass = Role.class)
    @JoinTable(name = "person_role", joinColumns = @JoinColumn(name = "person_id"))
    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<>();


    public String getName() {
        if (this.socialName != null && !this.socialName.isEmpty()) {
            return this.socialName;
        }
        return this.fullName;
    }


}

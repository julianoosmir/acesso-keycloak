package tutorial.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
public class ModelBase extends PanacheEntityBase implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "active")
    private Boolean active = true;
    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate = LocalDateTime.now();
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate = LocalDateTime.now();
    @Column(name = "exclusion_date")
    private LocalDateTime exclusionDate;

}

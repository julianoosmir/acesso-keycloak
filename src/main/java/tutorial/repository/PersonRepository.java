package tutorial.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import tutorial.entity.Person;

import java.util.UUID;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<Person, UUID> {
}

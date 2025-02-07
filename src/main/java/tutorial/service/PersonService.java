package tutorial.service;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tutorial.entity.Person;
import tutorial.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ApplicationScoped
@Slf4j
public class PersonService {

    private final PersonRepository personRepository;


    public List<Person> findAll() {
        return personRepository.findAll().stream().collect(Collectors.toList());
    }

    public Person findByCpf(String cpf) {
        return personRepository.findByCPF(cpf).orElse(null);
    }
}

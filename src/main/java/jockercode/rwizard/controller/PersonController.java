package jockercode.rwizard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jockercode.rwizard.pojo.Person;
import jockercode.rwizard.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository pRepo;

    public Person save(Person p){
        return pRepo.save(p);
    }

    public List<Person> findAll(){
        return pRepo.findAll();
    }
}

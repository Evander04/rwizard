package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Person;
import repository.PersonRepository;

import java.util.List;

@Service
public class PersonController {
    @Autowired
    private PersonRepository pRepo;

    public Person save(Person p){
        return pRepo.save(p);
    }

    public List<Person> findAll(){
        return pRepo.findAll();
    }
}

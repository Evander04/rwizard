package jockercode.rwizard.repository;

import jockercode.rwizard.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    
}

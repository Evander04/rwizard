package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import pojo.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    
}

package jockercode.rwizard.repository;

import jockercode.rwizard.pojo.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    @Query("SELECT p FROM Person p WHERE p.firstName LIKE %?1% OR p.middleName LIKE %?1% OR p.lastName LIKE %?1%")
    Page<Person> findByName(String param1,Pageable pageable);
    @Query("SELECT p FROM Person p WHERE p.firstName LIKE %?1% OR p.middleName LIKE %?1% OR p.lastName LIKE %?1%")
    Set<Person> findByName(String param1);
}

package jockercode.rwizard.repository;

import jockercode.rwizard.pojo.UserObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserObj,Integer> {
    Optional<UserObj> findByEmail(String email);
}

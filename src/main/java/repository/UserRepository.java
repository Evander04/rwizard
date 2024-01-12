package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pojo.UserObj;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserObj,Integer> {
    Optional<UserObj> findByEmail(String email);
}

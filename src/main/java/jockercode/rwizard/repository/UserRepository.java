package jockercode.rwizard.repository;

import jockercode.rwizard.pojo.UserObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserObj,Integer> {
    Optional<UserObj> findByEmail(String email);
    @Query("SELECT u.id,u.person,u.role,u.status,u.email,u.username FROM UserObj u WHERE u.id=?1")
    Optional<UserObj> findById(int id);
}

package jockercode.rwizard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jockercode.rwizard.pojo.Log;

public interface LogRepository extends JpaRepository<Log,Integer> {
}

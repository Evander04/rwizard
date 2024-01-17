package jockercode.rwizard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jockercode.rwizard.pojo.Permission;

public interface PermissionRepository extends JpaRepository<Permission,Integer> {
}

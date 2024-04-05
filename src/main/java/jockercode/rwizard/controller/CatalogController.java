package jockercode.rwizard.controller;

import jockercode.rwizard.pojo.Role;
import jockercode.rwizard.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogController {
    private final RoleRepository rRepo;

    public List<Role> findAllRoles(){
        return rRepo.findAll();
    }
}

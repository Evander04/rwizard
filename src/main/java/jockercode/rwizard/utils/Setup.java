package jockercode.rwizard.utils;

import jockercode.rwizard.pojo.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jockercode.rwizard.pojo.Person;
import jockercode.rwizard.pojo.UserObj;
import jockercode.rwizard.repository.PersonRepository;
import jockercode.rwizard.repository.RoleRepository;
import jockercode.rwizard.repository.UserRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class Setup {
    private final RoleRepository roleRepo;
    private final PersonRepository personRepo;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserObj initDB(){
        //Create Role User
        Role role= new Role();
        role.setTitle("Root user");
        role.setCode("ROOT");
        role.setStatus(true);
        roleRepo.save(role);
        //Create Person
        Person person=new Person();
        person.setFirstName("Luke");
        person.setMiddleName("Jedi");
        person.setLastName("Skywalker");
        person.setDob(new Date());
        personRepo.save(person);

        UserObj user=new UserObj();
        user.setUsername("root");
        user.setEmail("root@rwizard.com");
        user.setStatus(true);
        user.setPerson(person);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode("root"));
        return userRepository.save(user);
    }

}

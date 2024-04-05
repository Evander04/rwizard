package jockercode.rwizard.repository;

import jockercode.rwizard.pojo.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PersonRepositoryTest {

    @MockBean
    PersonRepository repo;
    @Mock
    Person p;

    @Test
    @DisplayName("Test Save Person")
    void save(){
        p.setFirstName("Thunder");
        p.setMiddleName("Test");
        p.setLastName("Rojas");
        p.setPhone("0123456789");
        p.setAddress("somewhere");
        p.setStatus(true);
        p.setDob(new Date());
        p.setUsers(new HashSet<>());
        repo.save(p);
        assertNotNull(p.getId());
    }
}
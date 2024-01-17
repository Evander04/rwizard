package jockercode.rwizard.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dob;
    private String address;

    @OneToMany
    private Set<UserObj> users;
}

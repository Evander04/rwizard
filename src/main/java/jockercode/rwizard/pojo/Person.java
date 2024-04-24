package jockercode.rwizard.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dob;
    private String address;
    private String phone;
    private boolean status;

    @OneToMany
    private Set<UserObj> users;

    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName.toUpperCase();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase();
    }
}

package jockercode.rwizard.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private boolean status;
    private String code;

    @ManyToMany
    private Set<Permission> permissions;

    @OneToMany
    private Set<UserObj> users;

}

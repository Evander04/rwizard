package jockercode.rwizard.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Date dateCreated;
    private Date lastModified;
    private Set<String> sections;
    private boolean status;
}

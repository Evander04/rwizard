package jockercode.rwizard.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer code;//0: person creation
    private String message;
    private Date date;

    @ManyToOne
    private UserObj user;

}

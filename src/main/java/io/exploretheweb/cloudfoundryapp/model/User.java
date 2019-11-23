package io.exploretheweb.cloudfoundryapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 123L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String teamName;
    private long salary;

    public User(String name, String teamName, long salary) {
        this.name = name;
        this.teamName = teamName;
        this.salary = salary;
    }
}

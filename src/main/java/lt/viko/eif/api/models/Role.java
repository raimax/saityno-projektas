package lt.viko.eif.api.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Role model class
 */
@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(length = 60)
    private String name;
}
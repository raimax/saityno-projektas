package lt.viko.eif.api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post = new Post();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user = new User();

    public Like() {
    }
}

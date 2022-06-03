package lt.viko.eif.api.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Post extends RepresentationModel<Post> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String title;
    private String image;
    private Integer views = 0;

    public Post() {
    }
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user = new User();

    @JsonManagedReference(value = "post-comments")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @JsonManagedReference(value = "post-likes")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes;
}

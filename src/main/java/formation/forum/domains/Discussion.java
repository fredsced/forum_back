package formation.forum.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "discussions")
public class Discussion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_discussion")
  private Long id;

  private String title;

  private String text;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;

  @OneToMany(mappedBy = "discussion")
  // mappedBy => discussion is the slave side of the bi-directional relation
  // between discussion and comment
  // http://blog.paumard.org/cours/jpa/chap03-entite-relation.html
  private List<Comment> comments;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public List<Comment> getComments() {
    return comments;
  }

}

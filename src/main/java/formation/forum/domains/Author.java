package formation.forum.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_author")
  private Long id;
  private String pseudo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPseudo() {
    return pseudo;
  }

  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

}

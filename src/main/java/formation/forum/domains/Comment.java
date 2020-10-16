package formation.forum.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_comment")
  private Long id;

  private String text;

  @ManyToOne
  @JoinColumn(name="author_id")
  private Author author;

  @ManyToOne
  @JoinColumn(name="discussion_id")
  private Discussion discussion;

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

  public Discussion getDiscussion() {
    return discussion;
  }

  public void setDiscussion(Discussion discussion) {
    this.discussion = discussion;
  }
}

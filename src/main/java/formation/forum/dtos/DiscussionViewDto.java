package formation.forum.dtos;


import java.util.List;

public class DiscussionViewDto {
  private String title;
  private String author;
  private String text;
  private List<CommentViewDto> comments;

  public DiscussionViewDto() {
    //
  }

  public DiscussionViewDto(String title, String author, String text) {
    this.title = title;
    this.author = author;
    this.text = text;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<CommentViewDto> getComments() {
    return comments;
  }

  public void setComments(List<CommentViewDto> comments) {
    this.comments = comments;
  }
}

package formation.forum.dtos;


import javax.validation.constraints.NotBlank;

public class DiscussionCreateDto {
  @NotBlank
  private String title;
  @NotBlank
  private String pseudo;
  @NotBlank
  private String text;

  protected DiscussionCreateDto() {
    //
  }

  public String getTitle() {
    return title;
  }


  public String getPseudo() {
    return pseudo;
  }


  public String getText() {
    return text;
  }


  @Override
  public String toString() {
    return "DiscussionCreateDto{" +
        "title='" + title + '\'' +
        ", pseudo='" + pseudo + '\'' +
        ", text='" + text + '\'' +
        '}';
  }
}

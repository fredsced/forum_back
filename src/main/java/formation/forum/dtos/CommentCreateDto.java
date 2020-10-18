package formation.forum.dtos;


import javax.validation.constraints.NotBlank;

public class CommentCreateDto {
  @NotBlank
  private String pseudo;
  @NotBlank
  private String text;

  protected CommentCreateDto() {
    //
  }

  public String getPseudo() {
    return pseudo;
  }

  public String getText() {
    return text;
  }
}

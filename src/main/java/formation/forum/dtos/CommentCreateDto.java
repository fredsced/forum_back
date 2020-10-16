package formation.forum.dtos;

import javax.validation.constraints.NotBlank;

public class CommentCreateDto {
  @NotBlank
  private String author;
  @NotBlank
  private String text;

  protected CommentCreateDto(){
    //
  }
}

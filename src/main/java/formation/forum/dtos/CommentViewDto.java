package formation.forum.dtos;
/**
 A projection of {@code Comment} to display
 **/
public interface CommentViewDto {
  AuthorViewDto getAuthor();
  String getText();
}

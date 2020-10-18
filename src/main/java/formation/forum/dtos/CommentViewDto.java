package formation.forum.dtos;
/**
 A projection of {@code Comment} to display with author
 **/
public interface CommentViewDto {
  AuthorViewDto getAuthor();
  String getText();
}

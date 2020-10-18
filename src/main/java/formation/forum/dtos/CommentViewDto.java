package formation.forum.dtos;

public interface CommentViewDto {
  AuthorViewDto getAuthor();
  String getText();
}

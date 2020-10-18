package formation.forum.dtos;

import java.util.List;

/**
 * A projection of {@code Discussion} to display with author and comments
 */
public interface DiscussionViewDto {
  String getTitle();

  String getText();

  List<CommentViewDto> getComments();

  AuthorViewDto getAuthor();
}

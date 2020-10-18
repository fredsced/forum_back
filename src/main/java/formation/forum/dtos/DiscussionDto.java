package formation.forum.dtos;

import formation.forum.domains.Author;

import java.util.List;

/**
 * A project of {@code Discussion} to display with author and comments
 */
public interface DiscussionDto {
  String getTitle();
  String getText();
  List<CommentDto> getComments();
  AuthorDto getAuthor();
    interface AuthorDto{
      String getPseudo();
    }
    interface CommentDto{
      String getText();
      Author getAuthor();
    }
}

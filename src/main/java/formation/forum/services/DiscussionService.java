package formation.forum.services;

import formation.forum.dtos.CommentCreateDto;
import formation.forum.dtos.DiscussionCreateDto;
import formation.forum.dtos.DiscussionDto;
import formation.forum.dtos.DiscussionViewDto;
import formation.forum.dtos.EntityIdDto;

/**
 * Service to handle Discussions
 */

public interface DiscussionService {

  DiscussionDto getDiscussionById(Long id);



  EntityIdDto save(DiscussionCreateDto inputs);
  EntityIdDto addComment(CommentCreateDto inputs, Long discussionId);
}

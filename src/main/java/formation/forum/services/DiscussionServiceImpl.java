package formation.forum.services;

import formation.forum.domains.Author;
import formation.forum.domains.Comment;
import formation.forum.domains.Discussion;
import formation.forum.dtos.CommentCreateDto;
import formation.forum.dtos.DiscussionCreateDto;
import formation.forum.dtos.DiscussionViewDto;
import formation.forum.dtos.EntityIdDto;
import formation.forum.exceptions.ResourceNotFound;
import formation.forum.repositories.AuthorRepository;
import formation.forum.repositories.CommentRepository;
import formation.forum.repositories.DiscussionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionServiceImpl implements DiscussionService {

  private final DiscussionRepository discussionRepository;
  private final AuthorRepository authorRepository;
  private final CommentRepository commentRepository;

  protected DiscussionServiceImpl(DiscussionRepository discussionRepository,
                                  AuthorRepository authorRepository,
                                  CommentRepository commentRepository) {
    this.discussionRepository = discussionRepository;
    this.authorRepository = authorRepository;
    this.commentRepository = commentRepository;
  }

  @Override
  public DiscussionViewDto getDiscussionById(Long id) {
    return discussionRepository
        .getDiscussionById(id)
        .orElseThrow(() -> new ResourceNotFound("Discussion not found"));
  }

  @Override
  public EntityIdDto save(DiscussionCreateDto inputs) {
    Discussion discussionToCreate = new Discussion();
    String pseudo = inputs.getPseudo().trim().toLowerCase();

    if (authorRepository.existsByPseudo(pseudo)) {
      Author authorRelatedToDiscussion = authorRepository.findByPseudo(pseudo);
      discussionToCreate.setAuthor(authorRelatedToDiscussion);
    } else {
      Author authorToCreate = new Author();
      authorToCreate.setPseudo(pseudo);
      Author authorSaved = authorRepository.save(authorToCreate);
      discussionToCreate.setAuthor(authorSaved);

    }
    discussionToCreate.setTitle(inputs.getTitle());
    discussionToCreate.setText(inputs.getText());

    Discussion discussionCreated = discussionRepository.save(discussionToCreate);
    return new EntityIdDto(discussionCreated.getId());
  }

  @Override
  public EntityIdDto addComment(CommentCreateDto inputs, Long discussionId) {
    Comment commentToSave = new Comment();
    String pseudo = inputs.getPseudo().trim().toLowerCase();
    commentToSave.setText(inputs.getText());
    // TODO : TRY to refactor .... same as save method...
    if (authorRepository.existsByPseudo(pseudo)) {
      Author authorRelatedToComment = authorRepository.findByPseudo(pseudo);
      commentToSave.setAuthor(authorRelatedToComment);
    } else {
      Author authorToCreate = new Author();
      authorToCreate.setPseudo(pseudo);
      Author authorSaved = authorRepository.save(authorToCreate);
      commentToSave.setAuthor(authorSaved);

    }
    Discussion discussionToUpdate = discussionRepository.getOne(discussionId);
    List<Comment> commentsInDb = discussionToUpdate.getComments();
    commentsInDb.add(commentToSave);
    discussionToUpdate.setComments(commentsInDb);
    discussionRepository.save(discussionToUpdate);
    return new EntityIdDto(discussionToUpdate.getId());
  }


}

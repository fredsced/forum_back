package formation.forum.services;

import formation.forum.domains.Author;
import formation.forum.domains.Discussion;
import formation.forum.dtos.DiscussionCreateDto;
import formation.forum.dtos.DiscussionViewDto;
import formation.forum.dtos.EntityIdDto;
import formation.forum.repositories.AuthorRepository;
import formation.forum.repositories.DiscussionRepository;
import org.springframework.stereotype.Service;

@Service
public class DiscussionServiceImpl implements DiscussionService {

  private final DiscussionRepository discussionRepository;
  private final AuthorRepository authorRepository;

  protected DiscussionServiceImpl(DiscussionRepository discussionRepository, AuthorRepository authorRepository) {
    this.discussionRepository = discussionRepository;
    this.authorRepository = authorRepository;
  }

  @Override
  public DiscussionViewDto getDiscussionById(Long id) throws Exception {

    Discussion discussionToDisplay = discussionRepository.findById(id).orElseThrow(() -> new Exception("Discussion not found"));

    DiscussionViewDto discussionViewDtoToDisplay = new DiscussionViewDto();
    discussionViewDtoToDisplay.setTitle(discussionToDisplay.getTitle());
    discussionViewDtoToDisplay.setText(discussionToDisplay.getText());
    discussionViewDtoToDisplay.setAuthor(discussionToDisplay.getAuthor().getPseudo());

    return discussionViewDtoToDisplay;
  }

  @Override
  public EntityIdDto save(DiscussionCreateDto inputs) {
    Author authorToCreate = new Author();
    authorToCreate.setPseudo(inputs.getPseudo());
    Author authorSaved = authorRepository.save(authorToCreate);

    Discussion discussionToCreate = new Discussion();
    discussionToCreate.setTitle(inputs.getTitle());
    discussionToCreate.setText(inputs.getText());
    discussionToCreate.setAuthor(authorSaved);
    Discussion discussionCreated = discussionRepository.save(discussionToCreate);
    return new EntityIdDto(discussionCreated.getId());
  }


}

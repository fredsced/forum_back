package formation.forum.controllers;

import formation.forum.dtos.CommentCreateDto;
import formation.forum.dtos.DiscussionCreateDto;
import formation.forum.dtos.DiscussionDto;
import formation.forum.dtos.EntityIdDto;
import formation.forum.services.DiscussionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("discussions")
@CrossOrigin(value = "http://127.0.0.1:5500")
public class DiscussionController {

  private final DiscussionService discussionService;

  protected DiscussionController(DiscussionService discussionService) {
    this.discussionService = discussionService;
  }

  @PostMapping
  public EntityIdDto save(@Valid @RequestBody DiscussionCreateDto inputs) {
    return discussionService.save(inputs);


  }

  @GetMapping("/{discussionId}")
  public DiscussionDto getDiscussion(@PathVariable Long discussionId) {

    return discussionService.getDiscussionById(discussionId);

  }

  @PatchMapping("/{discussionId}/comments")
  public EntityIdDto addComment(@Valid @RequestBody CommentCreateDto inputs, @PathVariable Long discussionId) {
    return discussionService.addComment(inputs, discussionId);
  }

}

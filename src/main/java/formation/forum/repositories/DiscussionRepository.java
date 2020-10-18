package formation.forum.repositories;

import formation.forum.domains.Discussion;
import formation.forum.dtos.DiscussionViewDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscussionRepository extends JpaRepository <Discussion, Long> {
  Optional<DiscussionViewDto> getDiscussionById(Long id);
}

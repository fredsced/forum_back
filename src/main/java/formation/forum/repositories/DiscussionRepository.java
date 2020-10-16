package formation.forum.repositories;

import formation.forum.domains.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepository extends JpaRepository <Discussion, Long> {
}

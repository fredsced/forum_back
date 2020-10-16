package formation.forum.repositories;

import formation.forum.domains.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository <Author, Long> {

   boolean existsByPseudo(String pseudo);
   Author findByPseudo(String pseudo);
}

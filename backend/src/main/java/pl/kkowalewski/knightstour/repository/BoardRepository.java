package pl.kkowalewski.knightstour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kkowalewski.knightstour.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

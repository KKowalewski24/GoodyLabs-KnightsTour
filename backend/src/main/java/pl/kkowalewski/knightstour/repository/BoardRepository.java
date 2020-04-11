package pl.kkowalewski.knightstour.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.knightstour.model.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
}

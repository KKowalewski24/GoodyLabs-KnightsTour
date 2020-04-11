package pl.kkowalewski.knightstour.service;

import org.springframework.stereotype.Service;
import pl.kkowalewski.knightstour.exception.service.BoardNotFoundException;
import pl.kkowalewski.knightstour.model.Board;
import pl.kkowalewski.knightstour.repository.BoardRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BoardServiceImpl implements BoardService {

    /*------------------------ FIELDS REGION ------------------------*/
    private final BoardRepository boardRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board findById(Long id) {
        Optional<Board> board = boardRepository.findById(id);

        if (board.isEmpty()) {
            throw new BoardNotFoundException();
        }

        return board.get();
    }

    @Override
    public List<Board> findAll() {
        return StreamSupport
                .stream(boardRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Board save(Board object) {
        return boardRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public void delete(Board object) {
        boardRepository.delete(object);
    }

    @Override
    public void deleteAll() {
        boardRepository.deleteAll();
    }
}
    
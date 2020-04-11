package pl.kkowalewski.knightstour.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kkowalewski.knightstour.service.board.BoardService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BoardServiceImplTest {

    /*------------------------ FIELDS REGION ------------------------*/
    @Mock
    private BoardService boardService;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {

    }

    @Test
    void findByIdTest() {
        boardService.findAll();
    }

    @Test
    void findAllTest() {

    }

    @Test
    void saveTest() {

    }

    @Test
    void deleteByIdTest() {

    }

    @Test
    void deleteTest() {

    }

    @Test
    void deleteAllTest() {

    }
}
package pl.kkowalewski.knightstour.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.kkowalewski.knightstour.service.board.BoardService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.kkowalewski.knightstour.constant.Constants.PATH_BOARD_SOLUTION;

@ExtendWith(MockitoExtension.class)
class BoardControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    @Mock
    private BoardService boardService;
    @InjectMocks
    private BoardController boardController;
    private MockMvc mockMvc;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(boardController)
                .setControllerAdvice(new RestResponseEntityExceptionHandler())
                .build();
    }

    @Test
    void getSolutionTest() throws Exception {
        mockMvc.perform(get(PATH_BOARD_SOLUTION + "?pointx=0&pointy=0")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    void getSolutionExceptionTest() throws Exception {
        mockMvc.perform(get(PATH_BOARD_SOLUTION + "?point=0&pointy=0")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }
}

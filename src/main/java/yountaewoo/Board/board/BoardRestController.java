package yountaewoo.Board.board;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardRestController {

    private BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }
}

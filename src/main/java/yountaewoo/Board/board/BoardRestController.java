package yountaewoo.Board.board;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import yountaewoo.Board.board.DTO.CreateBoardDto;
import yountaewoo.Board.board.DTO.ReadBoardResoponse;
import yountaewoo.Board.board.DTO.UpdateBoardDto;

import java.util.List;

@RestController
public class BoardRestController {

    private BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 생성
    @PostMapping("/boards")
    public void createBoard(@Valid @RequestBody CreateBoardDto createBoardDto) {
        boardService.createBoard(createBoardDto);
    }

    //조회
    @GetMapping("/boards")
    public List<ReadBoardResoponse> findAll() {
        return boardService.findALl();
    }

    //수정
    @PostMapping("/boards/{boardId}")
    public void updateBoard(@Valid @RequestBody UpdateBoardDto updateBoardDto, @Valid @PathVariable Long boardId) {
        boardService.updateBoard(updateBoardDto, boardId);
    }

    //삭제
    @DeleteMapping("/boards/{boardId}")
    public void deleteBoard(@Valid @PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
    }
}

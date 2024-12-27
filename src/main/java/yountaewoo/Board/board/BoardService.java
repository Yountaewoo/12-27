package yountaewoo.Board.board;

import org.springframework.stereotype.Service;
import yountaewoo.Board.board.DTO.CreateBoardDto;
import yountaewoo.Board.board.DTO.ReadBoardResoponse;
import yountaewoo.Board.board.DTO.UpdateBoardDto;

import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //생성
    public void createBoard(CreateBoardDto createBoardDto) {
        Board board = new Board(createBoardDto.title());
        boardRepository.save(board);
    }

    //조회
    public List<ReadBoardResoponse> findALl() {
        List<Board> boards = boardRepository.findAll();
        List<ReadBoardResoponse> readBoardResponses = boards.stream()
                .map(board -> new ReadBoardResoponse(board.getTitle()))
                .toList();
        return readBoardResponses;
    }

    //수정
    public void updateBoard(UpdateBoardDto updateBoardDto, Long id) {
        Board find = boardRepository.findById(id).orElseThrow();
        find.setTitle(updateBoardDto.title());
        boardRepository.save(find);
    }

    //삭제
    public void deleteBoard(Long id) {
        Board find = boardRepository.findById(id).orElseThrow();
        boardRepository.delete(find);
    }
}

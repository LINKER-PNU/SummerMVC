package ac.linker.service;

import java.util.List;

import ac.linker.dto.BoardDto;
import ac.linker.vo.BoardVo;

public interface BoardService {
    BoardVo getBoardTitle(BoardDto boardDto);

    List<BoardVo> getBoards(BoardDto boardDto);

    BoardVo getBoardContent(BoardDto boardDto);

    void insertBoard(BoardDto boardDto);

    void editBoard(BoardDto boardDto);

    void invisibleBoard(BoardDto boardDto);
}

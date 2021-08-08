package ac.linker.service;

import ac.linker.dto.BoardDto;
import ac.linker.vo.BoardVo;

public interface BoardService {
    BoardVo getBoardTitle(BoardDto boardDto);
}

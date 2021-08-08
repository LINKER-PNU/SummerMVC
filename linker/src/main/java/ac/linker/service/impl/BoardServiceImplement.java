package ac.linker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.linker.dto.BoardDto;
import ac.linker.mapper.BoardMapper;
import ac.linker.service.BoardService;
import ac.linker.vo.BoardVo;

@Service
public class BoardServiceImplement implements BoardService {
    private BoardMapper boardMapper;

    @Autowired
    BoardServiceImplement(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public BoardVo getBoardTitle(BoardDto boardDto) {
        return boardMapper.getBoardTitle(boardDto);
    }

    public BoardVo getBoards(BoardDto boardDto) {
        return boardMapper.getBoards(boardDto);
    };
}

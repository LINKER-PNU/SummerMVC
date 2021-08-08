package ac.linker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ac.linker.dto.BoardDto;
import ac.linker.vo.BoardVo;

@Repository
@Mapper
public interface BoardMapper {
    BoardVo getBoardTitle(BoardDto boardDto);

    List<BoardVo> getBoards(BoardDto boardDto);

    BoardVo getBoardContent(BoardDto boardDto);
}

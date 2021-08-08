package ac.linker.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ac.linker.dto.BoardDto;
import ac.linker.vo.BoardVo;

@Repository
@Mapper
public interface BoardMapper {
    BoardVo getBoardTitle(BoardDto boardDto);

    BoardVo getBoards(BoardDto boardDto);
}

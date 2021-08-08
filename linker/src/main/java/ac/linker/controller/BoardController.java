package ac.linker.controller;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.linker.dto.BoardDto;
import ac.linker.service.BoardService;
import ac.linker.vo.BoardVo;

@RestController
@RequestMapping(value = "/board")
public class BoardController {
    private BoardService boardService;
    private Gson gson = new Gson();

    @Autowired
    BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // get board list
    @PostMapping(value = "/list", produces = "application/json; charset=utf8")
    public String getBoards(@RequestBody BoardVo boardVo) {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardRoom(boardVo.getBoardRoom());
        return gson.toJson(boardService.getBoards(boardDto));
    }

    // click board
    @PostMapping(value = "/content")
    public String getBoardContent(@RequestBody BoardVo boardVo) {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardId(boardVo.getBoardId());
        return boardService.getBoardContent(boardDto).getBoardContent();
    }

    // // write board
    // @PostMapping
    // public String insertBoard(@RequestBody BoardVo boardVo) {
    // }

    // // edit board
    // public String editBoard(@RequestBody BoardVo boardVo) {
    // }

    // // delete(deactivate) board
    // public String deactivateBoard(@RequestBody BoardVo boardVo) {
    // }
}

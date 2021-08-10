package ac.linker.controller;

import com.google.gson.Gson;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.linker.dto.BoardDto;
import ac.linker.service.BoardService;
import ac.linker.service.ResponseService;
import ac.linker.vo.BoardVo;

@RestController
@RequestMapping(value = "/board")
public class BoardController {
    private BoardService boardService;
    private ResponseService responseService;
    private Gson gson = new Gson();

    @Autowired
    BoardController(BoardService boardService, ResponseService responseService) {
        this.boardService = boardService;
        this.responseService = responseService;
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

    // write board
    @PostMapping(value = "/insert")
    public String insertBoard(@RequestBody BoardVo boardVo) {
        ModelMapper modelMapper = new ModelMapper();
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        boardService.insertBoard(boardDto);

        return responseService.getResultResponse(true);
    }

    // edit board
    @PostMapping(value = "/edit")
    public String editBoard(@RequestBody BoardVo boardVo) {
        ModelMapper modelMapper = new ModelMapper();
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        boardService.editBoard(boardDto);

        return responseService.getResultResponse(true);
    }

    // delete(deactivate) board
    @PostMapping(value = "/delete")
    public String deleteBoard(@RequestBody BoardVo boardVo) {
        ModelMapper modelMapper = new ModelMapper();
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        boardService.invisibleBoard(boardDto);

        return responseService.getResultResponse(true);
    }
}

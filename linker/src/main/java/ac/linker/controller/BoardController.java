package ac.linker.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private ModelMapper modelMapper = new ModelMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BoardController(BoardService boardService, ResponseService responseService) {
        this.boardService = boardService;
        this.responseService = responseService;
    }

    // get board list
    @PostMapping(value = "/list", produces = "application/json; charset=utf8")
    public String getBoards(@RequestBody BoardVo boardVo) {
        logger.info("getBoards :: {}", boardVo.getBoardRoom());
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        final JsonObject jsonObject = new JsonObject();

        jsonObject.add("result", gson.toJsonTree(boardService.getBoards(boardDto)).getAsJsonArray());
        logger.info("Boards select complete.\n");

        return jsonObject.toString();
    }

    // click board
    @PostMapping(value = "/content", produces = "application/json; charset=utf8")
    public String getBoardContent(@RequestBody BoardVo boardVo) {
        logger.info("getBoardContent :: {}", boardVo.getBoardId());
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        logger.info("Content select complete.\n");
        return boardService.getBoardContent(boardDto).getBoardContent();
    }

    // write board
    @PostMapping(value = "/insert", produces = "application/json; charset=utf8")
    public String insertBoard(@RequestBody BoardVo boardVo) {
        logger.info("insertBoard :: {} :: {} :: {}", boardVo.getBoardRoom(), boardVo.getBoardTitle(),
                boardVo.getBoardWriterId());
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        boardService.insertBoard(boardDto);

        logger.info("Board insert complete.\n");
        return responseService.getResultResponse(200);
    }

    // edit board
    @PostMapping(value = "/edit", produces = "application/json; charset=utf8")
    public String editBoard(@RequestBody BoardVo boardVo) {
        logger.info("editBoard :: {}", boardVo.getBoardId());

        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);
        boardService.editBoard(boardDto);

        logger.info("Board edit complete.\n");
        return responseService.getResultResponse(200);
    }

    // delete(deactivate) board
    @PostMapping(value = "/delete", produces = "application/json; charset=utf8")
    public String deleteBoard(@RequestBody BoardVo boardVo) {
        logger.info("deleteBoard :: {}", boardVo.getBoardId());
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        boardService.invisibleBoard(boardDto);

        logger.info("Board deactivate complete.\n");
        return responseService.getResultResponse(200);
    }
}

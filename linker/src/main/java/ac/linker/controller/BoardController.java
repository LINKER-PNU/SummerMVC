package ac.linker.controller;

import java.util.Optional;

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

    private int resultCode;

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

        final JsonObject boardJsonObject = new JsonObject();

        try {
            boardJsonObject.add("result", gson.toJsonTree(boardService.getBoards(boardDto)).getAsJsonArray());
            resultCode = 200;
            logger.info("Boards select complete.\n");
        } catch (Exception e) {
            logger.error("{} :: Errors on select query :: getBoards\n", e.toString());
            resultCode = 500;
            return responseService.getResultResponse(resultCode);
        }

        boardJsonObject.addProperty("resultCode", resultCode);

        return boardJsonObject.toString();
    }

    // click board
    @PostMapping(value = "/content", produces = "application/json; charset=utf8")
    public String getBoardContent(@RequestBody BoardVo boardVo) {
        logger.info("getBoardContent :: {}", boardVo.getBoardId());
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        String boardContent;

        try {
            boardContent = boardService.getBoardContent(boardDto).getBoardContent();

        } catch (Exception e) {
            boardContent = "ERROR 500, failed to request query to DB...";
            logger.error("{} :: Errors on select query :: getBoardContent\n", e.toString());
        }

        Optional<String> contentOptional = Optional.ofNullable(boardContent);

        if (contentOptional.isPresent()) {
            logger.info("Content select complete.\n");
        } else {
            logger.warn("Board id or content client requests is not exist!");
        }

        return contentOptional.orElse("WARN 400, there is no content or board. One of those is null.");
    }

    // write board
    @PostMapping(value = "/insert", produces = "application/json; charset=utf8")
    public String insertBoard(@RequestBody BoardVo boardVo) {
        logger.info("insertBoard :: {} :: {} :: {}", boardVo.getBoardRoom(), boardVo.getBoardTitle(),
                boardVo.getBoardWriterId());
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        try {
            boardService.insertBoard(boardDto);
            resultCode = 200;
            logger.info("Board insert complete.\n");
        } catch (Exception e) {
            resultCode = 500;
            logger.error("{} :: Errors on insert query :: insertBoard\n", e.toString());
        }

        return responseService.getResultResponse(resultCode);
    }

    // edit board
    @PostMapping(value = "/edit", produces = "application/json; charset=utf8")
    public String editBoard(@RequestBody BoardVo boardVo) {
        logger.info("editBoard :: {}", boardVo.getBoardId());

        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        try {
            boardService.editBoard(boardDto);
            resultCode = 200;
            logger.info("Board edit complete.\n");
        } catch (Exception e) {
            resultCode = 500;
            logger.error("{} :: Errors on update query :: editBoard\n", e.toString());
        }

        return responseService.getResultResponse(resultCode);
    }

    // delete(deactivate) board
    @PostMapping(value = "/delete", produces = "application/json; charset=utf8")
    public String deleteBoard(@RequestBody BoardVo boardVo) {
        logger.info("deleteBoard :: {}", boardVo.getBoardId());
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        try {
            boardService.invisibleBoard(boardDto);
            resultCode = 200;
            logger.info("Board deactivate complete.\n");
        } catch (Exception e) {
            resultCode = 500;
            logger.error("{} :: Errors on update query :: deleteBoard\n", e.toString());
        }

        return responseService.getResultResponse(resultCode);
    }
}

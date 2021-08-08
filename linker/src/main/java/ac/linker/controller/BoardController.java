package ac.linker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ac.linker.service.ConnectService;
import ac.linker.vo.BoardVo;

@RestController
public class BoardController {
    // private ConnectService connectService;

    // @Autowired
    // BoardController(ConnectService connectService) {
    // this.connectService = connectService;
    // }

    // write board
    @PostMapping
    public String insertBoard(@RequestBody BoardVo boardVo) {
    }

    // get board list
    @PostMapping
    public String getBoards(@RequestBody BoardVo boardVo) {
        // List<Map<String,Object>> queryResult = connectService.
    }

    // click board
    @PostMapping
    public String getBoardInfo(@RequestBody BoardVo boardVo) {
    }

    // edit board
    public String editBoard(@RequestBody BoardVo boardVo) {
    }

    // delete(deactivate) board
    public String deactivateBoard(@RequestBody BoardVo boardVo) {
    }
}

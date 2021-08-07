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
public class ClassroomController {
    private ConnectService connectService;

    @Autowired
    ClassroomController(ConnectService connectService){
        this.connectService = connectService;
    }

    @PostMapping
    public String insertBoard(@RequestBody BoardVo boardVo){
        

    }

    @PostMapping
    public String getBoards(@RequestBody BoardVo boardVo){
        // List<Map<String,Object>> queryResult = connectService.

    }

    @PostMapping
    public String insertTimer(@RequestBody ){

    }

    @PostMapping
    public String getTimers(@RequestBody ){

    }
}

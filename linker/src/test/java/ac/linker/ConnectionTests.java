package ac.linker;

import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ac.linker.dto.BoardDto;
import ac.linker.dto.RoomDto;
import ac.linker.service.AgoraService;
import ac.linker.service.BoardService;
import ac.linker.service.ConnectService;
import ac.linker.service.HomeService;
import ac.linker.vo.BoardVo;

@SpringBootTest
public class ConnectionTests {
    private Gson gson = new Gson();
    private ConnectService connectService;
    private AgoraService agoraService;
    private HomeService homeService;
    private BoardService boardService;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ConnectionTests(ConnectService connectService, AgoraService agoraService, HomeService homeService,
            BoardService boardService) {
        this.connectService = connectService;
        this.agoraService = agoraService;
        this.homeService = homeService;
        this.boardService = boardService;
    }

    @Test
    public void connectionTest() {
        System.out.println("###############ConnectionTest##############");
        BoardVo boardVo1 = new BoardVo();
        boardVo1.setBoardId(5);
        BoardDto boardDto1 = modelMapper.map(boardVo1, BoardDto.class);
        
        BoardVo boardVo2 = new BoardVo();
        boardVo2.setBoardRoom("boardroom");
        BoardDto boardDto2 = modelMapper.map(boardVo2, BoardDto.class);

        Optional optional = Optional.ofNullable(boardDto2.getBoardId());
    
        System.out.println(optional.orElse("other"));
        
    }
}
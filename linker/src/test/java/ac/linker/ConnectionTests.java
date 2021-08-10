package ac.linker;

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
        BoardVo boardVo = new BoardVo();

        boardVo.setBoardId(5);
        boardVo.setBoardRoom("boardroom");
        boardVo.setBoardTitle("boardtitle");
        
        ModelMapper modelMapper = new ModelMapper();
        BoardDto boardDto = modelMapper.map(boardVo, BoardDto.class);

        System.out.println(boardDto.getBoardId());
        System.out.println(boardDto.getBoardTitle());
        System.out.println(boardDto.getBoardRoom());
    }
}
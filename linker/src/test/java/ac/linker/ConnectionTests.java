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
import ac.linker.dto.TimerDto;
import ac.linker.dto.UserDto;
import ac.linker.service.AgoraService;
import ac.linker.service.BoardService;
import ac.linker.service.ConnectService;
import ac.linker.service.HomeService;
import ac.linker.service.TimerService;
import ac.linker.vo.BoardVo;

@SpringBootTest
public class ConnectionTests {
    private Gson gson = new Gson();
    private ConnectService connectService;
    private AgoraService agoraService;
    private HomeService homeService;
    private BoardService boardService;
    private TimerService timerService;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ConnectionTests(ConnectService connectService, AgoraService agoraService, HomeService homeService,
            BoardService boardService, TimerService timerService) {
        this.connectService = connectService;
        this.agoraService = agoraService;
        this.homeService = homeService;
        this.boardService = boardService;
        this.timerService = timerService;
    }

    @Test
    public void connectionTest() {
        System.out.println("###############ConnectionTest##############");
        // TimerDto timerDto = new TimerDto(1, "id", "10", "timerSubject5", 20);

        // BoardDto boardDto = new BoardDto("id", "1", "boardTitleIns", "boardContentIns1", "2021-01-01 01:02:00", true,
        //         false);
        // boardDto.setBoardId(1);

        // System.out.println(gson.toJson(boardService.getBoards(boardDto)));
        // boardService.editBoard(boardDto);
        // boardService.invisibleBoard(boardDto);
        // boardService.insertBoard(boardDto);
        // timerService.insertTimer(timerDto);

        // System.out.println(gson.toJson(timerService.getTimers(timerDto)));

        // timerService.accumTimer(timerDto);

        // timerService.editTimer(timerDto);

        // timerService.deleteTimer(timerDto);

    }
}